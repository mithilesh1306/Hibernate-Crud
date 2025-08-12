package com.Userdao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    
	public static SessionFactory getSessionFactory()
	{
		Configuration con=new Configuration();
		con.configure();
		SessionFactory sf=con.buildSessionFactory();
		return sf;
	}
}
