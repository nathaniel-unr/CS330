function createLoginPage() {
    let page = document.createElement('div');
    
    let title = document.createElement('h1');
    title.innerText = 'Login';
    
    let usernameInputDiv = document.createElement('div');
    let usernameInput = document.createElement('input');
    usernameInput.type = 'text';
    usernameInput.placeholder = 'Username';
    usernameInputDiv.appendChild(usernameInput);
    
    let passwordInputDiv = document.createElement('div');
    let passwordInput = document.createElement('input');
    passwordInput.type = 'password';
    passwordInput.placeholder = 'Password';
    passwordInputDiv.appendChild(passwordInput);
    
    let loginButton = document.createElement('button');
    loginButton.innerText = 'Login';
    loginButton.addEventListener('click', () => {
        let username = usernameInput.value;
        let password = passwordInput.value;
            
        window.controller.processLoginButtonClick(username, password);
    });
    
     page.appendChild(title);
     page.appendChild(usernameInputDiv);
     page.appendChild(passwordInputDiv);
     page.appendChild(loginButton);
    
    return page;
}

function removeAllChildren(parent) {
    while (parent.firstChild) 
            parent.removeChild(parent.firstChild);
}

class View {
    constructor() {
        this.loginPage = createLoginPage();
        
        this.listPage = document.createElement('div');
        
        let title = document.createElement('h1');
        title.innerText = 'Shopping List';
        
        let nameInput = document.createElement('input');
        nameInput.type = 'text';
        nameInput.placeholder = 'New Item';
        
        let addButton = document.createElement('button');
        addButton.innerText = 'Add';
        addButton.addEventListener('click', () => {
            let name = nameInput.value;
            window.controller.addItem(name);
        });
        
        let newItemDiv = document.createElement('div');
        newItemDiv.appendChild(nameInput);
        newItemDiv.appendChild(addButton);
        
        let saveButton = document.createElement('button');
        saveButton.innerText = 'Save';
        saveButton.addEventListener('click', () => {
            window.controller.handleSaveButtonClick();
        });
        
        this.list = document.createElement('ul');
        
        this.listPage.appendChild(title);
        this.listPage.appendChild(newItemDiv);
        this.listPage.appendChild(saveButton);
        this.listPage.appendChild(this.list);
    }
    
    displayLoginPage() {
        removeAllChildren(document.body);
        
        document.body.appendChild(this.loginPage);
    }
    
    displayListPage() {
        removeAllChildren(document.body);
        
        document.body.appendChild(this.listPage);
    }
    
    redrawList(list) {
        removeAllChildren(this.list);
        
        for(let i = 0; i < list.length; i++) {
            let el = document.createElement('li');
            el.style['display'] = 'flex';
            el.style['justify-content'] = 'space-between';
            
            let nameEl = document.createElement("p");
            nameEl.innerText = list[i];
            nameEl.style['display'] = 'inline';
            el.appendChild(nameEl);
            
            let buttonDiv = document.createElement('div');
            
            let upButton = document.createElement('button');
            upButton.innerText = '+';
            upButton.addEventListener('click', () => {
                window.controller.moveItemUpAtIndex(i);
            });
            buttonDiv.appendChild(upButton);
            
            let downButton = document.createElement('button');
            downButton.innerText = '-';
            downButton.addEventListener('click', () => {
                window.controller.moveItemDownAtIndex(i);
            });
            buttonDiv.appendChild(downButton);
            
            let removeButton = document.createElement('button');
            removeButton.innerText = 'X';
            removeButton.addEventListener('click', () => {
                window.controller.removeItemAtIndex(i);
            });
            buttonDiv.appendChild(removeButton);
            
            el.appendChild(buttonDiv);
            
            this.list.appendChild(el);
        }
    }
}