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

import com.myPackage.entitys.Classes;
import com.myPackage.entitys.Subjects;
import com.myPackage.entitys.Teacher;
import com.myPackage.utility.HibernateUtil;

/**
 * Servlet implementation class ReadTeacherTable
 */
@WebServlet("/read-teacher-table")
public class ReadTeacherTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadTeacherTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<html><body><h1>Teacher Table :-</h1>");
		out.println("<style> table,td,th{border:2px solid green;padding:10px;}</style>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Teacher ID</th>");
		out.println("<th>Teacher Name</th>");
		out.println("<th>Classes Alotted</th>");
		out.println("<th>Subjects Alloted</th>");
		//out.println("<th>Student Courses</th>");
		out.println("</tr>");
		SessionFactory sf=HibernateUtil.buildSessionFactory();
		Session session=sf.openSession();
		List<Teacher> teachers=session.createQuery("from Teacher").list();
		if(teachers != null && teachers.size()>0) {
			for(Teacher t : teachers) {
				out.println("<tr>");
				out.println("<td>"+t.getTeacher_id()+"</td>");
				out.println("<td>"+t.getTeacher_name()+"</td>");
				
				List<Classes> cl=t.getClass_alot();
				StringBuilder sb=new StringBuilder();
				for(Classes c: cl) {
					sb.append(c.getClass_name()+"<br>");
				}
				sb.toString();
				out.println("<td>"+sb+"</td>");
				
				List<Subjects> sub=t.getSubjects();
				StringBuilder sb1=new StringBuilder();
				for(Subjects s: sub) {
					sb1.append(s.getSubject_name()+"<br>");
				}
				sb1.toString();
				out.println("<td>"+sb1+"</td>");
				
				//out.println("<td>"STUDENT STRING"</td>");
				out.println("</tr>");
			}
		}
		out.println("</table></body></html>");
		out.close();
		session.close();
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
