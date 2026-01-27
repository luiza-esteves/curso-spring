package io.github.luiza_esteves.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class MailSender {

    public void enviar(String mensagem){
        System.out.println("enviando email "+mensagem);
    }
}
