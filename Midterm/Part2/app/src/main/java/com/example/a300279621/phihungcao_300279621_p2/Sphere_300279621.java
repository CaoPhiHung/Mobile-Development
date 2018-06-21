package com.example.a300279621.phihungcao_300279621_p2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sphere_300279621 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere_300279621);
        final double PI = 3.14;

        Button calculate = (Button) findViewById(R.id.btnCalculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    EditText radiusText = (EditText) findViewById(R.id.txtInputRadius);
                    double r = Double.valueOf(radiusText.getText().toString());
                    double volume = (PI * r * r * r * 4) / 3;
                    TextView result = (TextView) findViewById(R.id.textResult);
                    String resultString = "Volume of Sphere is "  + volume;
                    result.setText(resultString);
                    Toast.makeText(Sphere_300279621.this,resultString,Toast.LENGTH_LONG).show();
                }catch (Exception ex){
                    Toast.makeText(Sphere_300279621.this,"Invalid input",Toast.LENGTH_LONG).show();
                }
            }
        });


        Button btn = (Button) findViewById(R.id.btnBack);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
