/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACAMA;

import java.util.Date;

/**
 * Fichero de la clase Cesion de la aplicación
 *
 * @author  Miguel de Domingo
 * @author  Antonio Olmos
 * 
 * @version  1.0
 * 
 * @date  11/10/2017
 */
public class Cesion {
    private Moto cedida;
    private Date fechaCesion;
    private Miembro origen, destino;
    private int idCesion;
    private static int IDSIG = 1;
    
    /* Cesion(Moto, Miembro, Miembro) ******************************************
    *
    * Constructor con parámetros de la clase
    *
    * param  [in]  ce  Moto a ceder
    * param  [in]  or  Miembro que cede la moto
    * param  [in]  de  Miembro que recibe la moto
    *
    ***************************************************************************/
    public Cesion(Moto ce, Miembro or, Miembro de){
        cedida = ce;
        fechaCesion = new Date();
        origen = or;
        destino = de;
        idCesion = IDSIG;
        
        IDSIG++;
    }
    
    /* Moto getCedida() ********************************************************
    *
    * Getter de cedida
    *
    * param  [out]  cedida  Moto cedida
    *
    ***************************************************************************/
    public Moto getCedida() {
        return cedida;
    }

    /* Date getFechaCesion() ***************************************************
    *
    * Getter de fechaCesion
    *
    * param  [out]  fechaCesion  Fecha de la cesion
    *
    ***************************************************************************/
    public Date getFechaCesion() {
        return fechaCesion;
    }

    /* Miembro getOrigen() *****************************************************
    *
    * Getter de origen
    *
    * param  [out]  origen  Miembro que cede la moto
    *
    ***************************************************************************/
    public Miembro getOrigen() {
        return origen;
    }

    /* Miembro getDestino() ****************************************************
    *
    * Getter de destino
    *
    * param  [out]  destino  Miembro que recibe la moto
    *
    ***************************************************************************/
    public Miembro getDestino() {
        return destino;
    }

    /* int getIdCesion() *******************************************************
    *
    * Getter de idCesion
    *
    * param  [out]  idCesion  Identificador de la cesion
    *
    ***************************************************************************/
    public int getIdCesion() {
        return idCesion;
    }
    
    @Override
    /* String toString() *******************************************************
    *
    * Devuelve un String con las características de la cesion
    *
    * param  [out]  características de la cesion
    *
    ***************************************************************************/
    public String toString(){
        return "Antiguo propietario: " + origen.getNombre() + "\r\n -Moto cedida-\r\n" + cedida.toString() +  "      --      "
                + "\r\n" +"Nuevo propietario: " + destino.getNombre() + "\r\nFecha cesion: " + fechaCesion + "\r\n";
    }
}
