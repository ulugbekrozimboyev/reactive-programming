package uz.ulugbek.reactive.reactivehomework.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import uz.ulugbek.reactive.reactivehomework.models.Sport;
import uz.ulugbek.reactive.reactivehomework.models.SportsData;

@Component
@RequiredArgsConstructor
@Slf4j
public class SportsApiClientImpl implements SportsApiClient {

    private final WebClient webClient;

    @Override
    public Flux<Sport> getAllSportsData() {
        return webClient
                .get()
                .uri("/sports")
                .exchangeToMono(resp -> resp.bodyToMono(SportsData.class))
                .doOnError(err -> log.error("getting error while getting response", err))
                    .doOnNext(data -> log.info("sports data {}", data))
                .flatMapIterable(SportsData::getData);
    }
}
