package it.uniroma3.catalogo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.catalogo.domain.Supplier;
import it.uniroma3.catalogo.service.SupplierService;

@Controller
@RequestMapping("suppliers")
public class SupplierController {
	
	private SupplierService supplierService;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddSupplierForm(Model model) {
		Supplier newSupplier = new Supplier();
		model.addAttribute("supplier", newSupplier);
		return "addSupplier";
	}
	
	public String processNewSupplier(@ModelAttribute("newSupplier") Supplier supplier) {
		supplierService.create(supplier);
		return "supplier";
		
	}
	@RequestMapping("/remove/{id}")
	public String removeSupplier(@RequestParam("id") String id, Model model) {
		supplierService.delete(id);
		return "redirect:/suppliers";
	}   
	
	@RequestMapping("/product")
	   public String getSupplierById(@RequestParam("id") String id, Model model) {
	  	model.addAttribute("product", supplierService.getSupplierById(id));
	   	return "supplier";
	   }
	
	
}
