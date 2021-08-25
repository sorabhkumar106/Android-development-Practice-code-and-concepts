package com.example.musicstreamingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    Button play;
    Button pause;
    MediaPlayer mp;
    private Handler updatehandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        seekBar = findViewById(R.id.seekBar2);
        mp = new MediaPlayer();
        try {
            mp.setDataSource("http://djbloom.info/Music/My%20Music/38%20Special/38%20SPECIAL%20BACK%20WHERE%20YOU%20BELONG.MP3");
        } catch (IOException e) {
            e.printStackTrace();
        }
        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Toast.makeText(MainActivity.this, "Streaming Music......", Toast.LENGTH_LONG);
                seekBar.setMax(mp.getDuration());
                play.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();
                    }
                });

                pause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.pause();
                    }
                });



                Runnable updateSeekbar = new Runnable() {
                    @Override
                    public void run() {
                        seekBar.setProgress(mp.getCurrentPosition());
                        updatehandler.postDelayed(this, 50);
                    }
                };
                updatehandler.postDelayed(updateSeekbar, 0);
                updatehandler.removeCallbacks(updateSeekbar);
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser)
                            mp.seekTo(progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

            }
        });
        mp.prepareAsync();


    }
}