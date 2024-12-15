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

    // PRIMERA MANERA TENER LOS DATOS DEL ARRAYLIST
    // Constructor de fragmento en el que se pasa el conjunto de datos
    public FragmentoLista(ArrayList<Comic> comicArrayList) {
        this.comicArrayList = comicArrayList;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento_lista, container, false);
        RecyclerView rvComics = view.findViewById(R.id.rv_comics);

        // Crear el adaptador
        ComicAdapter comicAdapter = new ComicAdapter(this.comicArrayList);
        // Asignar el adaptador al RecyclerView
        rvComics.setAdapter(comicAdapter);
        // Opcionalmente podríamos modificar el tipo de LayoutManager
        rvComics.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}