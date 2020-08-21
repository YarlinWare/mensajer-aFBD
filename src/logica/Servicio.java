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
public class Servicio {
    int k_id_servicio;
    int k_id_tipo_paquete;
    int k_num_documento_usuario;
    String k_tipo_documento_usuario;
    String k_num_documento_mensajero;
    String k_tipo_documento_mensajero;
    String f_fecha;
    String f_hora;
    String v_valor_servicio;

    public Servicio(int k_id_servicio, int k_id_tipo_paquete, int k_num_documento_usuario, String k_tipo_documento_usuario, String k_num_documento_mensajero, String k_tipo_documento_mensajero, String f_fecha, String f_hora, String v_valor_servicio) {
        this.k_id_servicio = k_id_servicio;
        this.k_id_tipo_paquete = k_id_tipo_paquete;
        this.k_num_documento_usuario = k_num_documento_usuario;
        this.k_tipo_documento_usuario = k_tipo_documento_usuario;
        this.k_num_documento_mensajero = k_num_documento_mensajero;
        this.k_tipo_documento_mensajero = k_tipo_documento_mensajero;
        this.f_fecha = f_fecha;
        this.f_hora = f_hora;
        this.v_valor_servicio = v_valor_servicio;
    }
    

    public int getK_id_servicio() {
        return k_id_servicio;
    }

    public void setK_id_servicio(int k_id_servicio) {
        this.k_id_servicio = k_id_servicio;
    }

    public int getK_id_tipo_paquete() {
        return k_id_tipo_paquete;
    }

    public void setK_id_tipo_paquete(int k_id_tipo_paquete) {
        this.k_id_tipo_paquete = k_id_tipo_paquete;
    }

    public int getK_num_documento_usuario() {
        return k_num_documento_usuario;
    }

    public void setK_num_documento_usuario(int k_num_documento_usuario) {
        this.k_num_documento_usuario = k_num_documento_usuario;
    }

    public String getK_tipo_documento_usuario() {
        return k_tipo_documento_usuario;
    }

    public void setK_tipo_documento_usuario(String k_tipo_documento_usuario) {
        this.k_tipo_documento_usuario = k_tipo_documento_usuario;
    }

    public String getK_num_documento_mensajero() {
        return k_num_documento_mensajero;
    }

    public void setK_num_documento_mensajero(String k_num_documento_mensajero) {
        this.k_num_documento_mensajero = k_num_documento_mensajero;
    }

    public String getK_tipo_documento_mensajero() {
        return k_tipo_documento_mensajero;
    }

    public void setK_tipo_documento_mensajero(String k_tipo_documento_mensajero) {
        this.k_tipo_documento_mensajero = k_tipo_documento_mensajero;
    }

    public String getF_fecha() {
        return f_fecha;
    }

    public void setF_fecha(String f_fecha) {
        this.f_fecha = f_fecha;
    }

    public String getF_hora() {
        return f_hora;
    }

    public void setF_hora(String f_hora) {
        this.f_hora = f_hora;
    }

    public String getV_valor_servicio() {
        return v_valor_servicio;
    }

    public void setV_valor_servicio(String v_valor_servicio) {
        this.v_valor_servicio = v_valor_servicio;
    }
    
    
}
