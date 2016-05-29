package com.gao.cordova.plugin;

import org.apache.cordova.*;
import org.json.*;
import android.widget.Toast; 

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
    
    public void returnResult(int code, String result) {
        Intent returnIntent=new Intent();
        returnIntent.putExtra("result", result);
        setResult(code, returnIntent);
        finish();
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent intent) { //TODO 尚未完成結果界接
        switch(requestCode) {
            case 0:
                if(resultCode == android.app.Activity.RESULT_OK) {
                    String result=intent.getStringExtra("result");
                    this.callbackContext.success(result);
                } else {
                    String message=intent.getStringExtra("result");
                    this.callbackContext.error(message);
                }
                break;
            default:
                break;
        }
    }
}