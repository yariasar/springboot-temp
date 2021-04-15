package com.experis.springboot.app.clientes.models.service;

import java.util.List;

import com.experis.springboot.app.clientes.models.entity.Cliente;
import com.experis.springboot.app.clientes.models.request.ClienteRequest;
import com.experis.springboot.app.clientes.models.request.KpiClientesRequest;

public interface IClienteService {
	public Cliente crearCliente(Cliente cliente);
	public KpiClientesRequest obtenerKPIClientes();
	public List<ClienteRequest> listarAll();
}
