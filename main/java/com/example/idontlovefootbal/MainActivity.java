package com.example.lizatop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Integer lizaCounter = 0;
    Integer owlCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onClickLiza(View view){
        lizaCounter++;
        TextView counterLizaView = findViewById(R.id.txt_LizaCounter);
        counterLizaView.setText(lizaCounter.toString());
    }
    public void onClickOwl(View view){
        owlCounter++;
        TextView counterOwlView = findViewById(R.id.txt_OwlCounter);
        counterOwlView.setText(owlCounter.toString());
    }
    public void onClickReset(View view){
        lizaCounter = 0;
        owlCounter = 0;
        TextView counterBrazilView = findViewById(R.id.txt_LizaCounter);
        TextView counterSpainView = findViewById(R.id.txt_OwlCounter);
        counterBrazilView.setText(lizaCounter.toString());
        counterSpainView.setText(owlCounter.toString());
    }
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("LizaCount")) {
            lizaCounter = savedInstanceState.getInt("LizaCount");
        }
        if (savedInstanceState != null && savedInstanceState.containsKey("OwlCount")) {
            owlCounter = savedInstanceState.getInt("OwlCount");
        }
    }
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("LizaCount", lizaCounter);
        outState.putInt("OwlCount", owlCounter);
    }
    public void resetUI() {
        ((TextView) findViewById(R.id.txt_LizaCounter)).setText(lizaCounter.toString());
        ((TextView) findViewById(R.id.txt_OwlCounter)).setText(owlCounter.toString());
    }
    public void onResume() {
        super.onResume();
        resetUI();
    }
}