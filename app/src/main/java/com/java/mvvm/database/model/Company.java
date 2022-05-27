package com.java.mvvm.database.model;

public class Company {
    String companyName;
    Boolean isSelected;

    public Company(String companyName) {
        this.companyName = companyName;
        this.isSelected = false;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }
}
