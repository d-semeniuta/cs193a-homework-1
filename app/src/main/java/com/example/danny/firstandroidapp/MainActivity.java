package com.example.danny.firstandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void rps(View view) {
        int id = view.getId();
        ImageView img = (ImageView) findViewById(R.id.player_choice);
        ImageView img2 = (ImageView) findViewById(R.id.comp_choice);


        Random rnd = new Random();
        int result = rnd.nextInt(3); //0 = marty, 1 = mehran, 2 = keith

        if(id == R.id.marty_button) {
            img.setImageResource(R.drawable.marty);
            switch (result) {
                case 0: draw();
                        break;
                case 1: win();
                        break;
                case 2: loss();
                        break;
            }
        } else if(id == R.id.mehran_button){
            img.setImageResource(R.drawable.mehran);
            switch (result) {
                case 0: loss();
                        break;
                case 1: draw();
                        break;
                case 2: win();
                        break;
            }
        } else {
            img.setImageResource(R.drawable.keith);
            switch (result) {
                case 0: win();
                        break;
                case 1: loss();
                        break;
                case 2: draw();
                        break;
            }
        }

        if (result == 0){
            img2.setImageResource(R.drawable.marty);
        } else if (result == 1){
            img2.setImageResource(R.drawable.mehran);
        } else {
            img2.setImageResource(R.drawable.keith);
        }

    }

    private void win() {
        Toast.makeText(this, "Good Win! +1", Toast.LENGTH_SHORT).show();
        score++;
        TextView scoreboard = (TextView) findViewById(R.id.score);
        scoreboard.setText("Score: " + score);
    }
    private void loss() {
        Toast.makeText(this, "Commendable Loss! -1", Toast.LENGTH_SHORT).show();
        score--;
        TextView scoreboard = (TextView) findViewById(R.id.score);
        scoreboard.setText("Score: " + score);
    }
    private void draw() {
        Toast.makeText(this, "Nice Draw! +0", Toast.LENGTH_SHORT).show();
    }
}
