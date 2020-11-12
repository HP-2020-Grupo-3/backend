package com.hp2020g3.venidemary.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "entity")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne
    @JoinColumn(name = "entityTypeId")
    private EntityType entityType;
    
    @Transient
    private Date creationDate;
    private Date deletionDate;
    
    
    private Boolean isDeleted = false;

    public BaseEntity() {}

    public BaseEntity(Integer id, EntityType entityType, Date creationDate, Date deletionDate, Boolean isDeleted) {
        
        this.entityType = entityType;
        this.creationDate = creationDate;
        this.deletionDate = deletionDate;
        this.isDeleted = isDeleted;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDeletionDate() {
        return deletionDate;
    }

    public void setDeletionDate(Date deletionDate) {
        this.deletionDate = deletionDate;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
