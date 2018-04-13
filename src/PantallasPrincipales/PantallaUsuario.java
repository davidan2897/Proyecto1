/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PantallasPrincipales;


import Interfaces.Usuarios.ListaObrasUsuarioPrestadas;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
 
/**
 *
 * @author David
 */
public class PantallaUsuario {
   
    ListaObrasUsuarioPrestadas  listasObrasUsuaruio= new ListaObrasUsuarioPrestadas();
    
    public VBox pantallaUsuario (){
        VBox vboxPantallaUsuario =new VBox();
        Label Espacio = new Label("");
        Label tituloBienvenido = new Label("Bienvenido a la Biblioteca Virtual");
        Label obrasPrestadas = new Label("Obras Prestadas");
        Label Espaci = new Label();
        
        vboxPantallaUsuario.getChildren().addAll(tituloBienvenido,Espacio,obrasPrestadas,Espaci, listasObrasUsuaruio.MostrarListalibros());
       
        
        
        
        
        
        
        
        
        return vboxPantallaUsuario;
    }
}
