
package com.mycompany.proyectoabuelos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Clase principal en donde estan contenidos los metodos principales para ejecutar el programa
 * @author gtior
 */
public class Principal {
   
    /**
     * Variable tipo Map para guardar los datos de la clase persona
     */
    Map<Integer,Persona> mapaAbuelo= new HashMap();
    
    public Principal(){
    }
    
    /**
     * Metodo para recorrer el mapa y poder imprimirlo por consola
     * @param mapAb
     * @param busqueda
     * @return 
     */
    
    public String abuelos(Map mapAb,int busqueda){ 
        String prueba = "";
        mapaAbuelo.putAll(mapAb);
        
        //-------------------------------------------------------------------------------------
        //Impresion
        for (Integer keyAbuelo : mapaAbuelo.keySet()) {
            Persona pAbuelo = mapaAbuelo.get(keyAbuelo);
           // prueba = prueba.concat(pAbuelo.getNombres());
            //System.out.println(pAbuelo.getNombres());
            for (Integer KeyPadre : pAbuelo.getArbol().keySet()){
                Persona pPadre = pAbuelo.getArbol().get(KeyPadre);
              //  prueba = prueba.concat(pPadre.getNombres());
                //System.out.println("     " +pPadre.getNombres());
                for (Integer KeyHijo : pPadre.getArbol().keySet() ){
                    Persona pHijo = pPadre.getArbol().get(KeyHijo);
                    //System.out.println("            "+pHijo.getNombres());
                    if(mapaAbuelo.containsKey(busqueda)){
                        if(keyAbuelo == busqueda){
                            prueba = prueba.concat(pAbuelo.getNombres());
                            prueba = prueba.concat(pPadre.getNombres());
                            prueba = prueba.concat(pHijo.getNombres());
                            System.out.println("Abuelo: "+pAbuelo.getNombres()+pAbuelo.getApellidos());
                            System.out.println("Padre:"+pPadre.getNombres()+pPadre.getApellidos());
                            System.out.println("Nieto: "+pHijo.getNombres()+pHijo.getApellidos());
                        }
                    }else if(mapaAbuelo.get(keyAbuelo).getArbol().containsKey(busqueda)){
                        if(KeyPadre == busqueda){
                            prueba = prueba.concat(pPadre.getNombres());
                            prueba = prueba.concat(pHijo.getNombres());
                            prueba = prueba.concat(pAbuelo.getNombres());
                            System.out.println("Padre: "+pPadre.getNombres()+pPadre.getApellidos());
                            System.out.println("Hijo: "+pHijo.getNombres()+pHijo.getApellidos());
                            System.out.println("Abuelo: "+pAbuelo.getNombres()+pAbuelo.getApellidos());
                        }
                    }else if(mapaAbuelo.get(keyAbuelo).getArbol().get(KeyPadre).getArbol().containsKey(busqueda)){
                        if(KeyHijo == busqueda){
                            prueba = prueba.concat(pHijo.getNombres());
                            prueba = prueba.concat(pPadre.getNombres());
                            prueba = prueba.concat(pAbuelo.getNombres());
                            System.out.println("Hijo: "+pHijo.getNombres()+pHijo.getApellidos());
                            System.out.println("Padre: "+pPadre.getNombres()+pPadre.getApellidos());
                            System.out.println("Abuelo: "+pAbuelo.getNombres()+pAbuelo.getApellidos());
                        }
                    }
                    }
                }
            
        }
      return prueba;  
    }//abuelos
}//Principal
