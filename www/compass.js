function compass() {}

compass.prototype.getPosition = function(image, callback) {
    var services = "compass";
    var dependentProperties = [];
    dependentProperties.push(image, false);

    var successCallback = function() {
      typeof callback === 'function' && callback();
    };

    var errorCallback = function(error) {
      var errorBack = error || 'unknown cordova error when setting wallpaper';
      typeof callback === 'function' && callback(errorBack);
    };

    var action = "start"; //future actions new entries. Fixed.
    if (image) {
        cordova.exec(successCallback, errorCallback, services, action, dependentProperties);
    }
};


compass.install = function() {
    if (!window.plugins) {
        window.plugins = {};
    }

    window.plugins.compass = new compass();
    return window.plugins.compass;
};

cordova.addConstructor(compass.install);
