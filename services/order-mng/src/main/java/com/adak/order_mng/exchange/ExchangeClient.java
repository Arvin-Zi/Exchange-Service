package com.adak.order_mng.exchange;

import com.adak.order_mng.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
@RequiredArgsConstructor
public class ExchangeClient {

    @Value("${application.config.exchange-url}")
    private String exchangeUrl;

    private final RestTemplate restTemplate;

    public ExchangeResponse findExchangeById(Integer exchangeId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE, APPLICATION_JSON_VALUE);
        HttpEntity<Void> request = new HttpEntity<>(headers); // No request body for GET requests

        String url = exchangeUrl + "/" + exchangeId; // Append the ID to the URL

        ParameterizedTypeReference<ExchangeResponse> responseType = new ParameterizedTypeReference<>() {};

        ResponseEntity<ExchangeResponse> response = restTemplate.exchange(url,
                HttpMethod.GET,
                request,
                responseType);

        if (response.getStatusCode().isError()) {
            throw new BusinessException("Error while fetching exchange ID: " + response.getStatusCode());
        }
        return response.getBody();
    }

    public ExchangeResponse findExchangeByBranch(String exchangeBranch) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE, APPLICATION_JSON_VALUE);
        HttpEntity<String> request = new HttpEntity<>(exchangeBranch, headers);
        ParameterizedTypeReference<ExchangeResponse> responseType = new ParameterizedTypeReference<>() {};

        ResponseEntity<ExchangeResponse> response = restTemplate.exchange(exchangeUrl + "/exchange",
                HttpMethod.GET,
                request,
                responseType);
        if(response.getStatusCode().isError()) {
            throw new BusinessException("Error while fetching exchange branch" + response.getStatusCode());
        }
        return response.getBody();
    }
    }

