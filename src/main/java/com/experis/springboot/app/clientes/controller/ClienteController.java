package com.experis.springboot.app.clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.experis.springboot.app.clientes.models.entity.Cliente;
import com.experis.springboot.app.clientes.models.request.ClienteRequest;
import com.experis.springboot.app.clientes.models.request.KpiClientesRequest;
import com.experis.springboot.app.clientes.models.service.IClienteService;

@RestController
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	
	@PostMapping("/crearcliente")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente crearCliente(@RequestBody Cliente cliente) {
		return clienteService.crearCliente(cliente);
	}
	
	@GetMapping("/kpideclientes")
	@ResponseStatus(HttpStatus.OK)
	public KpiClientesRequest obtenerPKIClientes() {
		return clienteService.obtenerKPIClientes();
	}
	
	@GetMapping("/listclientes")
	@ResponseStatus(HttpStatus.OK)
	public List<ClienteRequest> listarClientes() {
		return clienteService.listarAll();
	}
	
}
