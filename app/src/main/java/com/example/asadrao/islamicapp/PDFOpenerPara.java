package com.example.asadrao.islamicapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFOpenerPara extends AppCompatActivity {
    PDFView myPDFViewer;
    Button btnBack;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // set theme
        SharedPreferences sharedPreferences = getSharedPreferences(Themes.APP_PREFERENCES, Context.MODE_PRIVATE);
        int theme = sharedPreferences.getInt(Themes.THEME_Key, R.style.AppTheme);
        setTheme(theme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfopener_para);

        myPDFViewer = (PDFView)findViewById(R.id.pdfViewer);
        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PDFOpenerPara.this, Main2Activity.class));
                finish();
            }
        });
        String getItem = getIntent().getStringExtra("pdfFilesName");

        String[] pdfFiles = {"Select Para to Read","Para No 1","Para No 2","Para No 3","Para No 4","Para No 5","Para No 6"
                ,"Para No 7","Para No 8","Para No 9","Para No 10","Para No 11","Para No 12","Para No 13"
                ,"Para No 14","Para No 15","Para No 16","Para No 17","Para No 18","Para No 19","Para No 20","Para No 21"
                ,"Para No 22","Para No 23","Para No 24","Para No 25","Para No 26","Para No 27","Para No 28"
                ,"Para No 29","Para No 30"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinnerlayout,R.id.textView,pdfFiles)
        {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
            {
                View view = super.getView(position, convertView, parent);
                TextView mytext = (TextView) view.findViewById(R.id.text1);
                return view;
            }
        };

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 1)
                {
                    myPDFViewer.fromAsset("1.pdf").load();
                }
                if (position == 2)
                {
                    myPDFViewer.fromAsset("2.pdf").load();
                }
                else if (position == 3)
                {
                    myPDFViewer.fromAsset("3.pdf").load();
                }
                else if (position == 4)
                {
                    myPDFViewer.fromAsset("4.pdf").load();
                }
                else if (position == 5)
                {
                    myPDFViewer.fromAsset("5.pdf").load();
                }
                else if (position == 6)
                {
                    myPDFViewer.fromAsset("6.pdf").load();
                }
                else if (position == 7)
                {
                    myPDFViewer.fromAsset("7.pdf").load();
                }
                else if (position == 8)
                {
                    myPDFViewer.fromAsset("8.pdf").load();
                }
                else if (position == 9)
                {
                    myPDFViewer.fromAsset("9.pdf").load();
                }
                else if (position == 10)
                {
                    myPDFViewer.fromAsset("10.pdf").load();
                }
                else if (position == 11)
                {
                    myPDFViewer.fromAsset("11.pdf").load();
                }
                else if (position == 12)
                {
                    myPDFViewer.fromAsset("12.pdf").load();
                }
                else if (position == 13)
                {
                    myPDFViewer.fromAsset("13.pdf").load();
                }
                else if (position == 14)
                {
                    myPDFViewer.fromAsset("14.pdf").load();
                }
                else if (position == 15)
                {
                    myPDFViewer.fromAsset("15.pdf").load();
                }
                else if (position == 16)
                {
                    myPDFViewer.fromAsset("16.pdf").load();
                }
                else if (position == 17)
                {
                    myPDFViewer.fromAsset("17.pdf").load();
                }
                else if (position == 18)
                {
                    myPDFViewer.fromAsset("18.pdf").load();
                }
                else if (position == 19)
                {
                    myPDFViewer.fromAsset("19.pdf").load();
                }
                else if (position == 20)
                {
                    myPDFViewer.fromAsset("20.pdf").load();
                }
                else if (position == 21)
                {
                    myPDFViewer.fromAsset("21.pdf").load();
                }
                else if (position == 22)
                {
                    myPDFViewer.fromAsset("22.pdf").load();
                }
                else if (position == 23)
                {
                    myPDFViewer.fromAsset("23.pdf").load();
                }
                else if (position == 24)
                {
                    myPDFViewer.fromAsset("24.pdf").load();
                }
                else if (position == 25)
                {
                    myPDFViewer.fromAsset("25.pdf").load();
                }
                else if (position == 26)
                {
                    myPDFViewer.fromAsset("26.pdf").load();
                }
                else if (position == 27)
                {
                    myPDFViewer.fromAsset("27.pdf").load();
                }
                else if (position == 28)
                {
                    myPDFViewer.fromAsset("28.pdf").load();
                }
                else if (position == 29)
                {
                    myPDFViewer.fromAsset("29.pdf").load();
                }
                else if (position == 30)
                {
                    myPDFViewer.fromAsset("30.pdf").load();
                }
                /*else
                {
                    Toast.makeText(getApplicationContext(), "No Matched Resource!", Toast.LENGTH_SHORT).show();
                }*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if (getItem.equals("Para No 1"))
        {
            myPDFViewer.fromAsset("1.pdf").load();
        }
        else if (getItem.equals("Para No 2"))
        {
            myPDFViewer.fromAsset("2.pdf").load();
        }
        else if (getItem.equals("Para No 3"))
        {
            myPDFViewer.fromAsset("3.pdf").load();
        }
        else if (getItem.equals("Para No 4"))
        {
            myPDFViewer.fromAsset("4.pdf").load();
        }
        else if (getItem.equals("Para No 5"))
        {
            myPDFViewer.fromAsset("5.pdf").load();
        }
        else if (getItem.equals("Para No 6"))
        {
            myPDFViewer.fromAsset("6.pdf").load();
        }
        else if (getItem.equals("Para No 7"))
        {
            myPDFViewer.fromAsset("7.pdf").load();
        }
        else if (getItem.equals("Para No 8"))
        {
            myPDFViewer.fromAsset("8.pdf").load();
        }
        else if (getItem.equals("Para No 9"))
        {
            myPDFViewer.fromAsset("9.pdf").load();
        }
        else if (getItem.equals("Para No 10"))
        {
            myPDFViewer.fromAsset("10.pdf").load();
        }
        else if (getItem.equals("Para No 11"))
        {
            myPDFViewer.fromAsset("11.pdf").load();
        }
        else if (getItem.equals("Para No 12"))
        {
            myPDFViewer.fromAsset("12.pdf").load();
        }
        else if (getItem.equals("Para No 13"))
        {
            myPDFViewer.fromAsset("13.pdf").load();
        }
        else if (getItem.equals("Para No 14"))
        {
            myPDFViewer.fromAsset("14.pdf").load();
        }
        else if (getItem.equals("Para No 15"))
        {
            myPDFViewer.fromAsset("15.pdf").load();
        }
        else if (getItem.equals("Para No 16"))
        {
            myPDFViewer.fromAsset("16.pdf").load();
        }
        else if (getItem.equals("Para No 17"))
        {
            myPDFViewer.fromAsset("17.pdf").load();
        }
        else if (getItem.equals("Para No 18"))
        {
            myPDFViewer.fromAsset("18.pdf").load();
        }
        else if (getItem.equals("Para No 19"))
        {
            myPDFViewer.fromAsset("19.pdf").load();
        }
        else if (getItem.equals("Para No 20"))
        {
            myPDFViewer.fromAsset("20.pdf").load();
        }
        else if (getItem.equals("Para No 21"))
        {
            myPDFViewer.fromAsset("21.pdf").load();
        }
        else if (getItem.equals("Para No 22"))
        {
            myPDFViewer.fromAsset("22.pdf").load();
        }
        else if (getItem.equals("Para No 23"))
        {
            myPDFViewer.fromAsset("23.pdf").load();
        }
        else if (getItem.equals("Para No 24"))
        {
            myPDFViewer.fromAsset("24.pdf").load();
        }
        else if (getItem.equals("Para No 25"))
        {
            myPDFViewer.fromAsset("25.pdf").load();
        }
        else if (getItem.equals("Para No 26"))
        {
            myPDFViewer.fromAsset("26.pdf").load();
        }
        else if (getItem.equals("Para No 27"))
        {
            myPDFViewer.fromAsset("27.pdf").load();
        }
        else if (getItem.equals("Para No 28"))
        {
            myPDFViewer.fromAsset("28.pdf").load();
        }
        else if (getItem.equals("Para No 29"))
        {
            myPDFViewer.fromAsset("29.pdf").load();
        }
        else if (getItem.equals("Para No 30"))
        {
            myPDFViewer.fromAsset("30.pdf").load();
        }
        /*else
        {
            Toast.makeText(this, "No Matching PDF Found", Toast.LENGTH_SHORT).show();
        }*/

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
        startActivity(new Intent(getApplicationContext(), Main2Activity.class));
        finish();
    }
}
