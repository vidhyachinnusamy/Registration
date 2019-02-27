package org.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.cts.bean.Emp;
import org.cts.util.DBConstants;
import org.cts.util.DBUtil;

public class EmpDaoImpl implements EmpDao {

	@Override
	public boolean insert(Emp e) {
		Connection con=null;
		PreparedStatement pst=null;
		boolean b=false;
		try {
			con=DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL, DBConstants.UNAME, DBConstants.PWD);
			pst=con.prepareStatement("insert into emp(eno,name,address,gender) values(?,?,?,?)");
			pst.setInt(1, e.getEno());
			pst.setString(2, e.getName());
			pst.setString(3, e.getAddress());
			pst.setString(4, e.getGender());
			int r=pst.executeUpdate();
			
			if(r>0)
				b=true;
			else
				b=false;
			con.close();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return b;
	}

}
