package com.example.testdemo08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.testdemo08.adapter.PlanetListWithButtonAdapter;
import com.example.testdemo08.entity.Planet;
import com.example.testdemo08.util.ToastUtil;

import java.util.List;

/*
* ListView 条目事件冲突
* */
public class ListFocusActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<Planet> planetList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_focus);

        ListView lv_planet = findViewById(R.id.lv_planet);

        planetList = Planet.getDefaultList();
        PlanetListWithButtonAdapter adapter = new PlanetListWithButtonAdapter(this, planetList);
        lv_planet.setAdapter(adapter);
        lv_planet.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ToastUtil.show(this,"条目被点击了，"+planetList.get(position).name);
    }
}