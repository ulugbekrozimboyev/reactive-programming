package uz.ulugbek.reactive.reactivehomework.client;

import reactor.core.publisher.Flux;
import uz.ulugbek.reactive.reactivehomework.models.Sport;

public interface SportsApiClient {

    Flux<Sport> getAllSportsData();

}
