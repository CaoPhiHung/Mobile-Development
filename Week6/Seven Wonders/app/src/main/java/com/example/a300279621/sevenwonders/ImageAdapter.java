package com.example.a300279621.sevenwonders;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by 300279621 on 6/14/2018.
 */

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private Integer[] Wonders;
    public ImageAdapter (Context c, Integer[] Wonders) {

        context=c;
        this.Wonders = Wonders;
    }

    @Override
    public int getCount() {
        return Wonders.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView pic = new ImageView(context);
        pic.setImageResource(Wonders[position]);
        pic.setScaleType(ImageView.ScaleType.FIT_XY);
        pic.setLayoutParams(new GridView.LayoutParams(330,300));
        return pic;
    }
}

