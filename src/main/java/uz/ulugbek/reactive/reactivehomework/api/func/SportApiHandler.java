package uz.ulugbek.reactive.reactivehomework.api.func;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.ulugbek.reactive.reactivehomework.repository.SportRepository;

import java.util.Optional;
import java.util.function.Predicate;

@Component
@RequiredArgsConstructor
public class SportApiHandler {

    private final SportRepository sportRepository;

    public Mono<ServerResponse> getById(ServerRequest request){
        var id = Optional.of(request.pathVariable("id"))
                .filter(Predicate.not(String::isBlank))
                .orElseThrow(() -> new ServerWebInputException("Invalid id param"));

        return sportRepository.findById(id)
                .flatMap(sport -> ServerResponse.ok().bodyValue(sport))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getBySportName(ServerRequest request) {
        var sportname = Optional.of(request.pathVariable("sportname"))
                .filter(Predicate.not(String::isBlank))
                .orElseThrow(() -> new ServerWebInputException("Invalid id param"));

        return sportRepository.findByAttributesName(sportname)
                .collectList()
                .flatMap (list -> ServerResponse.ok().bodyValue(list))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
