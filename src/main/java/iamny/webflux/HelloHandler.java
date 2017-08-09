package iamny.webflux;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Date;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Component
public class HelloHandler {
    public Mono<ServerResponse> helloWorld(ServerRequest request) {
        return ServerResponse.ok().body(fromObject("Hello World!"));
    }

    public Mono<ServerResponse> time(ServerRequest request) {

        return ServerResponse.ok().body(fromObject(new Date()));
    }
}
