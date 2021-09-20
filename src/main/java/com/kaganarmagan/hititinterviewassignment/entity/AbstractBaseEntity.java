package com.kaganarmagan.hititinterviewassignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @CreatedDate
    @Column(name = "created_date",updatable = false)
    @JsonIgnore
    private Instant createdDate=Instant.now();
    @LastModifiedDate
    @Column(name="last_modified_date")
    @JsonIgnore
    private Instant lastModifiedDate=Instant.now();
}
