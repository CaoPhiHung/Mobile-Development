package com.example.a300279621.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

        final EditText et = (EditText) findViewById(R.id.txtDollar);
        final TextView tv = (TextView) findViewById(R.id.txtResult);
        final Button btn = (Button) findViewById(R.id.btnCalculate);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.rdGroup);

        btn.setOnClickListener(new View.OnClickListener() {
            double price;
            String resultText;
            @Override
            public void onClick(View view) {
                try {
                    int dollars = Integer.parseInt(et.getText().toString());

                    int checkedId = rg.getCheckedRadioButtonId();
                    RadioButton rd = (RadioButton) findViewById(checkedId);
                    String type =  rd.getText().toString();
                    switch (type){
                        case "Euros":
                            price = dollars * 1.85;
                            break;
                        case "Mexican Pesos":
                            price = dollars * 20;
                            break;
                        default:
                            price = dollars * 1.3;
                            break;
                    }
                    if(dollars >= 100000){
                        resultText = "";
                        tv.setText(resultText);
                        Toast.makeText(MainActivity.this, "Program only converts values " +
                                "below $100,000 US dollar", Toast.LENGTH_SHORT).show();
                    }else{
                        resultText = "$" + dollars + " US dollar equal to $" + price + " " + type;
                        tv.setText(resultText);
                    }

                }catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Program only converts values " +
                            "below $100,000 US dollar", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
