package com.hb.ex01.a0607_planner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by HB04-03 on 2017-06-07.
 */

public class SelectAll extends Activity{
    TextView tv_datasize;
    ListView listView;
    ListViewAdaptor listViewAdaptor;
    ArrayList<VO> voList,voListDesc,voListAsc;
    RadioGroup rg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectall);
        listView = (ListView)findViewById(R.id.list_view);
        voListDesc = new ArrayList<>();
        tv_datasize = (TextView)findViewById(R.id.tv_datasize);
        rg = (RadioGroup)findViewById(R.id.rg_order);
        DAOmethods helper = new DAOmethods(this);
        voListDesc = helper.selectAll();
        voListAsc = (ArrayList<VO>)voListDesc.clone();
        voList = (ArrayList<VO>)voListDesc.clone();
        Collections.reverse(voListAsc);

        tv_datasize.setText("일정 수 : "+voListDesc.size()+"개");

        listViewAdaptor = new ListViewAdaptor(this,R.layout.vo_set,voListDesc);

        listView.setAdapter(listViewAdaptor);

        findViewById(R.id.btn_maingo2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                voList = new ArrayList<VO>();
                if(checkedId==R.id.rb_asc){
                    voList = voListAsc;
                }else{
                    voList = voListDesc;
                }
                listViewAdaptor = new ListViewAdaptor(SelectAll.this,R.layout.vo_set,voList);
                listView.setAdapter(listViewAdaptor);
            }

        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),SelectOne.class);
                intent.putExtra("date",voList.get(position).getDate());
                startActivity(intent);
                finish();
            }
        });
    }
}