package com.example.mobileapplication6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main2Activity extends AppCompatActivity {

    final int RESULT_STORE = 0;
    final int RESULT_CANCELED = 50;

    RadioButton radio1, radio2, radio3;
    EditText etname, ettel, etmenu1, etmenu2, etmenu3, ethomepage;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etname = (EditText) findViewById(R.id.etname);
        ettel = (EditText) findViewById(R.id.ettel);
        etmenu1 = (EditText) findViewById(R.id.etmenu1);
        etmenu2 = (EditText) findViewById(R.id.etmenu2);
        etmenu3 = (EditText) findViewById(R.id.etmenu3);
        ethomepage = (EditText) findViewById(R.id.ethomepage);
        radio1 = (RadioButton) findViewById(R.id.radio1);
        radio2 = (RadioButton) findViewById(R.id.radio2);
        radio3 = (RadioButton) findViewById(R.id.radio3);
    }

    public void onClick(View v) {
        intent = new Intent(Main2Activity.this, MainActivity.class);
        if (v.getId() == R.id.btnAdd) {
            add();
        }
        else if(v.getId() == R.id.btnCancel){
            setResult(RESULT_CANCELED, intent);
            finish();
        }
    }

    private void add() {
        intent = new Intent(Main2Activity.this, MainActivity.class);
        Store store;
        String date = date();
        if (radio1.isChecked()) {
            store = new Store(etname.getText().toString(), ettel.getText().toString()
                    , etmenu1.getText().toString(), etmenu2.getText().toString()
                    , etmenu3.getText().toString(), ethomepage.getText().toString(), 1, date);
        } else if (radio2.isChecked()) {

            store = new Store(etname.getText().toString(), ettel.getText().toString()
                    , etmenu1.getText().toString(), etmenu2.getText().toString()
                    , etmenu3.getText().toString(), ethomepage.getText().toString(), 2, date);

        } else {
            store = new Store(etname.getText().toString(), ettel.getText().toString()
                    , etmenu1.getText().toString(), etmenu2.getText().toString()
                    , etmenu3.getText().toString(), ethomepage.getText().toString(), 3, date);

        }
        intent.putExtra("store", store);
        setResult(RESULT_STORE, intent);
        finish();

    }
    private String date(){
        long now = System.currentTimeMillis();
        Date date_ = new Date(now);
        SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd");
        String formatDate = sdfNow.format(date_);

        return  formatDate;
    }
}
