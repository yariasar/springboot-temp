package com.experis.springboot.app.clientes.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.experis.springboot.app.clientes.models.dao.ClienteDao;
import com.experis.springboot.app.clientes.models.entity.Cliente;
import com.experis.springboot.app.clientes.models.request.ClienteRequest;
import com.experis.springboot.app.clientes.models.request.KpiClientesRequest;
import com.experis.springboot.app.clientes.util.UtilNumber;

@Service
public class ClienteService implements IClienteService{

	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	@Transactional
	public Cliente crearCliente(Cliente cliente) {
		
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public KpiClientesRequest obtenerKPIClientes() {
		double sum = 0;
		double desviacion = 0;
		
		List<Cliente> listaClientes = (List<Cliente>) clienteDao.findAll();
		double promedio = UtilNumber.promedio(listaClientes);
		
		for (Cliente cliente : listaClientes) {
			sum += Math.pow ( (double) cliente.getEdad() - promedio, 2 );		
		}
		
		if(sum != 0)
			desviacion = Math.sqrt ( sum / ( double ) listaClientes.size() );
		
		KpiClientesRequest response = new KpiClientesRequest();
		response.setPromedio(promedio);
		response.setDesviacion(desviacion);
		
		return response;
	}

	@Transactional(readOnly = true)
	public List<ClienteRequest> listarAll() {
		List<Cliente> listaClientes = (List<Cliente>) clienteDao.findAll();
		
		List<ClienteRequest> lista = listaClientes.stream().map( p -> new ClienteRequest(p.getNombre(), 
				p.getApellido(), p.getEdad(), p.getFechaNacimiento(), UtilNumber.fechaProbable(p.getEdad())))
				.collect(Collectors.toList());
		
		return lista;
	}

}
