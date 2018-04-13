/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Usuarios;

import Constructores.Bibliotecarios;
import Constructores.Libros;
import Constructores.Prestar;
import InterfazPrestar.MostrarObrasTodas;
import InterfazPrestar.PrestarObras;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import main.InicioSesion;

/**
 *
 * @author UsuarioPC
 */
public class ListaObrasUsuarioPrestadas {
    PrestarObras prestarObras= new PrestarObras();
   GestionarBibliotecarios gestionarBibliotecarios=new GestionarBibliotecarios();
    InicioSesion inici;
    
     public VBox MostrarListalibros(){
          
        TableView<Prestar> tabla=new TableView<>();
        
        
       
        TableColumn fechaPrestamo=new TableColumn("Fecha Prestamo");
         fechaPrestamo.setCellValueFactory(new PropertyValueFactory("fechaPrestamo"));
        
        TableColumn fechaRetorno=new TableColumn("Fecha Retorno");
        fechaRetorno.setCellValueFactory(new PropertyValueFactory<>("fechaRetorno"));
        TableColumn nombreUnico=new TableColumn("Nombre único");
        nombreUnico.setCellValueFactory(new PropertyValueFactory<>("nombreUnico"));
        TableColumn nombreObra=new TableColumn("Nombre Obra");
        nombreObra.setCellValueFactory(new PropertyValueFactory<>("nombreObra"));
        TableColumn  tipoObra=new TableColumn("Tipo Obra");
        tipoObra.setCellValueFactory(new PropertyValueFactory<>("tipoObra"));
         
        
        
        ObservableList<Prestar>datos=getDatosTabla();
        tabla.setItems(datos);
        tabla.getColumns().addAll(fechaPrestamo,fechaRetorno,nombreUnico,nombreObra,tipoObra);
        tabla.setMaxSize(500, 300);

        VBox vbox=new VBox();
        vbox.getChildren().addAll(tabla);
        return vbox;
    }

     public ObservableList<Prestar> getDatosTabla(){
        ArrayList array=new ArrayList();
       
       Prestar temp[]=prestarObras.arregloObrasPrestadas();
       // for(Libros valor:temp)
           // array.add(valor);
            for(int i=0;i<temp.length;i++){
               
                   if(temp[i].getNombreUnico().equalsIgnoreCase(inici.valorUsuario)){
                       array.add(temp[i]);
                      
                       
                   }
              }
         
        
        
        ObservableList<Prestar> listaDatos=FXCollections.observableArrayList(array);
         return listaDatos;       
         
    } 
    
}
