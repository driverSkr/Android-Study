package com.example.testdemo04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
//跳转到ActFinishActivity
//展示生命周期方法的调用顺序
public class ActStartActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ning";

    //创建活动
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"ActStartActivity onCreate");
        setContentView(R.layout.activity_act_start);

        findViewById(R.id.btn_act_next).setOnClickListener(this);
    }

    //开始活动
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"ActStartActivity onStart");
    }

    //恢复活动
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"ActStartActivity onResume");
    }
/*-------------------------------------Activity is running-----------------------------------------*/
    //暂停活动
    //跳转到别的activity执行
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"ActStartActivity onPause");
    }

    //停止活动
    //当activity不可见时执行
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"ActStartActivity onStop");
    }

    //重启活动
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"ActStartActivity onRestart");
    }

    //销毁活动
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"ActStartActivity onDestroy");
    }

    //重用已有的活动实例
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG,"ActStartActivity onNewIntent");
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,ActFinishActivity.class));
    }
}