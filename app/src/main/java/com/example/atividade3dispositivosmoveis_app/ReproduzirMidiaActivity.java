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

public class ReproduzirMidiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.reproduzir_midia);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText inputReproduzir = findViewById(R.id.inputReproduzir);
        TextView outputReproduzir = findViewById(R.id.outputReproduzir);
        Button btnReproduzir = findViewById(R.id.btnReproduzir);
        Button btnVoltar = findViewById(R.id.btnVoltarReproduzir);

        btnReproduzir.setOnClickListener(view -> {
            String titulo = inputReproduzir.getText().toString().trim();
            if (!titulo.isBlank()) {
                for (Midia m : MainActivity.listaMidias) {
                    if (m.getTitulo().equalsIgnoreCase(titulo)) {
                        outputReproduzir.setText(
                                m.reproduzir()
                        );
                        return;
                    } else {
                        outputReproduzir.setText("Mídia não encontrada.");
                    }
                }
            } else {
                outputReproduzir.setText("Preencha o campo de busca.");
            }
        });

        btnVoltar.setOnClickListener(view -> {
            Intent MainActivity = new Intent(ReproduzirMidiaActivity.this, MainActivity.class);
            startActivity(MainActivity);
            finish();
        });
    }
}