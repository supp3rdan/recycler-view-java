package com.danrley.recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.danrley.recyclerview.R;
import com.danrley.recyclerview.activity.adapter.Adapter;
import com.danrley.recyclerview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        // Listagem de itens
        this.criarFilmes();

        //Configuração do adapter
        Adapter adapter = new Adapter(listaFilmes);
        // Configuração Recycler view
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager((getApplicationContext()));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        // Chamaando recycler view
        recyclerView.setAdapter( adapter );
    }
    public void criarFilmes(){

        Filme filme2 = new Filme("Mulher maravilha", "fantasia", "2018");
        listaFilmes.add(filme2);
        Filme filme3 = new Filme("Liga da justiça", "ficção", "2017");
        listaFilmes.add(filme3);
        Filme filme4 = new Filme("Capitão américa - Guerra Cívil", "Aventura", "2016");
        listaFilmes.add(filme4);
        Filme filme5 = new Filme("It - A Coisa", "Terror / Drama", "2016");
        listaFilmes.add(filme5);
        Filme filme6 = new Filme("It - A Coisa", "Terror / Drama", "2016");
        listaFilmes.add(filme6);
        Filme filme7 = new Filme("Pica-pau: O filme", "Comédia / Animação", "2017");
        listaFilmes.add(filme7);
        Filme filme8 = new Filme("A bela e a fera", "Romance", "2017");
        listaFilmes.add(filme8);
        Filme filme9 = new Filme("Meu malvado favorito", "Comédia", "2017");
        listaFilmes.add(filme9);
    }
}