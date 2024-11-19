package com.cidead.pmdm.listacomics;

import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

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

        // Crear conjunto de datos
        ArrayList<Comic> comicArrayList = new ArrayList<>(Arrays.asList(new Comic[]{
                new Comic("Calle Peligro", R.drawable.calle_peligro, Comic.TipoComic.AMERICANO),
                new Comic("Criminal", R.drawable.criminal, Comic.TipoComic.AMERICANO),
                new Comic("Cyberpunk 2077", R.drawable.cyberpunk_2077, Comic.TipoComic.AMERICANO),
                new Comic("Dragon Ball", R.drawable.dragon_ball, Comic.TipoComic.MANGA),
                new Comic("Hora de Aventuras", R.drawable.hora_de_aventuras, Comic.TipoComic.INFANTIL),
                new Comic("Maldito Karma", R.drawable.maldito_karma, Comic.TipoComic.EUROPEO),
                new Comic("Berserk", R.drawable.berserk, Comic.TipoComic.MANGA),
                new Comic("Bleach", R.drawable.bleach, Comic.TipoComic.MANGA),
                new Comic("Frieren", R.drawable.frieren, Comic.TipoComic.MANGA)
        }));

        // Crear el adaptador
        ComicAdapter comicAdapter = new ComicAdapter(comicArrayList);

        // Instanciar el RecyclerView
        RecyclerView rvComics = findViewById(R.id.rv_comics);

        // Crear el auto-scroll en horizontal
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvComics.setLayoutManager(linearLayoutManager);

        // Opcionalmente podríamos modificar el tipo de LayoutManager
        //rvComics.setLayoutManager(new LinearLayoutManager(this));




        // Asignar el adaptador al RecyclerView
        rvComics.setAdapter(comicAdapter);


        // código del auto-scroll
        final int speedScroll = 1000;
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            int count = 0;
            @Override
            public void run() {
                if(count == comicAdapter.getItemCount())
                    count =0;

                if(count < comicAdapter.getItemCount()){
                    rvComics.smoothScrollToPosition(++count);
                    handler.postDelayed(this,speedScroll);
                }
            }
        };
        handler.postDelayed(runnable,speedScroll);


    }



}