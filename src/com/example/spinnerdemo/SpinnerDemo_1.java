package com.example.spinnerdemo;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerDemo_1 extends Activity implements OnItemSelectedListener{

	private TextView textView;
	private Spinner spinner;
	private List<String> list;
	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spinner_1);
		textView = (TextView) this.findViewById(R.id.textView);
		textView.setText("您選擇的城市是北京");
		spinner = (Spinner) this.findViewById(R.id.spinner);
		// 设置数据源
		list = new ArrayList<String>();
		list.add("北京");
		list.add("上海");
		list.add("广州");
		list.add("深圳");
		// 创建数组适配器
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		// 设置一个adapter设置一个下拉样式
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// 加載適配器
		spinner.setAdapter(adapter);
		// spinner設置監聽器
        spinner.setOnItemSelectedListener(this);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long arg3) {
		 String cityName = adapter.getItem(position);
		//String  city = list.get(position);
		 textView.setText("您选择的城市是："+cityName);
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		 
	}
}
