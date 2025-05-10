package com.quod.antifraude.controller;

import com.quod.antifraude.model.BiometriaRequest;
import com.quod.antifraude.service.DocumentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoController {

    private final DocumentoService documentoService;

    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    @PostMapping("/validar")
    public ResponseEntity<?> validarDocumento(@RequestBody BiometriaRequest request) {
        return documentoService.validarDocumento(request);
    }
}
