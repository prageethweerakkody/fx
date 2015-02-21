package com.prageeth.con;

import java.util.ArrayList;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdaptor extends BaseAdapter {

	private Activity activity;
	private ArrayList data;
	private static LayoutInflater inflator = null;
	public Resources res;
	ListModel tempValues = null;
	int i = 0;

	public CustomAdaptor(Activity activityFromOut, ArrayList arraylistFromOut,
			Resources resLocal) {
		activity = activityFromOut;
		data = arraylistFromOut;
		res = resLocal;

		inflator = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	}

	/********* Create a holder Class to contain inflated xml file elements *********/
	public static class ViewHolder {

		public TextView symbol;
		public TextView country;
		public TextView rates;
		public ImageView image;

	}

	@Override
	public int getCount() {
		if (data.size() <= 0)
			return 1;
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		ViewHolder holder;

		if (convertView == null) {
			vi = inflator.inflate(com.prageeth.con.R.layout.tableitem, null);

			holder = new ViewHolder();
			holder.image = (ImageView) vi
					.findViewById(com.prageeth.con.R.id.image);
			holder.symbol = (TextView) vi
					.findViewById(com.prageeth.con.R.id.symbol);
			holder.country = (TextView) vi
					.findViewById(com.prageeth.con.R.id.country);
			holder.rates = (TextView) vi
					.findViewById(com.prageeth.con.R.id.rates);

			// for (int i = 0; i < data.size(); i++) {
			// ListModel listmodel = new ListModel();
			// listmodel = (ListModel) data.get(i);
			// holder.symbol.setText(listmodel.getSysmbol());

			// }
			vi.setTag(holder);

		} else {
			holder = (ViewHolder) vi.getTag();
		}

		if (data.size() <= 0) {

		} else {
			tempValues = null;
			tempValues = (ListModel) data.get(position);
			if (tempValues.getImage() != null) {
				holder.image.setImageResource(res.getIdentifier(
						"com.prageeth.con:drawable/" + tempValues.getImage(),
						null, null));
			}
			holder.symbol.setText(tempValues.getSysmbol());
			holder.country.setText(tempValues.getCountry());

			if (tempValues.getRates() != null) {
				Typeface tf = MainActivity.tf;
				holder.country.setTypeface(tf);

				holder.rates.setText(tempValues.getRates());
				holder.rates.setTypeface(tf);

			}

		}

		vi.setOnClickListener(new OnItemClickListener(position));

		/*
		 * ListView listView =(ListView)parent;
		 * listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
		 * {
		 * 
		 * @Override public void onItemClick(AdapterView<?> parent, View view,
		 * int position, long id) { tempValues=null; tempValues = ( ListModel )
		 * data.get( position ); String a = tempValues.getSysmbol(); String b =
		 * tempValues.getCountry(); if (convert == null) { ArrayList<String>
		 * conData = new ArrayList<String>(); Converter con = new
		 * Converter(conData);
		 * 
		 * }
		 * 
		 * 
		 * 
		 * //setContentView(com.prageeth.con.R.layout.converter);
		 * 
		 * 
		 * Log.i(a, b); //EditText setRate = (EditText)
		 * view.findViewById(com.prageeth.con.R.id.editText1);
		 * //setRate.setText( a);
		 * 
		 * 
		 * 
		 * } });
		 */

		return vi;
	}

	private class OnItemClickListener implements OnClickListener {
		private int mPosition;

		OnItemClickListener(int position) {
			mPosition = position;

		}

		@Override
		public void onClick(View arg0) {

			MainActivity sct = (MainActivity) activity;

			/****
			 * Call onItemClick Method inside CustomListViewAndroidExample Class
			 * ( See Below )
			 ****/

			sct.onItemClick(mPosition);
		}
	}

}
