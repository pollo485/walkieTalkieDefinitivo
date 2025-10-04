package com.example.walkietalkiedefinitivo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Conversaciones extends AppCompatActivity {

    RecyclerView recyclerView;
    ConversacionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversaciones);

        recyclerView = findViewById(R.id.recycler_conversaciones);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> demo = new ArrayList<>();
        for (int i = 1; i <= 8; i++) demo.add("Conversacion " + i);

        adapter = new ConversacionAdapter(demo, new ConversacionAdapter.OnItemClickListener() {
            @Override
            public void onNotasClick(int position) {
                // aquí sí estás en la Activity — inicia Notas:
                Intent intent = new Intent(Conversaciones.this, Notas.class);
                // si quieres pasar datos:
                // intent.putExtra("titulo", demo.get(position));
                startActivity(intent);
            }

            @Override
            public void onPlayClick(int position) {
                // por ahora nada
            }
        });

        recyclerView.setAdapter(adapter);
    }
}

