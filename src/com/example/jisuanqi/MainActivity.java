package com.example.jisuanqi;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
	private Button bt0;
	private Button bt1;
	private Button bt2;
	private Button bt3;
	private Button bt4;
	private Button bt5;
	private Button bt6;
	private Button bt7;
	private Button bt8;
	private Button bt9;
	private Button bt_dian;
	private Button bt_c;
	private Button bt_del;
	private Button bt_jia;
	private Button bt_jian;
	private Button bt_cheng;
	private Button bt_chu;
	private Button bt_deng;
	private EditText xian;
	Boolean clear_flag;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bt0 = (Button) findViewById(R.id.q0);
		bt1 = (Button) findViewById(R.id.q1);
		bt2 = (Button) findViewById(R.id.q2);
		bt3 = (Button) findViewById(R.id.q3);
		bt4 = (Button) findViewById(R.id.q4);
		bt5 = (Button) findViewById(R.id.q5);
		bt6 = (Button) findViewById(R.id.q6);
		bt7 = (Button) findViewById(R.id.q7);
		bt8 = (Button) findViewById(R.id.q8);
		bt9 = (Button) findViewById(R.id.q9);
		bt_dian = (Button) findViewById(R.id.dian);
		bt_c = (Button) findViewById(R.id.clear);
		bt_del = (Button) findViewById(R.id.del);
		bt_jia = (Button) findViewById(R.id.jia);
		bt_jian = (Button) findViewById(R.id.jian);
		bt_cheng = (Button) findViewById(R.id.cheng);
		bt_chu = (Button) findViewById(R.id.chu);
		bt_deng = (Button) findViewById(R.id.deng);
		xian = (EditText) findViewById(R.id.editText1);
		
		
		
		bt0.setOnClickListener(MainActivity.this);
		bt1.setOnClickListener(MainActivity.this);
		bt2.setOnClickListener(MainActivity.this);
		bt3.setOnClickListener(MainActivity.this);
		bt4.setOnClickListener(MainActivity.this);
		bt5.setOnClickListener(MainActivity.this);
		bt6.setOnClickListener(MainActivity.this);
		bt7.setOnClickListener(MainActivity.this);
		bt8.setOnClickListener(MainActivity.this);
		bt9.setOnClickListener(MainActivity.this);
		bt_dian.setOnClickListener(MainActivity.this);
		bt_c.setOnClickListener(MainActivity.this);
		bt_del.setOnClickListener(MainActivity.this);
		bt_jia.setOnClickListener(MainActivity.this);
		bt_jian.setOnClickListener(MainActivity.this);
		bt_cheng.setOnClickListener(MainActivity.this);
		bt_chu.setOnClickListener(MainActivity.this);
		bt_deng.setOnClickListener(MainActivity.this);
		
		
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		String str = xian.getText().toString();
		switch (arg0.getId()) {
		case R.id.q0:
		case R.id.q1:
		case R.id.q2:
		case R.id.q3:
		case R.id.q4:
		case R.id.q5:
		case R.id.q6:
		case R.id.q7:
		case R.id.q8:
		case R.id.q9:
		case R.id.dian:
			if (clear_flag) {
				clear_flag = false;
				xian.setText("");
			}
			xian.setText(str+((Button)arg0).getText());
			break;
		case R.id.jia:
		case R.id.jian:
		case R.id.cheng:
		case R.id.chu:
			if (clear_flag) {
				clear_flag = false;
				xian.setText("");
			}
			xian.setText(str + " "+ ((Button)arg0).getText() + " " );
			break;
		case R.id.del:
			if (clear_flag) {
				clear_flag = false;
				xian.setText("");
			
			}else if (str!=null && str.equals("")) {
				xian.setText(str.substring(0, str.length()-1));
			}
			break;
		case R.id.clear:
			clear_flag = false;
			xian.setText("");
			break;
		case R.id.deng:
			getresult();
			break;
		}
		
	}

	private void getresult() {
		String exp = xian.getText().toString();
		if (exp==null||exp.equals("")) {
			return;
		}
		if (!exp.contains(" ")) {
			return;
		}if (clear_flag) {
			clear_flag = false;
			return;
		}
		clear_flag = true;
		double result = 0;
		String i1 = exp.substring(0,exp.indexOf(" "));
		String op = exp.substring(exp.indexOf(" ")+1, exp.indexOf(" ")+2);
		String i2 = exp.substring(exp.indexOf(" ")+3);
		if (!i1.equals("")&&!i2.equals("")) {
			double d1 = Double.parseDouble(i1);
			double d2 = Double.parseDouble(i2);
			if (op.equals("+")) {
				result = d1+d2;
			} else if(op.equals("-")){
				result = d1-d2;
			} else if(op.equals("¡Á")){
				result = d1*d2;
			} else if(op.equals("¡Â")){
				if (d2==0) {
					result = 0;
				} else {
					result = d1/d2;

				}
			}
			if (!i1.contains(".")&&!i2.contains(".")) {
				int r= (int) result;
				xian.setText(r+"");
			} else {
				xian.setText(result+"");
			}
		}
		else if(!i1.equals("")&&i2.equals("")){
			xian.setText(exp);
		}else if(i1.equals("")&&!i2.equals("")){
			double d2 = Double.parseDouble(i2);
			if (op.equals("+")) {
				result = 0+d2;
			} else if(op.equals(" ")){
				result = 0-d2;
			} else if(op.equals("¡Á")){
				result = 0;
			} else if(op.equals("¡Â")){
				if (d2==0) {
					result = 0;

			}
		}		if (!i2.contains(".")) {
			int r= (int) result;
			xian.setText(r+"");
		} else {
			xian.setText(result+"");
		}
	}else{
		xian.setText("");
	}


	}
		
}


