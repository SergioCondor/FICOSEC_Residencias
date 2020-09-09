package com.example.vinos.Conexiones;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Server extends AsyncTask<String,Void,String> {
    private  String USER_AGENT = "Mozilla/5.0";
    private  String servidor = "http://grijalvaromero.me/webservice/";
    private static String archivo;
    public Server(String archivo){
        this.archivo = archivo;
    }

    @Override
    public String doInBackground(String... strings) {
        String respuesta = "";
        try{
            URL obj = new URL(this.servidor+this.archivo);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent",USER_AGENT);
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK){
                BufferedReader in = new BufferedReader((new InputStreamReader(con.getInputStream())));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                Log.e("RESPUESTA", response.toString());
                respuesta = response.toString();
            } else {
                respuesta = "ERROR";
            }
        } catch (MalformedURLException e){
            e.printStackTrace();
            respuesta = "ERROR";
        } catch (IOException e) {
            e.printStackTrace();
            respuesta = "ERROR";
        }

        return respuesta;
    }
}