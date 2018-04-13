// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package Constructores;

import java.io.PrintStream;

/************************************************************/
/**
 * 
 */
public class Libros extends Catalogo {
     public Libros(String titulo, String fechaIngreso, String Autor,String codigoISBN,String Tema,String subtema,String Estado) {
        super(titulo, fechaIngreso, Autor,Estado);
        this.codigoISBN=codigoISBN;
        this.Tema=Tema;
        this.subtema=subtema;
    }



	/**
	 * 
	 */
	private String codigoISBN;
	/**
	 * 
	 */
	private String Tema;
	/**
	 * 
	 */
	private String subtema;

  

  

    public String getCodigoISBN() {
        return codigoISBN;
    }

    public void setCodigoISBN(String codigoISBN) {
        this.codigoISBN = codigoISBN;
    }

    public String getTema() {
        return Tema;
    }

    public void setTema(String Tema) {
        this.Tema = Tema;
    }

    public String getSubtema() {
        return subtema;
    }

    public void setSubtema(String subtema) {
        this.subtema = subtema;
    }
    public void Agregar(Libros libros) {
		// TODO Auto-generated method stub
	 PrintStream ps = getPrintStream("Libros.txt");

        ps.println(libros.getTitulo() + ";" + libros.getFechaIngreso()+ ";" + libros.getAutor()+ ";" + libros.getCodigoISBN() + ";" + libros.getTema()+";"+libros.getSubtema()+";"+libros.getEstado());
	}
    

} 