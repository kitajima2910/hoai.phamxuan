package com.gameloft.samplejni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("pxh");
    }

    private native int getInit();
    private native String getText();
    private native double add(double a, double b);
    private native double add(double a, double b, double c);
    private native double addThree(double a, double b, double c);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtContent = findViewById(R.id.txtContent);
        txtContent.setText(addThree(1, 2, 3) + "");
    }
}