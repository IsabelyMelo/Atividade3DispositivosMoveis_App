package com.example.atividade3dispositivosmoveis_app;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.atividade3dispositivosmoveis_app.Model.Midia;

public class ListarMidiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.listar_midia);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnVoltar = findViewById(R.id.btnVoltarListar);
        LinearLayout container = findViewById(R.id.containerMidias);

        container.removeAllViews();

        for (int i = 0; i < MainActivity.listaMidias.size(); i++) {

            Midia m = MainActivity.listaMidias.get(i);

            LinearLayout linha = new LinearLayout(this);
            linha.setOrientation(LinearLayout.VERTICAL);
            linha.setPadding(16, 16, 16, 16);

            if (i % 2 == 0) {
                linha.setBackgroundColor(0xFFEFEFEF);
            }

            TextView titulo = new TextView(this);
            titulo.setText(m.getTitulo());
            titulo.setTextSize(18);
            titulo.setTypeface(null, Typeface.BOLD);

            TextView detalhes = new TextView(this);
            detalhes.setText(m.exibirDetalhes());

            linha.addView(titulo);
            linha.addView(detalhes);

            View divisor = new View(this);
            divisor.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, 2));
            divisor.setBackgroundColor(0xFFCCCCCC);

            container.addView(linha);
            container.addView(divisor);
        }

        btnVoltar.setOnClickListener(view -> {
            Intent MainActivity = new Intent(ListarMidiaActivity.this, MainActivity.class);
            startActivity(MainActivity);
            finish();
        });
    }
}