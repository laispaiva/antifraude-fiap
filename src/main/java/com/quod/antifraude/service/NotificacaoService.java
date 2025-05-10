package com.quod.antifraude.service;

import com.quod.antifraude.model.ResultadoValidacao;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificacaoService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String NOTIFICACAO_URL = "http://localhost:9090/api/notificacoes/fraude";

    public void notificarFraude(ResultadoValidacao resultado) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ResultadoValidacao> request = new HttpEntity<>(resultado, headers);
        try {
            restTemplate.postForEntity(NOTIFICACAO_URL, request, Void.class);
        } catch (Exception e) {
            System.out.println("Erro ao enviar notificação: " + e.getMessage());
        }
    }
}
