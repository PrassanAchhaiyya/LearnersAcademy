package com.myPackage.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import com.myPackage.entitys.Subjects;
import com.myPackage.entitys.Teacher;
import com.myPackage.utility.HibernateUtil;

/**
 * Servlet implementation class UpdateTeacherTable
 */
@WebServlet("/update-teacher-table")
public class UpdateTeacherTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTeacherTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		SessionFactory sf=HibernateUtil.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		
		Classes classObject=(Classes)session.get(Classes.class, 7);
		Teacher[] arr=classObject.getTeachers();
		
		Teacher teacherObject=session.get(Teacher.class, 12);
		Subjects subject=session.get(Subjects.class, 10);
		subject.setTeacher(teacherObject);
		session.saveOrUpdate(subject);
		arr[0]=teacherObject;
		classObject.setTeachers(arr);
		session.saveOrUpdate(classObject);
		tx.commit();
		session.close();
		*/
		int classId=Integer.parseInt(request.getParameter("class"));
		int subjectId=Integer.parseInt(request.getParameter("subject"));
		int teacherId=Integer.parseInt(request.getParameter("teacher"));
		int subOrder=getOrder(subjectId,classId);
		
		SessionFactory sf=HibernateUtil.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		
		Classes classObject=(Classes)session.get(Classes.class, classId);
		Teacher[] arr=classObject.getTeachers();
		Teacher teacherObject=session.get(Teacher.class, teacherId);
		Subjects subject=session.get(Subjects.class, subjectId);
		subject.setTeacher(teacherObject);
		session.saveOrUpdate(subject);
		arr[subOrder]=teacherObject;
		classObject.setTeachers(arr);
		session.saveOrUpdate(classObject);
		tx.commit();
		session.close();
		
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		out.println("Data successfully updated");
		out.println("<p><a href='index.html'> Click here </a> to return to dashboard</p>");
		out.println("</body></html>");
		
		
		
	}
	public int getOrder(int x,int c) {
		if(x==2 && c==1) {
			return 0;
		}else if(x==4 && c==1) {
			return 1;
		}else if(x==5 && c==1){
			return 2;
		}else if(x==8 && c==7) {
			return 0;
		}else if(x==10 && c==7) {
			return 1;
		}else if(x==11 && c==7) {
			return 2;
		}else if(x==14 && c==13) {
			return 0;
		}else if(x==16 && c==13) {
			return 1;
		}else if(x==17 && c==13) {
			return 2;
		}else {
			return -1;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
