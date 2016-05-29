exports.show = function (message) {
    cordova.exec(success, error, "androidSpeech", "show", [message]);
};