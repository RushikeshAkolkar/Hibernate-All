//main method
package First.Hiberna;
//video - 9

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FatchDemo {

	public static void main(String[] args) {
		// get , load
		Configuration cfg = new Configuration();
        cfg.configure("First/Hiberna/hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
       
        Student s = session.load(Student.class, 1);    //In replace of get we can use load method 
        System.out.println(s);
        
        Address ad = session.get(Address.class,1);
        System.out.println(ad.getCity());
        factory.close();
	}
}
