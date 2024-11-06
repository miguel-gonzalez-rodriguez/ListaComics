package com.cidead.pmdm.listacomics;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MiViewHolder> {
    @NonNull
    @Override
    public MiAdaptador.MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.MiViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MiViewHolder extends RecyclerView.ViewHolder{
        public MiViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
