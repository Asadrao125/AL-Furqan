package com.example.asadrao.islamicapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PlayerActivity extends AppCompatActivity {
    Button pause,previous,next;
    SeekBar suratSeekbar;
    TextView suratTextLabe;
    TextView tvTotalDuration;
    String suratName;
    String now_playing;
    TextView tvCurretDuration;

    public int duration;
    public int currentPosition;

    static MediaPlayer myMediaPlayer;
    int position;
    ArrayList<File> mySurat;
    Thread updateseekbar;
    String sName;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // set theme
        SharedPreferences sharedPreferences = getSharedPreferences(Themes.APP_PREFERENCES, Context.MODE_PRIVATE);
        int theme = sharedPreferences.getInt(Themes.THEME_Key, R.style.AppTheme);
        setTheme(theme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        tvCurretDuration = findViewById(R.id.tvCurrentDuration);

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("now_playing",suratName);
                startActivity(intent);
                finish();
            }
        });

        tvTotalDuration = findViewById(R.id.tvTotalDuration);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        suratSeekbar = findViewById(R.id.seekbar);
        pause = findViewById(R.id.pause);
        previous = findViewById(R.id.previous);
        next = findViewById(R.id.next);
        suratTextLabe = findViewById(R.id.suratTextLabe);

        //suratSeekbar.setEnabled(false);

        updateseekbar = new Thread()
        {
            @Override
            public void run() {
                int totalDuration = myMediaPlayer.getDuration();
                int currentPosition = 0;
                while (currentPosition<totalDuration)
                {
                    try
                    {
                        sleep(500);
                        currentPosition = myMediaPlayer.getCurrentPosition();
                        suratSeekbar.setProgress(currentPosition);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };

        if (myMediaPlayer!=null)
        {
            myMediaPlayer.stop();
            myMediaPlayer.release();
        }
        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        mySurat = (ArrayList) bundle.getParcelableArrayList("surat");
        sName = mySurat.get(position).getName().toString();

        suratName = i.getStringExtra("suratName");

        suratTextLabe.setText(suratName);
        suratTextLabe.setSelected(true);

        position = bundle.getInt("pos",0);

        Uri u = Uri.parse(mySurat.get(position).toString());

        myMediaPlayer = MediaPlayer.create(getApplicationContext(),u);
        myMediaPlayer.start();
        suratSeekbar.setMax(myMediaPlayer.getDuration());

        updateseekbar.start();

        suratSeekbar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.MULTIPLY);
        suratSeekbar.getThumb().setColorFilter(getResources().getColor(R.color.colorPrimary),PorterDuff.Mode.SRC_IN);

        duration = myMediaPlayer.getDuration();
        String time = String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(duration),
                TimeUnit.MILLISECONDS.toSeconds(duration) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration))
        );
        tvTotalDuration.setText(""+time);


        myMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                try{ myMediaPlayer.setLooping(true);
                     myMediaPlayer.start();
                     updateseekbar.start();}
                catch(Exception e){e.printStackTrace();}
            }
        });

        suratSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                String time = String.format("%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes(progress),
                        TimeUnit.MILLISECONDS.toSeconds(progress) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(progress))
                );
                tvCurretDuration.setText(""+time);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                myMediaPlayer.seekTo(seekBar.getProgress());
            }
        });
        //Onclick Listeners For Pause Next Previous
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suratSeekbar.setMax(myMediaPlayer.getDuration());
                if (myMediaPlayer.isPlaying())
                {
                    pause.setBackgroundResource(R.drawable.icon_play);
                    myMediaPlayer.pause();
                }
                else
                {
                    pause.setBackgroundResource(R.drawable.icon_pause);
                    myMediaPlayer.start();
                }
            }
        });

        //To Change The Next Surat
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myMediaPlayer.stop();
                myMediaPlayer.release();


                position = (position + 1) % mySurat.size();

                Uri u = Uri.parse(mySurat.get(position).toString());

                myMediaPlayer = MediaPlayer.create(getApplicationContext(), u);

                sName = mySurat.get(position).getName().toString();
                suratName = mySurat.get(position).getName();
                suratTextLabe.setText(sName);

                duration = myMediaPlayer.getDuration();
                String time = String.format("%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes(duration),
                        TimeUnit.MILLISECONDS.toSeconds(duration) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration))
                );
                tvTotalDuration.setText(""+time);
                myMediaPlayer.start();

                pause.setBackgroundResource(R.drawable.icon_pause);
                suratSeekbar.setMax(myMediaPlayer.getDuration());

            }
        });
        
        //To Change The Previous Surat
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myMediaPlayer.stop();
                myMediaPlayer.release();
                position = ((position - 1)<0)?(mySurat.size() - 1): (position - 1);

                Uri u = Uri.parse(mySurat.get(position).toString());

                myMediaPlayer = MediaPlayer.create(getApplicationContext(), u);

                suratName = mySurat.get(position).getName();
                sName = mySurat.get(position).getName().toString();
                suratTextLabe.setText(sName);


                duration = myMediaPlayer.getDuration();
                String time = String.format("%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes(duration),
                        TimeUnit.MILLISECONDS.toSeconds(duration) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration))
                );
                tvTotalDuration.setText(""+time);


                myMediaPlayer.start();

                pause.setBackgroundResource(R.drawable.icon_pause);
                suratSeekbar.setMax(myMediaPlayer.getDuration());
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        now_playing = "Now Playing: " + suratName;
        intent.putExtra("now_playing",now_playing);
        startActivity(intent);
        finish();
    }
}
