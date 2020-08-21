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
public class Horario {
    String k_id_horario;
    String n_dia;
    String o_hora_inicio;

    public Horario(String k_id_horario, String n_dia, String o_hora_inicio, String o_hora_final, int k_num_documento, String k_tipo_documento) {
        this.k_id_horario = k_id_horario;
        this.n_dia = n_dia;
        this.o_hora_inicio = o_hora_inicio;
        this.o_hora_final = o_hora_final;
        this.k_num_documento = k_num_documento;
        this.k_tipo_documento = k_tipo_documento;
    }
    
    

    public String getK_id_horario() {
        return k_id_horario;
    }

    public void setK_id_horario(String k_id_horario) {
        this.k_id_horario = k_id_horario;
    }

    public String getN_dia() {
        return n_dia;
    }

    public void setN_dia(String n_dia) {
        this.n_dia = n_dia;
    }

    public String getO_hora_inicio() {
        return o_hora_inicio;
    }

    public void setO_hora_inicio(String o_hora_inicio) {
        this.o_hora_inicio = o_hora_inicio;
    }

    public String getO_hora_final() {
        return o_hora_final;
    }

    public void setO_hora_final(String o_hora_final) {
        this.o_hora_final = o_hora_final;
    }

    public int getK_num_documento() {
        return k_num_documento;
    }

    public void setK_num_documento(int k_num_documento) {
        this.k_num_documento = k_num_documento;
    }

    public String getK_tipo_documento() {
        return k_tipo_documento;
    }

    public void setK_tipo_documento(String k_tipo_documento) {
        this.k_tipo_documento = k_tipo_documento;
    }
    String o_hora_final;
    int k_num_documento;
    String k_tipo_documento;

}
