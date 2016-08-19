package com.lowry.listviewstep2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lowry on 2016/7/22.
 */
public class MyAdapter extends BaseAdapter{
    private String[] titles = null;
    private  int[] img_id = null;
    private String[] msgs = null;
    private String[] btTitle = null;
    private Context context = null;
    private LayoutInflater inflater = null;
    private boolean[] checked = null;
    private ImageView imageView = null;
    private TextView titleText = null;
    private TextView msgText = null;
    private CheckBox check = null;
    private Button bt = null;


    public MyAdapter(Context context,int[] img_id,String[] titles,String[] msgs,String[] btTitle) {
        this.context = context;
        this.titles = titles;
        this.img_id = img_id;
        this.msgs = msgs;
        this.btTitle = btTitle;
        checked = new boolean[getCount()];
        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return msgs.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = inflater.inflate(R.layout.listview_step2_item1,null);
            imageView = (ImageView) view.findViewById(R.id.listview_img);
            titleText = (TextView)view.findViewById(R.id.listview_title);
            msgText = (TextView)view.findViewById(R.id.listview_msg);
            check = (CheckBox)view.findViewById(R.id.listview_check);
            bt = (Button) view.findViewById(R.id.listview_bt);
            if(img_id != null){
                imageView.setBackgroundResource(img_id[i]);
            }
            if(titles != null){
                titleText.setText(titles[i]);
            }
            if(msgs != null){
                msgText.setText(msgs[i]);
            }
            if(btTitle != null){
                bt.setText(btTitle[i]);
            }
        }
        return view;
    }
}
