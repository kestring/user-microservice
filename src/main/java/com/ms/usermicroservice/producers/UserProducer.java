package com.ms.usermicroservice.producers;

import com.ms.usermicroservice.dtos.EmailDTO;
import com.ms.usermicroservice.models.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(User user){
        var emailDTO = new EmailDTO();

        emailDTO.setUserId(user.getUserId());
        emailDTO.setEmailTo(user.getEmail());
        emailDTO.setSubject("Cadastro realizado com sucesso");
        emailDTO.setText(user.getNome() + ", seja bem vindo PNC");

        //exchange "" é a defailt
        rabbitTemplate.convertAndSend("", routingKey, emailDTO);
    }

}
