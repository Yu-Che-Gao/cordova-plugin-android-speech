package com.gao.cordova.plugin.androidSpeech;

import org.apache.cordova.*;
import org.json.*;
import android.widget.Toast;

public class androidSpeech extends CordovaPlugin {
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if(action.equals("startSpeech")) {
            String message=args.getString(0);
            Toast.makeText(this.cordova.getActivity(), message, Toast.LENGTH_LONG).show();
            return true;
        }
        
        return false;
    }
}