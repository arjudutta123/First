package com.example.a1stassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    TextView chDate, choDate, tvPrice, tvResult, tvFirst, tvSecond;
    Boolean ch, cho;
    Spinner sRoom;
    Button btnCal;
    EditText etAdult, etChild, etRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chDate = findViewById(R.id.chDate);
        choDate = findViewById(R.id.choDate);
        sRoom = findViewById(R.id.sRoom);
        etAdult = findViewById(R.id.etAdult);
        etChild = findViewById(R.id.etChild);
        etRoom = findViewById(R.id.etRoom);
        tvPrice = findViewById(R.id.tvPrice);
        btnCal = findViewById(R.id.btnCal);
        tvResult = findViewById(R.id.tvResult);
        tvFirst = findViewById(R.id.tvFirst);
        tvSecond = findViewById(R.id.tvSecond);


        chDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePickerchDate();
                ch = true;


            }
        });

        choDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePickerchoDate();
                cho = true;
            }
        });

        String room[] = {"Select room type", "Deluxe -Rs. 2000", "Presidential -Rs. 5000", "Premium- Rs. 4000"};
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, room);
        sRoom.setAdapter(adapter);


        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int adult, child, room;
                double total, price,vat,GrossTotal;

                adult = Integer.parseInt(etAdult.getText().toString());
                child = Integer.parseInt(etChild.getText().toString());
                room = Integer.parseInt(etRoom.getText().toString());



                if(TextUtils.isEmpty(etAdult.getText()))
                {
                    etAdult.setError("Enter no of Adults");
                    return;
                }
                if(TextUtils.isEmpty(etChild.getText()))
                {
                    etChild.setError("Enter no of childs");
                    return;
                }
                if(TextUtils.isEmpty(etRoom.getText()))
                {
                    etRoom.setError("Enter no of rooms");
                    return;
                }


                if (sRoom.getSelectedItem() == "Deluxe -Rs. 2000") {
                    tvPrice.setText("2000");


                }
                if (sRoom.getSelectedItem() == "Presidential -Rs. 5000") {
                    tvPrice.setText("5000");


                }
                if (sRoom.getSelectedItem() == "Premium- Rs. 4000") {
                    tvPrice.setText("4000");

                }
                price=Integer.parseInt(tvPrice.getText().toString());
                total=price*room;
                vat=0.13*total;
                GrossTotal = total +vat;

                //int diff=Integer.parseInt(tvSecond.getText().toString())-Integer.parseInt(tvFirst.getText().toString());


                tvResult.setText("Total: Rs." + total+"\n"+"Vat Rs.:"+vat+"\n"+"Gross Total: Rs."+GrossTotal);
            }
        });


    }


    private void loadDatePickerchDate() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this, year, month, day);
        datePickerDialog.show();
    }

    private void loadDatePickerchoDate() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);


        tvSecond.setText(c.getTime() + "");


        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this, year, month, day);
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        month = month + 1;

        if (ch == true) {
            String date = "Checking Date: " + month + "/" + dayOfMonth + "/" + year;

            //SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            // // try {
            //     Date dateCheckout=format.parse(date);
            //  }
            //  catch (ParseException e)
            //  {
            //      e.printStackTrace();
            //  }
            chDate.setText(date);

            ch = false;
            return;

        }
        if (cho = true) {
            String date = "Check out Date: " + month + "/" + dayOfMonth + "/" + year;
            choDate.setText(date);
            // SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            // try {
            //     Date dateCheckout=format.parse(date);
            // }
            // catch (ParseException e)
            // {
            //     e.printStackTrace();
            // }

            cho = false;
            return;
        }


    }


}
