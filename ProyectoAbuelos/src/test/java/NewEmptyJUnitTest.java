/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.proyectoabuelos.Persona;
import com.mycompany.proyectoabuelos.Principal;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gtior
 */
public class NewEmptyJUnitTest {
    
    /**
     * Mapa para guardar todos los atributos de la clase persona
     */
    static Map<Integer,Persona> mapaAbuelo = new HashMap();
    
    public NewEmptyJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        ingresar();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    /*@Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }*/

    /**
     * Metodo statico para quemar los datos de todoa la familia en el Mapa
     */
    public static void ingresar(){
        //abuelos
        Persona pJuan = new Persona(1,"Juan","");
        mapaAbuelo.put(1, pJuan);
        mapaAbuelo.put(2, new Persona(2,"Jose",""));
        
        //padres
        Persona pAndres = new Persona(3,"Andres","Gutierrez");
        Persona pMaria = new Persona(4,"Maria","Ortiz");
        Persona pCarlos = new Persona(5,"Carlos","Castro");
        
        pJuan.getArbol().put(3, pAndres);
        pJuan.getArbol().put(4, pMaria);
        pJuan.getArbol().put(5, pCarlos);
        
        //Hijos
        Persona pJuana = new Persona(9,"Juana","Ortiz");
        Persona pPaola = new Persona(10,"Paola","Ortiz");
        Persona pSofia = new Persona(11,"Sofia","Ortiz");
        Persona pJaime = new Persona(12,"Jaime","Ortiz");
        
        pAndres.getArbol().put(9,pJuana);
        pAndres.getArbol().put(10,pPaola);
        pMaria.getArbol().put(11,pSofia);
        pCarlos.getArbol().put(12,pJaime);
        
        //-----------------------------------------------------------------------------------
        
        mapaAbuelo.get(2).getArbol().put(6, new Persona(6,"Alberto","Gutierrez"));
        mapaAbuelo.get(2).getArbol().put(7, new Persona(7,"Jimmy","Gutierrez"));
        mapaAbuelo.get(2).getArbol().put(8, new Persona(8,"Jhon","Gutierrez"));
        
        mapaAbuelo.get(2).getArbol().get(6).getArbol().put(13, new Persona(13,"Tatiana","Castro"));
        mapaAbuelo.get(2).getArbol().get(6).getArbol().put(14, new Persona(14,"Fernanda","Castro"));
        mapaAbuelo.get(2).getArbol().get(7).getArbol().put(15, new Persona(15,"Viviana","Castro"));
        mapaAbuelo.get(2).getArbol().get(8).getArbol().put(16, new Persona(16,"Diana","Castro"));
    }
 
    /**
     * Metodo para probar la busqueda por medio del codigo de un abuelo
     */
    @Test
    public void abuelos(){
        Principal p = new Principal();
        String test = p.abuelos(mapaAbuelo, 2);
        assertEquals("JoseAlbertoTatianaJoseAlbertoFernandaJoseJimmyVivianaJoseJhonDiana", test);
    }
    
    /**
     * Metodo para probar la busqueda por medio del codigo de un padre
     */
    @Test
    public void padres(){
        Principal p = new Principal();
        String test = p.abuelos(mapaAbuelo, 5);
        assertEquals("CarlosJaimeJuan", test);
    }
    
    /**
     * Metodo para probar la busqueda por medio del codigo de un hijo/nieto
     */
    @Test
    public void nietos(){
        Principal p = new Principal();
        String test = p.abuelos(mapaAbuelo, 16);
        assertEquals("DianaJhonJose", test);
    }
    
    /**
     * Metodo para probar el resultado vacio que deberia mandar cuando se le pide buscar por un codigo que no existe
     */
    @Test
    public void falla(){
        Principal p = new Principal();
        String test = p.abuelos(mapaAbuelo, 20);
        assertEquals("", test);
    }
}
