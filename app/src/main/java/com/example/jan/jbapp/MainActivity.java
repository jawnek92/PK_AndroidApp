package com.example.jan.jbapp;

import android.app.Activity;
import android.content.Intent;
import android.icu.util.ULocale;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
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

    String Samochody;
    String Dom;
    String Motocykle;
    List<String> subCategoryCars;
    List<String> subCategoryHouse;
    List<String> subCategoryMotocykle;

    public class GetData extends AsyncTask<Void, Void, Void>{

        String data;

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document document = Jsoup.connect(urlWeb).get();
            } catch (Exception e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            //textView.setText(data);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GlobalCategory = (Spinner) findViewById(R.id.Category_array);
        subCategory = (Spinner) findViewById(R.id.subCategory);
        OpenURL = (Button)findViewById(R.id.OpenURL);
        UserSearch = (EditText)findViewById(R.id.editText);

        List<String> Category = new ArrayList<>();

        subCategoryCars = new ArrayList<>();
        subCategoryHouse = new ArrayList<>();

        subCategoryMotocykle = new ArrayList<>();


        Samochody = "/motoryzacja/samochody/";
        Dom = "/nieruchomosci/domy/";
        Motocykle = "/motoryzacja/motocykle-skutery/";



        Category.add(Samochody);
        Category.add(Dom);
        Category.add(Motocykle);

        subCategoryCars.add("Honda");
        subCategoryCars.add("Merc");
        subCategoryCars.add("BMW");

        subCategoryHouse.add("Jednorodzinne ");
        subCategoryHouse.add("wielosoobowe");
        subCategoryHouse.add("bloki");

        subCategoryMotocykle.add("KTM");
        subCategoryMotocykle.add("Suzuki");
        subCategoryMotocykle.add("Komar");


        //Wczytywanie strony - narazie calej strony w formie stringu
        //textView = (TextView)findViewById(R.id.textView2);
        new GetData().execute();



        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,Category);

        ArrayAdapter<CharSequence> fromResource = dataAdapter.createFromResource(this, R.array.Category_array, android.R.layout.simple_spinner_dropdown_item);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        GlobalCategory.setAdapter(fromResource);
        GlobalCategory.setOnItemSelectedListener(this);



        OpenURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        //Zgarnia info o tym czy cos zostalo wpisane w okienko EditText.
        UserSearch.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }


        });

        Editable e = UserSearch.getText();





    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String item = adapterView.getItemAtPosition(i).toString();

        setSubSpinner(item);

        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlWeb + item));

        Toast.makeText(adapterView.getContext(),"Selected " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    void setSubSpinner(String item)
    {
        if(item.equals("Samochody"))
        {
            ArrayAdapter<String > dataAdapterSubCars = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, subCategoryCars);
            subCategory.setAdapter(dataAdapterSubCars);
            Editable e = UserSearch.getText();
            System.out.print(e.toString());


        }else if(item.equals("Dom") )
        {
            ArrayAdapter<String > dataAdapterSubHouse = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, subCategoryHouse);
            subCategory.setAdapter(dataAdapterSubHouse);

        }else if(item.equals("Motocykle"))
        {
            ArrayAdapter<String > dataAdapterSubHouse = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, subCategoryMotocykle);
            subCategory.setAdapter(dataAdapterSubHouse);
        }
    }
}