package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceService.IProductoService;
import com.example.demo.interfaces.IProducto;
import com.example.demo.modelo.Producto;

@Service
public class ProductoService implements IProductoService{
	@Autowired
	private IProducto data;
	
	//listar
	@Override
	public List<Producto> listar() {
		return (List<Producto>) data.findAll();
	}

	@Override
	public Optional<Producto> listarId(int id) {
		return data.findById(id);
	}
	
	//guardar
	@Override
	public int save(Producto p) {
		int res=0;
		Producto producto = data.save(p);
		if(!producto.equals(null)) {
			res = 1;
		}
		return res;
	}
	
	//eliminar
	@Override
	public void delete(int id) {
		data.deleteById(id);
	}
	//Adrian Morante Quispe
	
	
}
