package com.example.testdemo06;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

/*
* SharePreferences用法
* */
public class ShareWriteActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_name;
    private EditText et_age;
    private EditText et_height;
    private EditText et_weight;
    private CheckBox ck_married;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_write);

        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_height = findViewById(R.id.et_height);
        et_weight = findViewById(R.id.et_weight);
        ck_married = findViewById(R.id.ck_married);

        findViewById(R.id.btn_save).setOnClickListener(this);

        //获得SharePreferences(config指文件命名)
        preferences = getSharedPreferences("config", Context.MODE_PRIVATE);
        //读取保存在SharePreferences里面的数据
        reload();
    }

    @Override
    public void onClick(View v) {
        String name = et_name.getText().toString();
        String age = et_age.getText().toString();
        String height = et_height.getText().toString();
        String weight = et_weight.getText().toString();

        //获得SharePreferences编辑器
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name",name);
        editor.putInt("age",Integer.parseInt(age));
        editor.putFloat("height",Float.parseFloat(height));
        editor.putFloat("weight",Float.parseFloat(weight));
        editor.putBoolean("married",ck_married.isChecked());
        //编辑器提交
        editor.commit();

        //提醒对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("success");
        builder.setMessage("SharePreferences数据保存成功");
        builder.setPositiveButton("确定",(dialog, which) -> {
            et_name.setText("");
            et_age.setText("");
            et_height.setText("");
            et_weight.setText("");
            ck_married.setChecked(false);
        });
        builder.create().show();
    }
    private void reload() {
        //defValue:若文件里没有指，设定默认值
        //从SharePreferences中获取相应数据
        String name = preferences.getString("name", null);
        if (name != null) {
            et_name.setText(name);
        }

        int age = preferences.getInt("age", 0);
        if (age != 0) {
            et_age.setText(String.valueOf(age));
        }

        float height = preferences.getFloat("height", 0f);
        if (height != 0f) {
            et_height.setText(String.valueOf(height));
        }

        float weight = preferences.getFloat("weight", 0f);
        if (weight != 0f) {
            et_weight.setText(String.valueOf(weight));
        }

        boolean married = preferences.getBoolean("married", false);
        ck_married.setChecked(married);
    }
}