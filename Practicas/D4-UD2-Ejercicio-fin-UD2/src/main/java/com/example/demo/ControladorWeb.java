package com.example.demo;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControladorWeb {
	
	@GetMapping("/")
	public String formulario() {
		return "formulario";
	}
	
	
	@GetMapping("/texto")
	@ResponseBody
	public String pruebaTextoGet(@RequestParam(name="texto", required = false) String texto) {
		return "Texto get " +  texto;
		
	}
	
	@PostMapping("/texto")
	@ResponseBody
	public String pruebaTextoPost(@RequestParam(name="texto", required = false) String texto) {
		return "Texto post " +  texto;
		
	}
	
	@GetMapping("/enlace")
	@ResponseBody
	public String enlace() {
		String texto = "Hola qué tal?";
		String enlacecodificado = URLEncoder.encode(texto);
		return "<a href='/texto?texto=" + enlacecodificado + "'>Enviar el texto</a>";		
	}
	
	
	//Ejercicio 2
	@GetMapping("/idioma")
	public String idioma() {
		return "ejercicio2Idioma";
	}

}
