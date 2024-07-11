package org.konditer.blogus;

import org.konditer.blogus.domain.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("blogus");
        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, 1);
        System.out.println("\n" + user.getName());
    }
}
