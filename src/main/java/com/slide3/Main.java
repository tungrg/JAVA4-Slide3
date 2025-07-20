package com.slide3;

import java.beans.PersistenceDelegate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("polyoe");
        EntityManager em = factory.createEntityManager();
        User user = new User();
        user.setId("2");
        user.setPassword("223");
        user.setFullname("tung tran");
        user.setEmail("tungtran@gmail.com");
        user.setAdmin(false);
        
        Video video = new Video();
        video.setId("1");
        video.setTitle("Java 4");
        video.setPoster("poster.jpg");
        video.setDescription("Java 4 is a great course");
        video.setActive(true);
        video.setViews(1000);
        Favorite favorite = new Favorite();
        favorite.setVideo(em.find(Video.class, "1"));
        favorite.setUser(user);
        favorite.setVideo(video);
        favorite.setLikeDate(new java.util.Date());
        em.getTransaction().begin();
        em.persist(video);
        em.persist(user);
        em.persist(favorite);
        em.getTransaction().commit();
        em.close();
        factory.close();
        System.out.println("Done!");
        System.out.println("User: " + user.getFullname());
        System.out.println("Video: " + video.getTitle());
        System.out.println("Favorite Video: " + favorite.getVideo().getTitle());
        
        
    }
}