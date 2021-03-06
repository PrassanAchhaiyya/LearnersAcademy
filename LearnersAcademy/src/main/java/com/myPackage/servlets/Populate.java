package com.myPackage.servlets;

import java.io.IOException;
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
import com.myPackage.entitys.Student;
import com.myPackage.utility.HibernateUtil;
import com.myPackage.utility.PopulateData;

/**
 * Servlet implementation class Populate
 */
@WebServlet("/populate")
public class Populate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Populate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory sf=HibernateUtil.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Classes web=(Classes)session.get(Classes.class, 1);
		Classes core=(Classes)session.get(Classes.class, 7);
		Classes prog=(Classes)session.get(Classes.class, 13);
		Student ram=new Student("Ram K","ram@gmail.com",web);
		Student abhinav=new Student("Abhinav G","abi@gmail.com",web);
		Student sanjay=new Student("Sanjay M","iamsanjay@gmail.com",web);
		Student vivek=new Student("Vivek N","vivek@gmail.com",web);
		Student santosh=new Student("Santosh","santosh@yahoo.com",web);
		List<Student> webStud=new ArrayList<>();
		webStud.add(ram);
		webStud.add(abhinav);
		webStud.add(sanjay);
		webStud.add(vivek);
		webStud.add(santosh);
		web.setStudents(webStud);
		
		Student tony=new Student("Tony","tony@gmail.com",core);
		Student madhu=new Student("Madhu G","mad@gmail.com",core);
		Student sharlin=new Student("Sharlin S","iamsharlin@gmail.com",core);
		Student ruchi=new Student("Ruchi","ruchi@gmail.com",core);
		Student rachana=new Student("Rachana B","rachanab@gmail.com",core);
		List<Student> coreStud=new ArrayList<>();
		coreStud.add(tony);
		coreStud.add(madhu);
		coreStud.add(sharlin);
		coreStud.add(ruchi);
		coreStud.add(rachana);
		core.setStudents(coreStud);
		
		Student surya=new Student("Surya G","surya@gmail.com",prog);
		Student vinod=new Student("Vinod K","vinod@gmail.com",prog);
		Student prajwal=new Student("Prajwal R","prajwal@gmail.com",prog);
		Student rohan=new Student("Rohan W","rohanw@gmail.com",prog);
		Student anand=new Student("Anand C","chenga@gmail.com",prog);
		Student shekar=new Student("Shekar K","shekar@gmail.com",prog);
		List<Student> progStud=new ArrayList<>();
		progStud.add(surya);
		progStud.add(vinod);
		progStud.add(prajwal);
		progStud.add(rohan);
		progStud.add(anand);
		progStud.add(shekar);
		prog.setStudents(progStud);
		
		session.saveOrUpdate(web);
		session.saveOrUpdate(core);
		session.saveOrUpdate(prog);
		tx.commit();
		
		//DeleteStudent
		
		/*
		SessionFactory sf=HibernateUtil.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Student ob=(Student)session.load(Student.class, 104);
		session.delete(ob);
		tx.commit();
		session.close();
		*/
		
		//populateData();
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void populateData() {
		PopulateData populateData = new PopulateData();
		populateData.hardPopulate();
	}

}
