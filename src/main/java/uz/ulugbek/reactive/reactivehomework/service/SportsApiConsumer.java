package uz.ulugbek.reactive.reactivehomework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;
import uz.ulugbek.reactive.reactivehomework.client.SportsApiClient;
import uz.ulugbek.reactive.reactivehomework.repository.SportRepository;

@Component
@RequiredArgsConstructor
public class SportsApiConsumer implements SmartLifecycle {

    private final SportsApiClient sportsApiClient;
    private final SportRepository sportRepository;

    @Override
    public void start() {
//        sportRepository.insert(sportsApiClient.getAllSportsData()).blockLast();
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
