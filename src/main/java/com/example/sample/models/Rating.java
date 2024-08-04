package com.example.sample.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating extends BaseModel{
    private int rating;
    private String review;
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "product")
    @JsonBackReference
    private Product product;
}
