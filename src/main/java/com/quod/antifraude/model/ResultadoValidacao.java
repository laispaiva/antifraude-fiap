package com.quod.antifraude.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Document(collection = "validacoes")
public class ResultadoValidacao {
    @Id
    private String id;

    private String transacaoId;
    private String tipoBiometria;
    private boolean fraudeDetectada;
    private String tipoFraude;
    private LocalDateTime dataCaptura;
    private Dispositivo dispositivo;
    private Metadados metadados;
    private String[] canalNotificacao;
    private String notificadoPor;
}
