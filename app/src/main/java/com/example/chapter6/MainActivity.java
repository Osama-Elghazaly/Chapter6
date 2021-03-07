package com.example.chapter6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bttnFirstSong,bttnSecondSong;
    MediaPlayer mpFirstSong,mpSecondSong;
    int playing;
    int songMain;//I declared this variable to only allow one song to play at a time


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bttnFirstSong=(Button)findViewById(R.id.button);
        bttnSecondSong=(Button)findViewById(R.id.button2);
        Button bttnBack=(Button)findViewById(R.id.button3);

        mpFirstSong=new MediaPlayer();
        mpSecondSong=new MediaPlayer();

        mpFirstSong=MediaPlayer.create(this,R.raw.track1);
        mpSecondSong=MediaPlayer.create(this,R.raw.track2);


        playing=0;//this means that so far nothing is playing
        songMain=0;


        bttnFirstSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    switch (playing) {
                        case 0:
                            mpFirstSong.start();
                            playing = 1;
                            bttnFirstSong.setText("Pause first song");
                            break;


                        case 1:
                            mpFirstSong.pause();
                            playing = 0;
                            bttnFirstSong.setText("Play first song");
                            break;
                    }


                }


        });

        bttnSecondSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (playing){
                    case 0:
                        mpSecondSong.start();
                        playing=1;
                        bttnSecondSong.setText("Pause second song");
                        break;

                    case 1:
                        mpSecondSong.pause();
                        playing=0;
                        bttnSecondSong.setText("Play second song");
                        break;
                }


            }
        });

        bttnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Splash.class));
            }
        });



    }
}