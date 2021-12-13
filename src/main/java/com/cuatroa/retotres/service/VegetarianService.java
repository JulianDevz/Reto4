package com.cuatroa.retotres.service;

import com.cuatroa.retotres.model.Vegetarian;
import com.cuatroa.retotres.repository.VegetarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author desaextremo
 */
@Service
public class VegetarianService {

    @Autowired
    private VegetarianRepository vegetarianRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Vegetarian> getAll() {
        return vegetarianRepository.getAll();
    }

    public Optional<Vegetarian> getAccesory(String reference) {
        return vegetarianRepository.getAccesory(reference);
    }

    public Vegetarian create(Vegetarian accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return vegetarianRepository.create(accesory);
        }
    }

    public Vegetarian update(Vegetarian accesory) {

        if (accesory.getReference() != null) {
            Optional<Vegetarian> accesoryDb = vegetarianRepository.getAccesory(accesory.getReference());
            if (!accesoryDb.isEmpty()) {
                if (accesory.getBrand() != null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }

                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }

                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                vegetarianRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getAccesory(reference).map(accesory -> {
            vegetarianRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
