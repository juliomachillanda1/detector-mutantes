package com.juliomachillanda.detectormutantes.repository;

import com.juliomachillanda.detectormutantes.domain.AdnVerificacion;
import com.juliomachillanda.detectormutantes.vo.AdnVerificacionEstadisticasVo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdnVerificacionRepository extends JpaRepository<AdnVerificacion, Long> {

    Optional<AdnVerificacion> findByAdn(String[] adn);
    
    @Query(nativeQuery = true)
    AdnVerificacionEstadisticasVo buscarEstadisticasVerificaciones();

}
