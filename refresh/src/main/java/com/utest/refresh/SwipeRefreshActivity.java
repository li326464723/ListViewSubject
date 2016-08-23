package com.utest.refresh;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by lowry on 2016/8/22.
 */
public class SwipeRefreshActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener{
    private static final int REFRESH_COMPLETE = 0x11;
    private ListView myListView = null;
    private SwipeRefreshLayout mySwipeRefreshLayout = null;
    private ArrayAdapter<String> adapter = null;
    private List<String> datas = new ArrayList<String>(Arrays.asList("烧茄子","酱骨头","肉丸子","小炒肉"));
    private Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case REFRESH_COMPLETE :
                    ArrayList<String> newData = new ArrayList<String>(Arrays.asList("鲜橙汁","西瓜汁"));
                    if(!datas.containsAll(newData)){
                        datas.addAll(newData);
                        adapter.notifyDataSetChanged();
                    }else{
                        Toast.makeText(SwipeRefreshActivity.this,"已经是最新数据！",Toast.LENGTH_SHORT).show();
                    }
                    //刷新完成，取消刷新动画
                    mySwipeRefreshLayout.setRefreshing(false);
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe_refresh);
        init();
    }

    private void init() {
        mySwipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe);
        mySwipeRefreshLayout.setOnRefreshListener(this);
        mySwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_green_dark, android.R.color.holo_green_light,
                android.R.color.holo_orange_light, android.R.color.holo_red_light);
//        mySwipeRefreshLayout.setSize(500);
        //设置菊花背景颜色
//        mySwipeRefreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.holo_green_light);
        myListView = (ListView)findViewById(R.id.my_list_view);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datas);
        myListView.setAdapter(adapter);
    }

    @Override
    public void onRefresh() {
        //刷新时完成的动作
        //主线程
        Log.i("lowry", Thread.currentThread().getName());
        myHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE,5000);
    }
}
