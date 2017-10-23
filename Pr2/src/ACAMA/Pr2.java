/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACAMA;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Fichero de la clase main de la aplicación
 * 
 * @author  Miguel de Domingo
 * @author  Antonio Olmos
 * 
 * @version  1.0
 * 
 * @date  11/10/2017
 */
public class Pr2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numEntrada, cilindrada = 0, precio = 0, num, maximo = 6000, gastos;
        String nombre, marca, modelo;
        Cesion ce;
        ArrayList<Cesion> cesiones = new ArrayList<Cesion>();
        boolean ok = true, max = true;
        Scanner sc = new Scanner(System.in);
        ArrayList<Miembro> miembros = new ArrayList<Miembro>();
        ArrayList<Moto> motos = new ArrayList<Moto>();
        ArrayList<Moto> motosElim = new ArrayList<Moto>();
        Miembro mi, miem;
        
        do{
            try{
                System.out.println("Dame el precio maximo que puede poseer un miembro " +
                "sumando el precio de sus motos\n");
                maximo = sc.nextInt();
                if(isNegat(maximo)){
                    throw new Exception();
                }
                max = true;
            }
            catch(InputMismatchException e){
                System.out.println("Datos no validos");
                sc.next();
                max = false;
            }catch(Exception e){
                System.out.println("Numero negativo\n");
                max = false;
            }
        }while(!max);
        
        //iniciarACAMA(motos, miembros, maximo);
        while(ok){
            System.out.println("1) Registrar un nuevo miembro\n2) Registrar una " +
            "nueva motocicleta\n3) Registrar una cesion\n4) Mostrar los miembros " +
            "con motos en posesión\n5) Mostrar todas las motos\n6) Mostrar las " +
            "cesiones realizadas\n7) Incrementar otros gastos de un moto\n8) "+
            "Eliminar miembro\n9) Mostrar los miembros con mas cesiones\n10) Salir del programa\n");
            
            numEntrada = sc.nextInt();
            
            switch(numEntrada){
                case 1:
                    try{
                        System.out.println("Dame el nombre del miembro: ");
                        nombre = br.readLine();
                        if(isNumeric(nombre))
                            throw new Exception();
                        Miembro m = new Miembro(nombre);
                        miembros.add(m);
                        m.toString();
                    }
                    catch (Exception e){
                        System.out.println("Nombre no valido.");
                    }
                    finally
                    {
                    break;
                    }
                            
                case 2:
                    System.out.println("Dame la marca: ");
                    marca = br.readLine();
                    System.out.println("Dame el modelo: ");
                    modelo = br.readLine();
                    try{
                        System.out.println("Dame la cilindrada: ");
                        cilindrada = sc.nextInt();
                        System.out.println("Dame el precio: ");
                        precio = sc.nextInt();
                        System.out.println("Dame el importe de otros gastos: ");
                        gastos = sc.nextInt();
                    

                        mostrarMiembros(miembros);
                        System.out.println("Dame el id del miembro: ");
                        numEntrada = sc.nextInt();
                        mi = obtenerMiembro(numEntrada, miembros);
                        if(comprobarDisponibilidad(mi, precio, maximo)){
                            Moto moto = new Moto(marca, modelo, cilindrada, precio, mi.getId(), gastos);
                            motos.add(moto);
                            asignarMotoMiembro(mi, moto, maximo);
                        }
                    }
                    catch (InputMismatchException e){
                        System.out.println("Datos no validos");
                        sc.next();
                    }
                    finally
                    {
                    break;
                    }
                case 3:
                    try{
                        numEntrada = 0;
                        for(int i = 0; i < motos.size(); i++)
                            System.out.println((i+1)+ "- " + motos.get(i).toString());
                        System.out.println("Dame el id de la moto a ceder: ");
                        numEntrada = sc.nextInt();
                        numEntrada--;
                        mostrarMiembros(miembros);
                        System.out.println("Dame el id del miembro: ");
                        num = sc.nextInt();
                        mi = obtenerMiembro(num, miembros);
                        precio = motos.get(numEntrada).getPrecio();
                        miem = obtenerMiembroMoto(motos.get(numEntrada), miembros);
                        if(crearCesion(motos.get(numEntrada), miem, mi, maximo))
                        {
                          ce = new Cesion(motos.get(numEntrada), miem, mi);
                          cesiones.add(ce);
                        }
                    }
                    catch (InputMismatchException e){
                        System.out.println("Id no valido\n");
                        sc.next();
                    }
                    finally{
                    break;
                    }
                case 4:
                    mostrarMiembros(miembros);
                    break;
                case 5:
                    for(int i = 0; i < motos.size(); i++)
                        System.out.println(motos.get(i).toString());
                    break;
                case 6:
                    for(int i = 0; i < cesiones.size(); i++)
                        System.out.println(cesiones.get(i).toString());
                    break;
                case 7:
                    try{
                        for(int i = 0; i < motos.size(); i++){
                            System.out.println(motos.get(i).toString());
                        }
                        System.out.println("Dame el id de la moto a modificar: ");
                        numEntrada = sc.nextInt();
                        if(numEntrada > motos.size() || numEntrada < 1)
                            throw new InputMismatchException();
                        System.out.println("Dame el importe de otros gastos: ");
                        gastos = sc.nextInt();
                        if(isNegat(gastos))
                            throw new Exception();
                        motos.get(numEntrada-1).addOtrosGastos(gastos);
                    }catch(InputMismatchException e){
                        System.out.println("Datos no validos\n");
                        sc.next();
                    }catch(Exception e){
                        System.out.println("Numero negativo\n");
                    }finally{
                    break;
                    }
                case 8:
                    boolean amm = false;
                    
                    mostrarMiembros(miembros);
                    try{
                        System.out.println("Dame el id del miembro a eliminar: ");
                        numEntrada = sc.nextInt();
                        if(numEntrada > miembros.size() || numEntrada < 1)
                            throw new InputMismatchException();
                        mi = obtenerMiembro(numEntrada, miembros);
                        motosElim = mi.getMotos();
                        int tam = motosElim.size();
                        if(tam == 0)
                            miembros.remove(mi);
                        else{
                            for(int i = 0; i < tam; i++){
                                System.out.println(motos.get(i).toString());
                                mostrarMiembros(miembros);
                                while(!amm){
                                    System.out.println("Dame el id del miembro al que deseas asignar la moto: ");
                                    numEntrada = sc.nextInt();
                                    if(numEntrada > getMaxId(miembros) || numEntrada < 1)
                                        throw new InputMismatchException();
                                    miem = obtenerMiembro(numEntrada, miembros);
                                    amm = asignarMotoMiembro(miem, motos.get(i), maximo);
                                }
                            }
                            miembros.remove(mi);
                        }
                    }catch(InputMismatchException e){
                        System.out.println("Datos no validos\n");
                        sc.next();
                    }
                    break;
                case 9:
                    mostrarMiembrosCesiones(cesiones);
                    break;
                case 10:
                    escribirFichero(miembros, cesiones);
                    ok = false;
                    break;
                default:
                    System.out.println("Por favor, seleccione un numero en el rango 1-7.");
                    break;
            }
        }
    }
    
    public static void mostrarMiembrosCesiones(ArrayList<Cesion> c){
        Cesion ce;
        Miembro m, mm;
        int tot, ref = 0;
        int id1, id2;
        ArrayList<Miembro> mi = new ArrayList<Miembro>();
        
        for(int i = 0; i < c.size(); i++){
            ce = c.get(i);
            m = ce.getDestino();
            tot = m.getTotalCesiones();
            if(tot > ref){
                for(int j = 0; j < mi.size(); j++){
                    mm = mi.get(j);
                    mi.remove(mm);
                }
                ref = tot;
                mi.add(m);
            }
            else if(tot == ref){
                boolean b = false;
                for(int k = 0; k < mi.size() && !b; k++){
                    id1 = mi.get(i).getId();
                    id2 = m.getId();
                    if(id1 == id2){
                        b = true;
                    }
                }
                if(!b)
                    mi.add(m);
            }
        }
        mostrarMiembros(mi);
    }
    
    public static int getMaxId(ArrayList<Miembro> m){
        Miembro mi;
        int ref = 0, id;
        
        for(int i = 0; i < m.size(); i++){
            mi = m.get(i);
            id = mi.getId();
            if(ref < id)
                ref = id;
        }
        return ref;
    }
    
    /* boolean isNegat(int i) **************************************************
    *
    * La funcion comprueba si un numero es negativo
    *
    * param  [in]  i  Numero a comprobar
    *
    * param  [out]  n  True si es negativo y false si es positivo
    *
    ***************************************************************************/
    public static boolean isNegat(int i){
        boolean ok = false;
        
        if(i < 0){
            ok = true;
        }
        return ok;
    }
    
    /* boolean isNumeric(String s) *********************************************
    * 
    * La función permite saber si un string contiene almenos un numero
    *
    * param  [in]  s  String en el que se buscaran numeros
    *
    * param  [out]  ok  True si s contiene algun caracter numerico y false si
    *                   no lo contiene
    *
    ***************************************************************************/
    public static boolean isNumeric(String s){
        boolean ok = true;
        
        try{
            for(int i = 0; i < s.length(); i++)
            {
                if(Character.isDigit(s.charAt(i)))
                    throw new Exception();
            }
            ok = false;
        }
        catch(Exception e)
        {
            ok = true;
        }
        
        finally
        {
        return ok;
        }
    }
    
 
    /* void mostrarMiembros(ArrayList<Miembro>) ********************************
    * 
    * La función muestra todos los miembros y las motos que tienen asignadas
    * cada miembro de la asociación
    *
    * param  [in]  miembro  Lista de miembros que se han de mostrar
    *
    ***************************************************************************/
    public static void mostrarMiembros(ArrayList<Miembro> miembro){
        for(int i = 0; i < miembro.size(); i++){
            System.out.println(miembro.get(i).toString());
            System.out.println("----------------\n");
        }
    }
    
    /* boolean comprobarDisponibilidad(Miembro, int) ***************************
    * 
    * La función comprueba la disponibilidad del miembro pasado como parámetro
    * para tener una nueva moto en su poder
    *
    * param  [in]  m       Miembro del que se ha de comprobar su disponibilidad
    * param  [in]  precio  Precio de la moto a asignar
    *
    * param  [out]  ok  Devuelve true si el miembro puede tener una moto nueva y
    *                   false si no la puede tener
    *
    ***************************************************************************/
    public static boolean comprobarDisponibilidad(Miembro m, int precio, int max){
        boolean ok = false;
        
        if(m.getTotalPrecio() + precio < max){
            ok = true;
        }
        else
            System.out.println("No cumple el requisito de precio total\n");
        return ok;
    }
    
    /* boolean asignarMotoMiembro(Miembro, Moto) *******************************
    * 
    * La función asigna una moto a un miembro, siempre y cuando el miembro esté
    * disponible para recibirla
    *
    * param  [in]  m     Miembro al que se le quiere asignar una moto
    * param  [in]  moto  Moto a asignar
    *
    * param  [out]  ok  Devuelve true si la asignación se ha realizado
    *                   correctamente y false si no es así
    *
    ***************************************************************************/
    public static boolean asignarMotoMiembro(Miembro m, Moto moto, int max){
        boolean ok = false;
        
        if(comprobarDisponibilidad(m,moto.getPrecio(), max)){
            m.addMoto(moto);
            
            ok = true;
        }
        return ok;
    }
    
    /* void obtenerMiembro(int, ArrayList<Miembro>) ****************************
    * 
    * La función devuelve un miembro en función del numero que se le pasa como
    * parámetro y su identificador
    *
    * param  [in]  num      Número a comparar con el identificador de cada
    *                       miembro
    * param  [in]  miembro  Lista de miembros a comprobar
    *
    * param  [out]  m  Miembro que se devuelve
    *
    ***************************************************************************/
    public static Miembro obtenerMiembro(int num, ArrayList<Miembro> miembro){
        Miembro m = new Miembro();
        
        for(int i = 0; i < miembro.size(); i++){
            if(miembro.get(i).getId() == num){
                m = miembro.get(i);
            }
        }
        return m;
    }
    
    /* boolean crearCesion(Moto, Miembro, Miembro) *****************************
    * 
    * La función comprueba si se puede realizar una cesión; y, en caso
    * afirmativo, la lleva a cabo.
    *
    * param  [in]  m   Moto cedida
    * param  [in]  or  Miembro que cede la moto
    * param  [in]  de  Miembro que recibe la moto
    *
    * param  [out]  ok  Devuelve true si la cesion se realiza correctamente y
    *                   false si no es así
    *
    ***************************************************************************/
    public static boolean crearCesion(Moto m, Miembro or, Miembro de, int max)
    {
        boolean ok = false;
        if(asignarMotoMiembro(de, m, max))
        {
            or.deleteMoto(m);
            ok = true;
        }  
        return ok;  
    }
    
    /* void obtenerMiembroMoto(Moto, ArrayList<Miembro>) ***********************
    * 
    * La función devuelve el miembro poseedor de la moto que se pasa como
    * parámetro
    *
    * param  [in]  m         Moto de la cual se quiere conocer el poseedor
    * param  [in]  miembros  Lista de miembros a comprobar
    *
    * param  [out]  m  Miembro que se devuelve
    *
    ***************************************************************************/
    public static Miembro obtenerMiembroMoto(Moto m, ArrayList<Miembro> miembros)
    {
        return miembros.get(m.getIDDueño()-1);
    }
    
    /* void escribirFichero(ArrayList<Miembro>, ArrayList<Cesion>) *************
    * 
    * La función registra todas las cesiones y todos los miembro en el fichero
    * "historial.txt"
    *
    * param  [in]  miembros  Lista de miembros que se han de guardar
    * param  [in]  cesiones  Lista de cesiones que se han de guardar
    *
    ***************************************************************************/
    public static void escribirFichero(ArrayList<Miembro> miembros, ArrayList<Cesion> cesiones)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        try
        {
            fichero = new FileWriter("historial.txt");
            pw = new PrintWriter(fichero);
            for (int i = 0; i < miembros.size(); i++)
                pw.println(miembros.get(i).toString());
            pw.println("***Cesiones***");
            for (int j = 0; j < cesiones.size(); j++)
                pw.println(cesiones.get(j).toString());

        } catch (Exception e) {
            e.printStackTrace();
        
            } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
         
        }
    }
    
    /* void iniciarACAMA(ArrayList<Moto>, ArrayList<Miembro>) ******************
    * 
    * La función actúa como generador de datos de prueba para la aplicación
    *
    * param  [in]  motos     Lista de motos
    * param  [in]  miembros  Lista de miembros
    *
    ***************************************************************************/
    public static void iniciarACAMA(ArrayList<Moto> motos, ArrayList<Miembro> miembros, int max)
    {
        Moto moto;
        Miembro miem;
        
        
        miem = new Miembro("Juan");
        miembros.add(miem);
        miem = new Miembro("Pepe");
        miembros.add(miem);
        miem = new Miembro("Joseba");
        miembros.add(miem);
        miem = new Miembro("Pablo");
        miembros.add(miem);
        
        moto = new Moto("Vespa", "Primavera", 125, 2500, miembros.get(0).getId(),0);
        motos.add(moto);
        asignarMotoMiembro(miembros.get(0), moto, max);
        moto = new Moto("Vespa", "Primavera", 125, 2500, miembros.get(0).getId(),0);
        motos.add(moto);
        asignarMotoMiembro(miembros.get(0), moto, max);
        moto = new Moto("Motobenae", "Poney AG2", 70, 2300, miembros.get(2).getId(),0);
        motos.add(moto);
        asignarMotoMiembro(miembros.get(2), moto, max);
        moto = new Moto("Bultaco", "", 200, 3800, miembros.get(1).getId(),0);
        motos.add(moto);
        asignarMotoMiembro(miembros.get(1), moto, max);        
        moto = new Moto("Guzzi", "Cardelino 73", 75, 1200, miembros.get(1).getId(),0);
        motos.add(moto);
        asignarMotoMiembro(miembros.get(1), moto, max);
        moto = new Moto("Ducati", "mini", 49, 4000, miembros.get(3).getId(),0);
        motos.add(moto);
        asignarMotoMiembro(miembros.get(3), moto, max);         
    }
}
