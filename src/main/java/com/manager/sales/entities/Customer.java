package com.manager.sales.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    Set<Order> orders = new HashSet<>();

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<Payment> payments = new HashSet<>();
    
    public Customer() {
    }
    public Customer(Long id, String name) {
        this.name = name;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<Order> getOrders() {
        return orders;
    }
    public Set<Payment> getPayments() {
        return payments;
    }

    public Double getTotalPayment() {
        double sum = 0.0;
        for (Payment payment : payments) {
            sum += payment.getSubTotal();
        }
        return sum;
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
        Customer other = (Customer) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
