package com.cidead.pmdm.listacomics;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements ComicAdapter.OnItemClickListener {
    // Hay que almacenarlo como propiedad de la clase si queremos gestionar sus eventos
    public ArrayList<Comic> comicArrayList;

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
        comicArrayList = new ArrayList<>(Arrays.asList(new Comic("Calle Peligro", R.drawable.calle_peligro, Comic.TipoComic.AMERICANO),
                new Comic("Criminal", R.drawable.criminal, Comic.TipoComic.AMERICANO),
                new Comic("Cyberpunk 2077", R.drawable.cyberpunk_2077, Comic.TipoComic.AMERICANO),
                new Comic("Dragon Ball", R.drawable.dragon_ball, Comic.TipoComic.MANGA),
                new Comic("Hora de Aventuras", R.drawable.hora_de_aventuras, Comic.TipoComic.INFANTIL),
                new Comic("Maldito Karma", R.drawable.maldito_karma, Comic.TipoComic.EUROPEO),
                new Comic("Berserk", R.drawable.berserk, Comic.TipoComic.MANGA),
                new Comic("Bleach", R.drawable.bleach, Comic.TipoComic.MANGA),
                new Comic("Frieren", R.drawable.frieren, Comic.TipoComic.MANGA)));

        // Crear el adaptador
        // Establecemos el capturador de eventos de pulsaciones de elementos,
        // en este caso somos nosotros mismos. Es el método onClick
        ComicAdapter comicAdapter = new ComicAdapter(comicArrayList,this);

        // Instanciar el RecyclerView
        RecyclerView rvComics = findViewById(R.id.rv_comics);

        // Opcionalmente podríamos modificar el tipo de LayoutManager
        //rvComics.setLayoutManager(new LinearLayoutManager(this));

        // Usando el GridLayoutManager
        rvComics.setLayoutManager(new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false));

        // Usando el StaggeredLayoutManager
        //rvComics.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

        // Asignar el adaptador al RecyclerView
        rvComics.setAdapter(comicAdapter);

    }

    @Override
    public void onItemClick(View view, int position) {
        // Lanza un Toast con los datos del Comic pulsado
        Comic comic = comicArrayList.get(position);
        Toast.makeText(this, "PROPAGANDO EVENTO CLICK \n"+ comic.toString(), Toast.LENGTH_SHORT).show();

    }
}