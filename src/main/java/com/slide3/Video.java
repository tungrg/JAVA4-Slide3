package com.slide3;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "videos")
@Data
public class Video {
    @Id
    @Column(length = 11)
    private String id;

    @Column(length = 50)
    private String title;

    @Column(length = 50)
    private String poster;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Boolean active;

    private Integer views;

    @OneToMany(mappedBy = "video")
    private List<Favorite> favorites;
}
