package com.utest.refresh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RefreshMainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button swipeBt = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_main);
        initView();
    }

    private void initView() {
        swipeBt = (Button)findViewById(R.id.swipe_bt);
        swipeBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.swipe_bt:
                jumpActivity(SwipeRefreshActivity.class);
                break;
        }
    }

    private void jumpActivity(Class<?> activityClass) {
        Intent intent = new Intent(RefreshMainActivity.this, activityClass);
        startActivity(intent);
    }
}
