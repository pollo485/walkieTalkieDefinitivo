package com.example.walkietalkiedefinitivo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Vinculacion extends AppCompatActivity {

    ListView listavinculados;
    ListView listadisponibles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vinculacion);

        listavinculados = findViewById(R.id.lv_vinculados);
        listadisponibles = findViewById(R.id.lv_disponibles);

        ArrayAdapter<CharSequence> adaptadorVinculados =
                ArrayAdapter.createFromResource(this, R.array.ListaVinculados, android.R.layout.simple_list_item_1);
        listavinculados.setAdapter(adaptadorVinculados);

        ArrayAdapter<CharSequence> adaptadorDisponibles=
                ArrayAdapter.createFromResource(this, R.array.ListaDisponibles, android.R.layout.simple_list_item_1);
        listadisponibles.setAdapter(adaptadorDisponibles);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
