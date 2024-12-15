package com.cidead.pmdm.listacomics;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentoLista extends Fragment {
    ArrayList<Comic> comicArrayList;

    public FragmentoLista() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // comprobamos si tenemos datos
        if (this.comicArrayList == null){
            // Comprobamos si los datos se han pasado en un bundel
            if (getArguments() != null) {
                // añadimos los datos del Bundle a la lista de la clase FragmentoLista
                this.comicArrayList = getArguments().getParcelableArrayList("datos");
                System.out.println("Datos en OnCreate..… " + this.comicArrayList);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento_lista, container, false);
        RecyclerView rvComics = view.findViewById(R.id.rv_comics);

        // Esta comprobación puede ser redundante dependiento de dónde se use el fragmento
        // (como en este ejemplo)
        if (this.comicArrayList == null){
            // Comprobamos si los datos se han pasado en un bundle
            if (getArguments() != null) {
                this.comicArrayList = getArguments().getParcelableArrayList("datos");
                System.out.println("Datos en OnCreateView..… " + this.comicArrayList);
            }
        }

        // Crear el adaptador
        ComicAdapter comicAdapter = new ComicAdapter(this.comicArrayList);
        // Asignar el adaptador al RecyclerView
        rvComics.setAdapter(comicAdapter);
        // Opcionalmente podríamos modificar el tipo de LayoutManager
        rvComics.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}