// methods
exports.show = function (message) {
    cordova.exec(null, null, "NotificationService", "show", [message]);
};