package com.myPackage.utility;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.myPackage.entitys.Classes;
import com.myPackage.entitys.Subjects;
import com.myPackage.entitys.Teacher;

public class PopulateData {
	public void hardPopulate() {
		/*
		public Classes(String class_name, Subjects[] subjects, Teacher[] teachers) {
			super();
			this.class_name = class_name;
			this.subjects = subjects;
			this.teachers = teachers;
		}*/
		Classes WEB =new Classes();
		WEB.setClass_name("WEB DEVELOPMENT");
		Classes core=new Classes();
		core.setClass_name("CORE COMPUTER SCIENCE");
		Classes languages=new Classes();
		languages.setClass_name("PROGRAMMING LANGUAGES");
		
		//3 classes objects
		
		/*
		public Subjects(String subject_name, Classes class_alotted, Teacher teacher) {
			super();
			this.subject_name = subject_name;
			this.class_alotted = class_alotted;
			this.teacher = teacher;
		}*/
		//3 web subjects
		Subjects html =new Subjects();
		html.setSubject_name("HTML");
		html.setClass_alotted(WEB);
		Subjects css=new Subjects();
		css.setSubject_name("CSS");
		css.setClass_alotted(WEB);
		Subjects javascript=new Subjects();
		javascript.setSubject_name("JAVASCRIPT");
		javascript.setClass_alotted(WEB);
		
		//3 core subjects
		Subjects datastructures=new Subjects();
		datastructures.setSubject_name("DATA STRUCTURES");
		datastructures.setClass_alotted(core);
		Subjects ada=new Subjects();
		ada.setSubject_name("ADA");
		ada.setClass_alotted(core);
		Subjects tfcs=new Subjects();
		tfcs.setSubject_name("TFCS");
		tfcs.setClass_alotted(core);
		
		//3 programming subjects
		Subjects cpp=new Subjects();
		cpp.setSubject_name("C++");
		cpp.setClass_alotted(languages);
		Subjects java=new Subjects();
		java.setSubject_name("JAVA");
		java.setClass_alotted(languages);
		Subjects python=new Subjects();
		python.setSubject_name("PYTHON");
		python.setClass_alotted(languages);
		
		/*
		public Teacher(String teacher_name, List<Subjects> subjects, List<Classes> class_alot) {
			super();
			this.teacher_name = teacher_name;
			this.subjects = subjects;
			this.class_alot = class_alot;
		}*/
		
		//3 teachers for now
		Teacher ramesh =new Teacher();
		ramesh.setTeacher_name("RAMESH");
		List<Subjects> rameshSubjects= new ArrayList<>();
		rameshSubjects.add(css);
		rameshSubjects.add(html);
		//rameshSubjects.add(javascript);
		ramesh.setSubjects(rameshSubjects);
		List<Classes> rameshClasses= new ArrayList<>();
		rameshClasses.add(WEB);
		ramesh.setClass_alot(rameshClasses);
		
		Teacher meganadh=new Teacher();
		meganadh.setTeacher_name("MEGANADH");
		List<Subjects> meganadhSubjects= new ArrayList<>();
		meganadhSubjects.add(javascript);
		meganadh.setSubjects(meganadhSubjects);
		List<Classes> meganadhClasses= new ArrayList<>();
		meganadhClasses.add(WEB);
		meganadh.setClass_alot(meganadhClasses);
		
		Teacher gururaj =new Teacher();
		gururaj.setTeacher_name("GURURAJ");
		List<Subjects> gururajSubjects= new ArrayList<>();
		gururajSubjects.add(datastructures);
		gururajSubjects.add(ada);
		//gururajSubjects.add(tfcs);
		gururaj.setSubjects(gururajSubjects);
		List<Classes> gururajClasses= new ArrayList<>();
		gururajClasses.add(core);
		gururaj.setClass_alot(gururajClasses);
		
		Teacher vignesh=new Teacher();
		vignesh.setTeacher_name("VIGNESH");
		List<Subjects> vigneshSubjects=new ArrayList<>();
		vigneshSubjects.add(tfcs);
		vignesh.setSubjects(vigneshSubjects);
		List<Classes> vigneshClasses=new ArrayList<>();
		vigneshClasses.add(core);
		vignesh.setClass_alot(vigneshClasses);
		
		Teacher navya =new Teacher();
		navya.setTeacher_name("NAVYA");
		List<Subjects> navyaSubjects= new ArrayList<>();
		navyaSubjects.add(cpp);
		navyaSubjects.add(java);
		navyaSubjects.add(python);
		navya.setSubjects(navyaSubjects);
		List<Classes> navyaClasses= new ArrayList<>();
		navyaClasses.add(languages);
		navya.setClass_alot(navyaClasses);
		
		html.setTeacher(ramesh);
		css.setTeacher(ramesh);
		javascript.setTeacher(meganadh);
		
		datastructures.setTeacher(gururaj);
		ada.setTeacher(gururaj);
		tfcs.setTeacher(vignesh);
		
		cpp.setTeacher(navya);
		java.setTeacher(navya);
		python.setTeacher(navya);
		
		Teacher[] webTeachers= {ramesh,ramesh,meganadh};
		Subjects[] webSubjects= {html,css,javascript};
		WEB.setTeachers(webTeachers);
		WEB.setSubjects(webSubjects);
		
		Teacher[] coreTeachers= {gururaj,gururaj,vignesh};
		Subjects[] coreSubjects= {datastructures,ada,tfcs};
		core.setTeachers(coreTeachers);
		core.setSubjects(coreSubjects);
		
		Teacher[] languagesTeachers= {navya,navya,navya};
		Subjects[] languagesSubjects= {cpp,java,python};
		languages.setTeachers(languagesTeachers);
		languages.setSubjects(languagesSubjects);
		
		SessionFactory sf=HibernateUtil.buildSessionFactory();
		Session session=sf.openSession();
		
		Transaction tx=session.beginTransaction();
		session.save(WEB);
		session.save(core);
		session.save(languages);
		tx.commit();
		
		
		
		
		
		
	}

}
