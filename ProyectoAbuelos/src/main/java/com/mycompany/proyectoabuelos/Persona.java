
package com.mycompany.proyectoabuelos;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase persona que tiene los atributos de la misma que seran insertados en el Mapa
 * @author gtior
 */
public class Persona {
    
    /**
     * Variables que se van a guardar en el Mapa
     */
    public int identificacion;
    public String nombres;
    public String apellidos;
    private Map<Integer, Persona> arbol = new HashMap();

    /**
     * Constructor que inicializa las variables
     * @param identificacion
     * @param nombres
     * @param apellidos 
     */
    public Persona(int identificacion, String nombres, String apellidos) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    
    /**
     * Getters y Setters
     * Obtiene un valor
     * @return identificacion
     */
    public int getIdentificacion() {
        return identificacion;
    }

    /**
     * Asigna un valor
     * @param identificacion 
     */
    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * Obtiene el nombre
     * @return nombres 
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Asigna un Nombre
     * @param nombres 
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obiene el apellido
     * @return apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Asigna un apellido
     * @param apellidos 
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    /**
     * Obtiene el arbol
     * @return arbol 
     */
    public Map<Integer, Persona> getArbol() {
        return arbol;
    }

    /**
     * Asigna un valor
     * @param arbol 
     */
    public void setArbol(Map<Integer, Persona> arbol) {
        this.arbol = arbol;
    }
    
    
}
