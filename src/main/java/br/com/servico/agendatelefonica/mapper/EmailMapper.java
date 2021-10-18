package br.com.servico.agendatelefonica.mapper;

import org.springframework.stereotype.Component;

import br.com.servico.agendatelefonica.models.dto.EmailDTO;
import br.com.servico.agendatelefonica.models.entity.Email;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmailMapper {

    public Email toEntity(EmailDTO emailDTO) {
        Email email = new Email();
        email.setIdEmail(emailDTO.getIdEmailDTO());
        email.setEmailContato(emailDTO.getEmailDTO());
        return email;
    }

    public EmailDTO toDTO(Email email) {
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setIdEmailDTO(email.getIdEmail());
        emailDTO.setEmailDTO(email.getEmailContato());
        return emailDTO;
    }

    public List<EmailDTO> toDTO(List<Email> listEmail) {
        return listEmail.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
