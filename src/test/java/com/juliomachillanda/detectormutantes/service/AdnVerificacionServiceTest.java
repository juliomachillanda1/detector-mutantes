package com.juliomachillanda.detectormutantes.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdnVerificacionServiceTest {

    @Autowired
    private AdnVerificacionService adnVerificacionService;

    @Test
    public void isMutant_conSecuenciaHorizontalDe4Letras_retornaTrue() {
        String[] dna = {
            "AAAA",
            "AAAA"};

        boolean esMutante = adnVerificacionService.isMutant(dna);

        assertThat(esMutante).isTrue();
    }

    @Test
    public void isMutant_conSecuenciaVerticalDe4Letras_retornaTrue() {
        String[] dna = {
            "AA",
            "AA",
            "AA",
            "AA"};

        boolean esMutante = adnVerificacionService.isMutant(dna);

        assertThat(esMutante).isTrue();
    }

    @Test
    public void isMutant_conSecuenciaOblicuaIzquierdaADerechaDe4Letras_retornaTrue() {
        String[] dna = {
            "AAAA",
            "TACC",
            "TGAC",
            "CGTA"};

        boolean esMutante = adnVerificacionService.isMutant(dna);

        assertThat(esMutante).isTrue();
    }

    @Test
    public void isMutant_conSecuenciaOblicuaDerechaIzquierdaDe4Letras_retornaTrue() {
        String[] dna = {
            "ATCG",
            "TTGC",
            "TGAC",
            "GGGG"};

        boolean esMutante = adnVerificacionService.isMutant(dna);

        assertThat(esMutante).isTrue();
    }

}
