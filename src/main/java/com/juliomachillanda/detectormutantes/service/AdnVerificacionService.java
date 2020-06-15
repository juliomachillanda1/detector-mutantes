package com.juliomachillanda.detectormutantes.service;

import org.springframework.stereotype.Service;

@Service
public class AdnVerificacionService {

    private static final String[] SECUENCIAS = {"AAAA", "TTTT", "CCCC", "GGGG"};

    public boolean isMutant(String[] dna) {
        char[][] basesNitrogenadas = obtenerBasesNitrogenadas(dna);

        int secuenciasEncontradas = 0;
        for (String secuencia : SECUENCIAS) {
            secuenciasEncontradas += buscarSecuencias(basesNitrogenadas, secuencia);
            if (secuenciasEncontradas > 1) {
                return true;
            }
        }
        return false;
    }

    private char[][] obtenerBasesNitrogenadas(String[] adn) {
        int filas = adn.length;
        int columnas = adn[0].length();
        char[][] basesNitrogenadas = new char[filas][columnas];

        for (int i = 0; i < filas; i++) {
            basesNitrogenadas[i] = adn[i].toCharArray();
        }
        return basesNitrogenadas;
    }

    private int buscarSecuencias(char[][] basesNitrogenadas, String secuencia) {
        int filasTotales = basesNitrogenadas.length;
        int columnasTotales = basesNitrogenadas[0].length;
        int secuenciasEncontradas = 0;

        for (int fila = 0; fila < filasTotales; fila++) {
            for (int columna = 0; columna < columnasTotales; columna++) {
                if (buscarSecuencia(basesNitrogenadas, fila, columna, secuencia)) {
                    secuenciasEncontradas++;
                }
            }
        }

        return secuenciasEncontradas;
    }

    private boolean buscarSecuencia(char[][] basesNitrogenadas, int fila, int columna, String secuencia) {
        int direccionesABuscar = 4;
        int[] coordenadasX = {1, 0, -1, 1};
        int[] coordenadasY = {0, 1, -1, -1};

        if (basesNitrogenadas[fila][columna] != secuencia.charAt(0)) {
            return false;
        }

        for (int direccion = 0; direccion < direccionesABuscar; direccion++) {
            int direccionFila = fila + coordenadasX[direccion];
            int direccionColumna = columna + coordenadasY[direccion];

            int posicionActual;
            for (posicionActual = 1; posicionActual < secuencia.length(); posicionActual++) {
                if (direccionFila >= basesNitrogenadas.length || direccionFila < 0 || direccionColumna >= basesNitrogenadas[0].length || direccionColumna < 0) {
                    break;
                }

                if (basesNitrogenadas[direccionFila][direccionColumna] != secuencia.charAt(posicionActual)) {
                    break;
                }

                direccionFila += coordenadasX[direccion];
                direccionColumna += coordenadasY[direccion];
            }

            if (posicionActual == secuencia.length()) {
                return true;
            }
        }
        return false;
    }

}
