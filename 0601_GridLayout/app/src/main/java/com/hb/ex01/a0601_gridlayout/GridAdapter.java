package com.hb.ex01.a0601_gridlayout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by HB04-03 on 2017-06-01.
 */

public class GridAdapter extends BaseAdapter{
    Context context;
    public GridAdapter() {}
    public GridAdapter(Context context) {
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView == null){
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(185,185));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
        }else{
            imageView = (ImageView)convertView;
        }
        imageView.setImageResource(imgs[position]);
        return imageView;
    }

    // 해당 이미지를 추가
    public Integer[] imgs = {
            R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,
            R.drawable.pic4,R.drawable.pic5,R.drawable.pic6
    };

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int position) {
        return imgs[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
