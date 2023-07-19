package org.sid.Ecommerce.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Abstrat_Classes {
    @Id
    @GeneratedValue
    private Integer id;
    @CreatedDate
    @Column(name = "creationDate")
    private Instant creationDate;
    @LastModifiedDate
    @Column(name = "lastModifiedDate")
    private Instant lastUpdateDate;
}

