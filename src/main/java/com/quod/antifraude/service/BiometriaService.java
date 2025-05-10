package com.quod.antifraude.service;

import com.quod.antifraude.model.*;
import com.quod.antifraude.repository.ValidacaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class BiometriaService {

    private final NotificacaoService notificacaoService;
    private final ValidacaoRepository validacaoRepository;

    public BiometriaService(NotificacaoService notificacaoService, ValidacaoRepository validacaoRepository) {
        this.notificacaoService = notificacaoService;
        this.validacaoRepository = validacaoRepository;
    }

    public ResponseEntity<ResultadoValidacao> validarBiometria(BiometriaRequest request, String tipo) {
        boolean fraude = simularFraude(request);

        ResultadoValidacao resultado = new ResultadoValidacao();
        resultado.setTransacaoId(request.getTransacaoId() != null ? request.getTransacaoId() : UUID.randomUUID().toString());
        resultado.setTipoBiometria(tipo);
        resultado.setDataCaptura(request.getDataCaptura() != null ? request.getDataCaptura() : LocalDateTime.now());
        resultado.setDispositivo(request.getDispositivo());
        resultado.setMetadados(request.getMetadados());
        resultado.setFraudeDetectada(fraude);
        resultado.setTipoFraude(fraude ? "deepfake" : null);
        resultado.setCanalNotificacao(new String[]{"sms", "email"});
        resultado.setNotificadoPor("sistema-de-monitoramento");

        // Persistir sempre
        validacaoRepository.save(resultado);

        // Notificar apenas se for fraude
        if (fraude) {
            notificacaoService.notificarFraude(resultado);
        }

        return ResponseEntity.ok(resultado);
    }

    private boolean simularFraude(BiometriaRequest request) {
        return Math.random() < 0.3;
    }
}
