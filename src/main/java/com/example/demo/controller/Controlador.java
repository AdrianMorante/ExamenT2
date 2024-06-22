package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.interfaceService.IProductoService;
import com.example.demo.modelo.Producto;

@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private IProductoService service;
	
	//Listar
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Producto> productos = service.listar();
		model.addAttribute("producto",productos);
		return "index";
	}
	
	//Agregar - Nuevo
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("producto",new Producto());
		return "form";
	}
	
	//guardar actualizacion(editar)
	@PostMapping("/save")
	public String save(@Validated Producto p, Model model) {
		service.save(p);
		return "redirect:/listar";
	}
	
	//editar
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Producto>producto=service.listarId(id);
		model.addAttribute("producto",producto);
		return "Form";
	}
	
		//eliminar
		@GetMapping("/eliminar/{id}")
		public String delete(Model model, @PathVariable int id) {
			service.delete(id);
			return "redirect:/listar";
		}
	//Adrian MOrante Quispe	
	
	

}
