package First.Hiberna;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

//   1 to 7
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "com/tut/ProjectHiber/Project Started" );
//        video - 5
        Configuration cfg = new Configuration();
        cfg.configure("First/Hiberna/hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
//        System.out.println(factory);
//        System.out.println(factory.isClosed());
        
        
        
        Student s = new Student();
        s.setId(1);
        s.setName("Rahul");
        s.setCity("pune");
        System.out.println(s);
        
        Certificate c= new Certificate();
        c.setCources("java");
        c.setDuration("6 Months");
        
        s.setCerti(c);
        
//        creating object of address class
        Address a = new Address();
        a.setStreet("Savedi");
        a.setCity("Ahmednagar");
        a.setOpen(true);
        a.setAddedDate(new Date());
        a.setX(123.56);
        
//        reading Image
        FileInputStream fs = new FileInputStream("src/main/java/11.png");
        byte[] data = new byte[fs.available()];
        fs.read(data);
        a.setImg(data);
        		
       Session session = factory.openSession();
       Transaction tx = session.beginTransaction();
       session.save(s);
       session.save(a);
       tx.commit();
       
//       session.getTransaction();
       session.close();
       System.out.println("Done");
    }
}