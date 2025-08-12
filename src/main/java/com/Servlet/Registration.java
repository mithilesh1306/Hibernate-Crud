package com.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.Userdao.UserDao;
import com.model.StudentInfo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
		String path=request.getServletPath();
		switch(path)
		{
		case "/insert":insert(request,response);
		break;
		case "/view":view(request,response);
		break;
		case "/delete":delete(request,response);
		break;
		case "/edit":edit(request,response);
		break;
		case "/update":update(request,response);
		break;
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void insert(HttpServletRequest request, HttpServletResponse response)
	{
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		
		StudentInfo sf=new StudentInfo();
	    sf.setName(name);
		sf.setAge(age);
		
		UserDao user=new UserDao();
		user.saveUser(sf);
		try {
			response.sendRedirect("index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void view(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("inside view");
		UserDao dao=new UserDao();
		List<StudentInfo> user= dao.getAll();
		
		request.setAttribute("User",user);
		RequestDispatcher rd=request.getRequestDispatcher("list.jsp");
		try {
			rd.forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void delete(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("inside delete");
		int id=Integer.parseInt(request.getParameter("id"));
		UserDao user=new UserDao();
	    user.deleterow(id);
	    RequestDispatcher rd=request.getRequestDispatcher("view");
		try {
			rd.forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		} 
	}
	
	public void edit(HttpServletRequest request, HttpServletResponse response)
	{
	    int id = Integer.parseInt(request.getParameter("id"));
	    
	    UserDao userDao = new UserDao();
	    StudentInfo student = userDao.getById(id);  

	    request.setAttribute("student", student);

	    RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
	    try {
	        rd.forward(request, response);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	public void update(HttpServletRequest request, HttpServletResponse response)
	{
	    int id = Integer.parseInt(request.getParameter("id"));
	    String name = request.getParameter("name");
	    int age = Integer.parseInt(request.getParameter("age"));

	    StudentInfo student = new StudentInfo();
	    student.setId(id);
	    student.setName(name);
	    student.setAge(age);

	    UserDao dao = new UserDao();
	    dao.updateStudent(student);

	    try {
	        response.sendRedirect("view");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


}
