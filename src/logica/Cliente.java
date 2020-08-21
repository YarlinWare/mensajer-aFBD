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
public class Cliente {
    int k_num_documento;
    String k_tipo_documento;
    String n_primer_nombre;
    String n_segundo_nombre;
    String n_primer_apellido;
    String n_segundo_apellido;
    String o_genero;
    String f_nacimiento;
    String n_correo;

    public Cliente(int k_num_documento, String k_tipo_documento, String n_primer_nombre, String n_segundo_nombre, String n_primer_apellido, String n_segundo_apellido, String o_genero, String f_nacimiento, String n_correo) {
        this.k_num_documento = k_num_documento;
        this.k_tipo_documento = k_tipo_documento;
        this.n_primer_nombre = n_primer_nombre;
        this.n_segundo_nombre = n_segundo_nombre;
        this.n_primer_apellido = n_primer_apellido;
        this.n_segundo_apellido = n_segundo_apellido;
        this.o_genero = o_genero;
        this.f_nacimiento = f_nacimiento;
        this.n_correo = n_correo;
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

    public String getN_correo() {
        return n_correo;
    }

    public void setN_correo(String n_correo) {
        this.n_correo = n_correo;
    }
    
    
    
}
