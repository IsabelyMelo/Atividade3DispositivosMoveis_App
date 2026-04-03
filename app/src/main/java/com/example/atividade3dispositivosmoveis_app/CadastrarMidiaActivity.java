package com.example.atividade3dispositivosmoveis_app;

import static com.example.atividade3dispositivosmoveis_app.MainActivity.listaMidias;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.atividade3dispositivosmoveis_app.Enums.TipoMidia;
import com.example.atividade3dispositivosmoveis_app.Model.Midia;
import com.example.atividade3dispositivosmoveis_app.Model.Musica;
import com.example.atividade3dispositivosmoveis_app.Model.Podcast;
import com.example.atividade3dispositivosmoveis_app.Model.Video;

public class CadastrarMidiaActivity extends AppCompatActivity {

    private EditText inputTitulo, inputAno;
    private EditText inputArtista, inputAlbum;
    private EditText inputDiretor, inputDuracao;
    private EditText inputAnfitriao, inputEpisodio;

    private Spinner spinnerTipoMidia;
    private LinearLayout layoutMusica, layoutVideo, layoutPodcast;
    private Button btnCadastrar;

    private Button btnVoltar;
    private TextView lblResultado;

    private TipoMidia tipoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.cadastrar_midia);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputTitulo = findViewById(R.id.inputTitulo);
        inputAno = findViewById(R.id.inputAno);
        inputArtista = findViewById(R.id.inputArtista);
        inputAlbum = findViewById(R.id.inputAlbum);
        inputDiretor = findViewById(R.id.inputDiretor);
        inputDuracao = findViewById(R.id.inputDuracao);
        inputAnfitriao = findViewById(R.id.inputAnfitriao);
        inputEpisodio = findViewById(R.id.inputEpisodio);
        spinnerTipoMidia = findViewById(R.id.spinnerTipoMidia);
        layoutMusica = findViewById(R.id.layoutMusica);
        layoutVideo = findViewById(R.id.layoutVideo);
        layoutPodcast = findViewById(R.id.layoutPodcast);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnVoltar = findViewById(R.id.btnVoltarMidia);
        lblResultado = findViewById(R.id.lblResultado);

        ArrayAdapter<TipoMidia> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                TipoMidia.values()
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoMidia.setAdapter(adapter);

        spinnerTipoMidia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipoSelecionado = (TipoMidia) parent.getItemAtPosition(position);
                atualizarCamposEspecificos(tipoSelecionado);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        tipoSelecionado = (TipoMidia) spinnerTipoMidia.getSelectedItem();
        atualizarCamposEspecificos(tipoSelecionado);

        btnCadastrar.setOnClickListener(v -> cadastrarMidia());

        btnVoltar.setOnClickListener(view -> {
            Intent MainActivity = new Intent(CadastrarMidiaActivity.this, MainActivity.class);
            startActivity(MainActivity);
            finish();
        });

    }

    private void atualizarCamposEspecificos(TipoMidia tipo) {
        layoutMusica.setVisibility(View.GONE);
        layoutVideo.setVisibility(View.GONE);
        layoutPodcast.setVisibility(View.GONE);

        switch (tipo) {
            case MUSICA:
                layoutMusica.setVisibility(View.VISIBLE);
                break;

            case VIDEO:
                layoutVideo.setVisibility(View.VISIBLE);
                break;

            case PODCAST:
                layoutPodcast.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void cadastrarMidia() {
        try {
            String titulo = inputTitulo.getText().toString().trim();
            String anoTexto = inputAno.getText().toString().trim();

            if (titulo.isEmpty() || anoTexto.isEmpty()) {
                Toast.makeText(this, "Preencha título e ano.", Toast.LENGTH_SHORT).show();
                return;
            }

            int ano = Integer.parseInt(anoTexto);
            Midia midia;

            switch (tipoSelecionado) {
                case MUSICA:
                    String artista = inputArtista.getText().toString().trim();
                    String album = inputAlbum.getText().toString().trim();

                    if (artista.isEmpty() || album.isEmpty()) {
                        Toast.makeText(this, "Preencha os campos da música.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    midia = new Musica(titulo, ano, artista, album);
                    break;

                case VIDEO:
                    String diretor = inputDiretor.getText().toString().trim();
                    String duracaoTexto = inputDuracao.getText().toString().trim();

                    if (diretor.isEmpty() || duracaoTexto.isEmpty()) {
                        Toast.makeText(this, "Preencha os campos do vídeo.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    int duracao = Integer.parseInt(duracaoTexto);
                    midia = new Video(titulo, ano, diretor, duracao);
                    break;

                case PODCAST:
                    String anfitriao = inputAnfitriao.getText().toString().trim();
                    String episodioTexto = inputEpisodio.getText().toString().trim();

                    if (anfitriao.isEmpty() || episodioTexto.isEmpty()) {
                        Toast.makeText(this, "Preencha os campos do podcast.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    int episodio = Integer.parseInt(episodioTexto);
                    midia = new Podcast(titulo, ano, anfitriao, episodio);
                    break;

                default:
                    Toast.makeText(this, "Selecione um tipo de mídia.", Toast.LENGTH_SHORT).show();
                    return;
            }

            lblResultado.setText(
                    midia.exibirDetalhes()
            );

            listaMidias.add(midia);
            limparCampos();

            Toast.makeText(this, "Mídia cadastrada com sucesso.", Toast.LENGTH_SHORT).show();

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Ano, duração e episódio devem ser numéricos.", Toast.LENGTH_SHORT).show();
        }
    }

    private void limparCampos() {
        inputTitulo.setText("");
        inputAno.setText("");

        inputArtista.setText("");
        inputAlbum.setText("");

        inputDiretor.setText("");
        inputDuracao.setText("");

        inputAnfitriao.setText("");
        inputEpisodio.setText("");
    }
}