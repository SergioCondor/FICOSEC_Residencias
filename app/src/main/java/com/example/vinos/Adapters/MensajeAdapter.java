package com.example.vinos.Adapters;

import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinos.Modelos.Mensaje;
import com.example.vinos.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TimeZone;

public class MensajeAdapter extends RecyclerView.Adapter<MensajeAdapter.MensajeViewHolder> {
private ArrayList<Mensaje> data;
public MensajeAdapter(ArrayList<Mensaje> data){
this.data=data;
}
    @NonNull
    @Override
    public MensajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MensajeAdapter.MensajeViewHolder(LayoutInflater.from(
                parent.getContext()).inflate(R.layout.item_chat,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MensajeViewHolder holder, int position) {
    Mensaje mensaje = data.get(position);
        holder.txtNickname.setText(mensaje.getNickname());
        holder.txtMensaje.setText(mensaje.getMensaje());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            long time = simpleDateFormat.parse(mensaje.getFecha()).getTime();
            long now = System.currentTimeMillis();
            CharSequence ago = DateUtils.getRelativeTimeSpanString(time, now, DateUtils.MINUTE_IN_MILLIS);
            holder.txtFecha.setText(ago.toString() );
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MensajeViewHolder extends RecyclerView.ViewHolder {
        TextView txtNickname;
        TextView txtFecha;
        TextView txtMensaje;
        public MensajeViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNickname=itemView.findViewById(R.id.chat_nickname);
            txtMensaje=itemView.findViewById(R.id.chat_mensaje);
            txtFecha=itemView.findViewById(R.id.chat_fecha);
        }
    }
}
/*
* package com.example.vinos.Adapters;

import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinos.Modelos.Mensaje;
import com.example.vinos.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TimeZone;

public class MensajeAdapter extends RecyclerView.Adapter<MensajeAdapter.MensajeViewHolder>{
    private ArrayList<Mensaje> data;
    public MensajeAdapter(ArrayList<Mensaje> data){
        this.data = data;
    }

    @NonNull
    @Override
    public MensajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MensajeAdapter.MensajeViewHolder(LayoutInflater.from(
                                                parent.getContext()).inflate(R.activity_login.item_chat,parent , false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MensajeViewHolder holder, int position) {
       Mensaje mensaje = data.get(position);
       holder.txtNickName.setText(mensaje.getNickname());
       holder.txtMensaje.setText(mensaje.getMensaje());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            long time = simpleDateFormat.parse(mensaje.getFecha()).getTime();
            long now=System.currentTimeMillis();
            CharSequence ago = DateUtils.getRelativeTimeSpanString(time,now,DateUtils.MINUTE_IN_MILLIS);
            holder.txtFecha.setText(ago.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {

        return data.size();
    }

    class MensajeViewHolder extends RecyclerView.ViewHolder{

        TextView txtNickName;
        TextView txtMensaje;
        TextView txtFecha;


        public MensajeViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNickName = itemView.findViewById(R.id.chatNickname);
            txtMensaje = itemView.findViewById(R.id.chatMensaje);
            txtFecha = itemView.findViewById(R.id.chatFecha);



        }
    }



}

*
* */