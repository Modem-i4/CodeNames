package com.modemi4.codenames;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    LayoutInflater inflater;
    Context context;
    @Override
    @SuppressLint("ResourceType")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflater = getLayoutInflater();
        context = getApplicationContext();
        Button playAsHostBtn = findViewById(R.id.playAsHost);
        Button playAsParticipantBtn = findViewById(R.id.playAsParticipant);
        playAsHostBtn.setOnClickListener(play);
        playAsParticipantBtn.setOnClickListener(play);

    }
    View.OnClickListener play = new View.OnClickListener() {
        @Override
        public void onClick(View btn) {
            View layout = inflater.inflate(R.layout.game, null, false);
            Game game;
            if(btn.getId() == R.id.playAsHost)
                game = new GameHost(context, layout);
            else if(btn.getId() == R.id.playAsParticipant)
                game = new GameParticipant(context, layout);
            setContentView(layout);
        }
    };
}