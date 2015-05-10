package com.example.spinnerdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerDemo_2 extends Activity {
	private TextView textView2;
	private Spinner spinner2;
	private SimpleAdapter adapter;
	private List<Map<String, Object>> dataList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spinner_2);
		dataList = new ArrayList<Map<String,Object>>();
		getData();
		textView2 = (TextView) this.findViewById(R.id.textView2);
		spinner2 = (Spinner) this.findViewById(R.id.spinner2);
		adapter = new SimpleAdapter(this, dataList, R.layout.item,
				new String[] { "image", "text" }, new int[] { R.id.image,
						R.id.text });
		//设置下拉样式
		adapter.setDropDownViewResource(R.layout.item);
		spinner2.setAdapter(adapter);
		//设置响应时间
		spinner2.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View view,
					int position, long arg3) {
				textView2.setText("您选择的是"+adapter.getItem(position));
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				textView2.setText("NONE");
			}
			
		});
	}
	
	private void getData() {
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("image", R.drawable.ic_launcher);
		map1.put("text", "北京");
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("image", R.drawable.ic_launcher);
		map2.put("text", "上海");
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("image", R.drawable.ic_launcher);
		map3.put("text", "广州");
		
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("image", R.drawable.ic_launcher);
		map4.put("text", "深圳");
		
		dataList.add(map1);
		dataList.add(map2);
		dataList.add(map3);
		dataList.add(map4);
	}
}
