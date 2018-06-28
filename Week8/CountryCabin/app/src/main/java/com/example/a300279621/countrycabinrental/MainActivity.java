package com.example.a300279621.countrycabinrental;

import android.app.DatePickerDialog;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private int id_row = 3;
    private TableLayout table;
    private RadioButton rd1, rd2;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        table = (TableLayout) findViewById(R.id.main_table);

        Button btn = (Button) findViewById(R.id.btnCreate);
        rd1 = (RadioButton) findViewById(R.id.radioButton);
        rd2 = (RadioButton) findViewById(R.id.radioButton2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);

                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dpd = new DatePickerDialog(MainActivity.this, mylistener, year, month, day);
                dpd.show();
                DatePicker dp = dpd.getDatePicker();
                //Set the DatePicker minimum date selection to current date
                dp.setMinDate(calendar.getTimeInMillis());//get the current day
            }
        });
    }

    DatePickerDialog.OnDateSetListener mylistener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            TableRow row = (TableRow) table.getChildAt(4);
            TextView tv = (TextView) row.getChildAt(0);
            Date date = new Date(year - 1900, month, dayOfMonth);
            Date date2 = new Date(year - 1900, month, dayOfMonth+1);
            String dateFacDB = DateFormat.getDateInstance().format(date).toString();
            String dateFacDB2 = DateFormat.getDateInstance().format(date2).toString();
            if(rd1.isChecked()){
                type = rd1.getText().toString();
            }else{
                type = rd2.getText().toString();
            }
            tv.setText("You have selected date from " + dateFacDB + " to " + dateFacDB2 + " and Type: " + type);
        }
    };
}
