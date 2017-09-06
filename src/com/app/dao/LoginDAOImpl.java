package com.app.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.UserDetails;
import com.app.utils.ConnectionUtils;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public Long save(UserDetails entity) {
		System.out.println("save() - start");
		Long id = null;
		Session session = null;
		Transaction tx = null;
		try {
			session = ConnectionUtils.getInstance();
			tx = session.beginTransaction();
			id = (Long) session.save(entity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("save() - end");
		return id;
	}

	public static void main(String [] args){
		LoginDAOImpl obj = new LoginDAOImpl();
		UserDetails entity = new UserDetails(null,"vishnu","Secure*123","vishnu.awasthi.dev9@gmail.com");
		Long id =obj.save(entity);
		System.out.println("ID : "+id);
	}
}
