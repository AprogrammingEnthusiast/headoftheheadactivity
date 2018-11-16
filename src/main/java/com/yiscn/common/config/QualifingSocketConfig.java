package com.yiscn.common.config;

import com.yiscn.service.IPvpService;
import com.yiscn.service.impl.PvpServiceImpl;
import com.yiscn.socket.QualifyingSocket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*@Configuration
public class QualifingSocketConfig {

    @Bean
    public IPvpService getIpvpService(){return new PvpServiceImpl(); }

    @Bean
    public QualifyingSocket getPvpService(){
        QualifyingSocket qualifyingSocket = new QualifyingSocket();
        qualifyingSocket.setPvpService(getIpvpService());
        return qualifyingSocket;
    }
}*/
