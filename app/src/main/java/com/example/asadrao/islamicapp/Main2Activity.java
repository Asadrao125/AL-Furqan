package com.example.asadrao.islamicapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    ListView pdfListView;
    SearchView svQuran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // set theme
        SharedPreferences sharedPreferences = getSharedPreferences(Themes.APP_PREFERENCES, Context.MODE_PRIVATE);
        int theme = sharedPreferences.getInt(Themes.THEME_Key, R.style.AppTheme);
        setTheme(theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        svQuran = findViewById(R.id.svQuran);

        pdfListView = (ListView)findViewById(R.id.myPDFList);
        String[] pdfFiles = {"Para No 1","Para No 2","Para No 3","Para No 4","Para No 5"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.custom,R.id.textView,pdfFiles)
        {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView mytext = (TextView) view.findViewById(R.id.textView);
                return view;
            }
        };
        pdfListView.setAdapter(adapter);
        svQuran.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String text) {

                adapter.getFilter().filter(text);
                return false;
            }
        });
        pdfListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = pdfListView.getItemAtPosition(position).toString();
                Intent intent = new Intent(Main2Activity.this,PDFOpenerPara.class);
                intent.putExtra("pdfFilesName",item);
                startActivity(intent);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void btnBack(View view) {
        startActivity(new Intent(Main2Activity.this, MainActivity.class));
    }
}