class Controller {
    constructor() {
        this.model = new Model();
        this.view = new View();
    }
    
    setWindowLoaded() {
        console.log('Window Loaded');
        
        this.view.displayLoginPage();
    }
    
    async processLoginButtonClick(username, password) {
        console.log(`Logging in "${username}"...`);
        
        try {
            await window.api.login(username, password);
            window.controller.setLoggedIn(username);
        } catch(error) {
            alert(error);
            return;
        }
        
        try {
            this.setList(await window.api.getList());
        } catch(error) {
            alert(error);
            window.location.reload();
            return;
        }
    }
    
    setLoggedIn(username) {
        console.log(`Logged in as "${username}"`);
        
        this.model.setUsername(username);
        this.view.displayListPage();
    }
    
    setList(list) {
        console.log('Set list as', list);
        
        this.model.setList(list);
        this.view.redrawList(this.model.getList());
    }
    
    addItem(name) {
        if(name.length == 0) alert('invalid item');
        
        console.log(`Adding item "${name}"`);
        
        this.model.addItem(name);
        this.view.redrawList(this.model.getList());
    }
    
    removeItemAtIndex(i) {
        console.log(`Remove item at index ${i}`);
        this.model.removeItemAtIndex(i);
        this.view.redrawList(this.model.getList());
    }
    
    moveItemUpAtIndex(i) {
        console.log(`Move item up at index ${i}`);
        
        this.model.swap(i - 1, i);
        this.view.redrawList(this.model.getList());
    }
    
    moveItemDownAtIndex(i) {
        console.log(`Move item down at index ${i}`);
        
        this.model.swap(i + 1, i);
        this.view.redrawList(this.model.getList());
    }
    
    async handleSaveButtonClick() {
        console.log('Saving...');
        
        try {
            await window.api.setList(this.model.getList());
        } catch(error) {
            alert(error);
        }
    }
}