package dev.shivan.fakestoreimpl.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.shivan.fakestoreimpl.Model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {

    List<Category> findAll();
    public Optional<Category> getCategoryByName(String name);

    public Optional<Category> findByName(String name);

    public List<Category> findAllByIdIn(List<Long> id);
}