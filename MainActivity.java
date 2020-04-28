package com.example.mad_practical_2_android_basics_zheng_jj;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="Whack-A-Mole!";
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "Finished Pre-Initialisation!");
        Button temp = findViewById(R.id.Hole1);
        Button temp1 = findViewById(R.id.Hole2);
        Button temp2 = findViewById(R.id.Hole3);
        final Button[] buttons = new Button[]{temp,temp1,temp2};
        for(final Button x:buttons)
        {
            x.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setNewMole(v, x, buttons);
                }
            });
        }
    }
    protected void onStart(View view){
        super.onStart();
        Log.v(TAG, "Starting GUI!");
    }
    @SuppressLint("SetTextI18n")
    public void setNewMole(View view, Button chosen, Button[] buttons)
    {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        Button Randomizedbutton = buttons[randomLocation];
        for(int i=0;i<buttons.length;i++){
            Button temp = buttons[i];
            String buttonname=temp.getText().toString();
            if(buttonname=="*"){
                temp.setText("O");
                if(chosen==buttons[0]){
                    Log.v(TAG,"Left Button Clicked!");
                }
                else if (chosen==buttons[1]){
                    Log.v(TAG,"Middle Button Clicked!");
                }
                else if (chosen==buttons[2]){
                    Log.v(TAG,"Right Button Clicked!");
                }
                if(chosen==temp){
                    score++;
                    Log.v(TAG,"HIT! SCORE +1!");
                }
                else {
                    score--;
                    Log.v(TAG,"MISS! SCORE -1!");
                }
                break;
            }
        }
        Randomizedbutton.setText("*");
        TextView scoredisplay=findViewById(R.id.Score);
        scoredisplay.setText("Score: " + score);
    }
}
