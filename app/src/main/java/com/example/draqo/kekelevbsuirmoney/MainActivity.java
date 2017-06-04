package com.example.draqo.kekelevbsuirmoney;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    //Обьявление и инициализация переменных
    public static ArrayList<TextView> bank_buys = new ArrayList<>();
    public static ArrayList<TextView> bank_sells = new ArrayList<>();
    public static TextView day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

            //Заполнение значениями
            bank_buys.add((TextView) findViewById(R.id.usa_buy));
            bank_buys.add((TextView) findViewById(R.id.eu_buy));
            bank_buys.add((TextView) findViewById(R.id.rus_buy));

            bank_sells.add((TextView) findViewById(R.id.usa_sell));
            bank_sells.add((TextView) findViewById(R.id.eu_sell));
            bank_sells.add((TextView) findViewById(R.id.rus_sell));

            day = (TextView) findViewById(R.id.text_day);


            //Запуск нового таска
            ProcessLoading processLoading = new ProcessLoading();
            processLoading.execute();


    }
}
