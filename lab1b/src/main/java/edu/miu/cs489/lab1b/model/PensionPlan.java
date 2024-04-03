package edu.miu.cs489.lab1b.model;

import java.time.LocalDate;

public class PensionPlan {
    private String referenceNumber;
    private LocalDate enrollmentDate;
    private Double contribution;

    public PensionPlan(){}
    public PensionPlan(String referenceNumber, LocalDate enrollmentDate, Double contribution) {
        this.referenceNumber = referenceNumber;
        this.enrollmentDate = enrollmentDate;
        this.contribution = contribution;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Double getContribution() {
        return contribution;
    }

    public void setContribution(Double contribution) {
        this.contribution = contribution;
    }

    @Override
    public String toString() {
        return "PensionPlan{" +
                "referenceNumber='" + referenceNumber + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                ", contribution=" + contribution +
                '}';
    }
}
