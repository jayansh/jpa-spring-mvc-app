package net.tao.spring.assignment;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
public interface ProductRepository extends CrudRepository<Product, String> {

    //Optional<Product> findByName(String productName);

}
