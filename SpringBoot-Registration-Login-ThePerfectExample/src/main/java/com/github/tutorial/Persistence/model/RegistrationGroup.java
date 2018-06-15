package com.github.tutorial.Persistence.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "registration_group")
public class RegistrationGroup {
        
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "group_id")
		private int id;
		
		@Column(name = "group_name")
		private String name;
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		

		@ManyToMany(cascade = CascadeType.ALL)
		@JoinTable(name = "group_user", joinColumns = @JoinColumn(name = "group_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
		private Set<User> users;
		
		public Set<User> getUsers() {
			return users;
		}
		public void setUsers(Set<User> users) {
			this.users = users;
		}

		
}
