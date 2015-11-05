/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author matias.heredia
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataExpira {
    private Date fechaCom;
    private Date fechaFin;
    
     public DataExpira(){
        fechaCom= new Date();
        fechaFin= new Date();
    }
     
    public DataExpira(Date fecha1 ,Date fecha2){
        fechaCom=fecha1;
        fechaFin=fecha2;
    }
    
    public Date getFechai(){
        return fechaCom;
    }
    public Date getFechaf(){
        return fechaFin;
    }

    public void setFechaCom(Date fechaCom) {
        this.fechaCom = fechaCom;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
}
