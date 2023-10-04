package com.courses.IITB.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;

    @Column(name = "active", nullable = false, columnDefinition = "boolean default true")
    private boolean active = true;


    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdOn = createdDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.modifiedOn = updateDate;
    }

    @PrePersist
    public void onPrePersist() {
        setCreatedDate( LocalDateTime.now());

    }

    @PreUpdate
    public void onPreUpdate() {
        setUpdateDate( LocalDateTime.now());
    }
}