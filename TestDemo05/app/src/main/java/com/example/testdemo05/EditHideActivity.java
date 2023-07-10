package com.example.testdemo05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.example.testdemo05.util.ViewUtil;

/*
* 文本变化监听器(输完内容，输入法软键盘自动退出）
* */
public class EditHideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_hide);

        EditText et_phone = findViewById(R.id.et_phone);
        EditText et_password = findViewById(R.id.et_password);

        et_phone.addTextChangedListener(new HideTextWatcher(et_phone,11));
        et_phone.addTextChangedListener(new HideTextWatcher(et_password,6));
    }

    //定义一个编辑框监听器，在输入文本达到指定长度时自动隐藏输入法
    private class HideTextWatcher implements TextWatcher {

        private EditText mView;
        private int mMaxLength;

        public HideTextWatcher(EditText v, int maxLength) {
            this.mView = v;
            this.mMaxLength = maxLength;
        }

        //在编辑框的输入文本变化后触发
        //Editable是EditText.getText()的返回类型
        @Override
        public void afterTextChanged(Editable s) {
            //获取已输入的文本字符串
            String str = s.toString();
            //输入文本达到11位（如手机号），或达到6位（如登录密码）时关闭输入法
            if (str.length() == mMaxLength){
                //隐藏输入法软键盘
                ViewUtil.hideOneInputMethod(EditHideActivity.this,mView);
            }
        }
        //在编辑框的输入文本变化前触发
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        //在编辑框的输入文本变化中触发
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }
    }
}