package com.example.mytable;

import android.app.DatePickerDialog;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private int id_row;
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
            public void onClick(View v) {
                EditText et = (EditText) findViewById(R.id.nPeople);
                int n = Integer.parseInt(et.getText().toString());

                table.removeAllViews();

                // Creating the Header
                TableRow tr_head = new TableRow(MainActivity.this);
                tr_head.setBackgroundColor(Color.GRAY);
                tr_head.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));

                String labels[] = {"#", "Firstname", "Lastname", "Age Group", "Date"};
                TextView tv;
                for (int x = 0 ; x < labels.length; x++) {
                    tv = new TextView(MainActivity.this);
                    tv.setText(labels[x]);
                    tv.setTextColor(Color.WHITE);
                    tv.setPadding(5, 5, 5, 5);
                    tr_head.addView(tv);
                }

                // adding the row to the table
                table.addView(tr_head,tblParams);

                // populate the rows
                TableRow tr ;
                EditText userInput;
                RadioGroup rgrp;
                RadioButton rb;
                Button btnDate;

                int c[] = {Color.WHITE,Color.LTGRAY};
                for (int y = 0 ; y < n ; y++) {
                    tr = new TableRow(MainActivity.this);
                    tr.setPadding(10,5,10,5);
                    tr.setBackgroundColor(c[y%2]);

                    tv = new TextView(MainActivity.this);
                    tv.setText("" + (y+1));
                    tr.addView(tv);

                    userInput = new EditText(MainActivity.this);
                    tr.addView(userInput);

                    userInput = new EditText(MainActivity.this);
                    tr.addView(userInput);

                    // age group
                    rgrp = new RadioGroup(MainActivity.this);
                    rgrp.setOrientation(LinearLayout.VERTICAL);

                    rb = new RadioButton(MainActivity.this);
                    rb.setText("Adult");
                    rgrp.addView(rb);

                    rb = new RadioButton(MainActivity.this);
                    rb.setText("Children");
                    rgrp.addView(rb);

                    rgrp.check(rb.getId());
                    tr.addView(rgrp);

                    tv = new TextView(MainActivity.this);

                    tr.addView(tv);

                    btnDate = new Button(MainActivity.this);
                    btnDate.setText("Date");
                    btnDate.setId(y+1);
                    tr.addView(btnDate);

                    btnDate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Calendar calendar = Calendar.getInstance();
                            int year = calendar.get(Calendar.YEAR);

                            int month = calendar.get(Calendar.MONTH);
                            int day = calendar.get(Calendar.DAY_OF_MONTH);

                            id_row = v.getId();

                            new DatePickerDialog(MainActivity.this, mylistener, year, month, day).show();
                        }
                    });
                    table.addView(tr,tblParams);
                }
            }
        });

    }

    DatePickerDialog.OnDateSetListener mylistener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            TableRow row = (TableRow) table.getChildAt(id_row);
            TextView tv = (TextView) row.getChildAt(4);
            tv.setText(dayOfMonth + "/" + (month +1) + "/" + year);
        }
    };
}
