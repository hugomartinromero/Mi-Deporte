package com.fireboy.mideporte;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RadioButton rbIndividual, rbPareja, rbGrupal;
    Spinner spDeportes;
    TextView lblDeporte;
    List<String> opciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbIndividual = findViewById(R.id.rbIndividual);
        rbPareja = findViewById(R.id.rbPareja);
        rbGrupal = findViewById(R.id.rbGrupal);
        spDeportes = findViewById(R.id.spDeportes);
        lblDeporte = findViewById(R.id.lblDeporte);

        cambiarOpciones("Individual");

        rbIndividual.setOnClickListener(v -> cambiarOpciones("Individual"));
        rbPareja.setOnClickListener(v -> cambiarOpciones("En pareja"));
        rbGrupal.setOnClickListener(v -> cambiarOpciones("Grupal"));

        spDeportes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cambiarTextos();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }

    private void cambiarOpciones(String tipo) {
        opciones = new ArrayList<>();
        switch (tipo) {
            case "Individual":
                opciones.add("Salto de altura");
                opciones.add("Atletismo");
                opciones.add("Gimnasia");
                break;
            case "En pareja":
                opciones.add("Pádel");
                opciones.add("Tenis");
                opciones.add("Squash");
                break;
            case "Grupal":
                opciones.add("Fútbol");
                opciones.add("Rugby");
                opciones.add("Balonmano");
                break;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, opciones);
        spDeportes.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void cambiarTextos() {
        if (spDeportes.getSelectedItem() != null) {
            lblDeporte.setText(spDeportes.getSelectedItem().toString());
        }
    }
}