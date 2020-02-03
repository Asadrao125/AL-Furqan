package com.example.asadrao.islamicapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Themes extends AppCompatActivity implements View.OnClickListener {
    Button btnDarkTheme;
    Button btnPeachTheme;
    Button btnBack;
    Button btntheme4;
    Button btntheme5;
    private SharedPreferences settings;
    public static final String THEME_Key = "app_theme";
    public static final String APP_PREFERENCES = "notepad_settings";
    private int theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Theme Setting Using Shared Prefrences
        settings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        theme = settings.getInt(THEME_Key, R.style.AppTheme);
        setTheme(theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView mTitle = toolbar.findViewById(R.id.tv);
        mTitle.setText("Themes");

        btnDarkTheme = findViewById(R.id.btnDarkTheme);
        btnPeachTheme = findViewById(R.id.btnPeachTheme);
        btntheme4 = findViewById(R.id.btntheme4);
        btntheme5 = findViewById(R.id.btntheme5);

        btnDarkTheme.setOnClickListener(this);
        btnPeachTheme.setOnClickListener(this);
        btntheme4.setOnClickListener(this);
        btntheme5.setOnClickListener(this);
        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Themes.this, MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnDarkTheme:
                settings.edit().putInt(THEME_Key, R.style.AppTheme2).apply();
                restartApp();
                break;
            case R.id.btnPeachTheme:
                settings.edit().putInt(THEME_Key, R.style.AppTheme3).apply();
                restartApp();
                break;
            case R.id.btntheme4:
                settings.edit().putInt(THEME_Key, R.style.AppTheme4).apply();
                restartApp();
                break;
            case R.id.btntheme5:
                settings.edit().putInt(THEME_Key, R.style.AppTheme5).apply();
                restartApp();
                break;
        }

    }

    public void restartApp() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}