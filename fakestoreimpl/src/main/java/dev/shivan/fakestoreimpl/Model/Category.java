package dev.shivan.fakestoreimpl.Model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category extends BaseModel
{
    private String name;

    @OneToMany(fetch = jakarta.persistence.FetchType.LAZY, mappedBy = "category")
    private List<Product> products;
}