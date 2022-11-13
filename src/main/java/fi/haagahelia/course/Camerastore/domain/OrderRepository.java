package fi.haagahelia.course.Camerastore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

	List<Order> findByFirstName(String firstName);
}
