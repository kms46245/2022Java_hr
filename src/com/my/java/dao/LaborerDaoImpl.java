package com.my.java.dao;

import java.time.LocalDate;
import java.util.List;

import com.my.java.domain.Laborer;

public class LaborerDaoImpl implements LaborerDao{
	private List<Laborer> laborers;
	private int laborerIdSeq;		//id������ ����۾��̾ƴ� ������ �̵������̶�� �����ߴ�.
	
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
		
		// ���ؼ� id�� ��ġ�ϸ� �ش� id�� �뵿�ڸ� �����ͼ� ����
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
		if(laborer != null)	laborers.remove(laborer);	// remove(��ü)�� �̿��� id�� �������ʿ���� ���� ����
	}
}
