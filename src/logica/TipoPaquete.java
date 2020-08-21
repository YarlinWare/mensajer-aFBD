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
public class TipoPaquete {
    int k_id_tipo_paquete;
    int k_id_servicio;
    String n_tipo;
    String o_descripcion;

    public TipoPaquete(int k_id_tipo_paquete, int k_id_servicio, String n_tipo, String o_descripcion) {
        this.k_id_tipo_paquete = k_id_tipo_paquete;
        this.k_id_servicio = k_id_servicio;
        this.n_tipo = n_tipo;
        this.o_descripcion = o_descripcion;
    }
    
    

    public int getK_id_tipo_paquete() {
        return k_id_tipo_paquete;
    }

    public void setK_id_tipo_paquete(int k_id_tipo_paquete) {
        this.k_id_tipo_paquete = k_id_tipo_paquete;
    }

    public int getK_id_servicio() {
        return k_id_servicio;
    }

    public void setK_id_servicio(int k_id_servicio) {
        this.k_id_servicio = k_id_servicio;
    }

    public String getN_tipo() {
        return n_tipo;
    }

    public void setN_tipo(String n_tipo) {
        this.n_tipo = n_tipo;
    }

    public String getO_descripcion() {
        return o_descripcion;
    }

    public void setO_descripcion(String o_descripcion) {
        this.o_descripcion = o_descripcion;
    }
	
}
