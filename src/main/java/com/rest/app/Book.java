package com.rest.app;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
