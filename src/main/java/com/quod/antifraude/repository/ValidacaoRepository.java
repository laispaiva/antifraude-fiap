package com.quod.antifraude.repository;

import com.quod.antifraude.model.ResultadoValidacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidacaoRepository extends MongoRepository<ResultadoValidacao, String> {
}
