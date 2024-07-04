package com.example.library.DTO;

import lombok.Data;

@Data
public class BookResponseDto {
    private Integer id;
    private String title;

    private String author;

    private double price;

    private int yearPublished;
}
