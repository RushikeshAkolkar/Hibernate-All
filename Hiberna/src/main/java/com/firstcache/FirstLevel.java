package com.firstcache;

import com.hql.Student;
import com.sql.*;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FirstLevel {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
        cfg.configure("com/firstcache/hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Session session = factory.openSession();
        Student student = session.get(Student.class,50);

        System.out.println(student);
        factory.close();
	}

}
