exports.show = function (message) {
    cordova.exec(null, null, "androidSpeech", "show", [message]);
};