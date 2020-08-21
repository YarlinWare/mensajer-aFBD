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
public class Estado {
    int k_id_servicio;
    int k_id_estado ;
    String o_estado_actual;

    public Estado(int k_id_servicio, int k_id_estado, String o_estado_actual) {
        this.k_id_servicio = k_id_servicio;
        this.k_id_estado = k_id_estado;
        this.o_estado_actual = o_estado_actual;
    }
    


    public int getK_id_servicio() {
        return k_id_servicio;
    }

    public void setK_id_servicio(int k_id_servicio) {
        this.k_id_servicio = k_id_servicio;
    }

    public int getK_id_estado() {
        return k_id_estado;
    }

    public void setK_id_estado(int k_id_estado) {
        this.k_id_estado = k_id_estado;
    }

    public String getO_estado_actual() {
        return o_estado_actual;
    }

    public void setO_estado_actual(String o_estado_actual) {
        this.o_estado_actual = o_estado_actual;
    }
    
}
