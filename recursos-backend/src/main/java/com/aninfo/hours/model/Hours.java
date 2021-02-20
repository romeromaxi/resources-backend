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
    private Integer quantityMinutes;
    private Integer date;
    private Integer loadingDate;

    public Hours() {
    }

    public Hours(Integer file, Integer idTask, Integer quantityHours, Integer quantityMinutes, Integer date) {
        this.file = file;
        this.idTask = idTask;
        this.quantityHours = quantityHours;
        this.quantityMinutes = quantityMinutes;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantityHours(){
        return this.quantityHours;
    }

    public Integer getQuantityMinutes(){
        return this.quantityMinutes;
    }

    public Integer getFile(){
        return this.file;
    }

    public Integer getIdTask(){
        return this.idTask;
    }

    public Integer getDate(){ return this.date; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuantityHours(Integer hoursToChange) {
        this.quantityHours = hoursToChange;
    }

    public void setQuantityMinutes(Integer minutesToChange){
        this.quantityMinutes = minutesToChange;
    }

    public void setDate(Integer newDate) {
        this.date = newDate;
    }

    public Integer getLoadingDate() { return this.loadingDate; }

    public void setLoadingDate(Integer loadingDate) { this.loadingDate = loadingDate; }

    public void setTask(Integer newIdTask) {
        this.idTask = newIdTask;
    }
}
