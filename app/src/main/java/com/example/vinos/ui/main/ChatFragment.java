package com.example.vinos.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.StrictMode;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vinos.Adapters.MensajeAdapter;
import com.example.vinos.Conexiones.Server;
import com.example.vinos.Modelos.Mensaje;
import com.example.vinos.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.Random;

public class ChatFragment extends Fragment {
   /*private RecyclerView listaChat;
   private MensajeAdapter adapter;
   private SwipeRefreshLayout swipe;
   private GridLayoutManager gridLayoutManager;
   TextView txtChat;
   int numero = 10;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);



        // Inflate the activity_login for this fragment
        View root = inflater.inflate(R.layout.fragment_chat, container, false);
        listaChat = root.findViewById(R.id.lista_chat);
        swipe= root.findViewById(R.id.swipe);
        txtChat = root.findViewById(R.id.txtChat);
        adapter = new MensajeAdapter(dataSet());
        gridLayoutManager = new GridLayoutManager(root.getContext(),1);
        listaChat.setLayoutManager(gridLayoutManager);
        listaChat.setAdapter(adapter);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter = new MensajeAdapter(dataSet());
                listaChat.setAdapter(adapter);
                swipe.setRefreshing(false);
            }
        });
        txtChat.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if((event.getAction() == KeyEvent.ACTION_DOWN)&&(event.getKeyCode() == KeyEvent.KEYCODE_ENTER)){
                    Server server = new Server("insertar.php?nickname=CesarGaytan&mensaje="+txtChat.getText());
                    String respuesta = server.doInBackground("");
                    if (!respuesta.equals("")){
                        Log.e("Respuesta al insertar", respuesta);
                        adapter = new MensajeAdapter(dataSet());
                        listaChat.setAdapter(adapter);
                        txtChat.setText("");
                        listaChat.scrollToPosition(adapter.getItemCount()-1);
                    }
                }
                return true;
            }
        });
        return  root;

    }
    private ArrayList<Mensaje> dataSet(){
        ArrayList<Mensaje> data = new ArrayList<>();
       Server server = new Server("mensajes.php");
       String respuesta = server.doInBackground("");
       if(!respuesta.equals("Error")){
           try {
               JSONObject json = (JSONObject)new JSONTokener(respuesta).nextValue();

               JSONArray mensajes = json.getJSONArray("Mensajes");
               for (int x=0; x<mensajes.length();x++){
                   JSONObject d = mensajes.getJSONObject(x);
                   data.add(new Mensaje(d.getString("Nickname").toLowerCase().toString(),
                                        d.getString("Mensaje").toLowerCase().toString(),
                                        d.getString("Created_at").toLowerCase().toString()));
               }
           } catch (JSONException e) {
               e.printStackTrace();
           }

       }
       swipe.setRefreshing(false);
       return data;
    }*/
}
