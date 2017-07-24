package com.hb.ex01.a0607_planner;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by HB04-03 on 2017-06-07.
 */

public class ListViewAdaptor extends BaseAdapter{
    Context context;
    int layout;
    ArrayList<VO> list;
    LayoutInflater inflater;    // xml정보를 메모리에 적재하거나, 자바에서 해당 메모리에 적재된 정보를 사용할 수 있게 한다.
    public ListViewAdaptor() {}

    public ListViewAdaptor(Context context, int layout, ArrayList<VO> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position).getDate();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = inflater.inflate(
                    layout, // 보여질 화면
                    parent, // 뷰 그룹
                    false   // 첨부파일
            );
        }
        // 항목뷰 이용
        final TextView tv_date = (TextView)convertView.findViewById(R.id.tv_date);
        TextView tv_content = (TextView) convertView.findViewById(R.id.tv_content);
        if(position%2==0){
            tv_content.setBackgroundColor(Color.argb(201,153,204,255));
        }else{
            tv_content.setBackgroundColor(Color.argb(60,255,255,204));
        }

        // 현재 위치에서 해당 데이터 얻기
        final VO vo = list.get(position);
        tv_date.setText(vo.getDate());
        String content = vo.getContent();
        if(vo.getContent().length()>10){
            content = vo.getContent().substring(0,9)+"...";
        }
        tv_content.setText(content);



        return convertView;
    }
}
