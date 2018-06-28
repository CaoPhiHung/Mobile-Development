package com.example.a300279621.week8;

import android.app.DatePickerDialog;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private int id_row = 3;
    private TableLayout table;
    final LinearLayout.LayoutParams params =  new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        table = (TableLayout) findViewById(R.id.main_table);

        // width, height
        final TableLayout.LayoutParams tblParams=  new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT);

        Button btn = (Button) findViewById(R.id.btnCreate);

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
            TableRow row = (TableRow) table.getChildAt(3);
            TextView tv = (TextView) row.getChildAt(0);
            Date date = new Date(year - 1900, month, dayOfMonth);
            String dateFacDB = DateFormat.getDateInstance().format(date).toString();
            tv.setText(dateFacDB);
        }
    };
}
