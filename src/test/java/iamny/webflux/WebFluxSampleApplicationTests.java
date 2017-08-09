package iamny.webflux;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebFluxSampleApplication.class)
public class WebFluxSampleApplicationTests {
    WebTestClient client;

    WebClient webClient;

    @Before
    public void setUp() throws Exception {
        /*client = WebTestClient
                .bindToRouterFunction(router.router())
                .build();*/
        client = WebTestClient.bindToServer()
                .baseUrl("http://localhost:8080")
                .build();
        webClient = WebClient.create("http://localhost:8080");
    }

    @Test
    public void testHelloMono() {
        client.get()
                .uri("/hello/mono/iamny")
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(String.class)
                .isEqualTo("Hello iamny!");

        System.out.println("Hi Mono!");
    }

}
