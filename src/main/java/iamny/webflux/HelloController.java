package iamny.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@RestController
public class HelloController {

    @GetMapping("/hello/flux/{name}")
    public Flux<String> helloFlux(@PathVariable String name) {
        return Flux.just("Hello " + name + "!", "Hello " + name + "!!", "Hello " + name + "!!!");
    }

    @GetMapping("/hello/mono/{name}")
    public Mono<String> helloMono(@PathVariable String name) {
        return Mono.just("Hello " + name + "!");
    }

}
