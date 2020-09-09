package com.example.vinos.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.vinos.Adapters.VinoAdapter;
import com.example.vinos.Modelos.Vino;
import com.example.vinos.R;

import java.util.ArrayList;


public class VinosFragment extends Fragment {

private RecyclerView lista;
private GridLayoutManager glm;
private VinoAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_vinos, container, false);
        lista = root.findViewById(R.id.lista);
        glm = new GridLayoutManager(root.getContext(),2);
        lista.setLayoutManager(glm);
        adapter = new VinoAdapter(recargar());
        lista.setAdapter(adapter);


        return root;
    }
    public ArrayList<Vino> recargar(){
        ArrayList<Vino> data = new ArrayList<>();
        data.add(new Vino("1","vino 1","imagen.jpg","10","lorem"));
        data.add(new Vino("2","vino 2","imagen.jpg","10","lorem"));
        data.add(new Vino("3","vino 3","imagen.jpg","10","lorem"));
        data.add(new Vino("4","vino 4","imagen.jpg","10","lorem"));
        data.add(new Vino("5","vino 5","imagen.jpg","10","lorem"));
        data.add(new Vino("6","vino 6","imagen.jpg","10","lorem"));
        return data;
    }
}
