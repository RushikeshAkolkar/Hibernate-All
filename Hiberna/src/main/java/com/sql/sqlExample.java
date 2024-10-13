package com.sql;

//video 24
import com.sql.Student;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class sqlExample {

	public static void main(String[] args) {
		SessionFactory sessionfac = new Configuration().configure("com/sql/hibernate.cfg.xml").buildSessionFactory();
		Session s = sessionfac.openSession();
		
		
		//this is sql query
		String q = "select * from student";
		
		NativeQuery nq = s.createSQLQuery(q);
		
		List<Object[]> li = nq.list();
		
		for(Object[] st : li)
		{
//			System.out.println(Arrays.deepToString(st));
			System.out.println(st[4]+"  :  "+st[3]);
		}
		
		s.close();
		sessionfac.close();
	}

}
