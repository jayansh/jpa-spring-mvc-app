package net.tao.spring.assignment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public interface ProductRepository extends CrudRepository<Product, String> {

    //Optional<Product> findByName(String productName);

}
