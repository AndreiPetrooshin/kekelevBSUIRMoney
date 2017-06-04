package com.example.draqo.kekelevbsuirmoney;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by draqo on 04.06.2017.
 */

public class ProcessLoading extends AsyncTask<Void, Void, Void> {

    //Обьявление и инициализация переменных
    private String[] bankBuys = new String[3];
    private String[] bankSells = new String[3];
    private String day ;


    @Override
    protected Void doInBackground(Void... params) {

        try {
            //Получение html документа
            Document document = Jsoup.connect("https://finance.tut.by/kurs/").get();

            //Получение значений Валют
            for (int i = 1; i < 4; i++) {
                day  =  document.getElementById("from_text").text();
                bankBuys[i - 1] = document.getElementsByClass("cursList_table").get(0).getElementsByTag("tbody")
                        .get(0).getElementsByTag("tr").get(i).getElementsByTag("td").get(1).getElementsByTag("big").get(0).text();
                bankSells[i - 1] = document.getElementsByClass("cursList_table").get(0).getElementsByTag("tbody")
                        .get(0).getElementsByTag("tr").get(i).getElementsByTag("td").get(2).getElementsByTag("big").get(0).text();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.day.setText(day);

        for (int i = 0; i < MainActivity.bank_buys.size(); i++) {
            MainActivity.bank_buys.get(i).setText(bankBuys[i]);
            MainActivity.bank_sells.get(i).setText(bankSells[i]);
        }

    }
}
