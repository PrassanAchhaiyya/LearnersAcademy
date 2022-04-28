package com.myPackage.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.myPackage.entitys.Classes;
import com.myPackage.entitys.Student;
import com.myPackage.entitys.Subjects;
import com.myPackage.entitys.Teacher;

public class HibernateUtil {
static SessionFactory sessionFactory=null;
	
	public static SessionFactory buildSessionFactory() {
		sessionFactory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Classes.class).addAnnotatedClass(Subjects.class).addAnnotatedClass(Teacher.class).addAnnotatedClass(Student.class)
				.buildSessionFactory();
		return sessionFactory;
	}

}

