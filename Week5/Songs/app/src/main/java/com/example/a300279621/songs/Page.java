package com.example.a300279621.songs;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);



        final Button button1 = (Button) findViewById(R.id.btnIrish);
        final MediaPlayer song1 = MediaPlayer.create(Page.this,R.raw.jig);
        final MediaPlayer song2 = MediaPlayer.create(Page.this,R.raw.bagpipes);
        final Button button2 = (Button) findViewById(R.id.btnButton2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(song1.isPlaying()){
                    song1.pause();
                    button2.setVisibility(View.VISIBLE);
                    button1.setText("Play Irish Jig");
                }else{
                    button1.setText("Pause Irish Jig");
                    song1.start();
                    button2.setVisibility(View.INVISIBLE);


                }

            }
        });



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(song2.isPlaying()){
                    song2.pause();
                    button2.setText("Play Bagpipes Song");
                    button1.setVisibility(View.VISIBLE);
                }else{
                    song2.start();
                    button2.setText("Pause Bagpipes Song");
                    button1.setVisibility(View.INVISIBLE);

                }

            }
        });


    }
}
