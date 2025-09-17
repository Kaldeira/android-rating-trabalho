package com.example.sistemadeclassificacao;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.*;
import android.view.*;
import android.app.*;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StatusActivity extends AppCompatActivity {
    TextView txt_status;
    RatingBar rating_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_status);

        txt_status = (TextView)findViewById(R.id.tvstatus);
        rating_bar = (RatingBar)findViewById(R.id.rtbvotacao);

        String status = getIntent().getStringExtra("status");
        float rating = getIntent().getFloatExtra("rating", 0);

        rating_bar.setRating(rating);
        rating_bar.setIsIndicator(true);
        txt_status.setText("Status: " + status);
    }
}
