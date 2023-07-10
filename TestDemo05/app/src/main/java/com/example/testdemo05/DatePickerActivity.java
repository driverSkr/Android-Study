package com.example.testdemo05;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

/*
* DatePicker日期选择器
* DatePickerDialog对话框
* */
public class DatePickerActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private DatePicker dp_date;
    private TextView tv_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);

        findViewById(R.id.btn_ok).setOnClickListener(this);
        findViewById(R.id.btn_date).setOnClickListener(this);
        dp_date = findViewById(R.id.dp_date);
        tv_date = findViewById(R.id.tv_date);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
/*DatePicker日期选择器*/
            case R.id.btn_ok:
                //dp_date.getMonth()是从0-11，所以需要+1
                String desc = String.format("您选择的日期是%d年%d月%d日",dp_date.getYear(),dp_date.getMonth()+1,dp_date.getDayOfMonth());
                tv_date.setText(desc);
                break;
/*DatePickerDialog对话框*/
            case R.id.btn_date:
                //获取日历的一个实例，里面包含了当前的年月日
                /*Calendar calendar = Calendar.getInstance();
                calendar.get(Calendar.YEAR);
                calendar.get(Calendar.MONTH);
                calendar.get(Calendar.DAY_OF_MONTH);*/
                DatePickerDialog dialog = new DatePickerDialog(this,this,2090,6,11);
                //显示日期对话框
                dialog.show();
                break;
        }
    }

    //日期对话框的监听事件
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String desc = String.format("您选择的日期是%d年%d月%d日",year,month+1,dayOfMonth);
        tv_date.setText(desc);
    }
}