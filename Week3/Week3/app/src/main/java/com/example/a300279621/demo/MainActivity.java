package com.example.a300279621.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btnButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner moviesSpinner = (Spinner) findViewById(R.id.spinner);
                String movie = (String)moviesSpinner.getSelectedItem();
                int index = moviesSpinner.getSelectedItemPosition();

                int qty = 0;
                try {
                    EditText qtyText = (EditText) findViewById(R.id.txtTickets);
                    qty = Integer.valueOf(qtyText.getText().toString());

                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, "Please enter a valid number in the quantity", Toast.LENGTH_LONG);
                }


                TextView resultText = (TextView) findViewById(R.id.resultText);

                int price = qty * 20;
                String resultString = "The selected movie is " + movie + "\nThe qty is " + qty + "\nThe price is $" + price;
                resultText.setText(resultString);
                Toast.makeText(MainActivity.this, resultString, Toast.LENGTH_SHORT).show();

            }
            });
    }
}
