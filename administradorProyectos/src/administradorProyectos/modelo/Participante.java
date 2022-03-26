package administradorProyectos.modelo;

import java.util.ArrayList;

public class Participante 
{
	//Atributos
	private String nombre;
	private String correo;
	private Boolean dueño;
	private Reporte miReporte;
	private ArrayList<Actividad> misActividades;
	
	//Constructor
	public Participante(String elNombre, String email, Boolean lider) 
	{
		nombre = elNombre;
		correo = email;
		dueño = lider;
		miReporte = new Reporte();
		misActividades = new ArrayList<Actividad>();
	}
	
	//Metodos
	
	
}
