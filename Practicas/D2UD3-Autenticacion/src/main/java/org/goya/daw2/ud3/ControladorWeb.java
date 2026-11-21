package org.goya.daw2.ud3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class ControladorWeb {
	
	@GetMapping("/")
	public String raiz(HttpSession sesion, Model modelo) {
		if(sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		}
		modelo.addAttribute("usuario", sesion.getAttribute("usuario"));
		return "inicio";
	}
	
	@GetMapping("/pagina1")
	public String paginas(HttpSession sesion, Model modelo) {
		if(sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		}
		modelo.addAttribute("usuario", sesion.getAttribute("usuario"));
		return "pagina1";
		
	}
	
	@GetMapping("/pagina2")
	public String pagina2(HttpSession sesion, Model modelo) {
		if(sesion.getAttribute("usuario") == null) {
			return "redirect:/login";
		}
		modelo.addAttribute("usuario", sesion.getAttribute("usuario"));
		return "pagina2";
		
	}
	
	@GetMapping("/login")
	public String login(HttpSession sesion) {
		if(sesion.getAttribute("usuario") != null) {
			return "redirect:/";
		}
		return "login";
		
	}
	
	@PostMapping("/login")
	public String mostrarLogin(@RequestParam(name="usuario", required=false) String usuario,
			@RequestParam(name="contrasenya", required=false) String contrasenya,
			HttpSession sesion, Model modelo) {
		if("sara".equals(usuario) && "Holaquetal123".equals(contrasenya)) {
			sesion.setAttribute("usuario", usuario);
			return "redirect:/";
		}
		modelo.addAttribute("error", "el usuario o contraseña no es correcto");
		modelo.addAttribute("usuario", usuario);
		return "login";
		
	}
	
	@GetMapping("/logout")
	public String cerrarSesion(HttpSession sesion) {
		sesion.invalidate();
		return "redirect:/login";
		
	}

}
