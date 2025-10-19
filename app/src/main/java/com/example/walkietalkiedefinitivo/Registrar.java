package com.example.walkietalkiedefinitivo;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Registrar extends AppCompatActivity {

    Button buttonregister;
    EditText username_input, correo_input, password_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrar);

        buttonregister = findViewById(R.id.registrar_btn);
        username_input = findViewById(R.id.username_input);
        correo_input = findViewById(R.id.correo_input);
        password_input = findViewById(R.id.password_input);


        buttonregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registrar();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void registrar() {
        Sqlite con = new Sqlite(this, "dbWalkieTalkie", null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        String user = username_input.getText().toString().trim();
        String email = correo_input.getText().toString().trim();
        String password = password_input.getText().toString().trim();

        if (!user.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
            ContentValues registrar = new ContentValues();
            registrar.put("Name", user);
            registrar.put("Email", email);
            registrar.put("Password", password);

            long result = db.insert("tbUsers", null, registrar);
            if (result != -1) {
                Toast.makeText(this, "Se registró exitosamente", Toast.LENGTH_LONG).show();
                username_input.setText("");
                correo_input.setText("");
                password_input.setText("");

                Intent intent = new Intent(Registrar.this, Radio.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Error al registrar", Toast.LENGTH_LONG).show();
            }
            db.close();
        } else {
            Toast.makeText(this, "Algún campo viene vacío", Toast.LENGTH_LONG).show();
        }
    }

}

