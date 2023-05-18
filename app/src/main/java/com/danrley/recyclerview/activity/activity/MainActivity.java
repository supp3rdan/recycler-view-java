package com.danrley.recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.danrley.recyclerview.R;
import com.danrley.recyclerview.activity.RecyclerItemClickListener;
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

        //Eventos de clique
        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Filme filme = listaFilmes.get( position );
                            Toast.makeText(getApplicationContext(), "Item pressionado " + filme.getTituloFilme(),
                                    Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Filme filme = listaFilmes.get( position );
                            Toast.makeText(getApplicationContext(), "Clique longo " + filme.getTituloFilme(),
                                    Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    }
            )
        );
    }
    public void criarFilmes(){

        Filme filme = new Filme("Mulher maravilha", "fantasia", "2018");
        listaFilmes.add(filme);
        filme = new Filme("Liga da justiça", "ficção", "2017");
        listaFilmes.add(filme);
        filme = new Filme("Capitão américa - Guerra Cívil", "Aventura", "2016");
        listaFilmes.add(filme);
        filme = new Filme("It - A Coisa", "Terror / Drama", "2016");
        listaFilmes.add(filme);
        filme = new Filme("It - A Coisa", "Terror / Drama", "2016");
        listaFilmes.add(filme);
        filme = new Filme("Pica-pau: O filme", "Comédia / Animação", "2017");
        listaFilmes.add(filme);
        filme = new Filme("A bela e a fera", "Romance", "2017");
        listaFilmes.add(filme);
        filme = new Filme("Meu malvado favorito", "Comédia", "2017");
        listaFilmes.add(filme);
    }
}