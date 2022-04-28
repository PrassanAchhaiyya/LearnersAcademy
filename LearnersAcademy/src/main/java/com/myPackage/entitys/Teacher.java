package com.myPackage.entitys;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="teacher_table")
public class Teacher {
	@Id
	@GeneratedValue
	@Column(name="teacher_id")
	private int teacher_id;
	
	@Column(name="teacher_name")
	private String teacher_name;
	
	@OneToMany(mappedBy="teacher",cascade=CascadeType.ALL)
	private List<Subjects> subjects;
	
	@ManyToMany(mappedBy="teachers",cascade=CascadeType.ALL)
	List<Classes> class_alot;
	/*
	public Teacher(String teacher_name, List<Subjects> subjects, List<Classes> class_alot) {
		super();
		this.teacher_name = teacher_name;
		this.subjects = subjects;
		this.class_alot = class_alot;
	}*/

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public void addSubject(Subjects sub) {
		this.subjects.add(sub);
	}
	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}

	public List<Classes> getClass_alot() {
		return class_alot;
	}

	public void setClass_alot(List<Classes> class_alot) {
		this.class_alot = class_alot;
	}
	
	
	
	

}
