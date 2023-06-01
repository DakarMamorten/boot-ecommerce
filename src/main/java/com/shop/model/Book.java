package com.shop.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table(name = "book")
public class Book {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "author")
	private String author;

	@Column(name = "price")
	private String price;

	@Column(name = "picByte", length = 100000)
	private byte[] picByte;

	public Book(String name, String author, String price, byte[] picByte) {
		this.name = name;
		this.author = author;
		this.price = price;
		this.picByte = picByte;
	}
}
