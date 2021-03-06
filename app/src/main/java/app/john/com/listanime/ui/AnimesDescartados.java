package app.john.com.listanime.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.john.com.listanime.R;
import app.john.com.listanime.adapters.AnimeRVAdapter;
import app.john.com.listanime.intermediario.Controle;
import app.john.com.listanime.modelos.Anime;

public class AnimesDescartados extends AppCompatActivity {

    private RecyclerView rvAnimes;
    private Controle controle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animes_descartados);

        controle = new Controle();

        rvAnimes = findViewById(R.id.rvDescartados);

        carregarDados();
    }

    private void carregarDados() {
        List<Anime> animes = new ArrayList<>();

        for (Anime anime: controle.getUsuarioLogado().getAnimes()) {
            if (anime.getStatus().equals("Descartado")) {
                animes.add(anime);
            }
        }

        AnimeRVAdapter adapter = new AnimeRVAdapter(this, animes);

        rvAnimes.setLayoutManager(new LinearLayoutManager(this));
        rvAnimes.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarDados();
    }
}
