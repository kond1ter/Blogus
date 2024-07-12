package com.konditer.blogus;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.konditer.blogus.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@SpringBootApplication
public class BlogusApplication {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("blogus");
		EntityManager em = emf.createEntityManager();
		System.out.println(em.find(User.class, 1).getName());

		// SpringApplication.run(BlogusApplication.class, args);
	}
}
