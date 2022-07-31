package com.example.audioplayermobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    public void play(View view){
        mediaPlayer.start();

    }
    public void pause(View view){
        mediaPlayer.pause();

    }
    public void stop(View view){
        mediaPlayer.stop();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer=MediaPlayer.create(this,R.raw.music);

        SeekBar seekVol=findViewById(R.id.VolBar);

        audioManager= (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        int maxVol=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVol=audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        seekVol.setMax(maxVol);
        seekVol.setProgress(curVol);
    }
}