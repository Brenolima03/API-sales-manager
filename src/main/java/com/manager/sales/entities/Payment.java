package com.manager.sales.entities;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant datetime;
    private Double paymentValue;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Customer client;

    public Payment() {
    }
    public Payment(Long id, Instant datetime, Double paymentValue, Customer client) {
        this.id = id;
        this.datetime = datetime;
        this.client = client;
        this.paymentValue = paymentValue;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Instant getDatetime() {
        return datetime;
    }
    public void setDatetime(Instant datetime) {
        this.datetime = datetime;
    }
    public Double getValue() {
        return paymentValue;
    }
    public void setValue(Double paymentValue) {
        this.paymentValue = paymentValue;
    }
    public Customer getClient() {
        return client;
    }
    public void setClient(Customer client) {
        this.client = client;
    }

    public double getSubTotal() {
        return paymentValue != null ? paymentValue : 0.0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Payment other = (Payment) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
