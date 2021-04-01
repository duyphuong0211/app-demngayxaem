package com.example.dem_ngay_xa_em;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    Button btnTinhngay;
    EditText edtNgay1, edtNgay2;
    TextView txtKetqua;

    Calendar calendarOne, calendarTwo;
    SimpleDateFormat simpleDateFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        edtNgay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chonngay1();
            }
        });

        edtNgay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chonngay2();
            }
        });

        btnTinhngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ngayxa = (int) (calendarTwo.getTimeInMillis() - calendarOne.getTimeInMillis()) / (1000*60*60*24);
                txtKetqua.setText("So ngay xa nhau la" + ngayxa);

            }
        });
    }

    private void Chonngay1()
    {
        calendarOne = Calendar.getInstance();
        int ngay = calendarOne.get(Calendar.DATE);
        int thang = calendarOne.get(Calendar.MONTH);
        int nam = calendarOne.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    calendarOne.set(year,month,dayOfMonth);
                     edtNgay1.setText(simpleDateFormat.format(calendarOne.getTime()));
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }

    private void Chonngay2()
    {
        calendarTwo = Calendar.getInstance();
        int ngay = calendarTwo.get(Calendar.DATE);
        int thang = calendarTwo.get(Calendar.MONTH);
        int nam = calendarTwo.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendarTwo.set(year,month,dayOfMonth);
                edtNgay2.setText(simpleDateFormat.format(calendarTwo.getTime()));
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }

    private void Anhxa()
    {
        btnTinhngay = (Button) findViewById(R.id.buttonTinh);
        edtNgay1 = (EditText) findViewById(R.id.editTextDateOne);
        edtNgay2 = (EditText) findViewById(R.id.editTextDateTwo);
        txtKetqua = (TextView) findViewById(R.id.textViewResovle);
    }
}