package com.example.atividade3dispositivosmoveis_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.atividade3dispositivosmoveis_app.Model.Midia;

public class BuscarMidiasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.buscar_midias);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText inputBuscar = findViewById(R.id.inputBuscar);
        TextView outputBuscar = findViewById(R.id.outputBuscar);
        Button btnBuscar = findViewById(R.id.btnBuscar);
        Button btnVoltar = findViewById(R.id.btnVoltarBuscar);

        btnBuscar.setOnClickListener(view -> {
            String titulo = inputBuscar.getText().toString().trim();
            if (!titulo.isBlank()) {
                for (Midia m : MainActivity.listaMidias) {
                    if (m.getTitulo().equalsIgnoreCase(titulo)) {
                        outputBuscar.setText(m.exibirDetalhes());
                        return;
                    } else {
                        outputBuscar.setText("Mídia não encontrada.");
                    }
                }
            }else{
                outputBuscar.setText("Preencha o campo de busca.");
            }
        });

        btnVoltar.setOnClickListener(view -> {
            Intent MainActivity = new Intent(BuscarMidiasActivity.this, MainActivity.class);
            startActivity(MainActivity);
            finish();
        });
    }
}