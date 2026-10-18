package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorWeb {
	
	@GetMapping("/")
	public String pantalla0() {
		return "pantalla1";
	}
	
	//Nombre y apellidos son input text
	@PostMapping("/pantalla1")
	public String pantalla1(@RequestParam(name="nombre", required=false) String nombre, 
			@RequestParam(name="apellidos", required=false)String apellidos, Model modelo) {
		
		if(nombre == null || nombre.isBlank() || apellidos == null || apellidos.isBlank()) {
			modelo.addAttribute("error", "Error, introduce datos");
			modelo.addAttribute("nombre", nombre);
			modelo.addAttribute("apellidos", apellidos);
			return "pantalla1";
		}
		
		
		modelo.addAttribute("nombre", nombre);
		modelo.addAttribute("apellidos", apellidos);
		
		return "pantalla2";
	}
	
	//edad desplegable y sexo de elegir 1 opcion
	@PostMapping("/pantalla2")
	public String pantalla2(@RequestParam(name="nombre", required=false) String nombre,
			@RequestParam(name="apellidos", required=false)String apellidos,
			@RequestParam(name="edad", required=false) String edad, 
			@RequestParam(name="sexo", required=false) String sexo, 
			Model modelo) {
		
		modelo.addAttribute("nombre", nombre);
		modelo.addAttribute("apellidos", apellidos);
		modelo.addAttribute("edad", edad);
		modelo.addAttribute("sexo", sexo);
		
		if (edad == null || edad.isBlank()
		        || sexo == null || sexo.isBlank()) {
			 modelo.addAttribute("error", "Error, selecciona la edad y el sexo");
			    return "pantalla2";
		}
		
		modelo.addAttribute("nombre", nombre);
		modelo.addAttribute("apellidos", apellidos);
		modelo.addAttribute("edad", edad);
		modelo.addAttribute("sexo", sexo);

		return "pantalla3";
		
	}
	
	//comida de seleccion multiple
	@PostMapping("/pantalla3")
	public String pantalla3(@RequestParam(name="nombre", required=false) String nombre,
			@RequestParam(name="apellidos", required=false)String apellidos,
			@RequestParam(name="edad", required=false) String edad, 
			@RequestParam(name="sexo", required=false) String sexo, 
			@RequestParam(name="comida", required=false) ArrayList<String> comida, 
			Model modelo) {
		
		modelo.addAttribute("nombre", nombre);
		modelo.addAttribute("apellidos", apellidos);
		modelo.addAttribute("edad", edad);
		modelo.addAttribute("sexo", sexo);
		modelo.addAttribute("comida", comida);
		
		if (comida == null || comida.isEmpty()) {
		    modelo.addAttribute("error", "Error, selecciona al menos una comida");
		    return "pantalla3";
		}
		
		modelo.addAttribute("nombre", nombre);
		modelo.addAttribute("apellidos", apellidos);
		modelo.addAttribute("edad", edad);
		modelo.addAttribute("sexo", sexo);
		modelo.addAttribute("comida", comida);
		
		ArrayList<String> informacion = new ArrayList<String>();
		informacion.add(nombre);
		informacion.add(apellidos);
		informacion.add(edad);
		informacion.add(sexo);
		if(comida != null) {
			informacion.addAll(comida);
		}

		modelo.addAttribute("informacion", informacion);
		
		return "resultado";
		
	}
	
	@GetMapping("/volverPantalla1")
	public String volverPantalla1(
	        @RequestParam(name="nombre", required=false) String nombre,
	        @RequestParam(name="apellidos", required=false) String apellidos,
	        Model modelo) {

	    modelo.addAttribute("nombre", nombre);
	    modelo.addAttribute("apellidos", apellidos);

	    return "pantalla1";
	}

	@GetMapping("/volverPantalla2")
	public String volverPantalla2(
	        @RequestParam(name="nombre", required=false) String nombre,
	        @RequestParam(name="apellidos", required=false) String apellidos,
	        @RequestParam(name="edad", required=false) String edad,
	        @RequestParam(name="sexo", required=false) String sexo,
	        @RequestParam(name="comida", required=false) ArrayList<String> comida,
	        
	        Model modelo) {

	    modelo.addAttribute("nombre", nombre);
	    modelo.addAttribute("apellidos", apellidos);
	    modelo.addAttribute("edad", edad);
	    modelo.addAttribute("sexo", sexo);
	    modelo.addAttribute("comida", comida);

	    return "pantalla2";
	}
	

}
