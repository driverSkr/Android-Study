package com.example.testdemo06;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

/*(添加“记住密码”代码逻辑)*/
public class LoginForgetActivity extends AppCompatActivity implements View.OnClickListener {

    private String mPhone;
    private String mVerifyCode;
    private EditText et_password_first;
    private EditText et_password_second;
    private EditText et_verifycode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_forget);

        et_password_first = findViewById(R.id.et_password_first);
        et_password_second = findViewById(R.id.et_password_second);
        et_verifycode = findViewById(R.id.et_verifycode);

        findViewById(R.id.btn_verifycode).setOnClickListener(this);
        findViewById(R.id.btn_confirm).setOnClickListener(this);

        // 从上一个页面获取要修改密码的手机号码
        mPhone = getIntent().getStringExtra("phone");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //点击了“获取验证码”按钮
            case R.id.btn_verifycode:
                //生产六位随即数字的验证码
                mVerifyCode = String.format("%06d",new Random().nextInt(999999));
                // 以下弹出提醒对话框，提示用户记住六位验证码数字
                AlertDialog.Builder buider = new AlertDialog.Builder(this);
                buider.setTitle("请记住验证码");
                buider.setMessage("手机号" + mPhone + ",本次验证码是" + mVerifyCode + ",请输入验证码");
                buider.setPositiveButton("好的", null);
                AlertDialog dialog = buider.create();
                dialog.show();
                break;
            //点击了“确定”按钮
            case R.id.btn_confirm:
                String password_first = et_password_first.getText().toString();
                String password_second = et_password_second.getText().toString();
                if (password_first.length() < 6){
                    Toast.makeText(this,"请输入正确的密码",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password_first.equals(password_second)){
                    Toast.makeText(this,"两次输入的密码不一致",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!mVerifyCode.equals(et_verifycode.getText().toString())){
                    Toast.makeText(this,"请输入正确的验证码",Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(this,"密码修改成功",Toast.LENGTH_SHORT).show();
                //以下把修改好的新密码返回给上一个页面
                Intent intent = new Intent();
                intent.putExtra("new_password",password_first);
                setResult(Activity.RESULT_OK,intent);
                finish();
                break;
        }
    }
}