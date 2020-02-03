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
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    ListView pdfListView;
    SearchView svQuran;
    private long backPressedTime;
    private Toast backToast;

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
        String[] pdfFiles = {"Para No 1","Para No 2","Para No 3","Para No 4","Para No 5","Para No 6"
                             ,"Para No 7","Para No 8","Para No 9","Para No 10","Para No 11","Para No 12","Para No 13"
                             ,"Para No 14","Para No 15","Para No 16","Para No 17","Para No 18","Para No 19","Para No 20","Para No 21"
                             ,"Para No 22","Para No 23","Para No 24","Para No 25","Para No 26","Para No 27","Para No 28"
                             ,"Para No 29","Para No 30"};
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
                finish();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView mTitle = toolbar.findViewById(R.id.tv);
        mTitle.setText("Read Quran");
    }

    public void btnBack(View view) {
        startActivity(new Intent(Main2Activity.this, MainActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        /*if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();*/
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}