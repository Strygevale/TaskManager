package com.example.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Data
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "description")
    private String description;
    @Column(name = "created", updatable = false)
    @DateTimeFormat(pattern = "yyyy-mm-dd HH:mm:ss")
   // @CreationTimestamp
    private LocalDateTime created;
    @Column(name = "done")
    private boolean done;

    @PrePersist
    protected void onCreate() {
        if(created == null) {
            this.created = LocalDateTime.now();
        }
    }


}
