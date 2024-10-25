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
    // interfaz para que otra actividad pueda capturar el evento de click
    public interface OnItemClickListener{
        public void onClick(View view, int position);
    }

    // Datos
    private ArrayList<Comic> coleccion;
    // Capturador de eventos de click
    private OnItemClickListener itemClickListener;

    // Constructor que recibe los datos y el listener
    public ComicAdapter(ArrayList<Comic> coleccion, OnItemClickListener itemClickListener) {
        this.coleccion = coleccion;
        this.itemClickListener = itemClickListener;
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

    public class ComicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView tv_titulo;
        TextView tv_tipo;

        public ComicViewHolder(@NonNull View itemView) {
            super(itemView);
            // Para propagar el evento de click a nuestra actividad
            itemView.setOnClickListener(this);

            // Referencias a los elementos de la vista
            imageView = itemView.findViewById(R.id.imageView);
            tv_titulo = itemView.findViewById(R.id.tv_titulo);
            tv_tipo = itemView.findViewById(R.id.tv_tipo);


        }

        /**
         * Called when a view has been clicked.
         * @param v The view that was clicked.
         *          Propaga el evento hacía fuera, así podemos capturarlo en el punto
         *          que queramos de nuestra aplicación
         */
        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition());

        }
    }

    //Este metodo se utiliza desde la actividad que captura el evento de clic de los items
    public void setOnClickListener(OnItemClickListener clickListener){
        this.itemClickListener = clickListener;
    }
}
