package uz.ulugbek.reactive.reactivehomework.api.func;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class SportApiRouter {

    @Bean
    public RouterFunction<ServerResponse> sportsRouterFunction(SportApiHandler sportApiHandler){
        return RouterFunctions
                .route(GET("/api/v2/sports/{id}"),sportApiHandler::getById)
                .andRoute(GET("/api/v2/sports/by-name/{sportname}"),sportApiHandler::getBySportName);
    }

}
