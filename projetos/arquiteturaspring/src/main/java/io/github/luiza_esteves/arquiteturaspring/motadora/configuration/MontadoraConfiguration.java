package io.github.luiza_esteves.arquiteturaspring.motadora.configuration;

import io.github.luiza_esteves.arquiteturaspring.motadora.Motor;
import io.github.luiza_esteves.arquiteturaspring.motadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MontadoraConfiguration {
    //banco de dados, servidor de emails...


    @Bean(name = "motorAspirado")
    @Primary // se nao tiver um Qualifier na controller, ele pega esse como padrao
    public Motor motorAspirado(){
        var motor = new Motor();
        motor.setCavalos(120);
        motor.setCilindros(4);
        motor.setModelo("XTP");
        motor.setLitragem(2.0);
        motor.setTipoMotor(TipoMotor.ASPIRADO);
        return motor;
    }

    @Bean(name ="motorEletrico" )
    public Motor motorEletrico(){
        var motor = new Motor();
        motor.setCavalos(110);
        motor.setCilindros(3);
        motor.setModelo("XTP");
        motor.setLitragem(1.0);
        motor.setTipoMotor(TipoMotor.ELETRICO);
        return motor;
    }

    @Bean(name = "motorTurbo")
    public Motor motorTurbo(){
        var motor = new Motor();
        motor.setCavalos(180);
        motor.setCilindros(5);
        motor.setModelo("XTP");
        motor.setLitragem(1.0);
        motor.setTipoMotor(TipoMotor.TURBO);
        return motor;
    }
}
