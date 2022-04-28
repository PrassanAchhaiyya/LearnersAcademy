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
@Table(name="student_table")
public class Student {
	@Id
	@GeneratedValue
	@Column(name="student_id")
	private int student_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	//@ManyToOne(cascade=CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name="class_id")
	Classes alloted_class;
	
	
	public Student() {
		super();
	}

	public Student( String name, String email, Classes alloted_class) {
		this.name = name;
		this.email = email;
		this.alloted_class = alloted_class;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Classes getAlloted_class() {
		return alloted_class;
	}

	public void setAlloted_class(Classes alloted_class) {
		this.alloted_class = alloted_class;
	}
	
	
	

}
