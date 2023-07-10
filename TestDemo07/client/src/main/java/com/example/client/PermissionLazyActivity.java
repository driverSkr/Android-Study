package com.example.client;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.client.utils.PermissionUtil;

//运行时动态申请权限-Lazy模式（懒汉式：先不申请权限，等需要的时候再申请）
//[实际业务模式]
public class PermissionLazyActivity extends AppCompatActivity implements View.OnClickListener {

    //通讯录的读写权限
    private static final String[]  PERMISSIONS_CONTACTS = new String[]{
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.WRITE_CONTACTS
    };
    //短信的收发权限
    private static final String[]  PERMISSIONS_SMS = new String[]{
            Manifest.permission.SEND_SMS,
            Manifest.permission.READ_SMS
    };
    //通讯录的读写权限标识码
    private static final int REQUEST_CODE_CONTACTS = 1;
    //短信的收发权限标识码
    private static final int REQUEST_CODE_SMS = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_lazy);

        findViewById(R.id.btn_contact).setOnClickListener(this);
        findViewById(R.id.btn_sms).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //点击读写通讯录，检查是否获得权限
            case R.id.btn_contact:
                //int i = 1/0;
                PermissionUtil.checkPermission(this,PERMISSIONS_CONTACTS,REQUEST_CODE_CONTACTS);
                break;
            //点击收发短信，检查是否获得权限
            case R.id.btn_sms:
                PermissionUtil.checkPermission(this,PERMISSIONS_SMS,REQUEST_CODE_SMS);
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