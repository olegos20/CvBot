package com.oleh.model;
import com.oleh.entity.EnEntity;
import com.oleh.entity.RusEntity;
import com.oleh.entity.UaEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
public class HibernateUtil {
   static String out;
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;
    private static SessionFactory buildSessionFactory() {
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }
    public static void CVua() {
        int id;
        UaEntity uaEntity;
        try {
            sessionObj = buildSessionFactory().openSession();
            id=1;
           uaEntity = (UaEntity) sessionObj.get(UaEntity.class, new Integer(id));
            if(uaEntity != null) {
                out= uaEntity.getCv();
            }
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }
public static void CVen(){
    int id;
    EnEntity enEntity;
    try {
        sessionObj = buildSessionFactory().openSession();
        id=1;
        enEntity = (EnEntity) sessionObj.get(EnEntity.class, new Integer(id));
        if(enEntity != null) {
            System.out.println( enEntity.toString());
            out= enEntity.getCv();
        }
    } catch(Exception sqlException) {
        if(null != sessionObj.getTransaction()) {
            System.out.println("\n.......Transaction Is Being Rolled Back.......");
            sessionObj.getTransaction().rollback();
        }
        sqlException.printStackTrace();
    } finally {
        if(sessionObj != null) {
            sessionObj.close();
        }
    }
}
    public static void CVrus(){
        int id;
        RusEntity rusEntity;
        try {
            sessionObj = buildSessionFactory().openSession();
            id=1;
            rusEntity = (RusEntity) sessionObj.get(RusEntity.class, new Integer(id));
            if(rusEntity != null) {
                System.out.println( rusEntity.toString());
                out= rusEntity.getCv();
            }
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }
    public static void infoUa(){
        int id;
        UaEntity uaEntity;
        try {
            sessionObj = buildSessionFactory().openSession();
            id=1;
            uaEntity = (UaEntity) sessionObj.get(UaEntity.class, new Integer(id));
            if(uaEntity != null) {
                out= uaEntity.getInfo();
            }
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }
    public static void infoEn(){
        int id;
        EnEntity enEntity;
        try {
            sessionObj = buildSessionFactory().openSession();
            id=1;
            enEntity = (EnEntity) sessionObj.get(EnEntity.class, new Integer(id));
            if(enEntity != null) {
                out= enEntity.getInfo();
            }
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }
    public static void infoRus(){
        int id;
        RusEntity rusEntity;
        try {
            sessionObj = buildSessionFactory().openSession();
            id=1;
            rusEntity = (RusEntity) sessionObj.get(RusEntity.class, new Integer(id));
            if(rusEntity != null) {
                out= rusEntity.getInfo();
            }
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }
    public static void contactEn(){
        int id;
        EnEntity enEntity;
        try {
            sessionObj = buildSessionFactory().openSession();
            id=1;
            enEntity = (EnEntity) sessionObj.get(EnEntity.class, new Integer(id));
            if(enEntity != null) {
                out= enEntity.getContact();
            }
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }
    public static void contactRus(){
        int id;
        RusEntity rusEntity;
        try {
            sessionObj = buildSessionFactory().openSession();
            id=1;
            rusEntity = (RusEntity) sessionObj.get(RusEntity.class, new Integer(id));
            if(rusEntity != null) {
                out= rusEntity.getContact();
            }
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }
    public static void contactUa(){
        int id;
        UaEntity uaEntity;
        try {
            sessionObj = buildSessionFactory().openSession();
            id=1;
            uaEntity = (UaEntity) sessionObj.get(UaEntity.class, new Integer(id));
            if(uaEntity != null) {
                out= uaEntity.getContact();
            }
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }
}
