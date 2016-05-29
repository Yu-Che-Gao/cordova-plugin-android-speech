var exec=require('cordova/exec');

exports.startSpeech=function(success, error) {
    exec(success, error, 'androidSpeech', 'startSpeech', [])
};