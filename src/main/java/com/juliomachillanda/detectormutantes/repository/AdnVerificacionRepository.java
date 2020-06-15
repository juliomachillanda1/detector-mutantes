package com.juliomachillanda.detectormutantes.repository;

import com.juliomachillanda.detectormutantes.domain.AdnVerificacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdnVerificacionRepository extends JpaRepository<AdnVerificacion, Long> {

    Optional<AdnVerificacion> findByAdn(String[] adn);

}
