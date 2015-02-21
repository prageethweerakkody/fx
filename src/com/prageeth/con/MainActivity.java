package com.prageeth.con;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.jar.JarException;

import org.apache.http.Header;
import org.apache.http.HttpConnection;
import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.widget.ScrollingTabContainerView.TabView;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private static final Context MainActivity = null;
	private ProgressDialog progress;
	ListView list;
	CustomAdaptor adapter;
	public MainActivity main = null;
	public static Typeface tf = null;
	public ArrayList<ListModel> listModelArray = new ArrayList<ListModel>();
	public static String yen = null;
	public static String Euro = null;
	public static String GBP = null;
	public static String AUD = null;
	public static String NZD = null;
	public static String CNY = null;
	public static String TWD = null;
	public static String KRW = null;
	public static String CAD = null;
	public static String LKR = null;
	public static String HKD = null;
	public static String SGD = null;
	public static String INR = null;
	public static String CHF = null;
	public static String BRL = null;
	public static String MYR = null;
	public static String NOK = null;
	public static String RUB = null;
	public static String VND = null;
	public static String EGP = null;
	public static String BDT = null;
	public static String CLF = null;
	public static String AED = null;
	public static String EEK = null;
	public static String IQD = null;
	public static String NGN = null;
	public static String QAR = null;
	public static String ZAR = null;
	public static String SYP = null;

	public void open(View view) {
		progress.setMessage("Loading....");
		progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progress.setIndeterminate(true);
		progress.show();

		final int totalProgressTime = 3;

		final Thread t = new Thread() {

			@Override
			public void run() {

				try {
					sleep(200);

					progress.setProgress(totalProgressTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		};
		t.start();

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		progress = new ProgressDialog(this);
		open(list);
		main = this;

		tf = Typeface.createFromAsset(getAssets(), "GalSILB.ttf");

		// Button doit = (Button) findViewById(R.id.list);
		// final EditText usdvalue = (EditText) findViewById(R.id.USD);
		// final TextView gbpvalue = (TextView) findViewById(R.id.GBP);
		// doit.setOnClickListener(new OnClickListener() {

		// @Override
		// public void onClick(View v) {

		AsyncHttpClient client = new AsyncHttpClient();
		client.get(
				"https://openexchangerates.org/api/latest.json?app_id=bad0c83dabf74786a4bd0bdc795137b2",
				new AsyncHttpResponseHandler() {

					@Override
					public void onFailure(int arg0, Header[] arg1, byte[] arg2,
							Throwable arg3) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(int statusCode, Header[] headers,
							byte[] response) {
						Context context = getApplicationContext();
						String text = String.valueOf(statusCode);
						int duration = Toast.LENGTH_SHORT;

						try {

							String responsValues = new String(response);
							JSONObject jsonobj = new JSONObject(responsValues);
							JSONObject rate = jsonobj.getJSONObject("rates");
							// JSONObject time =
							// jsonobj.getJSONObject("timestamp");

							String date = jsonobj.getString("timestamp");

							Double jp = rate.getDouble("JPY");
							yen = jp.toString();
							Double euro = rate.getDouble("EUR");
							Euro = euro.toString();
							Double gbp = rate.getDouble("GBP");
							GBP = gbp.toString();
							Double aud = rate.getDouble("AUD");
							AUD = aud.toString();
							Double nzd = rate.getDouble("NZD");
							NZD = nzd.toString();
							Double cny = rate.getDouble("CNY");
							CNY = cny.toString();
							Double twd = rate.getDouble("TWD");
							TWD = twd.toString();
							Double krw = rate.getDouble("KRW");
							KRW = krw.toString();
							Double cad = rate.getDouble("CAD");
							CAD = cad.toString();
							Double slk = rate.getDouble("LKR");
							LKR = slk.toString();
							Double hkd = rate.getDouble("HKD");
							HKD = hkd.toString();
							Double sgd = rate.getDouble("SGD");
							SGD = sgd.toString();
							Double inr = rate.getDouble("INR");
							INR = inr.toString();
							Double chf = rate.getDouble("CHF");
							CHF = chf.toString();
							Double brl = rate.getDouble("BRL");
							BRL = brl.toString();
							Double myr = rate.getDouble("MYR");
							MYR = myr.toString();
							Double nok = rate.getDouble("NOK");
							NOK = nok.toString();
							Double vnd = rate.getDouble("VND");
							VND = vnd.toString();
							Double egp = rate.getDouble("EGP");
							EGP = egp.toString();
							Double bdt = rate.getDouble("BDT");
							BDT = bdt.toString();
							Double clf = rate.getDouble("CLF");
							CLF = clf.toString();
							Double aed = rate.getDouble("AED");
							AED = aed.toString();
							Double eek = rate.getDouble("EEK");
							EEK = eek.toString();
							Double iqd = rate.getDouble("IQD");
							IQD = iqd.toString();
							Double ngn = rate.getDouble("NGN");
							NGN = ngn.toString();
							Double qar = rate.getDouble("QAR");
							QAR = qar.toString();
							Double zar = rate.getDouble("ZAR");
							ZAR = zar.toString();
							Double syp = rate.getDouble("SYP");
							SYP = syp.toString();

							// gbpvalue.setText(gbp.toString());

							// Double usdcurrent =
							// Double.valueOf(usdvalue.getyText().toString());
							// Double gbpcurrent =
							// Double.valueOf(gbpvalue.getText().toString());

							// Double gbps = usdcurrent * gbp;

							// String s = String.valueOf(gbp);
							// Toast toast = Toast.makeText(context,
							// yen,Toast.LENGTH_LONG);
							// toast.show();

							setContentView(R.layout.activity_main);
							String epochString = date;
							long epoch = Long.parseLong(epochString);
							Date updatedTime = new Date(epoch * 1000);

							TextView header = (TextView) findViewById(com.prageeth.con.R.id.textView1);
							header.setText("最終更新日時:" + updatedTime.toString());

							TextView header2 = (TextView) findViewById(com.prageeth.con.R.id.textView2);
							header2.setText("レートは1時間ごとに更新されます");

							TextView header3 = (TextView) findViewById(com.prageeth.con.R.id.textView3);
							header3.setText("ベース通貨:USドル");
							header3.setTypeface(tf);

							String[] images = { "japan", "euro", "british",
									"australia", "taiwan", "korea", "canada",
									"srilanka", "hongkong", "singapore",
									"india", "swiss", "brazil", "china",
									"malaysia", "noway", "russia", "vietnam",
									"newzealand", "egyptian", "bangladesh",
									"chilean", "emirates", "estonian", "iraq",
									"nigeria", "qatar", "southafrica", "syrian" };
							String[] symbols = { "JPY", "EUR", "GBP", "AUD",
									"TWD", "KRW", "CAD", "LKR", "HKD", "SGD",
									"INR", "CHF", "BRL", "CNY", "MYR", "NOK",
									"RUB", "VND", "NZD", "EGP", "BDT", "CLF",
									"AED", "EEK", "IQD", "NGN", "QAR", "ZAR",
									"SYP" };
							String[] country = { "日本円", "ユーロ", "英国ポンド",
									"オーストラリアドル", "台湾 ニュードル", "韓国ウォン", "カナダ・ドル",
									"スリランカ・ルピー", "香港ドル", "シンガポールドル", "インド・ルピー",
									"スイス フラン", "ブラジルレアル", "中国. 人民元",
									"マレーシアリンギット", "ノルウェークローネ", "ロシアルーブル",
									"ベトナムドン", "ニュージーランド ドル", "エジプトポンド",
									"バングラデシュタカ", "チリペソ", "エミレーツディルハム",
									"エストニアクルーン", "イラクディナール", "ナイジェリアナイラ",
									"カタール リアル", "南アフリカランド", "シリアポンド" };
							String[] rates = { yen, Euro, GBP, AUD, TWD, KRW,
									CAD, LKR, HKD, SGD, INR, CHF, BRL, CNY,
									MYR, NOK, RUB, VND, NZD, EGP, BDT, CLF,
									AED, EEK, IQD, NGN, QAR, ZAR, SYP };

							for (int i = 0; i < images.length; i++) {

								ListModel listmodel = new ListModel();
								listmodel.setImage(images[i]);
								listmodel.setSysmbol(symbols[i]);
								listmodel.setCountry(country[i]);
								listmodel.setRates(rates[i]);
								listModelArray.add(listmodel);
							}

							Resources res = getResources();
							list = (ListView) findViewById(R.id.list);

							adapter = new CustomAdaptor(main, listModelArray,
									res);
							list.setAdapter(adapter);

							progress.dismiss();

						} catch (Exception e) {
							e.printStackTrace();

						}

					}

				});
		// }
		// });

		// setListData();

	}

	public void setListData() {

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void onItemClick(int mPosition) {
		ListModel tempValues = listModelArray.get(mPosition);
		setContentView(com.prageeth.con.R.layout.converter);
		TextView setCurr = (TextView) findViewById(com.prageeth.con.R.id.textView3);
		setCurr.setTypeface(tf);
		setCurr.setText(tempValues.getRates());

		TextView country = (TextView) findViewById(com.prageeth.con.R.id.textView2);
		country.setTypeface(tf);
		country.setText(tempValues.getCountry());
		calculate();

	}

	public void calculate() {

		Button b = (Button) findViewById(com.prageeth.con.R.id.button1);
		b.setTypeface(tf);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				EditText getAmount = (EditText) findViewById(com.prageeth.con.R.id.editText3);
				getAmount.setTypeface(tf);
				String aa = getAmount.getText().toString();
				if (getAmount.getText().toString().length() < 1) {
					Toast.makeText(main, "ドル量を入力してください", Toast.LENGTH_LONG)
							.show();
				} else {

					TextView tsetRae = (TextView) findViewById(com.prageeth.con.R.id.textView3);
					String ss = tsetRae.getText().toString();

					TextView tsetRaed = (TextView) findViewById(com.prageeth.con.R.id.textView2);
					String sss = tsetRaed.getText().toString();

					double i = Double.parseDouble(aa);
					double rate = Double.parseDouble(ss);
					double totals = i * rate;
					DecimalFormat df = new DecimalFormat("#");
					df.setMaximumFractionDigits(2);

					// TextView c = (TextView)
					// findViewById(com.prageeth.con.R.id.textView5);
					// c.setText(String.valueOf(df.format(totals))+" "+sss);
					// c.setTypeface(tf);

					AlertDialog alertDialog = new AlertDialog.Builder(main)
							.create(); // Read Update
					alertDialog.setTitle("USD:" + aa + "=");
					alertDialog.setMessage(df.format(totals) + " " + sss);

					alertDialog.setButton("OK",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// here you can add functions
								}
							});

					alertDialog.show();

				}
			}
		});
	}

	@Override
	public void onBackPressed() {
		RelativeLayout layout2 = (RelativeLayout) findViewById(R.id.rel);

		if (layout2 != null) {
			Intent present = getIntent();
			finish();
			Intent i = new Intent(MainActivity.this, MainActivity.class);
			startActivity(i);
			return;
		} else {
			finish();
		}

	}

}
