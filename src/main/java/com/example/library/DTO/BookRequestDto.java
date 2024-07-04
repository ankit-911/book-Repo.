package com.example.library.DTO;

import lombok.Data;

@Data
public class BookRequestDto {
    private String title;

    private String author;

    private Double price;

    private Integer yearPublished;

}
