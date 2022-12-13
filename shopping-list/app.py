from flask import Flask, render_template, jsonify, request, g, abort, session
import sqlite3
from passlib.hash import pbkdf2_sha256

DATABASE = "database.db"

SETUP_USERS_SQL = """
CREATE TABLE IF NOT EXISTS users (
    username TEXT NOT NULL UNIQUE PRIMARY KEY CHECK(typeof(username) == 'text'),
    hash TEXT CHECK(typeof(hash) == 'text')
);
"""

SETUP_SHOPPING_LIST_SQL = """
CREATE TABLE IF NOT EXISTS shopping_list (
    username TEXT NOT NULL UNIQUE PRIMARY KEY CHECK(typeof(username) == 'text'),
    items TEXT NOT NULL CHECK(typeof(items) == 'text'),
    FOREIGN KEY (username) REFERENCES users(username)
);
"""

def get_connection():
    connection = getattr(g, '_connection', None)
    if connection is None:
        connection = sqlite3.connect(DATABASE)
        connection.row_factory = sqlite3.Row
        connection.execute('PRAGMA foreign_keys=ON;')
        connection.execute(SETUP_USERS_SQL)
        connection.execute(SETUP_SHOPPING_LIST_SQL)
        
        g._connection = connection
    return connection

app = Flask(__name__)
app.secret_key = 'SECRET'

@app.route("/")
def index():
    return app.send_static_file("index.html")
    
@app.route("/api/login", methods=['POST'])
def login():
    json = request.get_json()
    
    username = json['username']
    password = json['password']
    
    connection = get_connection()
    cursor = connection.cursor()
    cursor.execute('SELECT hash FROM users WHERE username == ?', (username, ))
    hash = cursor.fetchone()
    if hash is None:
        hash = pbkdf2_sha256.hash(password)
        cursor.execute('INSERT INTO users (username, hash) VALUES (?, ?);', (username, hash))
        connection.commit()
        
        session['username'] = username
        return jsonify("new")
    else:
        hash = hash['hash']
        if not pbkdf2_sha256.verify(password, hash):
            return jsonify("old"), 403
            
        session['username'] = username
        return jsonify("old")
        
@app.route("/api/list", methods=['GET'])
def get_list():
    if 'username' not in session:
        return jsonify("Unauthorized"), 403
        
    username = session['username']
    
    connection = get_connection()
    cursor = connection.cursor()
    cursor.execute('SELECT items FROM shopping_list WHERE username == ?', (username, ))
    items = cursor.fetchone()
    if items is None:
        items = "[]"
    else:
        items = items['items']
    
    # Assume items is json
    return items
    
@app.route("/api/list", methods=['POST'])
def set_list():
    if 'username' not in session:
        return jsonify("Unauthorized"), 403
        
    username = session['username']
    
    json = request.get_json()
    items = json['items']
    
    connection = get_connection()
    cursor = connection.cursor()
    cursor.execute('INSERT OR REPLACE INTO shopping_list (username, items) VALUES (?, ?);', (username, items))
    connection.commit()
    
    return jsonify("ok")

@app.teardown_appcontext
def close_connection(exception):
    connection = getattr(g, '_connection', None)
    if connection is not None:
        connection.close()