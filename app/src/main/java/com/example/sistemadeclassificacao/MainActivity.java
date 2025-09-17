package com.example.sistemadeclassificacao;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.*;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txt_status;
    RatingBar rating_bar;
    String status = "Péssimo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txt_status = (TextView)findViewById(R.id.tvstatus);
        rating_bar = (RatingBar)findViewById(R.id.rtbvotacao);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txt_status.setText("Status: " + status);

        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Status");

        rating_bar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (rating >= 0 && rating <= 1) {
                    status = "Pessimo";
                    txt_status.setText("Status: " + status);
                    alert.setMessage(status);
                    alert.show();
                } else if (rating > 1 && rating <= 2) {
                    status = "Ruim";
                    txt_status.setText("Status: " + status);
                    alert.setMessage(status);
                    alert.show();
                } else if (rating > 2 && rating <= 3) {
                    status = "Bom";
                    txt_status.setText("Status: " + status);
                    alert.setMessage(status);
                    alert.show();
                } else if (rating > 3 && rating <= 4) {
                    status = "Ótimo";
                    txt_status.setText("Status: " + status);
                    alert.setMessage(status);
                    alert.show();
                } else if (rating > 4 && rating <= 5) {
                    status = "Excelente";
                    txt_status.setText("Status: " + status);
                    alert.setMessage(status);
                    alert.show();
                }
            }
        });

        alert.setNeutralButton("OK", (dialog, which) -> {
            Intent intent = new Intent(MainActivity.this, StatusActivity.class);
            intent.putExtra("status", status);
            intent.putExtra("rating", rating_bar.getRating());
            startActivity(intent);
        });
    }
}