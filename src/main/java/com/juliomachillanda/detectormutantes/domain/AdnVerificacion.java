package com.juliomachillanda.detectormutantes.domain;

import com.juliomachillanda.detectormutantes.vo.AdnVerificacionEstadisticasVo;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@SqlResultSetMapping(
        name = "estadisticasVerificacionesMapping",
        classes = {
            @ConstructorResult(
                    targetClass = AdnVerificacionEstadisticasVo.class,
                    columns = {
                        @ColumnResult(name = "cantidadMutantes"),
                        @ColumnResult(name = "cantidadHumanos"),
                        @ColumnResult(name = "proporcionMutantes")}
            )
        }
)

@NamedNativeQuery(name = "AdnVerificacion.buscarEstadisticasVerificaciones", query = "SELECT"
        + " COUNT(CASE WHEN es_mutante = true THEN 1 END) AS cantidadMutantes,"
        + " COUNT(CASE WHEN es_mutante = false THEN 1 END) AS cantidadHumanos,"
        + " CAST(COUNT(CASE WHEN es_mutante = true THEN 1 END) AS FLOAT)/COUNT(*) AS proporcionMutantes"
        + " FROM adn_verificacion;", resultSetMapping = "estadisticasVerificacionesMapping")

@Entity
@Table(name = "adn_verificacion")
public class AdnVerificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String[] adn;
    private boolean esMutante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String[] getAdn() {
        return adn;
    }

    public void setAdn(String[] adn) {
        this.adn = adn;
    }

    public boolean esMutante() {
        return esMutante;
    }

    public void setEsMutante(boolean esMutante) {
        this.esMutante = esMutante;
    }

}