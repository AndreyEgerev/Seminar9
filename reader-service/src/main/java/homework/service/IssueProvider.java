package homework.service;

import homework.api.Issue;
import lombok.extern.slf4j.Slf4j;

import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class IssueProvider {
    private final WebClient webClient;

    public IssueProvider(ReactorLoadBalancerExchangeFilterFunction loadBalancerExchangeFilterFunction) {
        webClient = WebClient.builder()
                .filter(loadBalancerExchangeFilterFunction)
                .build();
    }

    public List<Issue> getIssuesByIdReader(Long id) {
        log.info("Запрос на выдачи читателя с id {}", id);
        List<Issue> issues;
        issues = webClient.get()
                .uri("http://issue-service/reader/{id}", id)
                .retrieve()
                .bodyToFlux(Issue.class)
                .collectList()
                .block();
        log.info("Получен ответ {}", issues);
        return issues;
    }
}
