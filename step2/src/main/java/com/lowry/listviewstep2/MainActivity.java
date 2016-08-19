package com.lowry.listviewstep2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener,AdapterView.OnItemSelectedListener{
    private ListView listView = null;
    private LinearLayout buttonLayout = null;
    private String[] strs = new String[]{"擎天柱","威震天","大黄蜂"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        buttonLayout = (LinearLayout)findViewById(R.id.button_layout);
        listView = (ListView)findViewById(R.id.step2_listview);
        listView.setOnItemClickListener(this);
        listView.setOnItemSelectedListener(this);


        Button step1 = new Button(this);
        step1.setText("形式一");
        step1.setOnClickListener(this);
        step1.setId(R.id.bt_step1);
        buttonLayout.addView(step1);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_step1:
                strs = new String[1000];
                for(int i = 0 ; i < 1000; i++){
                    strs[i] = "擎天柱" + i + "号";
                }
                Log.i("lowry","==================>>" + strs.length);
                for(String s : strs){
                    Log.i("lowry","========ss==========>>" + s);
                }
                ListAdapter listAdapter4 = new MyAdapter(this,null,null,strs,null);
                listView.setAdapter(listAdapter4);
                break;

        }
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this,"点击了" + strs[i],Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this,"选择了" + strs[i],Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this,"没选择",Toast.LENGTH_SHORT).show();
    }
}
