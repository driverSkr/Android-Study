package com.example.client;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.client.utils.PermissionUtil;
import com.example.client.utils.ToastUtil;

//运行时动态申请权限-Hungry模式（饿汉式，打开activity就申请权限）
//[实际业务模式]
public class PermissionHungryActivity extends AppCompatActivity implements View.OnClickListener {

    //通讯录的读写权限、短信的收发权限
    private static final String[]  PERMISSIONS = new String[]{
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.WRITE_CONTACTS,
            Manifest.permission.SEND_SMS,
            Manifest.permission.READ_SMS
    };
    private static final int REQUEST_CODE_ALL = 1;
    //通讯录的读写权限标识码
    private static final int REQUEST_CODE_CONTACTS = 2;
    //短信的收发权限标识码
    private static final int REQUEST_CODE_SMS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_lazy);

        findViewById(R.id.btn_contact).setOnClickListener(this);
        findViewById(R.id.btn_sms).setOnClickListener(this);
        //activity一创建就一次性请求四个权限
        PermissionUtil.checkPermission(this,PERMISSIONS,REQUEST_CODE_ALL);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //点击读写通讯录，检查是否获得权限
            case R.id.btn_contact:
                //jumpToSettings();
                PermissionUtil.checkPermission(this,new String[]{PERMISSIONS[0],PERMISSIONS[1]},REQUEST_CODE_CONTACTS);
                break;
            //点击收发短信，检查是否获得权限
            case R.id.btn_sms:
                PermissionUtil.checkPermission(this,new String[]{PERMISSIONS[2],PERMISSIONS[3]},REQUEST_CODE_SMS);
                break;
        }
    }

    //向用户请求权限的结果（回调方法）【用户请求后返回结果（是否给我们这个权限）】
    //grantResults(授权结果)【0：授权；-1：未授权】
    //ActivityCompat.requestPermissions(act,permissions,requestCode);通过这个方法才会有回调响应
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_CODE_ALL:
                if (PermissionUtil.checkGrant(grantResults)){
                    Log.d("boge","所有权限获取成功");
                }else {
                    //部分权限获取失败【permissions[]和grantResults[]的对应顺序是一致的】
                    for (int i = 0; i < grantResults.length; i++) {
                        if (grantResults[i] != PackageManager.PERMISSION_GRANTED){
                            //判断是什么权限没有获取成功
                            switch (permissions[i]){
                                case Manifest.permission.READ_CONTACTS:
                                case Manifest.permission.WRITE_CONTACTS:
                                    ToastUtil.show(this,"获取通讯录读写权限失败！");
                                    jumpToSettings();
                                    break;
                                case Manifest.permission.SEND_SMS:
                                case Manifest.permission.READ_SMS:
                                    ToastUtil.show(this,"获取收发短信权限失败！");
                                    jumpToSettings();
                                    break;
                            }
                        }
                    }
                }
                break;
            case REQUEST_CODE_CONTACTS:
                if (PermissionUtil.checkGrant(grantResults)){
                    Log.d("boge","通讯录权限获取成功");
                }else {
                    Toast.makeText(this, "获取通讯录读写权限失败！", Toast.LENGTH_SHORT).show();
                    jumpToSettings();
                }
                break;
            case REQUEST_CODE_SMS:
                if (PermissionUtil.checkGrant(grantResults)){
                    Log.d("boge","收发短信权限获取成功");
                }else {
                    Toast.makeText(this, "获取收发短信权限失败！", Toast.LENGTH_SHORT).show();
                    jumpToSettings();
                }
                break;
        }
    }

    //跳转到应用设置界面(隐式意图)
    private void jumpToSettings(){
        Intent intent = new Intent();
        //设置详情界面
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        //携带本页面的包名，标明来源
        intent.setData(Uri.fromParts("package",getPackageName(),null));
        //设置启动模式
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}