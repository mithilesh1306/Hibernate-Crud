package com.Userdao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.StudentInfo;

import com.Userdao.HibernateUtil;


public class UserDao{
	Transaction Tx=null;
	public void saveUser(StudentInfo student)
	{
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session s=sf.openSession();
			Transaction Tx=s.beginTransaction();
			s.save(student);
			Tx.commit();
			if(Tx!=null)
			{
				System.out.println("Sucessfull");
			}
		
	}
	
	public List<StudentInfo> getAll()
	{
		try
		{
			SessionFactory sf= HibernateUtil.getSessionFactory();
			Session session=sf.openSession();
			List<StudentInfo> list=session.createQuery("from StudentInfo",StudentInfo.class).list();
			session.close();
			return list;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
		
	}
	public void deleterow(int id)
	{
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			System.out.println("inside deleterow");
			Transaction Tx=session.beginTransaction();
			StudentInfo student=session.get(StudentInfo.class,id);
			if(student!=null)
			{
				System.out.println("inside null");
				session.delete(student);
				Tx.commit();
				System.out.println("deleted successfully");
			}
			else
			{
				System.out.println("not found the id which is entered");
			}
		}
	}
	
	public StudentInfo getById(int id) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        
	    	StudentInfo s=session.get(StudentInfo.class, id);
	    	return s;
	    }
	}
	public void updateStudent(StudentInfo student)
	{
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        Transaction tx = session.beginTransaction();
	        session.update(student);
	        tx.commit();
	        System.out.println("Student updated successfully");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}



}