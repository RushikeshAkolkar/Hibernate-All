package First.Hiberna;
//video - 10
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EMDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
        cfg.configure("First/Hiberna/hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Student s = new Student();
        s.setId(111);
        s.setName("Rahul");
        s.setCity("pune");
        
        Certificate c = new Certificate();
        c.setCources("Andriod");
        c.setDuration("2 Months");
        
        s.setCerti(c);
        
        Student s1 = new Student();
        s1.setId(222);
        s1.setName("Gandhi");
        s1.setCity("Gujrat");
        
        Certificate c1 = new Certificate();
        c1.setCources("Java");
        c1.setDuration("1.2 Month");
        
        s1.setCerti(c1);
        
        Session sess = factory.openSession();
        
        Transaction tx = sess.beginTransaction();
        
        //object save
        sess.save(s);
        sess.save(s1);
        
        
        tx.commit();
        sess.close();
        sess.close();

	}

}
