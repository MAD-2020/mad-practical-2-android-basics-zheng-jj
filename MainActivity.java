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
    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - Feel free to modify the function to suit your program.
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "Finished Pre-Initialisation!");
    }

    protected void onStart(View view){
        super.onStart();
        setNewMole(view);
        Log.v(TAG, "Starting GUI!");
    }

    @SuppressLint("SetTextI18n")
    public void setNewMole(View view)
    {
        int[] buttons = new int[]{R.id.Hole1,R.id.Hole2,R.id.Hole3};
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        Button Randomizedbutton = findViewById(buttons[randomLocation]);
        Button CurrentClickedButton = findViewById(view.getId());
        for(int i=0;i<3;i++){
            Button temp = findViewById(buttons[i]);
            String buttonname=temp.getText().toString();
            if(buttonname=="*"){
                temp.setText("O");
                if(CurrentClickedButton.getId()==buttons[0]){
                    Log.v(TAG,"Left Button Clicked!");
                }
                else if (CurrentClickedButton.getId()==buttons[1]){
                    Log.v(TAG,"Middle Button Clicked!");
                }
                else if (CurrentClickedButton.getId()==buttons[2]){
                    Log.v(TAG,"Right Button Clicked!");
                }
                if(CurrentClickedButton.getId()==temp.getId()){
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