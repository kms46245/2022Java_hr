package com.my.java.dao;

import java.time.LocalDate;
import java.util.List;

import com.my.java.domain.Laborer;

public class LaborerDaoImpl implements LaborerDao{
	private List<Laborer> laborers;
	private int laborerIdSeq;		//id생성을 계산작업이아닌 데이터 이동과정이라고 생각했다.
	
	public LaborerDaoImpl(List<Laborer> laborers) {
		this.laborers = laborers;
		this.laborerIdSeq = 1;
	}
	@Override
	public List<Laborer> selectLaborers(){
		return laborers;
	}
	
	@Override
	public Laborer selectLaborer(int laborerId) {
		Laborer laborer = null;
		
		// 비교해서 id가 일치하면 해당 id의 노동자를 가져와서 리턴
		for(Laborer laborerTmp: laborers) {
			if(laborerTmp.getLaborerId() == laborerId) {
				laborer = laborerTmp;
				break;
			}
		}
		
		return laborer;
	}
	
	@Override
	public void insertLaborer(String laborerName, LocalDate HireDate) {
		laborers.add(new Laborer(laborerIdSeq++,laborerName,HireDate));
	}
	
	@Override
	public void updateLaborer(Laborer laborerTmp) {
		laborers.forEach(laborer -> {
			if(laborer.getLaborerId() == laborerTmp.getLaborerId()) {
				laborer.setName(laborerTmp.getName());
				laborer.setHireDate(laborerTmp.getHireDate());
			}
		});		
	}
	
	@Override
	public void deleteLaborer(int laborerId) {
		Laborer laborer = null;
		laborer = selectLaborer(laborerId);
		if(laborer != null)	laborers.remove(laborer);	// remove(객체)를 이용해 id로 삽질할필요없이 직접 선택
	}
}
