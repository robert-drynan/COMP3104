package com.example.labexw1_101460767;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button b = findViewById(R.id.btnWWW);
        b.setOnClickListener(view ->{
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.georgebrown.ca/"));
            startActivity(i);
        });
        Button call = findViewById(R.id.btnCall);
        call.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:4165550000"));
            startActivity(i);
        });
        Button map = findViewById(R.id.btnMap);
        map.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:43.67, -79.49"));
            startActivity(i);
        });
    }
}