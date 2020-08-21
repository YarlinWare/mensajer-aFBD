/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author kjan
 */
public class Trayecto {
    int k_id_trayecto;
    String d_dir_origen;
    String d_dir_destino;
    int K_id_servicio;
    int k_id_tipo_servicio;

    public Trayecto(int k_id_trayecto, String d_dir_origen, String d_dir_destino, int K_id_servicio, int k_id_tipo_servicio) {
        this.k_id_trayecto = k_id_trayecto;
        this.d_dir_origen = d_dir_origen;
        this.d_dir_destino = d_dir_destino;
        this.K_id_servicio = K_id_servicio;
        this.k_id_tipo_servicio = k_id_tipo_servicio;
    }
    


    public int getK_id_trayecto() {
        return k_id_trayecto;
    }

    public void setK_id_trayecto(int k_id_trayecto) {
        this.k_id_trayecto = k_id_trayecto;
    }

    public String getD_dir_origen() {
        return d_dir_origen;
    }

    public void setD_dir_origen(String d_dir_origen) {
        this.d_dir_origen = d_dir_origen;
    }

    public String getD_dir_destino() {
        return d_dir_destino;
    }

    public void setD_dir_destino(String d_dir_destino) {
        this.d_dir_destino = d_dir_destino;
    }

    public int getK_id_servicio() {
        return K_id_servicio;
    }

    public void setK_id_servicio(int K_id_servicio) {
        this.K_id_servicio = K_id_servicio;
    }

    public int getK_id_tipo_servicio() {
        return k_id_tipo_servicio;
    }

    public void setK_id_tipo_servicio(int k_id_tipo_servicio) {
        this.k_id_tipo_servicio = k_id_tipo_servicio;
    }
    
}
