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
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/delete-student")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudent() {
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
				Classes ob=s.getAlloted_class();
				out.println("<td>"+ob.getClass_name()+"</td>");
				out.println("</tr>");
			}
		}
		out.println("</table>");
		out.println("<br><br>DELETE STUDENT<br><form action='delete-student' method='post'>");
		out.println("Enter Id : <input type=\"text\" name=\"studentId\"/>");
		out.println("<input type=\"submit\" value=\"Delete Student\">");
		out.println("</form>");
		out.println("</body></html>");
		out.close();
		session.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("studentId"));
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		SessionFactory sf=HibernateUtil.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Student ob=(Student)session.load(Student.class, id);
		session.delete(ob);
		tx.commit();
		session.close();
		out.println("Data successfully deleted");
		out.println("<p><a href='read-student-table'> Click here </a> to show all student table</p>");
		out.println("</body></html>");
		
	}

}
