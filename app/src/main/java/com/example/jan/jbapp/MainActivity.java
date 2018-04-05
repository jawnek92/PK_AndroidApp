package com.example.jan.jbapp;

import android.app.Activity;
import android.content.Intent;
import android.icu.util.ULocale;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by jan on 24.03.2018.
 */

public class MainActivity extends Activity implements OnItemSelectedListener, AdapterView.OnItemClickListener {
    private EditText UserSearch;
    private TextView WebDisplay;
    private Spinner GlobalCategory;
    private Spinner subCategory;
    private Button OpenURL;
    public Intent intent;
    private String urlWeb = "https://www.olx.pl/";
    private String userChoice;

    Player Tim = new Player();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GlobalCategory = (Spinner) findViewById(R.id.Category);
        subCategory = (Spinner) findViewById(R.id.subCategory);
        OpenURL = (Button)findViewById(R.id.OpenURL);

        List<String> Category = new ArrayList<>();

        Category.add("/motoryzacja/samochody/");
        Category.add("/nieruchomosci/domy/");
        Category.add("/motoryzacja/motocykle-skutery/");





        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Category);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        GlobalCategory.setAdapter(dataAdapter);
        GlobalCategory.setOnItemSelectedListener(this);

        OpenURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String item = adapterView.getItemAtPosition(i).toString();

        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlWeb + item));

        Toast.makeText(adapterView.getContext(),"Selected " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}