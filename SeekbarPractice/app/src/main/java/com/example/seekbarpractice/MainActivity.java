package com.example.seekbarpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;
import java.sql.Time;

public class MainActivity extends AppCompatActivity {

MediaPlayer mediaPlayer;
TextView textView;
SeekBar seekBar;
Runnable thread;
View time;
Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar=findViewById(R.id.seekbar);
        textView=findViewById(R.id.textView2);
        time=findViewById(R.id.editTextTime);
        mediaPlayer=MediaPlayer.create(this,R.raw.music);
        textView.setText(String.valueOf(mediaPlayer.getDuration()));
        seekBar.setMax(mediaPlayer.getDuration());
        thread=new Runnable(){
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                handler.postDelayed(thread,400);
            }
        };
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser)
                    mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void Play(View view) {
        mediaPlayer.start();
        thread.run();

    }

    public void Pause(View view) {
        mediaPlayer.pause();
    }


}