package com.cuatroa.retotres.repository.crud;

import com.cuatroa.retotres.model.User;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author desaextremo
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    List<User> findBybirthtDay(Date date);
    Optional<User> findByEmailAndPassword(String email, String password);
    
    //Para seleccionar el usuario con el id maximo
    Optional<User> findTopByOrderByIdDesc();
    
    List<User> findByMonthBirthtDay(String monthBirthtDay);
}
