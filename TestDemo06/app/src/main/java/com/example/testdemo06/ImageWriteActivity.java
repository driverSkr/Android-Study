package com.example.testdemo06;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;

import com.example.testdemo06.util.FileUtil;
import com.example.testdemo06.util.ToastUtil;

import java.io.File;

//在存储卡上读写图片文件
public class ImageWriteActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_content;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_write);

        iv_content = findViewById(R.id.iv_content);

        findViewById(R.id.btn_save).setOnClickListener(this);
        findViewById(R.id.btn_read).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //保存图片到外部存储的私有空间
            case R.id.btn_save:
                String fileName = System.currentTimeMillis() + ".jpeg";
                //获取当前APP的私有下载目录(File.pathSeparator：分隔符/)
                path = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString() + File.separatorChar+ fileName;
                //从指定资源文件中获取位图对象
                Bitmap b1 = BitmapFactory.decodeResource(getResources(), R.drawable.ting2);
                //把位图对象保存为图片文件
                FileUtil.saveImage(path,b1);
                ToastUtil.show(this,"保存成功");
                break;
            //读取图片
            case R.id.btn_read:
                //方法一
                /*Bitmap b2 = FileUtil.openImage(path);
                iv_content.setImageBitmap(b2);*/

                //方法二
                /*直接调用Bitmap工厂*/
                /*Bitmap b2 = BitmapFactory.decodeFile(path);
                iv_content.setImageBitmap(b2);*/

                //方法三
                /*直接调用setImageURI方法，设置图像视图的路径对象*/
                iv_content.setImageURI(Uri.parse(path));
                break;
        }
    }
}