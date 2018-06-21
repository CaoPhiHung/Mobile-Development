package com.example.a300279621.phihungcao_300279621_p2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class MainActivity_300279621 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_300279621);

        Button next = (Button) findViewById(R.id.buttonNext);
        final RadioButton cone = (RadioButton) findViewById(R.id.radioButtonCone);
        final RadioButton sphere = (RadioButton) findViewById(R.id.radioButtonSphere);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cone.isChecked()){
                    startActivity(new Intent(MainActivity_300279621.this, Cone_300279621.class));
                }else if(sphere.isChecked()){
                    startActivity(new Intent(MainActivity_300279621.this, Sphere_300279621.class));
                }
            }
        });
    }
}
