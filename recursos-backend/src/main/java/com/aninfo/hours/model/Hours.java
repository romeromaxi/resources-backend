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
    private Integer date;

    public Hours() {
    }

    public Hours(Integer file, Integer idTask, Integer quantityHours, Integer date) {
        this.file = file;
        this.idTask = idTask;
        this.quantityHours = quantityHours;
        this.date = date;
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

    public Integer getDate(){ return this.date; }
}
