package administradorProyectos.modelo;
import java.io.File;
import java.time.*;
import java.util.ArrayList;

public class Proyecto 
{
	//Atributos
	private String titulo;
	private String descripcion;
	private LocalDate fechaInicio;
	private LocalDate fechaFinal;
	private Participante dueño;
	private ArrayList<String> tipos;
	private File archivo;
	private ArrayList<Participante> participantes;
	private ArrayList<Actividad> actividades;
	private Actualizacion actualizador;
	private Buscador finder;
	
	
	//Constructor
	public Proyecto(String tittle, String description, LocalDate estimadoFinal, File archivoBase, String nombreDueño, String emailDuesño, ArrayList<String> tipoActividad) 
	{
		titulo = tittle;
		descripcion = description; 
		fechaInicio = LocalDate.now();
		fechaFinal = estimadoFinal;
		dueño = new Participante(nombreDueño, emailDuesño, true);
		tipos = tipoActividad;
		archivo = archivoBase;
		participantes = new ArrayList<Participante>();
		actividades = new ArrayList<Actividad>();
		
		
		
	}
}
