package com.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {
	public static void main(String args[])
	{
		Configuration cfg = new Configuration();
        cfg.configure("com/manytomany/hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Employee e1 = new Employee();
        
        Employee e2 = new Employee();
        
        e1.setEid(11);
        e1.setName("Rushi");
        
        e2.setEid(22);
        e2.setName("Rahul");
        
        Project p1 = new Project();
        
        Project p2 = new Project();
        
        p1.setPid(33);
        p1.setPname("Billing");
        
        p2.setPid(44);
        p2.setPname("Employee Payroll");
        
        List<Employee> elist = new ArrayList<Employee>();
        List<Project> plist = new ArrayList<Project>();
        
        elist.add(e1);
        elist.add(e2);
        
        plist.add(p1);
        plist.add(p2);
        
        e1.setPro(plist);
        p2.setEmps(elist);
        
        Session s = factory.openSession();
        
        Transaction tx = s.beginTransaction();

        s.save(e1);
        s.save(e2);
        s.save(p1);
        s.save(p2);
        
        tx.commit();
        factory.close();
	}
}

