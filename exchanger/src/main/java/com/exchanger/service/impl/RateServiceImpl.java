package com.exchanger.service.impl;

import com.exchanger.exception.ExternalHttpCallException;
import com.exchanger.model.CurrencyEnum;
import com.exchanger.model.Rate;
import com.exchanger.repository.RateRepository;
import com.exchanger.service.RateService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Timestamp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class RateServiceImpl implements RateService {

    @Value("${bank.rate.url}")
    private String bankRateUrl;
    @Value("${schedule.cron.time.table}")
    private String cronTime;
    private final RateRepository rateRepository;


    @Override
    @Scheduled(cron = "0 0 * * * MON-FRI")
    /*
    +-------------------- second (0 - 59)
    |  +----------------- minute (0 - 59)
    |  |  +-------------- hour (0 - 23)
    |  |  |  +----------- day of month (1 - 31)
    |  |  |  |  +-------- month (1 - 12)
    |  |  |  |  |  +----- day of week (0 - 6) (Sunday=0 or 7)
    |  |  |  |  |  |  +-- year [optional]
    |  |  |  |  |  |  |
    *  *  *  *  *  *  * command to be executed
    */
    public void getRates() throws JsonProcessingException {
        log.info("Get Rates from bank ...");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(bankRateUrl, String.class);
        log.error(response.getBody());

        if (response.getStatusCode().isError()){
            throw new ExternalHttpCallException("Bank Rate Error");
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jNode = mapper.readTree(response.getBody());
        jNode.forEach(node -> {
            if (node.get("ccy").asText().equals("USD") || node.get("ccy").asText().equals("EUR")){
                Rate rate = new Rate()
                    .setBuy(node.get("buy").asText())
                    .setSale(node.get("sale").asText())
                    .setReceive(new Timestamp(System.currentTimeMillis()))
                    .setCurrency(CurrencyEnum.valueOf(node.get("ccy").asText()));
                rateRepository.save(rate);
            }
        });
    }
}
