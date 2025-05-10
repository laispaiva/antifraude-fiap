package com.quod.antifraude.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BiometriaRequest {
    private String transacaoId;
    private String tipoBiometria;
    private String imagem;
    private LocalDateTime dataCaptura;
    private Dispositivo dispositivo;
    private Metadados metadados;
}
