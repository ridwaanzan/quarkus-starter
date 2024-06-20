package com.codecipta.dao.starter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class StarterEntity {
    @Id
    @GeneratedValue
    public Long id;
    public String name;
    public String email;
    public Date bod;
    public Integer status;
}
