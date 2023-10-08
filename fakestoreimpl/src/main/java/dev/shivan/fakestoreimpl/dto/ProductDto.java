package dev.shivan.fakestoreimpl.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDto {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
