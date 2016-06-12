exports.show = function (showMessage, success, error) {
    cordova.exec(success, error, "androidSpeech", "show", [showMessage]);
};