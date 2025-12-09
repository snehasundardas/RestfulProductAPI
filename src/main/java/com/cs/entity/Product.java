package com.cs.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Product {
	
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "Product_Api",initialValue = 1000,allocationSize=1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private Integer Id;
	
	@Column(name="NAME",length=30)
	@NonNull
	private String name;
	
	@Column(name="PRICE")
	@NonNull
	private Double price;
	
	@ManyToOne
	@JoinColumn(name="BRAND_ID")
	@JsonIgnoreProperties("products")
	@ToString.Exclude
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name="CATEGORY_ID")
	@JsonIgnoreProperties("products")
	@ToString.Exclude
	private Category category;
	
	
}
