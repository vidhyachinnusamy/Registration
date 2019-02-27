package org.cts.services;

import org.cts.bean.Emp;
import org.cts.dao.EmpDao;
import org.cts.dao.EmpDaoImpl;

public class ServiceImpl implements EmpService {
	EmpDao dao=new EmpDaoImpl();
	
	@Override
	public boolean register(Emp e) {
		boolean res=dao.insert(e);
		return res;
	}

}
