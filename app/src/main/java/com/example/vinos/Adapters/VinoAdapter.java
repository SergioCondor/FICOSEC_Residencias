package com.example.vinos.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinos.Modelos.Vino;
import com.example.vinos.R;

import java.util.ArrayList;

public class VinoAdapter extends RecyclerView.Adapter<VinoAdapter.VinosViewHolder> {
    private ArrayList<Vino> data;
    public VinoAdapter(ArrayList<Vino> data){
        this.data =data;
    }


    @NonNull
    @Override
    public VinosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      return new VinosViewHolder(LayoutInflater.from(
              parent.getContext()).inflate(R.layout.item_vino,parent,false)
      );

    }

    @Override
    public void onBindViewHolder(@NonNull VinosViewHolder holder, int position) {
    Vino vino =data.get(position);
    holder.titulo.setText(vino.getNombre());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class VinosViewHolder extends RecyclerView.ViewHolder{
ImageView item_image;
TextView titulo;
TextView likes;
        public VinosViewHolder(@NonNull View itemView) {

            super(itemView);
        titulo =itemView.findViewById(R.id.item_nombre);
        }
    }
}
