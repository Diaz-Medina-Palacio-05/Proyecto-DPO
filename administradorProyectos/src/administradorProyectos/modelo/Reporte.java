package administradorProyectos.modelo;

import java.util.ArrayList;

public class Reporte 
{
	//Atributos
	private Integer tiempoTotal;
	private Integer tiempoPromedio;
	private Integer tiempoPorDia;
	private String topActividad;
	public String elReporte;
	
	public Reporte() 
	{
		tiempoTotal = 0;
		tiempoPromedio = 0;
		tiempoPorDia = 0;
		elReporte = null;
	}
	
	public String getReporte()
	{
		return elReporte;
	}
	
	private String calcularTiempoInvertido(ArrayList Actividades) 
	{
		//TODO
		return null;
	}
	
	private String calcularTiempoPromedio(ArrayList Actividades) 
	{
		//TODO
		return null;
	}
	private String calcularTiempoPorDia(ArrayList Actividades) 
	{
		//TODO
		return null;
	}
	private String calcularTopActividad(ArrayList Actividades) 
	{
		//TODO
		return null;
	}
	public String generarTextoReporte() 
	{
		//TODO
		return null;
	}	
	
}
