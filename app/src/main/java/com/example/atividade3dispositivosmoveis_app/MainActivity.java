package com.example.atividade3dispositivosmoveis_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.atividade3dispositivosmoveis_app.Model.Midia;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Midia> listaMidias = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnCadastrarMidia = findViewById(R.id.btnCadastrarMidia);
        Button btnListarMidias = findViewById(R.id.btnListarMidias);
        Button btnBuscarMidia = findViewById(R.id.btnBuscarMidia);
        Button btnReproduzirMidia = findViewById(R.id.btnReproduzirMidia);
        Button btnSair = findViewById(R.id.btnSair);

        btnCadastrarMidia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CadastroMidia = new Intent(MainActivity.this, CadastrarMidiaActivity.class);
                startActivity(CadastroMidia);
                finish();
            }
        });

        btnListarMidias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ListarMidias = new Intent(MainActivity.this, ListarMidiaActivity.class);
                startActivity(ListarMidias);
                finish();
            }
        });

        btnBuscarMidia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent BuscaMidia = new Intent(MainActivity.this, BuscarMidiasActivity.class);
                startActivity(BuscaMidia);
                finish();
            }
        });

        btnReproduzirMidia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ReproduzirMidia = new Intent(MainActivity.this, ReproduzirMidiaActivity.class);
                startActivity(ReproduzirMidia);
                finish();
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }



}