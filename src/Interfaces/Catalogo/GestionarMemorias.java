
package Interfaces.Catalogo;

import Constructores.Memorias;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javax.swing.JOptionPane;

/**
 *
 * @author UsuarioPC
 */
public class GestionarMemorias {
    
    //Instancias globales
    public String titulo;
    public String autor;
    static String nombreConferenci;
    static String abstrac;
    public String resumen;
    public String fechaIngreso;
    public String Estado;

    TextField texfieldTitulomemoria;
    TextField textfieldAutor;
    TextField textfieldnombreConferencia;
    TextArea textareaResumen;
    TextArea textareaAbstract;
    Button btnAgregar;
    DatePicker datepickerFecha;
    String tituloAux, nombreArchivo ="Memorias.txt";
UtilidadesGestionar utilGestionar = new UtilidadesGestionar();
    
    public GridPane AgregarMemorias(){
    GridPane gpVentanaLibros = new GridPane();
        btnAgregar = new Button("Agregar");
         datepickerFecha = new DatePicker();
        Label labelTituloMemoria = new Label("Titulo");
        gpVentanaLibros.add(labelTituloMemoria, 0, 0);
        texfieldTitulomemoria = new TextField();
        gpVentanaLibros.add(texfieldTitulomemoria, 1, 0);
        Label labelAutor= new Label("Autor");
        gpVentanaLibros.add(labelAutor, 0, 1);
         textfieldAutor= new TextField();
        gpVentanaLibros.add(textfieldAutor, 1, 1);
        Label nombreConferencia = new Label("Nombre de la conferencia");
        gpVentanaLibros.add(nombreConferencia, 0, 2);
         textfieldnombreConferencia = new TextField();
        gpVentanaLibros.add(textfieldnombreConferencia, 1, 2);
        Label labelResumen = new Label("Resumen");
        gpVentanaLibros.add(labelResumen, 0, 3);
        textareaResumen = new TextArea();
         gpVentanaLibros.add(textareaResumen, 1, 3);
        Label labelAbstract = new Label("Abstract");
        gpVentanaLibros.add(labelAbstract, 0, 4);
         textareaAbstract = new TextArea();
       gpVentanaLibros.add(textareaAbstract, 1, 4);
         Label labelFechaingreso = new Label("Fecha de ingreso");
        gpVentanaLibros.add(labelFechaingreso, 0, 5);
         gpVentanaLibros.add(datepickerFecha,1,5);
//        Msj = new Label("");
           gpVentanaLibros.add(btnAgregar, 0, 6);
         textareaResumen.setPrefWidth(100);
         textareaResumen.setPrefHeight(100);
         textareaAbstract.setPrefWidth(100);
         textareaAbstract.setPrefHeight(100);
        
         datepickerFecha.setOnAction(new EventHandler() {
            public void handle(Event t) {
                LocalDate date = datepickerFecha.getValue();
                int dia = date.getDayOfMonth();
                int mes=date.getMonthValue();
                int año=date.getYear();
                fechaIngreso=dia+"/"+mes+"/"+año;
                }
     });
        btnAgregar.setOnAction(new EventHandler<ActionEvent>() {
            
             public void handle(ActionEvent event) {
                 
                       
                if(verificaInfo() == true)
           JOptionPane.showMessageDialog(null, "Porfavor ingrese toda la informacion necesaria.");
                else{   
                 titulo = texfieldTitulomemoria.getText();
                 autor= textfieldAutor.getText();
                 nombreConferenci=textfieldnombreConferencia.getText();
                
                resumen = textareaResumen.getText();
                 abstrac=textareaAbstract.getText();
                 Estado ="Disponible";
                Memorias memoria=new Memorias(titulo, fechaIngreso, autor, resumen, abstrac, nombreConferenci,Estado);
                memoria.Agregar(memoria);
                JOptionPane.showMessageDialog(null,"Memoria agregada con exito :)");
                 Limpiar();
                
            }
             }        
              });
           
            
             return gpVentanaLibros;

    
}
    public void Limpiar(){
      texfieldTitulomemoria.setText("");
      textfieldAutor.setText("");
      textfieldnombreConferencia.setText("");
      textareaAbstract.setText("");
      textareaResumen.setText("");
            }
    private boolean verificaInfo(){
         if(texfieldTitulomemoria.getText().isEmpty())
             return true;
         else if(textfieldAutor.getText().isEmpty())
             return true;
         else if(textfieldnombreConferencia.getText().isEmpty())
             return true;
         else if(textareaAbstract.getText().isEmpty())
             return true;
         else if(textareaResumen.getText().isEmpty())
             return true;
         else
             return false;
     }
    
       public BorderPane ventanaBorrarMemoria(){
   
     BorderPane BorrarVentana = new BorderPane();
     GridPane ventanaCentroBorrar = new GridPane();
     HBox OrdenBotones = new HBox();
     Label Ordenartop = new Label("\n\n\n\n\n\n");
     Label Espacio = new Label("                ");

     Label etiquetaLibro = new Label("Titulo de la Memoria:");
    texfieldTitulomemoria = new TextField();
    
    
     Button btnBorrar = new Button("Borrar");
     Button btnIngresar= new Button("Ingresar");
     Button btnCancelar = new Button("Cancelar");
     
     
      btnBorrar.setDisable(true);
        btnCancelar.setDisable(true);
        
        //Accion boton Ingresar
        btnIngresar.setOnAction((event) -> {

            tituloAux = texfieldTitulomemoria.getText();
            if (tituloAux.isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "No se ha ingresado ninguna Memoria");
            } 
            else {
                tituloAux = texfieldTitulomemoria.getText();
            
            if (utilGestionar.buscar(tituloAux, utilGestionar.getArreglo(utilGestionar.CantidadRegistros(nombreArchivo), nombreArchivo))== true){
                btnBorrar.setDisable(false);
                btnCancelar.setDisable(false);
                btnIngresar.setDisable(true);

            } else {
                JOptionPane.showMessageDialog(null, "Memoria no se encuentra en registro");
            }
            }

        });//fin btnIngresar
        
        
        //Accion boton borrar
        btnBorrar.setOnAction((event) -> {
            tituloAux = texfieldTitulomemoria.getText();

            btnBorrar.setDisable(true);
            texfieldTitulomemoria.setText("");
            btnIngresar.setDisable(false);
            btnCancelar.setDisable(true);
            JOptionPane.showMessageDialog(null, "Memoria eliminada con exito");
            utilGestionar.eliminar(tituloAux, utilGestionar.getArreglo(utilGestionar.CantidadRegistros(nombreArchivo),nombreArchivo),nombreArchivo);

        });//fin borrar
        btnCancelar.setOnAction((event) -> {
            texfieldTitulomemoria.setText("");
            btnBorrar.setDisable(true);
            btnCancelar.setDisable(true);
            btnIngresar.setDisable(false);

        });//fin botonCancelar
        
     OrdenBotones.getChildren().addAll(btnIngresar,btnBorrar,btnCancelar);
     
     

   
     ventanaCentroBorrar.add(etiquetaLibro, 0, 0);
     ventanaCentroBorrar.add(texfieldTitulomemoria, 1, 0);
     ventanaCentroBorrar.add(OrdenBotones, 1, 1);
    
            
    BorrarVentana.setRight(Espacio);
    BorrarVentana.setTop(Ordenartop);
    BorrarVentana.setCenter(ventanaCentroBorrar);
    ventanaCentroBorrar.setAlignment(Pos.CENTER);

     
     
        return BorrarVentana;
     
}
       
       
}