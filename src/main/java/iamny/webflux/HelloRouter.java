package iamny.webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class HelloRouter {

    HelloHandler helloHandler = new HelloHandler();

    @Bean
    RouterFunction<ServerResponse> router() {
        return route(GET("/hello"), helloHandler::helloWorld)
                .andRoute(GET("/time"), helloHandler::time);
    }

}
