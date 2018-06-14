package com.example.a300279621.sevenwonders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer[] Wonder = {R.drawable.wonder1, R.drawable.wonder2, R.drawable.wonder3,
            R.drawable.wonder4, R.drawable.wonder5, R.drawable.wonder6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid = (GridView)findViewById(R.id.gridView);
        final ImageView pic= (ImageView)findViewById(R.id.imgView);

        ImageAdapter image = new ImageAdapter(this,Wonder);

        grid.setAdapter(image);


        grid.setOnItemClickListener(new AdapterView.OnItemClickListener( ) {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext( ), "Selected Wonder " + (position + 1), Toast.LENGTH_SHORT).show( );
                pic.setImageResource(Wonder[position]);
            }
        });
    }

}
