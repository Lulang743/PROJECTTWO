package com.example.project;

public class addDrugModelTable {
    String drug_name;
    String drug_id;
    String drug_category;
    String drug_therapy_area;
    String drug_activeSubstance;
    String drug_quantity;
    String drug_quantitySize;

    public String getProd_date() {
        return prod_date;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setProd_date(String prod_date) {
        this.prod_date = prod_date;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    String prod_date;
    String expDate;

    String patient_safety;

    String drug_add_date;



    public addDrugModelTable(String patient_safety, String drug_name, String drug_id, String drug_category, String drug_therapy_area, String drug_activeSubstance, String drug_quantity,String drug_quantitySize,String prod_date,String expDate, String drug_add_date) {
        this.drug_name = drug_name;
        this.drug_id = drug_id;
        this.drug_category = drug_category;
        this.drug_therapy_area = drug_therapy_area;
        this.drug_activeSubstance = drug_activeSubstance;
        this.drug_quantity = drug_quantity;
        this.drug_quantitySize=drug_quantitySize;
        this.drug_add_date = drug_add_date;
        this.patient_safety=patient_safety;
        this.prod_date=prod_date;
        this.expDate=expDate;
    }

    public String getDrug_name() {
        return drug_name;
    }

    public String getDrug_id() {
        return drug_id;
    }

    public String getDrug_category() {
        return drug_category;
    }

    public String getDrug_therapy_area() {
        return drug_therapy_area;
    }

    public String getDrug_activeSubstance() {
        return drug_activeSubstance;
    }

    public String getDrug_quantity() {
        return drug_quantity;
    }

    public String getDrug_add_date() {
        return drug_add_date;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public void setDrug_id(String drug_id) {
        this.drug_id = drug_id;
    }

    public void setDrug_category(String drug_category) {
        this.drug_category = drug_category;
    }

    public void setDrug_therapy_area(String drug_therapy_area) {
        this.drug_therapy_area = drug_therapy_area;
    }

    public void setDrug_activeSubstance(String drug_activeSubstance) {
        this.drug_activeSubstance = drug_activeSubstance;
    }

    public void setDrug_quantity(String drug_quantity) {
        this.drug_quantity = drug_quantity;
    }

    public void setDrug_add_date(String drug_add_date) {
        this.drug_add_date = drug_add_date;
    }

    public String getPatient_safety() {
        return patient_safety;
    }

    public void setPatient_safety(String patient_safety) {
        this.patient_safety = patient_safety;
    }



}
