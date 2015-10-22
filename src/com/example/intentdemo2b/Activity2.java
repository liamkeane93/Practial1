package com.example.intentdemo2b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends Activity implements OnClickListener{
	EditText dataReceived;
	Button  btnDone;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);
		dataReceived = (EditText) findViewById(R.id.etDataReceived);
		btnDone = (Button) findViewById(R.id.btnDone);
		btnDone.setOnClickListener(this);
		
		// pick call made to Activity2 via Intent
		Intent myLocalIntent = getIntent();
		
		// look into the bundle sent to Activity2 for data items
		//Bundle myBundle =  myLocalIntent.getExtras();


		//Bundle myDataBundle  = myLocalIntent.getExtras();
		Bundle myBundle =  myLocalIntent.getExtras();


		double[] array1 =myBundle.getDoubleArray("MyArray1");


		double vResult = array1[0] + array1[1]+ array1[2] + array1[3]+ array1[4];
		double maxResult = 0;
		double minResult = 8000;

		for(int i=0; i< array1.length; i++)
		{
			if(array1[i]>= maxResult )
				maxResult=array1[i];
			if(array1[i]<= minResult )
				minResult=array1[i];
		}


		// operate on the input data
		//Double vResult =  v1 + v2 + v3 + v4 +v5;
		//Double maxResult = v5;
		//Double minResult = v1;

		
		// for illustration purposes. show data received & result
		dataReceived.setText("Data received is \n"
				+ "val1= " + array1[0]
				+ "\nval2= " + array1[1]
				+ "\nval3= " + array1[2]
				+ "\nval4= " + array1[3]
				+ "\nval5= " + array1[4]);

			//	+ "\n\nresult= " + vResult);
		
		// add to the bundle the computed result  
		myBundle.putDouble("vresult", vResult);
		myBundle.putDouble("maxResult", maxResult);
		myBundle.putDouble("minResult", minResult);
		
		// attach updated bumble to invoking intent
		myLocalIntent.putExtras(myBundle);
		
		// return sending an OK signal to calling activity
		setResult(Activity.RESULT_OK, myLocalIntent);
		
		// experiment: remove comment
		// finish();
	
	}//onCreate

	@Override
	public void onClick(View v) {
		    // close current screen - terminate Activity2
			finish();		
	}
	
}
