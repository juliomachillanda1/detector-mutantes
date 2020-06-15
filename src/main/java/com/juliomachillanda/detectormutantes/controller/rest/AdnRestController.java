package com.juliomachillanda.detectormutantes.controller.rest;

import com.juliomachillanda.detectormutantes.service.AdnVerificacionService;
import com.juliomachillanda.detectormutantes.vo.AdnVo;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdnRestController {
    
    @Autowired
    private AdnVerificacionService adnVerificacionService;

    @PostMapping("/mutant")
    public void esMutante(@RequestBody AdnVo adnVo, HttpServletResponse response) {
        if (adnVerificacionService.isMutant(adnVo.getDna())) {
            response.setStatus(HttpStatus.OK.value());
        } else {
            response.setStatus(HttpStatus.FORBIDDEN.value());
        }
    }
    
}
