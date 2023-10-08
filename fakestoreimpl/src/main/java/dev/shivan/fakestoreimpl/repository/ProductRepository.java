package dev.shivan.fakestoreimpl.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.shivan.fakestoreimpl.Model.*;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Override
    <S extends Product> S save(S entity);
    Optional<Product> findById(int i);
    void deleteById(int i);
    //List<Product> findAllByCategoryIn(Category category);
}