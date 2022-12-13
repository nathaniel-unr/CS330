class Model {
    constructor() {
        // If not null, consider logged in.
        this.username = null;
        this.list = [];
    }
    
    setUsername(username) {
        this.username = username;
    }
    
    setList(list) {
        this.list = list;
    }
    
    addItem(name) {
        this.list.push(name);
    }
    
    getList(name) {
        return this.list;
    }
    
    removeItemAtIndex(i) {
        this.list.splice(i, 1);
    }
    
    swap(i, j) {
        if(i == j || i >= this.list.length || j >= this.list.length || i < 0 || j < 0) return;
        let temp = this.list[i];
        this.list[i] = this.list[j];
        this.list[j] = temp;
    }
}