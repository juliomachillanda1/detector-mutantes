package com.juliomachillanda.detectormutantes.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigInteger;

public class AdnVerificacionEstadisticasVo {
    
    private BigInteger cantidadMutantes;
    private BigInteger cantidadHumanos;
    private Double proporcionMutantes;

    public AdnVerificacionEstadisticasVo(
            BigInteger cantidadMutantes,
            BigInteger cantidadHumanos,
            Double proporcionMutantes) {
        this.cantidadMutantes = cantidadMutantes;
        this.cantidadHumanos = cantidadHumanos;
        this.proporcionMutantes = proporcionMutantes;
    }

    public BigInteger getCantidadMutantes() {
        return cantidadMutantes;
    }

    @JsonProperty(value = "count_mutant_dna")
    public void setCantidadMutantes(BigInteger cantidadMutantes) {
        this.cantidadMutantes = cantidadMutantes;
    }

    public BigInteger getCantidadHumanos() {
        return cantidadHumanos;
    }

    @JsonProperty(value = "count_human_dna")
    public void setCantidadHumanos(BigInteger cantidadHumanos) {
        this.cantidadHumanos = cantidadHumanos;
    }

    public Double getProporcionMutantes() {
        return proporcionMutantes;
    }

    @JsonProperty(value = "ratio")
    public void setProporcionMutantes(Double proporcionMutantes) {
        this.proporcionMutantes = proporcionMutantes;
    }
    
}
