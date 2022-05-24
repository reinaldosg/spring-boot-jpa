package com.smu.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tr_notes_h")
public class NotesHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @OneToOne(mappedBy = "header", cascade = CascadeType.ALL)
    private NotesDetail detail;

    public NotesHeader() {
    }

    public NotesHeader(Long id, String name, Date createdAt, NotesDetail detail) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.detail = detail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public NotesDetail getDetail() {
        return detail;
    }

    public void setDetail(NotesDetail detail) {
        this.detail = detail;
    }
}
