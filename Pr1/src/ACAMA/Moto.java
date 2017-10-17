/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACAMA;

/**
 * Fichero de la clase Moto de la aplicación
 *
 * @author  Miguel de Domingo
 * @author  Antonio Olmos
 * 
 * @version  1.0
 * 
 * @date  11/10/2017
 */
public class Moto {
    private String marca, modelo;
    private int idMoto, cilindrada, precio, idDueño;
    private static int IDSIG = 1;
    
    /* Moto(String, String, int, int, int) *************************************
    *
    * Constructor de la clase con parámetros
    *
    * param  [in]  ma  Marca de la moto
    * param  [in]  mo  Modelo de la moto
    * param  [in]  ci  Cilindrada de la moto
    * param  [in]  pr  Precio de la moto
    * param  [in]  id  Id del dueño  
    *
    ***************************************************************************/
    public Moto(String ma, String mo, int ci, int pr, int id){
        marca = ma;
        modelo = mo;
        cilindrada = ci;
        precio = pr;
        idMoto = IDSIG;
        idDueño = id;
        IDSIG++;
    }
    
    /* String getMarca() *******************************************************
    *
    * Getter de marca
    *
    * param  [out]  marca  Marca de la moto
    *
    ***************************************************************************/
    public String getMarca() {
        return marca;
    }
    
    /* void setMarca(String) ***************************************************
    *
    * Setter de marca
    *
    * param  [in]  marca  Marca de la moto
    *
    ***************************************************************************/
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    /* String getModelo() ******************************************************
    *
    * Getter de modelo
    *
    * param  [out]  modelo  Modelo de la moto
    *
    ***************************************************************************/
    public String getModelo() {
        return modelo;
    }
    
    /* void setModelo(String) **************************************************
    *
    * Setter de modelo
    *
    * param  [in]  modelo  Modelo de la moto
    *
    ***************************************************************************/
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    /* int getCilindrada() *****************************************************
    *
    * Getter de cilindrada
    *
    * param  [out]  cilindrada  Cilindrada de la moto
    *
    ***************************************************************************/
    public int getCilindrada() {
        return cilindrada;
    }
    
    /* int getIDDueño() ********************************************************
    *
    * Getter de idDueño
    *
    * param  [out]  idDueño  Identificador del dueño de la moto
    *
    ***************************************************************************/
    public int getIDDueño()
    {
        return idDueño;
    }
    
    /* void setCilindrada(int) *************************************************
    *
    * Setter de cilindrada
    *
    * param  [in]  cilindrada  Cilindrada de la moto
    *
    ***************************************************************************/
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
    
    /* int getPrecio() *********************************************************
    *
    * Getter de precio
    *
    * param  [out]  precio  Precio de la moto
    *
    ***************************************************************************/
    public int getPrecio() {
        return precio;
    }
    
    /* void setPrecio(int) *****************************************************
    *
    * Setter de precio
    *
    * param  [in]  precio  Precio de la moto
    *
    ***************************************************************************/
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    /* int getId() *************************************************************
    *
    * Getter de idMoto
    *
    * param  [out]  idMoto  Identificador de la moto
    *
    ***************************************************************************/
    public int getId(){
        return idMoto;
    }
    
    @Override
    /* String toString() *******************************************************
    *
    * Devuelve un String con las características de la moto
    *
    * param  [out]  características de la moto
    *
    ***************************************************************************/
    public String toString(){
        return "ID " + idMoto + " " + marca + " " + modelo + "\r\nCC: " + cilindrada + "\r\nPrecio: " + precio + "€\r\n";
    }
}
