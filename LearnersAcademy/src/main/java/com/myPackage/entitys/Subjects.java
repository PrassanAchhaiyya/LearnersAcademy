package com.myPackage.entitys;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subjects_table")
public class Subjects {
	@Id
	@GeneratedValue
	@Column(name="subject_id")
	private int subject_id;
	
	@Column(name="subject_name")
	private String subject_name;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="class_id")
	Classes class_alotted;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="teacher_id")
	Teacher teacher;
   /*
	public Subjects(String subject_name, Classes class_alotted, Teacher teacher) {
		super();
		this.subject_name = subject_name;
		this.class_alotted = class_alotted;
		this.teacher = teacher;
	}*/

	public int getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public Classes getClass_alotted() {
		return class_alotted;
	}

	public void setClass_alotted(Classes class_alotted) {
		this.class_alotted = class_alotted;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	
	
	

}
