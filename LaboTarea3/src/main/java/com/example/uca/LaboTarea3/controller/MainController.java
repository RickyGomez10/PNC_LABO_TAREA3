package com.example.uca.LaboTarea3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.uca.LaboTarea3.domain.Product;

@Controller
public class MainController {
	
	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/compraProducto")
	public ModelAndView compraProducto() {
		productos.clear();
	ModelAndView mav = new ModelAndView();
	
	productos.add(new Product(0, "GTA5", 10));
	productos.add(new Product(1, "Papitas", 20));
	productos.add(new Product(2, "Chocolates", 30));
	productos.add(new Product(3, "Dulces", 40));
	mav.setViewName("select");
	mav.addObject("product", new Product());
	mav.addObject("producto", productos);
	
	return mav;
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product producto) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("p", productos.get(producto.getId()).getNombre());
		
		
		if( producto.getCantidad() > productos.get(producto.getId()).getCantidad()) {
			mav.setViewName("error");
			return mav;
		}else {
			mav.setViewName("compra");
			return mav;
				
		}
		
		
		
	}
}
