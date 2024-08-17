package com.example.demo.domain;

import org.springframework.validation.ObjectError;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 *
 *
 *
 */
@Entity
@DiscriminatorValue("2")
public class OutsourcedPart extends Part{
String companyName;

    public OutsourcedPart() {

        // The user can change this, but this is the default
        this.minimumInventory = 0;
        this.maximumInventory = 100;
        this.companyName = "Company Name";

    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
