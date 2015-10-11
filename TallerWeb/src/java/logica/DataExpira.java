/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.util.Date;

/**
 *
 * @author matias.heredia
 */
public class DataExpira {
    private Date fechaCom;
    private Date fechaFin;
    
    public DataExpira (Date d1 ,Date d2){
        fechaCom=d1;
        fechaFin=d2;
    }
    
    public Date getFechai(){
        return fechaCom;
    }
    public Date getFechaf(){
        return fechaFin;
    }
    
}
