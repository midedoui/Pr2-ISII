/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACAMA;

import java.util.ArrayList;

/**
 * Fichero de la clase Miembro de la aplicación
 *
 * @author  Miguel de Domingo
 * @author  Antonio Olmos
 * 
 * @version  1.0
 * 
 * @date  11/10/2017
 */
public class Miembro {
    private String nombre;
    private ArrayList<Moto> motos;
    private int idSocio, totalPrecio, totalCesiones;
    private static int IDSIG = 1;
    
    /* Miembro() ***************************************************************
    *
    * Constructor por defecto de la clase
    *
    ***************************************************************************/
    public Miembro(){
        idSocio = 0;
    }
    
    /* Miembro(String) *********************************************************
    *
    * Constructor con parámetros de la clase
    *
    * param  [in]  no  Nombre del miembro
    *
    ***************************************************************************/
    public Miembro(String no){
        nombre = no;
        motos = new ArrayList<Moto>();
        totalPrecio();
        idSocio = IDSIG;
        IDSIG++;
        totalCesiones = 0;
    }

    /* String getNombre() ******************************************************
    *
    * Getter de nombre
    *
    * param  [out]  nombre  Nombre del miembro
    *
    ***************************************************************************/
    public String getNombre() {
        return nombre;
    }
    
    /* void deleteMoto(Moto) ***************************************************
    *
    * Funcion que añade un precio determinado a totalPrecio
    *
    * param  [in]  m  Moto a eliminar
    *
    ***************************************************************************/
    public void deleteMoto(Moto m)
    {
        for(int i=0; i < motos.size(); i++)
        {
            if(motos.get(i).getId()==m.getId())
                motos.remove(i);
        }
        this.totalPrecio();
    }

    /* void setNombre(String) ***************************************************
    *
    * Setter de nombre
    *
    * param  [in]  nombre  Nombre del miembro
    *
    ***************************************************************************/
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /* int getId() *************************************************************
    *
    * Getter del identificador
    *
    * param  [out]  idSocio  Identificador del miembro
    *
    ***************************************************************************/
    public int getId(){
        return idSocio;
    }
    
    /* void addMoto(Moto) ******************************************************
    *
    * Funcion que añade una moto al miembro
    *
    * param  [in]  m  Moto a añadir
    *
    ***************************************************************************/
    public void addMoto(Moto m){
        motos.add(m);
        totalPrecio();
        totalCesiones++;
    }
    
    public int getTotalCesiones(){
        return totalCesiones;
    }
    
    /* void totalPrecio() ******************************************************
    *
    * Funcion que calcula el precio total de todas las posesiones del miembro
    *
    ***************************************************************************/
    public void totalPrecio(){
        totalPrecio = 0;
        for(int i = 0; i < motos.size(); i++){
            totalPrecio += motos.get(i).getPrecio();
        }
    }
    
    /* void addPrecio(int) *****************************************************
    *
    * Funcion que añade un precio determinado a totalPrecio
    *
    * param  [in]  precio  Precio a sumar a totalPrecio
    *
    ***************************************************************************/
    public void addPrecio(int precio){
        totalPrecio += precio;
    }
    
    /* int getTotalPrecio() ****************************************************
    *
    * Getter de totalPrecio
    *
    * param  [out]  totalPrecio  Suma del precio de todas las motos que posee
    *                            el miembro
    *
    ***************************************************************************/
    public int getTotalPrecio(){
        return totalPrecio;
    }
    
    /* boolean anyMoto() *******************************************************
    *
    * Funcion que comprueba si el miembro posee motos
    *
    * param  [out]  Devuelve true si el usuario posee alguna moto y false si no
    *               es así
    *
    ***************************************************************************/
    public boolean anyMoto(){
        return (motos.size() != 0);
    }
    
    /* ArrayList<Mot> getMotos() ***********************************************
    *
    * Getter de las motos
    *
    * param  [out]  motos  Motos que posee el miembro
    *
    ***************************************************************************/
    public ArrayList<Moto> getMotos()
    {
        return motos;
    }
    
    @Override
    /* String toString() *******************************************************
    *
    * Devuelve un String con las características del miembro y sus motos
    *
    * param  [out]  características del miembro
    *
    ***************************************************************************/
    public String toString(){
        String cadena = String.format("%03d", idSocio);
        String miembro, stringMotos = "";
        
        miembro = "Identificador: " + cadena + "\tNombre: " + nombre + "\r\n";
        for(int i = 0; i < this.motos.size(); i++){
            stringMotos += this.motos.get(i).toString();
        }
        return miembro + stringMotos + "Precio total: " + totalPrecio + "€\r\n";
    }
    
}
