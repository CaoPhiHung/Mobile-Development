package net.androidbootcamp.endangeredspecies;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private Integer[] Animals;
    public ImageAdapter (Context c, Integer[] Animals) {

        context=c;
        this.Animals = Animals;
    }

    @Override
    public int getCount() {
        return Animals.length;
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
        pic.setImageResource(Animals[position]);
        pic.setScaleType(ImageView.ScaleType.FIT_XY);
        pic.setLayoutParams(new GridView.LayoutParams(230,300));
        return pic;
    }
}