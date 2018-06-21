package com.example.a300279621.phihungcao_300279621_p2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cone_300279621 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cone_300279621);

        final double PI = 3.14;
        Button calculate = (Button) findViewById(R.id.btnCalculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    EditText radiusText = (EditText) findViewById(R.id.txtInputRadius);
                    double raidus = Double.valueOf(radiusText.getText().toString());
                    EditText heightText = (EditText) findViewById(R.id.txtInputHeigh);
                    double heigh = Double.valueOf(heightText.getText().toString());
                    double volume = (PI * raidus * raidus * heigh) / 3;
                    TextView result = (TextView) findViewById(R.id.txtResult);
                    String resultString = "Volume of cone is "  + volume;
                    result.setText(resultString);
                    Toast.makeText(Cone_300279621.this,resultString,Toast.LENGTH_LONG).show();
                }catch (Exception ex){
                    Toast.makeText(Cone_300279621.this,"Invalid input",Toast.LENGTH_LONG).show();
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
