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
import com.myPackage.utility.HibernateUtil;

/**
 * Servlet implementation class ReadMasterTable
 */
@WebServlet("/read-master-table")
public class ReadMasterTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadMasterTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<html><body><h1>Master Table :-</h1>");
		out.println("<style> table,td,th{border:2px solid green;padding:10px;}</style>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Class ID</th>");
		out.println("<th>Class Name</th>");
		out.println("<th>Subjects</th>");
		out.println("<th>Teachers</th>");
		out.println("<th>Students</th>");
		out.println("</tr>");
		SessionFactory sf=HibernateUtil.buildSessionFactory();
		Session session=sf.openSession();
		List<Classes> CL=session.createQuery("from Classes").list();
		if(CL != null && CL.size()>0) {
			for(Classes cl : CL) {
				out.println("<tr>");
				out.println("<td>"+cl.getClass_id()+"</td>");
				out.println("<td>"+cl.getClass_name()+"</td>");
				out.println("<td>"+cl.getSubjectsString()+"</td>");
				out.println("<td>"+cl.getTeachersString()+"</td>");
				
				out.println("<td>"+cl.getStudentsString()+"</td>");
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
