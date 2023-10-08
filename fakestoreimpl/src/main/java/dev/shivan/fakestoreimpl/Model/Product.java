package dev.shivan.fakestoreimpl.Model;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product extends BaseModel{
    private String title;
    private String description;
    private String image;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="category") 
    private Category category;

    private double price;
}