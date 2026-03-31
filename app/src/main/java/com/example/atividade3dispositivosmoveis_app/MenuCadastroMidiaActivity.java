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

public class MenuCadastroMidiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.menu_cadastro_midia);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnCadastrarMusica = findViewById(R.id.btnMusica);
        Button btnCadastrarVideo = findViewById(R.id.btnVideo);
        Button btnCadastrarPodcast = findViewById(R.id.btnPodcast);
        Button btnvoltar = findViewById(R.id.btnVoltarCadastro);

        btnCadastrarMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CadastrarMusicaActivity = new Intent(MenuCadastroMidiaActivity.this, CadastrarMidiaActivity.class);
                startActivity(CadastrarMusicaActivity);
                finish();
            }
        });

        btnCadastrarVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CadastrarVideoActivity = new Intent(MenuCadastroMidiaActivity.this, CadastrarMidiaActivity.class);
                startActivity(CadastrarVideoActivity);
                finish();
            }
        });

        btnCadastrarPodcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CadastrarPodcastAtctivity = new Intent(MenuCadastroMidiaActivity.this, CadastrarMidiaActivity.class);
                startActivity(CadastrarPodcastAtctivity);
                finish();
            }
        });

        btnvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MainActivity = new Intent(MenuCadastroMidiaActivity.this, MainActivity.class);
                startActivity(MainActivity);
                finish();
            }
        });
    }
}