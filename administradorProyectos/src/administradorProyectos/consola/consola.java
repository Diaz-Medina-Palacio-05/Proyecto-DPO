package administradorProyectos.consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import administradorProyectos.modelo.Actividad;
import administradorProyectos.modelo.Participante;
import administradorProyectos.modelo.Proyecto;

public class consola 
{
	private Proyecto proyecto = new Proyecto();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	public void ejecutarOpciones() throws IOException, ParseException
	{
		System.out.println("Bienvenido a ProjectAndes");
		
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
				switch(opcion_seleccionada) 
				{
				case 1 -> generarProyecto();
				case 2 -> añadirParticipante();
				case 3 -> agregarActividad();
				case 4 -> buscarParticipante();
				case 5 -> buscarActividad();
				case 6 -> {System.out.println("\nCerrando Sesión..."); continuar = false;}
				default -> System.out.println("Seleccione una opcion valida");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println(e);
			}
		}
		
	}
	
	public void mostrarMenu() 
	{
		System.out.println("\n Opciones de la aplicacion\n");
		System.out.println("1. CREAR NUEVO PROYECTO / CARGAR PROYECTO EXISTENTE");
		System.out.println("2. Añadir Participantes");
		System.out.println("3. Añadir Actividad");
		System.out.println("4. Buscar Participante");
		System.out.println("5. Buscar Actividad");
		System.out.println("6. Salir de la aplicacion\n");
	}
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	public void generarProyecto() throws ParseException
	{
		System.out.println("\n==== CARGA DE PROYECTO ===="); 
		System.out.println("\n1. Crear un nuevo Proyecto"); 
		System.out.println("\n2. Cargar un Archivo Existente"); 
		int opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opcion"));
		if (opcion_seleccionada == 1)
		{
			boolean conti = true;
			System.out.println("\nPor favor ingrese los siguientes datos"); 
			String titulo = input("\nTitulo");
			String descripcion = input("\nDescripción");
			Date fechaFinal = sdf.parse(input("\nFecha Final Aproximada en formato dia-Mes-año"));
			String nombreDueño = input("\nIngrese su nombre");
			String correoDueño = input("\nIngrese su correo");
			Participante dueño = new Participante(nombreDueño, correoDueño, true);
			while (conti == true)
			{
				String nuevoTipo = input("\nIngrese un tipo de actividad que usara el Proyecto");
				proyecto.getTipos().add(nuevoTipo);
				int seleccion = Integer.parseInt(input("\nQuiere añadir más tipos de actividades al Proyecto? 1. Si 2. No "));
				switch (seleccion)
				{
				case 1 -> conti = true;
				case 2 -> conti = false;
				default -> System.out.println("Escoja una opción valida");
				}
			}
			proyecto.setTitulo(titulo);
			proyecto.setDescripcion(descripcion);
			proyecto.setFechaFinal(fechaFinal);
			proyecto.setDueño(dueño);
			proyecto.getParticipantes().add(dueño);
			System.out.println("\nProyecto Creado a la Perfección!"); 
			
		}
		else if (opcion_seleccionada == 2)
		{
			//TODO
		}
		else
		{
			System.out.println("\n¡Seleccione una opción valida!");
		}
		
	}
	
	public void añadirParticipante()
	{
		System.out.println("\n====== Nuevo Participante ======");
		System.out.println("\nIngrese la información correspondiente.");
		String nombrePart = input("\nIngrese el nombre del participante");
		String correoPart = input("\nIngrese el correo del participante");
		proyecto.añadirParticipante(nombrePart, correoPart);
		System.out.println("\nEl/la participante " + nombrePart + " a sido agregad@ al proyecto.");
	}
	
	public void agregarActividad()
	{
		System.out.println("\n====== Nuevo Actividad ======");
		System.out.println("\nIngrese la información correspondiente.");
		String titulo = input("\nIngrese el titulo de la actividad");
		String descripcion = input("\nIngrese una breve descripción de la actividad");
		System.out.println("\n==== Tipos de Actividad ====\n");
		for (int i = 0; i < proyecto.getTipos().size(); i++)
		{
			String no = Integer.toString(i + 1);
			System.out.println(no + ". " + proyecto.getTipos().get(i));
		}
		int x = Integer.parseInt(input("\nPor favor seleccione de que tipo sera la actividad"));
		String tipo = proyecto.getTipos().get(x - 1);
		String encargado = input("\nIngrese el nombre completo del encargad@ de la actividad");
		proyecto.crearActividad(titulo, tipo, descripcion, encargado);
		System.out.println("\nSe ha creado la actividad " +  titulo + " y se ha añadido al proyecto.");
		
	}
	
	public void buscarParticipante()
	{
		System.out.println("\n====== Buscar Participante ======");
		String nombreParticipante = input("\nIngrese el nombre completo del participante a buscar");
		Participante elSujeto = proyecto.buscarParticipante(nombreParticipante);
		System.out.println("\n=========================================");
		ArrayList<Actividad> lasActividades = elSujeto.getActividades();
		elSujeto.getReporte().generarTextoReporte(lasActividades);
		System.out.println(elSujeto.getReporte().getReporte());
	}
	
	public void buscarActividad() throws ParseException
	{
		Actividad buscada = null;
		Boolean c = true;
		System.out.println("\n\n====== Buscar Actividad =======");
		System.out.println("\n\n==================================");
		System.out.println("\n\n¿Como quiere buscar la actividad?");
		System.out.println("\n\n1. Por Tipo.");
		System.out.println("\n\n2. Por Titulo.");
		System.out.println("\n\n3. Por Participante");
		Integer opcion_seleccionada = Integer.parseInt(input("\nPor favor seleccione una opcion"));
		while (c == true)
		{
			if (opcion_seleccionada.equals(1))
			{
				System.out.println("\n==== Tipos de Actividad ====\n");
				for (int i = 0; i < proyecto.getTipos().size(); i++)
				{
					String no = Integer.toString(i + 1);
					System.out.println(no + ". " + proyecto.getTipos().get(i));
				}
				int x = Integer.parseInt(input("Por favor seleccione de que tipo sera la actividad"));
				String tipo = proyecto.getTipos().get(x - 1);
				buscada = proyecto.buscarActividad("tipo", tipo);
				c = false;
			}
			else if (opcion_seleccionada.equals(2))
			{
				String t = input("\nIngrese el titulo de la actividad");
				buscada = proyecto.buscarActividad("titulo", t);
				c = false;
			}
			else if (opcion_seleccionada.equals(3)) 
			{
				String encargado = input("\nIngrese el nombre completo del encargad@ de la actividad");
				buscada = proyecto.buscarActividad("participante", encargado);
				c = false;
			}
			else
			{
				System.out.println("\nSeleccione una opcion valida.");
			}
		}
		if (buscada != null)
		{
			System.out.println("\n========================================");
			System.out.println("\nInfo de la Actividad Encontrada");
			System.out.println("\nTitulo: " + buscada.getTitulo());
			System.out.println("\nEncargado: " + buscada.getEncargado().getNombre());
			System.out.println("\nFecha de Inicio: " + sdf.format(buscada.getFechaInicial()));
			if (buscada.getTerminado() == true)
			{
				System.out.println("\nFecha de Finalización: " + sdf.format(buscada.getFechaFinal()));
				System.out.println("\nTiempo invertido: " + buscada.getCronometro().getTiempoInvertido());
			}
			System.out.println("\nDescripcion: " + buscada.getDescripcion());
			if (buscada.getEstado() == true)
			{
				System.out.println("\nEstado Cronometro = Pausado");
			}
			else
			{
				System.out.println("\nEstado Cronometro = Activo");
			}
			
			System.out.println("\n========================================");
			
			Integer k = Integer.parseInt(input("\nQuiere Editar la Actividad? 1. Si 2. No "));
			
			switch(k)
			{
			case 1 -> editarActividad(buscada);
			case 2 -> System.out.println("Regresando al menu principal... ");
			default -> System.out.println("Ingrese una opcion valida");
			}
		}
	}
	
	public void editarActividad(Actividad buscada) throws ParseException
	{
		Boolean b = true;
		String edicion = null;
		Integer pregunta = 0;
		while (b == true)
		{ 
			System.out.println("\nEdicion de Actividad");
			System.out.println("\n1. Fecha Inicial"
					+ "\n2. Titulo" + "\n3. Descripcion"
					+ "\n4. Tipo" + "\n5. Pausar/Continuar Cronometro" + "\n6. Marcar como finalizada");
			Integer opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion..."));
		
			if (opcion_seleccionada.equals(1))
			{
				edicion = input("\nIngrese la nueva Fecha Inicial en formato dia-Mes-año");
				proyecto.aEditar(buscada, opcion_seleccionada, edicion);
				pregunta = Integer.parseInt(input("\n\\n¿Quiere editar algo más? 1. Si 2. No"));
				if (pregunta.equals(2))
				{
					b = false;
				}
			}
			else if (opcion_seleccionada.equals(2))
			{
				edicion = input("\nIngrese el nuevo título");
				proyecto.aEditar(buscada, opcion_seleccionada, edicion);
				pregunta = Integer.parseInt(input("\n¿Quiere editar algo más? 1. Si 2. No"));
				if (pregunta.equals(2))
				{
					b = false;
				}
			}
			else if (opcion_seleccionada.equals(3))
			{
				edicion = input("\nIngrese la nueva Descripción");
				proyecto.aEditar(buscada, opcion_seleccionada, edicion);
				pregunta = Integer.parseInt(input("\nn¿Quiere editar algo más? 1. Si 2. No"));
				if (pregunta.equals(2))
				{
					b = false;
				}
			}
			else if (opcion_seleccionada.equals(4))
			{
				System.out.println("Lista de tipos de Actividades");
				for (int i = 0; i < proyecto.getTipos().size(); i++)
				{
					String no = Integer.toString(i) + 1;
					System.out.println(no + ". " + proyecto.getTipos().get(i));
				}
				Integer z = Integer.parseInt(input("Seleccione el nuevo tipo de la actividad"));
				edicion = proyecto.getTipos().get(z);
				proyecto.aEditar(buscada, opcion_seleccionada, edicion);
				pregunta = Integer.parseInt(input("\n¿Quiere editar algo más? 1. Si 2. No"));
				if (pregunta.equals(2))
				{
					b = false;
				}
			}
			else if (opcion_seleccionada.equals(5))
			{
				proyecto.aEditar(buscada, opcion_seleccionada, edicion);
				pregunta = Integer.parseInt(input("\n¿Quiere editar algo más? 1. Si 2. No"));
				if (pregunta.equals(2))
				{
					b = false;
				}
			}
			else if (opcion_seleccionada.equals(6))
			{
				int choose = Integer.parseInt(input("Quiere usar 1. la fecha actual o 2. una fecha determinada?"));
				switch(choose)
				{
				case 1 -> edicion = sdf.format(new Date());
				case 2-> edicion = input("Ingrese la fecha determinada en formato dia-Mes-Año");
				}
				proyecto.aEditar(buscada, opcion_seleccionada, edicion);
				pregunta = Integer.parseInt(input("\n¿Quiere editar algo más? 1. Si 2. No"));
				if (pregunta.equals(2))
				{
					b = false;
				}
			}
			else
			{
				System.out.println("\nIngrese una opcion valida");
			}
		}
		
	}
	
	
	public static void main(String[] args) throws IOException, ParseException
	{
		consola consolaProyecto = new consola();
		consolaProyecto.ejecutarOpciones();
	}
}
