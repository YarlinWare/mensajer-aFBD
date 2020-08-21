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
public class Mensajero {
    int k_num_documento;
    String k_tipo_documento;
    String n_primer_nombre;
    String n_segundo_nombre;

    public Mensajero(int k_num_documento, String k_tipo_documento, String n_primer_nombre, String n_segundo_nombre, String n_primer_apellido, String n_segundo_apellido, String q_tefefono, String o_genero, String f_nacimiento, String d_dir, int q_num_seguridad_social, String o_medio_transporte) {
        this.k_num_documento = k_num_documento;
        this.k_tipo_documento = k_tipo_documento;
        this.n_primer_nombre = n_primer_nombre;
        this.n_segundo_nombre = n_segundo_nombre;
        this.n_primer_apellido = n_primer_apellido;
        this.n_segundo_apellido = n_segundo_apellido;
        this.q_tefefono = q_tefefono;
        this.o_genero = o_genero;
        this.f_nacimiento = f_nacimiento;
        this.d_dir = d_dir;
        this.q_num_seguridad_social = q_num_seguridad_social;
        this.o_medio_transporte = o_medio_transporte;
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

    public String getN_primer_nombre() {
        return n_primer_nombre;
    }

    public void setN_primer_nombre(String n_primer_nombre) {
        this.n_primer_nombre = n_primer_nombre;
    }

    public String getN_segundo_nombre() {
        return n_segundo_nombre;
    }

    public void setN_segundo_nombre(String n_segundo_nombre) {
        this.n_segundo_nombre = n_segundo_nombre;
    }

    public String getN_primer_apellido() {
        return n_primer_apellido;
    }

    public void setN_primer_apellido(String n_primer_apellido) {
        this.n_primer_apellido = n_primer_apellido;
    }

    public String getN_segundo_apellido() {
        return n_segundo_apellido;
    }

    public void setN_segundo_apellido(String n_segundo_apellido) {
        this.n_segundo_apellido = n_segundo_apellido;
    }

    public String getQ_tefefono() {
        return q_tefefono;
    }

    public void setQ_tefefono(String q_tefefono) {
        this.q_tefefono = q_tefefono;
    }

    public String getO_genero() {
        return o_genero;
    }

    public void setO_genero(String o_genero) {
        this.o_genero = o_genero;
    }

    public String getF_nacimiento() {
        return f_nacimiento;
    }

    public void setF_nacimiento(String f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }

    public String getD_dir() {
        return d_dir;
    }

    public void setD_dir(String d_dir) {
        this.d_dir = d_dir;
    }

    public int getQ_num_seguridad_social() {
        return q_num_seguridad_social;
    }

    public void setQ_num_seguridad_social(int q_num_seguridad_social) {
        this.q_num_seguridad_social = q_num_seguridad_social;
    }

    public String getO_medio_transporte() {
        return o_medio_transporte;
    }

    public void setO_medio_transporte(String o_medio_transporte) {
        this.o_medio_transporte = o_medio_transporte;
    }
    String n_primer_apellido;
    String n_segundo_apellido;
    String q_tefefono;
    String o_genero;
    String f_nacimiento;
    String d_dir;
    int q_num_seguridad_social;
    String o_medio_transporte;
    
}
