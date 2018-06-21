package com.example.a300279621.phihungcao_300279621_p1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity_300279621 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_300279621);

        Button btn1 = (Button) findViewById(R.id.btn1);
        final CheckBox chcb = (CheckBox) findViewById(R.id.checkBox);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity_300279621.this, Page2_300279621.class);
                if(chcb.isChecked()){
                    myIntent.putExtra("title", chcb.getText());
                }else{
                    myIntent.putExtra("title", "");
                }
                startActivity(myIntent);
            }
        });

    }
}
