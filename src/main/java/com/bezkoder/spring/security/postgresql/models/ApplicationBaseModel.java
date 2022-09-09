package com.bezkoder.spring.security.postgresql.models;

import com.bezkoder.spring.security.postgresql.security.services.UserDetailsImpl;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Data
@ToString(callSuper = true)
@MappedSuperclass
public class ApplicationBaseModel extends BaseModel {

    @Column(name = "application_id", nullable = false)
    @org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
    @Convert(disableConversion = true)
    private UUID applicationId;

    @Override
    public void populateCreatedFields(UserDetailsImpl userDetails) {
        super.populateCreatedFields(userDetails);
        this.setApplicationId(UUID.randomUUID());
    }

    @Override
    public void populateUpdatedFields(UserDetailsImpl userDetails) {
        super.populateUpdatedFields(userDetails);
        this.setApplicationId(UUID.randomUUID());
    }

}
