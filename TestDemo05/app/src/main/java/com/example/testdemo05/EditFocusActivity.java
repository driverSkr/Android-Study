package com.example.testdemo05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/*
* 输入框焦点变更监听器
* */
public class EditFocusActivity extends AppCompatActivity implements View.OnFocusChangeListener {

    private EditText et_phone;
    private EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_focus);

        et_phone = findViewById(R.id.et_phone);
        et_password = findViewById(R.id.et_password);
        //findViewById(R.id.btn_login).va

        //设置焦点变更监听事件
        /*不设置点击事件监听是因为：
            第一次点击输入框是触发焦点变更
            第二次点击才触发点击事件*/
        et_password.setOnFocusChangeListener(this);
    }

    /*
     * 当焦点变更到密码输入框时触发
     */
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus){
            String phone = et_phone.getText().toString();
            //手机号码不足11位
            if (TextUtils.isEmpty(phone) || phone.length() < 11){
                //手机号码编辑框请求焦点，也就是把光标移回手机号码编辑框
                et_phone.requestFocus();
                Toast.makeText(this,"请输入11位手机号码",Toast.LENGTH_SHORT).show();
            }
        }
    }
}