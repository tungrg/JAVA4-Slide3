package com.slide3;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "videos")
@Getter
@Setter
public class Video {
    @Id
    private String Id;
    private String title;
    private String description;
    private String poster;
    private Boolean active;
    private Integer view;

    @OneToMany(mappedBy = "video")
    private List<Favorite> favorites;
    

}
