package it.uniroma3.catalogo.controller;


import java.io.File;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import it.uniroma3.catalogo.domain.Product;
import it.uniroma3.catalogo.exception.NoProductsFoundUnderCategoryException;
import it.uniroma3.catalogo.exception.ProductNotFoundException;
import it.uniroma3.catalogo.service.ProductService;
import it.uniroma3.catalogo.validator.ProductValidator;

@Controller
@RequestMapping("market")
public class ProductController {

	
	private ProductService productService;


	@RequestMapping("/products")
	public String list(Model model) {
		model.addAttribute("products",productService.getAllProducts());
		return "products";
	}

	@RequestMapping("/update/stock")
	public String updateStock(Model model) {
		productService.updateAllStock();
		return "redirect:/products";
	}

	@RequestMapping("/products/{category}")
	public String getProductByCategory(Model model, @PathVariable("category") String productCategory) {
		
		List<Product> products = productService.getProductsByCategory(productCategory);
		
		if(products == null || products.isEmpty()) {
			throw new NoProductsFoundUnderCategoryException();
		}
		
		model.addAttribute("products", products);
		return "products";
	}

//	@RequestMapping("/products/filter/{params}")
//	public String getProductsByFilter(@MatrixVariable(pathVar="params") Map<String, List<String>> filterParams, Model model) {
//		model.addAttribute("products", productService.getProductsByFilter(filterParams));
//		return "products";
//	}

	   @RequestMapping("/product/{id}")
	   public String getProductById(@RequestParam("id") String productId, Model model) {
	  	model.addAttribute("product", productService.getProductById(productId));
	   	return "product";
	   }

	@RequestMapping(value = "/products/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}

	
	
	@RequestMapping(value = "/products/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct, BindingResult result, HttpServletRequest request) {

		if(result.hasErrors()) return "addProduct";
		
		String[] suppressedFields = result.getSuppressedFields();
		if(suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		
		MultipartFile productImage = newProduct.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if(productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(rootDirectory+"resources\\images/"+newProduct.getProductId()+".png"));
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
				}
		}

		productService.addProduct(newProduct);
		return "redirect:/products";
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidProductId", exception.getProductId());
		mav.addObject("exception",exception);
		mav.addObject("url", req.getRequestURL()+"?"+req.getQueryString());
		mav.setViewName("productNotFound");
		return mav;
	}

	

}