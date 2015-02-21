package com.prageeth.con;

import java.util.ArrayList;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.EditText;

public class Converter extends Activity {

	ArrayList<String> listArray = new ArrayList<String>();

	public Converter(ArrayList list) {
		listArray = list;
		new asyc().execute("");
	}

	public Converter() {
		// TODO Auto-generated constructor stub
	}

	private class asyc extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			setContentView(com.prageeth.con.R.layout.converter);

			return null;
		}

	}

}
