package com.experis.springboot.app.clientes.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.experis.springboot.app.clientes.models.entity.Cliente;

public class UtilNumber {
	public static Random random = new Random();
	public static DateFormat dateTimeFormatDefault = new SimpleDateFormat("yyyy-MM-dd");
	
	public static double promedio(List<Cliente> clientes) {
		double promedio =  0;
		int sumaEdades = 0;
		
		for (Cliente cliente : clientes) {
			sumaEdades += cliente.getEdad();
		}
		
		if(sumaEdades != 0)
			promedio = ((double)sumaEdades / (double)clientes.size());
		
		return promedio;
	}
	
	public static int randInt(int min, int max) {
		int randNum = random.nextInt((max - min) + 1) + min;
		return randNum;
	}
	
	public static String fechaProbable(int edad) {
		int anioProbVida = 85;
		int maxProbVida = anioProbVida - edad;
		int diasMaxProbVida = 0;
		int diasProVida = 0;
		
		if(maxProbVida > 0) {
			diasMaxProbVida = maxProbVida * 365;
			diasProVida = randInt(1, diasMaxProbVida);
		} else {
			diasProVida = randInt(1, 100);
		}
		
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_YEAR, diasProVida);
		
		return dateTimeFormatDefault.format(c.getTime());
	}
}
