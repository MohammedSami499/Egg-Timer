package com.example.eggtimers;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    TextView editText1;

    Button btn = (Button)findViewById(R.id.button);
    public void start(View view){
        new CountDownTimer(currentTime*1000 , 1000){
            @Override
            public void onTick(long l) {
                editText1.setText(String.valueOf((l/1000)/60));
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext() , "Finished" , Toast.LENGTH_SHORT).show();
            }
        }.start();
    }



    int currentTime = 10*60;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        editText1 = (TextView) findViewById(R.id.second);
        seekBar.setMax(10*60);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                editText1.setText(String.valueOf(i*currentTime/60)+" : " + String.valueOf((i*currentTime/60)%60));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }
}


