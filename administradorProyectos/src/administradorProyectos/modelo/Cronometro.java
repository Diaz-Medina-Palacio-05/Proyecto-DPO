package administradorProyectos.modelo;

import java.time.*;
import java.util.*;

public class Cronometro 
{
	//Atributos 
	private LocalDate fechaInicial;
	private LocalDate fechaFinal;
	private Integer tiempoPausado;
	private Integer tiempoCronometrado;
	private Boolean enPausa;
	
	
	//Constructor
	public Cronometro(LocalDate fechaAproximada) 
	{
		fechaInicial = LocalDate.now();
		fechaFinal = fechaAproximada;
		tiempoPausado = 0;
		tiempoCronometrado = 0;
		enPausa = false;
	}
	
	//Metodos
	
	public void calcularTiempoCronometrado()
	{
		//TODO
	}
	
	public void pausarCronometro()
	{
		//TODO
	}
	
}
