package com.hmkcode.android.sign;


import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AccountSettingsActivity extends Activity {
	String loggedInAs;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account_settings);
		
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
		loggedInAs = preferences.getString("User","");
	}

	public void changePassword(View view) {
		EditText oldPass = (EditText)findViewById(R.id.etOldPass);
		EditText newPass = (EditText)findViewById(R.id.etNewPass);
		EditText newPassConfirm = (EditText)findViewById(R.id.etNewPassConfirm);
	
		if (!newPass.getText().toString().equals(newPassConfirm.getText().toString())) {
			Toast.makeText(getApplicationContext(), "Entered new passwords do not match", Toast.LENGTH_LONG).show();
			return;
		}
		  JavaMD5Hash myMD5 = new JavaMD5Hash();

		  String hashedOld = myMD5.md5(oldPass.getText().toString()); 
		  String hashedNew = myMD5.md5(newPass.getText().toString());
		  
		  JSONParser jParser = new JSONParser();
		  
		  List<NameValuePair> params = new ArrayList<NameValuePair>();	  
		    params.add(new BasicNameValuePair("email", loggedInAs));

			params.add(new BasicNameValuePair("password", hashedOld));
		    
		    
		    JSONObject jsonLogin = jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/check_login_credentials.php", "GET", params);
		    
			try {
				JSONArray emailArray = jsonLogin.getJSONArray("email");
				JSONObject c = emailArray.getJSONObject(0);
				if (Integer.parseInt(c.getString("email")) > 0) {
					params = new ArrayList<NameValuePair>();
					 params.add(new BasicNameValuePair("email", loggedInAs));
					 params.add(new BasicNameValuePair("password", hashedNew));
					 jParser.makeHttpRequest("http://lostandfound.web.engr.illinois.edu/update_password.php", "POST", params);
					 Toast.makeText(getApplicationContext(), "Password successfully updated", Toast.LENGTH_LONG).show();
					 
						Intent intent = new Intent(this, HomeActivity.class);
						startActivity(intent);
				}
				else {
					Toast.makeText(getApplicationContext(), "You have mistyped your old password", Toast.LENGTH_LONG).show();
				}		
			} catch (JSONException e) {
				e.printStackTrace();
			}
	}
	

}
