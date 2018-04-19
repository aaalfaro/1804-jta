package com.revature.project0;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Person implements Serializable{

	private static final long serialVersionUID = -7837235030867746015L;
	
	private String name;
	transient private String password;
	
	public Person(){
		super();
	}
	
	public Person(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

	public void logout() {
		System.out.println("Are you sure you want to log out?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		// make while loop with nested if loop to determine the choice
		//
		//
		//
		//
		//
		sc.close();
		
		
	}
	
	
	
	
	
}
