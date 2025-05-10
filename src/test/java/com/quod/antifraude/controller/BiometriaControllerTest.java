package com.quod.antifraude.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quod.antifraude.model.BiometriaRequest;
import com.quod.antifraude.model.Dispositivo;
import com.quod.antifraude.model.Metadados;
import com.quod.antifraude.service.BiometriaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDateTime;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BiometriaController.class)
public class BiometriaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BiometriaService biometriaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveRetornar200AoValidarBiometriaFacial() throws Exception {
        BiometriaRequest request = new BiometriaRequest();
        request.setTransacaoId("test-id-123");
        request.setTipoBiometria("facial");
        request.setImagem("base64simulado");
        request.setDataCaptura(LocalDateTime.now());

        Dispositivo dispositivo = new Dispositivo();
        dispositivo.setFabricante("Apple");
        dispositivo.setModelo("iPhone 14");
        dispositivo.setSistemaOperacional("iOS 17");
        request.setDispositivo(dispositivo);

        Metadados metadados = new Metadados();
        metadados.setLatitude(-23.55);
        metadados.setLongitude(-46.63);
        metadados.setIpOrigem("192.168.0.1");
        request.setMetadados(metadados);

        mockMvc.perform(post("/api/biometria/facial")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }
}
