package com.example.atividade3dispositivosmoveis_app.Midias;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.atividade3dispositivosmoveis_app.ListarMidiaActivity;
import com.example.atividade3dispositivosmoveis_app.MainActivity;
import com.example.atividade3dispositivosmoveis_app.MenuCadastroMidiaActivity;
import com.example.atividade3dispositivosmoveis_app.R;

public class CadastrarMusicaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.cadastrar_musica);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnvoltar = findViewById(R.id.btnVoltarMusica);

        btnvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MenuCadastroMidiaActivity = new Intent(CadastrarMusicaActivity.this, MenuCadastroMidiaActivity.class);
                startActivity(MenuCadastroMidiaActivity);
                finish();
            }
        });
    }
}