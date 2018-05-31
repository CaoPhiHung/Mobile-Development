package com.example.a300279621.week4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_foreground);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText et = (EditText) findViewById(R.id.txtNoOfWahses);
        final TextView tv = (TextView) findViewById(R.id.txtResult);
        final Button btn = (Button) findViewById(R.id.btnCalculate);
        final RadioButton rdB1 = (RadioButton) findViewById(R.id.rdBOption1);
        final RadioButton rdB2 = (RadioButton) findViewById(R.id.rdBOption2);

        btn.setOnClickListener(new View.OnClickListener() {
            double price;
            String resultText;
            @Override
            public void onClick(View view) {
                try {
                    int noOfWashes = Integer.parseInt(et.getText().toString());
                    if(rdB1.isChecked()){
                        if(noOfWashes >= 12){
                            price = 8.99;
                        }else{
                            price = 10.99;
                        }

                    }else{
                        if(noOfWashes >= 12){
                            price = 12.99;
                        }else{
                            price = 15.99;
                        }
                    }

                    if(noOfWashes <= 12){
                        Toast.makeText(MainActivity.this, "To have discount you must buy 12 items or more", Toast.LENGTH_SHORT).show();
                    }
                    price = price * noOfWashes;
                    resultText = "$" + price + " for " + noOfWashes + " washes";
                    tv.setText(resultText);

                }catch (Exception ex){
                    Toast.makeText(getApplicationContext(), "To have discount you must buy 12 items or more", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
