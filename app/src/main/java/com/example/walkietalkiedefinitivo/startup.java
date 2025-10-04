package com.example.walkietalkiedefinitivo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class startup extends AppCompatActivity {

    Button buttonlogin;
    Button buttonregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_startup);

        buttonlogin = findViewById(R.id.iniciarsesion_btn);
        buttonregister = findViewById(R.id.registro_btn);

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(startup.this,MainActivity.class);
                startActivity(intent);
            }
        });

        buttonregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v){
                Intent intent = new Intent(startup.this, Registrar.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}