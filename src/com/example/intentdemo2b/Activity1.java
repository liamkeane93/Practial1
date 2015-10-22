package com.example.intentdemo2b;
// Multi-Activity Application
// Activity1: collects two data items from the user's UI, places
//			  them into a Bundle, and calls Activity2
// Activity2: accepts two data items, adds them, returns result

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity1 extends Activity {
	EditText txtValue1;
	EditText txtValue2;
	EditText txtValue3;
	EditText txtValue4;
	EditText txtValue5;
	TextView txtResult;
	TextView txtResult1;
	TextView txtResult2;
	TextView txt;


	Button   btnAdd;
	Button   btnAdd1;

    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
		txtValue1 = (EditText)findViewById(R.id.EditText01);
		txtValue2 = (EditText)findViewById(R.id.EditText02);
		txtValue3 = (EditText)findViewById(R.id.EditText03);
		txtValue4 = (EditText)findViewById(R.id.EditText04);
		txtValue5 = (EditText)findViewById(R.id.EditText05);

		txtResult = (TextView) findViewById(R.id.txtResult);
		txtResult1 = (TextView) findViewById(R.id.txtResult1);
		txtResult2 = (TextView) findViewById(R.id.txtResult2);




        
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// get values from the UI
				Double v1 = Double.parseDouble(txtValue1.getText().toString());
				Double v2 = Double.parseDouble(txtValue2.getText().toString());
				Double v3 = Double.parseDouble(txtValue3.getText().toString());
				Double v4 = Double.parseDouble(txtValue4.getText().toString());
				Double v5 = Double.parseDouble(txtValue5.getText().toString());


				
				// create intent to call Activity2
				Intent myIntentA1A2 = new Intent (Activity1.this,
												  Activity2.class);
				// create a Bundle (MAP) container to ship data
				Bundle myDataBundle = new Bundle();
				
				// add <key,value> data items to the container

				double[] array1 = {v1,v2,v3,v4,v5};
				myDataBundle.putDoubleArray("MyArray1", array1);

				// attach the container to the intent
				myIntentA1A2.putExtras(myDataBundle);
				
				// call Activity2, tell your local listener to wait a 
				// response sent to a listener known as 101
				startActivityForResult(myIntentA1A2, 101);
				
			}
				
		});
		btnAdd1 = (Button) findViewById(R.id.btnAdd1);
		btnAdd1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				int v1 = 10;
				int v2 = 20;
				int v3 = 30;
				int v4 = 40;
				int v5 = 50;

				Intent myIntentA1A2 = new Intent (Activity1.this,
						Activity2.class);
				// create a Bundle (MAP) container to ship data
				Bundle myDataBundle = new Bundle();

				// add <key,value> data items to the container
				myDataBundle.putDouble("val1", v1);
				myDataBundle.putDouble("val2", v2);
				myDataBundle.putDouble("val3", v3);
				myDataBundle.putDouble("val4", v4);
				myDataBundle.putDouble("val5", v5);

				// attach the container to the intent
				myIntentA1A2.putExtras(myDataBundle);

				// call Activity2, tell your local listener to wait a
				// response sent to a listener known as 101
				startActivityForResult(myIntentA1A2, 101);

			}

		});

}//onCreate

    //////////////////////////////////////////////////////////////////////////////
    // local listener receives callbacks from other activities
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		try	{
			if ((requestCode == 101 ) && (resultCode == Activity.RESULT_OK)){
				Bundle myResultBundle = data.getExtras();
				Double myResult = myResultBundle.getDouble("vresult");
				txtResult.setText("Sum is " + myResult);
				Double myResult1 = myResultBundle.getDouble("maxResult");
				txtResult1.setText("Max is " + myResult1);
				Double myResult2 = myResultBundle.getDouble("minResult");
				txtResult2.setText("Min is " + myResult2);
			}
		}
		catch (Exception e) {
			txtResult.setText("Problems - " + requestCode + " " + resultCode);
		}
	}//onActivityResult
    
}//Activity1