package net.androidbootcamp.endangeredspecies;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Integer[] Animals = {R.drawable.eagle, R.drawable.elephant, R.drawable.gorilla,
            R.drawable.panda, R.drawable.panther, R.drawable.polar};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid = (GridView)findViewById(R.id.gridView);
        final ImageView pic= (ImageView)findViewById(R.id.imgLarge);

        ImageAdapter image = new ImageAdapter(this,Animals);

        grid.setAdapter(image);


        grid.setOnItemClickListener(new AdapterView.OnItemClickListener( ) {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext( ), "Selected Species " + (position + 1), Toast.LENGTH_SHORT).show( );
                pic.setImageResource(Animals[position]);
            }
        });
    }



}
