package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorSaludo {

	@RequestMapping(path="/saludar")
	public ModelAndView saludar(){
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("mensaje", "saludo");
		
		return new ModelAndView("saludo", modelo);
	}
	
	@RequestMapping(path="/hola")
	public ModelAndView hola(@RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido){
		ModelMap model = new ModelMap();
		model.put("nombre", nombre);
		model.put("apellido", apellido);
		return new ModelAndView("bienvenido", model);
	}

}
