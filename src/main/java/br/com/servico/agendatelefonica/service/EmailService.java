package br.com.servico.agendatelefonica.service;

import br.com.servico.agendatelefonica.mapper.EmailMapper;
import br.com.servico.agendatelefonica.models.dto.EmailDTO;
import br.com.servico.agendatelefonica.models.entity.Email;
import br.com.servico.agendatelefonica.repository.EmailRepository;
import br.com.servico.agendatelefonica.utils.Messages;
import br.com.servico.agendatelefonica.utils.exceptions.BusinessException;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private EmailMapper emailMapper;

    @Transactional
    public EmailDTO save(EmailDTO emailDTO) {
        Optional<Email> optionalEmail = emailRepository.findByEmail(emailDTO.getEmailDTO());
        if (optionalEmail.isPresent()) {
            throw new BusinessException(Messages.EMAIL_EXISTE);
        }
        Email email = emailMapper.toEntity(emailDTO);
        emailRepository.save(email);
        return emailMapper.toDTO(email);
    }

    @Transactional
    public EmailDTO update(EmailDTO emailDTO) {
        Optional<Email> optionalEmail = emailRepository.findByEmail(emailDTO.getEmailDTO());
        if (optionalEmail.isPresent()) {
            throw new BusinessException(Messages.EMAIL_NAO_EXISTE);
        }

        Email email = emailMapper.toEntity(emailDTO);
        emailRepository.save(email);
        return emailMapper.toDTO(email);
    }

}
