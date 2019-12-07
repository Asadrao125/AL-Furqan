package com.example.asadrao.islamicapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ListView pdfListView;
    SearchView svSurah;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // set theme
        SharedPreferences sharedPreferences = getSharedPreferences(Themes.APP_PREFERENCES, Context.MODE_PRIVATE);
        int theme = sharedPreferences.getInt(Themes.THEME_Key, R.style.AppTheme);
        setTheme(theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        svSurah = findViewById(R.id.svSurah);
        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main3Activity.this, MainActivity.class));
            }
        });


        pdfListView = (ListView)findViewById(R.id.myPDFList);
        String[] pdfFiles = {"Surah e Fatiha","Surah e Kausar","Surah e Mulk","Surah e Nisa","Surah e Rehman","Surah e Yaseen"};
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
        svSurah.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
                Intent intent = new Intent(Main3Activity.this,PDFOpener.class);
                intent.putExtra("pdfFilesName",item);
                startActivity(intent);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
