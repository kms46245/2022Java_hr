package com.my.java;

import java.util.ArrayList;
import java.util.List;

import com.my.java.dao.LaborerDao;
import com.my.java.dao.LaborerDaoImpl;
import com.my.java.domain.Laborer;
import com.my.java.presentation.Console;
import com.my.java.presentation.LaborerIo;
import com.my.java.service.LaborerService;
import com.my.java.service.LaborerServiceImpl;

public class Main {
	public static void main(String[] args) {
		List<Laborer> laborers = new ArrayList<>();
		
		LaborerDao laborerDao = new LaborerDaoImpl(laborers);
		LaborerService laborerService = new LaborerServiceImpl(laborerDao);
		LaborerIo laborerIo = new LaborerIo(laborerService);
		
		laborerIo.play();
		Console.info("³¡.");
	}
}
