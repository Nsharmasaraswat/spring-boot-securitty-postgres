package com.bezkoder.spring.security.postgresql.models;

import com.bezkoder.spring.security.postgresql.security.services.UserDetailsImpl;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/* Base Pojo Containing common fields and utility methods for all MFN  entities*/
@Data
@MappedSuperclass
public class BaseModel {

    @Column(name = "CRTE_USER_ID", nullable = false)
    @org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
    @Convert(disableConversion = true)
    private UUID createdUserId;

    @Column(name = "UPDT_USER_ID")
    @org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
    @Convert(disableConversion = true)
    private UUID updatedUserId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPD_DT")
    private Date lastUpdatedDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CRTD_DT")
    private Date createdDate;

    public void populateCreatedFields(UserDetailsImpl userDetails) {
        this.setCreatedDate(new Date());
        this.setCreatedUserId(userDetails.getId());
    }


    public void populateUpdatedFields(UserDetailsImpl userDetails) {
        this.setLastUpdatedDate(new Date());
        this.setUpdatedUserId(userDetails.getId());
    }


}
