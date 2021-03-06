package com.myPackage.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * Servlet implementation class ReadStudentTable
 */
@WebServlet("/read-student-table")
public class ReadStudentTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadStudentTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<html><body><h1>Student Table :-</h1>");
		out.println("<style> table,td,th{border:2px solid green;padding:10px;}</style>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Student ID</th>");
		out.println("<th>Student Name</th>");
		out.println("<th>Email</th>");
		out.println("<th>Class alloted</th>");
		out.println("</tr>");
		SessionFactory sf=HibernateUtil.buildSessionFactory();
		Session session=sf.openSession();
		List<Student> S=session.createQuery("from Student").list();
		if(S != null && S.size()>0) {
			for(Student s : S) {
				out.println("<tr>");
				out.println("<td>"+s.getStudent_id()+"</td>");
				out.println("<td>"+s.getName()+"</td>");
				out.println("<td>"+s.getEmail()+"</td>");
				Classes ob=s.getAlloted_class();
				out.println("<td>"+ob.getClass_name()+"</td>");
				out.println("</tr>");
			}
		}
		out.println("</table>");
		out.println("<br><p><a href='index.html'> Click here </a> to return to dashboard</p>");
		out.println("</body></html>");
		out.close();
		session.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*int x=Integer.parseInt(request.getParameter("studentId"));
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		out.println("<b>"+x+"</b>");
		out.println("</body></html>");
		
		SessionFactory sf=HibernateUtil.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Student student=(Student)session.get(Student.class, x);
		session.delete(student);
		tx.commit();
		session.close();*/
		doGet(request, response);
		
	}

}
