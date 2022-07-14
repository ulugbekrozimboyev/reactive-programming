package uz.ulugbek.reactive.reactivehomework.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.ulugbek.reactive.reactivehomework.models.Sport;
import uz.ulugbek.reactive.reactivehomework.repository.SportRepository;

@RestController
@RequestMapping("/api/v1/sports")
@RequiredArgsConstructor
public class SportController {

    private final SportRepository sportRepository;

    @GetMapping
    public Flux<Sport> getAllData(){
        return sportRepository.findAll();
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteById(@PathVariable String id){
        return sportRepository.deleteById(id);
    }
}
