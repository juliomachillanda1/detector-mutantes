# detector-mutantes
Proyecto para **detectar si un humano es mutante** basándose en su secuencia de ADN.

### Requerimientos
- Java 11
- Maven 3.x

### Instalación
1. Clonar el proyecto
2. Compilar y ejecutar. En el directorio del proyecto ejecutar en la terminal:

```console
$ mvn clean install

$ mvn spring-boot:run
```

# Servicios REST

**Detectar si un humano es mutante**
----
Se recibe un array de Strings que representan cada fila de una tabla de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las cuales representan cada base nitrogenada del ADN.

Un humano es mutante, si encuentra más de una secuencia de cuatro letras iguales, de forma oblicua, horizontal o vertical.

* **Endpoint:**

  /mutant

* **Método:**

   `POST` 

* **Respuesta: Es mutante**
  
  * **Código:** 200-OK <br />
 
    **Ejemplo de invocación**
    ```json
    {
        "dna": [
            "ATGCGA",
            "CAGTGC",
            "TTATGT",
            "AGAAGG",
            "CCCCTA",
            "TCACTG"
        ]
    }
    ```
* **Respuesta: No es mutante**

  * **Código:** 403-Forbidden <br />
  
    **Ejemplo de invocación para humano:**
    ```json
    {
        "dna": [
            "ATGCGA",
            "CAGTGC",
            "TTATTT",
            "AGACGG",
            "GCGTCA",
            "TCACTG"
        ]
    }
    ```

**Ver estadísticas de verificaciones de ADN**
----
Retorna la cantidad de correspondiente de mutantes y humanos encontrados en las verificaciones de ADN. Además la proporción de mutantes en base a las verificaciones realizadas.

* **Endpoint:**

  /stats

* **Método:**

   `GET` 

* **Respuesta:**
  
  * **Código:** 200-OK <br />
    ```json
    {
        "count_mutant_dna": 1,
        "count_human_dna": 0,
        "ratio": 1.0
    }
    ```

> Para probar con Postman se puede hacer click en el siguiente link e importar la colección.

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/9bf65527e52237dd79e4)
