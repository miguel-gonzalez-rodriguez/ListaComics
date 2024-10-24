package com.cidead.pmdm.listacomics;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ComicViewHolder>{
    ArrayList<Comic> coleccion;

    public ComicAdapter(ArrayList<Comic> coleccion) {
        this.coleccion = coleccion;
    }

    @NonNull
    @Override
    public ComicAdapter.ComicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ComicAdapter.ComicViewHolder comicViewHolder =
                new ComicViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.ficha,parent,false)
                );
        return comicViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ComicAdapter.ComicViewHolder holder, int position) {
        Comic comic = coleccion.get(position);
        holder.imageView.setImageResource(comic.getImagen());
        holder.tv_titulo.setText(comic.getTitulo());
        holder.tv_tipo.setText(comic.getTipo().toString());

    }

    @Override
    public int getItemCount() {
        return coleccion.size();
    }

    public class ComicViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tv_titulo;
        TextView tv_tipo;

        public ComicViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tv_titulo = itemView.findViewById(R.id.tv_titulo);
            tv_tipo = itemView.findViewById(R.id.tv_tipo);
        }
    }
}
