package com.myPackage.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.myPackage.entitys.Classes;
import com.myPackage.entitys.Student;
import com.myPackage.utility.HibernateUtil;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/add-student")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add-student.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student=new Student();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		int cid=Integer.parseInt(request.getParameter("class"));
		
		SessionFactory sf=HibernateUtil.buildSessionFactory();
		Session session=sf.openSession();
		
		Transaction tx=session.beginTransaction();
		Classes ob=session.get(Classes.class,cid);
		student.setName(name);
		student.setEmail(email);
		student.setAlloted_class(ob);
		session.save(student);
		tx.commit();
		session.close();
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		out.println("Data successfully added");
		out.println("<p><a href='read-student-table'> Click here </a> to show all student table</p>");
		out.println("</body></html>");
		
		
	}
	

}
