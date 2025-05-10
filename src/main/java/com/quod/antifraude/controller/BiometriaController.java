package com.quod.antifraude.controller;

import com.quod.antifraude.model.BiometriaRequest;
import com.quod.antifraude.service.BiometriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/biometria")
public class BiometriaController {

    private final BiometriaService biometriaService;

    public BiometriaController(BiometriaService biometriaService) {
        this.biometriaService = biometriaService;
    }

    @PostMapping("/facial")
    public ResponseEntity<?> validarFacial(@RequestBody BiometriaRequest request) {
        return biometriaService.validarBiometria(request, "facial");
    }

    @PostMapping("/digital")
    public ResponseEntity<?> validarDigital(@RequestBody BiometriaRequest request) {
        return biometriaService.validarBiometria(request, "digital");
    }
}
