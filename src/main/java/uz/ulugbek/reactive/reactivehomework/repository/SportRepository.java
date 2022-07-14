package uz.ulugbek.reactive.reactivehomework.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import uz.ulugbek.reactive.reactivehomework.models.Sport;

@Repository
public interface SportRepository extends ReactiveMongoRepository<Sport, String> {

    Flux<Sport> findByAttributesName(Object sportname);

}
