package com.clk.cordova.sample;

import org.apache.cordova.*;
import org.json.*;
import android.widget.Toast; 


public class NotificationService extends CordovaPlugin {
	
	// methods
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		
		// show
		if(action.equals("show")) {

			// arguments
			String message = args.getString(0); 

			// execute
			Toast.makeText(this.cordova.getActivity(), message, Toast.LENGTH_LONG).show();
		
			// return
			return true;
		}
		
		// default
		return false;		
    }
}