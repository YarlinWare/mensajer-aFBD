/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author ASUS
 */
public class Telefono {
    int k_telefono;
    int k_num_documento;
    String k_tipo_documento;

    public Telefono() {
    }
    
    
    public Telefono(int k_telefono, int k_num_documento, String k_tipo_documento) {
        this.k_telefono = k_telefono;
        this.k_num_documento = k_num_documento;
        this.k_tipo_documento = k_tipo_documento;
    }

    public int getK_telefono() {
        return k_telefono;
    }

    public void setK_telefono(int k_telefono) {
        this.k_telefono = k_telefono;
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

   

    
}
