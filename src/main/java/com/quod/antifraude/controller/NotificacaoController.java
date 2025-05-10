package com.quod.antifraude.controller;

import com.quod.antifraude.model.ResultadoValidacao;
import com.quod.antifraude.repository.ValidacaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notificacoes")
public class NotificacaoController {

    private final ValidacaoRepository validacaoRepository;

    public NotificacaoController(ValidacaoRepository validacaoRepository) {
        this.validacaoRepository = validacaoRepository;
    }

    @PostMapping("/fraude")
    public ResponseEntity<?> receberNotificacao(@RequestBody ResultadoValidacao resultado) {
        System.out.println("🚨 Notificação recebida: " + resultado.getTipoFraude() + " na transação " + resultado.getTransacaoId());

        // Armazena o registro no MongoDB
        validacaoRepository.save(resultado);

        return ResponseEntity.ok("Notificação recebida com sucesso.");
    }
}
