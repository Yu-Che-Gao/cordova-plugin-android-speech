package com.gao.cordova.plugin;

import org.apache.cordova.*;
import org.json.*;
import android.widget.Toast; 
import android.speech.RecognizerIntent;
import android.content.Intent;
import java.util.*;

public class androidSpeech extends CordovaPlugin {
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if(action.equals("show")) {
			//透過 Intent 的方式開啟內建的語音辨識 Activity... 
              Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH); 
              String message=args.getString(0);
              intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM); 
              intent.putExtra(RecognizerIntent.EXTRA_PROMPT, message); //語音辨識 Dialog 上要顯示的提示文字 
              this.cordova.startActivityForResult(this, intent, 1);
            return true;
		}
		return false;		
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch(requestCode) {
            case 1:
                if(resultCode == android.app.Activity.RESULT_OK) {
                    ArrayList<String> resultList = intent.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS); 
                    String result=resultList.get(0);
                    this.callbackContext.success(result);
                } else {
                    this.callbackContext.error("語音辨識失敗");
                }
                break;
            default:
                break;
        }
    }
}