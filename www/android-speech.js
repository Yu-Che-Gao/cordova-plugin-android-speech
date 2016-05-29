exports.show = function (success, error) {
    cordova.exec(success, error, "androidSpeech", "show", []);
};