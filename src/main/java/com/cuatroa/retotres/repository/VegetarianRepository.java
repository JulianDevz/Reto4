package com.cuatroa.retotres.repository;

import com.cuatroa.retotres.model.Vegetarian;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cuatroa.retotres.repository.crud.VegetarianCrudRepository;

/**
 *
 * @author Julian
 */
@Repository
public class VegetarianRepository {
    @Autowired
    private VegetarianCrudRepository vegetarianCrudRepository;

    public List<Vegetarian> getAll() {
        return vegetarianCrudRepository.findAll();
    }

    public Optional<Vegetarian> getAccesory(String reference) {
        return vegetarianCrudRepository.findById(reference);
    }
    
    public Vegetarian create(Vegetarian accesory) {
        return vegetarianCrudRepository.save(accesory);
    }

    public void update(Vegetarian accesory) {
        vegetarianCrudRepository.save(accesory);
    }
    
    public void delete(Vegetarian accesory) {
        vegetarianCrudRepository.delete(accesory);
    }
    
    public List<Vegetarian> productByPrice(double precio) {
	return vegetarianCrudRepository.findByPriceLessThanEqual(precio);
    }
}
