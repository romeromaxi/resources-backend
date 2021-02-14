package com.aninfo.hours.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
public class Hours {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer file;
    private Integer idTask;
    private Integer quantityHours;

    public Hours() {
    }

    public Hours(Integer file, Integer idTask, Integer quantityHours) {
        this.file = file;
        this.idTask = idTask;
        this.quantityHours = quantityHours;
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantityHours(){
        return this.quantityHours;
    }

    public Integer getFile(){
        return this.file;
    }

    public Integer getIdTask(){
        return this.idTask;
    }
}
