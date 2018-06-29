function compass() {}

compass.prototype.getPosition = function(successCallback, errorCallback, action) {
    cordova.exec(successCallback, errorCallback, 'compass', action);
};


compass.install = function() {
    if (!window.plugins) {
        window.plugins = {};
    }

    window.plugins.compass = new compass();
    return window.plugins.compass;
};

cordova.addConstructor(compass.install);
