package com.slide3;

import java.util.Date;
import java.util.List;

import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        User user = new User();
        user.setId("1");
        user.setFullname("Test User");
        user.setPassword("password");
        user.setEmail("testuser@example.com");
        user.setAdmin(true);
        Video video = new Video();
        video.setId("1");
        video.setTitle("Sample Video");
        video.setDescription("This is a sample video.");
        video.setPoster("poster.jpg");
        video.setActive(true);
        video.setView(100);
        Favorite favorite = new Favorite();
        favorite.setId(1);
        favorite.setLikeDate(new Date());
        favorite.setUser(user);
        favorite.setVideo(video);
        user.setFavorites(List.of(favorite));
        
        var pf = Persistence.createEntityManagerFactory("polyoe");
        var em = pf.createEntityManager();
        em.getTransaction().begin();
        em.persist(video);
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        pf.close();

    }
}