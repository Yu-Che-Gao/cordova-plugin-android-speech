exports.startSpeech=function(message) {
    cordova.exec(null, null, 'androidSpeech', 'startSpeech', [message]);
};