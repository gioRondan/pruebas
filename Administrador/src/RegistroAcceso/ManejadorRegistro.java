/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RegistroAcceso;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giovani.rondan
 */
public class ManejadorRegistro {
    private List<Registro> registros = new ArrayList<>();

    public ManejadorRegistro() {
    }

    public List<Registro> getRegistros() {
        return registros;
    }
    public void addRegistro(Registro registro){
        this.registros.add(registro);
    }
}
