package com.myPackage.entitys;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
@Entity
@Table(name="class_table")
public class Classes {
	@Id
	@GeneratedValue
	@Column(name="class_id")
	private int class_id;
	
	@Column(name="class_name")
	private String class_name;
	
	@OrderColumn
	@OneToMany(mappedBy="class_alotted" ,cascade=CascadeType.ALL)
	Subjects[] subjects=new Subjects[3];
	
	@OrderColumn
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="classes_teacher_link" , joinColumns = { @JoinColumn(name="class_id")},
	inverseJoinColumns= {@JoinColumn(name="teacher_id")})
	Teacher[] teachers=new Teacher[3];
	
	@OneToMany(mappedBy="alloted_class" ,cascade=CascadeType.ALL)
    List<Student> students;

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public Subjects[] getSubjects() {
		return subjects;
	}
	public String getSubjectsString() {
		StringBuilder sb=new StringBuilder();
		if(this.subjects != null) {
			for(Subjects s:this.subjects) {
				sb.append(s.getSubject_name()+"<br>");
			}
		}
		return sb.toString();
	}

	public void setSubjects(Subjects[] subjects) {
		this.subjects = subjects;
	}
	public String getTeachersString() {
		StringBuilder sb=new StringBuilder();
		if(this.teachers != null) {
			for(Teacher t:this.teachers) {
				sb.append(t.getTeacher_name()+"<br>");
			}
		}
		return sb.toString();
	}
	public Teacher[] getTeachers() {
		return teachers;
	}

	public void setTeachers(Teacher[] teachers) {
		this.teachers = teachers;
	}
	public String getStudentsString() {
		StringBuilder sb=new StringBuilder();
		if(this.students != null) {
			for(Student t:this.students) {
				sb.append(t.getName()+",");
			}
		}
		return sb.toString();
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	/*
	public Classes(String class_name, Subjects[] subjects, Teacher[] teachers) {
		super();
		this.class_name = class_name;
		this.subjects = subjects;
		this.teachers = teachers;
	}*/
	
	
	
	

}
