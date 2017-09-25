
package it.uniroma3.catalogo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping
	public String welcome(Model model) {
		model.addAttribute("greeting", "Benvenuto nel nostro Catalogo Prodotti");
		model.addAttribute("tagline", "");
		return "welcome";
	}
	
	@RequestMapping("/welcome/greeting")
	public String greeting() {
		return "welcome";
	}
}
