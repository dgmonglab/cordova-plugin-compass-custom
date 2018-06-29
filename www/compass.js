function compass() {}

compass.prototype.getPosition = function(successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, 'compass', 'echo');
};

//
//compass.install = function() {
//    if (!window.plugins) {
//        window.plugins = {};
//    }
//
//    window.plugins.compass = new compass();
//    return window.plugins.compass;
//};
//
//cordova.addConstructor(compass.install);
