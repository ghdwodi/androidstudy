package com.hb.ex01.a0531_list2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by HB04-03 on 2017-05-31.
 */

// 해당 클래스를 어댑터로 만들려면 BaseAdapter라는 클래스를 상속받아 오버라이딩해야 한다.
public class ListViewAdapter extends BaseAdapter{
    Context context;
    int layout;
    ArrayList<ListViewVO> list;
    LayoutInflater inflater;    // xml정보를 메모리에 적재하거나, 자바에서 해당 메모리에 적재된 정보를 사용할 수 있게 한다.

    public ListViewAdapter() {}

    // 기존 어댑터를 보고 생성자를 만든다. (Context, 보여질 모양, 들어갈 자료)
    public ListViewAdapter(Context context, int layout, ArrayList<ListViewVO> list){
        this.context = context;
        this.layout = layout;
        this.list = list;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        TextView txt1 = (TextView)convertView.findViewById(R.id.txt1);
        ImageView img1 = (ImageView)convertView.findViewById(R.id.img1);

        // 현재 위치에서 해당 데이터 얻기
        final ListViewVO vo = list.get(position);
        txt1.setText(vo.getItemName());
        img1.setImageResource(vo.getResId());

        txt1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(context, vo.getItemName(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return convertView;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}