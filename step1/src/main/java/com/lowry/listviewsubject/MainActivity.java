package com.lowry.listviewsubject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
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
        listView = (ListView)findViewById(R.id.step1_listview);
        listView.setOnItemClickListener(this);
        listView.setOnItemSelectedListener(this);
        listView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                MenuInflater mf = getMenuInflater();
                mf.inflate(R.menu.listview_step1_menu,contextMenu);
            }
        });

        Button step1 = new Button(this);
        step1.setText("形式一");
        step1.setOnClickListener(this);
        step1.setId(R.id.bt_step1);
        buttonLayout.addView(step1);

        Button step2 = new Button(this);
        step2.setText("形式二");
        step2.setOnClickListener(this);
        step2.setId(R.id.bt_step2);
        buttonLayout.addView(step2);

        Button step3 = new Button(this);
        step3.setText("形式三");
        step3.setOnClickListener(this);
        step3.setId(R.id.bt_step3);
        buttonLayout.addView(step3);

        Button step4 = new Button(this);
        step4.setText("自定义");
        step4.setOnClickListener(this);
        step4.setId(R.id.bt_step4);
        buttonLayout.addView(step4);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_step1:
                ListAdapter listAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_activated_1,strs);
                listView.setAdapter(listAdapter);
                break;
            case R.id.bt_step2:
                ListAdapter listAdapter2 = new ArrayAdapter(this,android.R.layout.simple_list_item_checked,strs);
                listView.setAdapter(listAdapter2);
                break;
            case R.id.bt_step3:
                ListAdapter listAdapter3 = new ArrayAdapter(this,android.R.layout.simple_list_item_multiple_choice,strs);
                listView.setAdapter(listAdapter3);
                break;
            case R.id.bt_step4:
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
