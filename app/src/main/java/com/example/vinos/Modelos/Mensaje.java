package com.example.vinos.Modelos;

public class Mensaje  {
    String nickname;

    public Mensaje(String nickname, String mensaje, String fecha) {
        this.nickname = nickname;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    String mensaje;
    String fecha;
}
