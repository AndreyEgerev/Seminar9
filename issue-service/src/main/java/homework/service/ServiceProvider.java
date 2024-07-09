package homework.service;

import homework.api.Issue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
@Slf4j
@Service
public class ServiceProvider {
    private final WebClient webClient;

    public ServiceProvider(ReactorLoadBalancerExchangeFilterFunction loadBalancerExchangeFilterFunction) {
        webClient = WebClient.builder()
                .filter(loadBalancerExchangeFilterFunction)
                .build();
    }

    public List<Issue> getByIdReader(Long id) {
        log.info("Запрос на получение читателя с id {}", id);
        List<Issue> issues;
        issues = webClient.get()
                .uri("http://reader-service/reader/{id}", id)
                .retrieve()
                .bodyToFlux(Issue.class)
                .collectList()
                .block();
        log.info("Получен ответ {}", issues);
        return issues;
    }

    public List<Issue> getByIdBook(Long id) {
        log.info("Запрос на получение книги с id {}", id);
        List<Issue> issues;
        issues = webClient.get()
                .uri("http://book-service/books/{id}", id)
                .retrieve()
                .bodyToFlux(Issue.class)
                .collectList()
                .block();
        log.info("Получен ответ {}", issues);
        return issues;
    }
}
