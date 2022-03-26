package administradorProyectos.modelo;

import java.time.*;

public class Actividad 
{
	//Atributos 
	private String titulo;
	private LocalDate fechaInicio;
	private LocalDate fechaFinal;
	private String tipo;
	private String descripcion;
	private Participante encargado;
	private Cronometro cronometro;
	
	// Constructor 
	public Actividad(String titulo, String tipo, String descripcion, Participante encargado)
	{
		this.titulo = titulo;
		fechaInicio = LocalDate.now();
		fechaFinal = null;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.encargado = encargado;
		this.cronometro = new Cronometro(fechaInicio);
	}
	
	//Getters
	
	public LocalDate getFechaInicial()
	{
		return fechaInicio;
	}
	
	public LocalDate getFechaFinal()
	{
		return fechaFinal;
	}
	
	public String getTitulo()
	{
		return titulo;
	}
	
	public String getTipo()
	{
		return tipo;
	}
	
	public String getDescripcion()
	{
		return descripcion;
	}
	
	//Setters
	
	public void setFechaInicial(LocalDate actualizacion)
	{
		fechaInicio = actualizacion;
	}
	
	public void setFechaFinal(LocalDate actualizacion)
	{
		fechaFinal = actualizacion;
	}
	
	public void setTitulo(String actualizacion)
	{
		titulo = actualizacion;
	}
	
	public void setTipo(String actualizacion)
	{
		tipo = actualizacion;
	}
	
	public void setDescripcion(String actualizacion)
	{
		descripcion = actualizacion;
	}
	
	//Metodos
	
	public void estadoCronometro()
	{
		//TODO
	}
	
	public LocalDate getInfoCronometro()
	{
		//TODO
		return null;
	}
	
}
