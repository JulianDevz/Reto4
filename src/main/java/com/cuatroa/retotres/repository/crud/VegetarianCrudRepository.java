package com.cuatroa.retotres.repository.crud;

import com.cuatroa.retotres.model.Vegetarian;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Julian
 */
public interface VegetarianCrudRepository extends MongoRepository<Vegetarian, String> {

    public List<Vegetarian> findByPriceLessThanEqual(double precio);
    
}
