package br.com.servico.agendatelefonica.service;

import br.com.servico.agendatelefonica.mapper.EmailMapper;
import br.com.servico.agendatelefonica.models.dto.EmailDTO;
import br.com.servico.agendatelefonica.models.entity.Email;
import br.com.servico.agendatelefonica.repository.EmailRepository;
import br.com.servico.agendatelefonica.utils.Messages;
import br.com.servico.agendatelefonica.utils.exceptions.BusinessException;
import br.com.servico.agendatelefonica.utils.exceptions.EmailException;
import br.com.servico.agendatelefonica.utils.exceptions.NotFoundException;

import java.util.List;
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

    // Salvar email no Banco de dados
    @Transactional
    public EmailDTO save(EmailDTO emailDto) {
        Optional<Email> optionalEmail = emailRepository.findByEmail(emailDto.getEmailDTO());
        if (optionalEmail.isPresent()) {
            throw new EmailException(Messages.EMAIL_EXISTE);
        }

        Email email = emailMapper.toEntity(emailDto);
        emailRepository.save(email);
        return emailMapper.toDto(email);
    }

    // Atualizar email por id
    @Transactional
    public EmailDTO update(EmailDTO emailDto) {
        Optional<Email> optionalEmail = emailRepository.findByEmailUpdate(emailDto.getIdEmailDTO());
        if (optionalEmail.isPresent()) {
            throw new EmailException(Messages.EMAIL_EXISTE);
        }

        Email email = emailMapper.toEntity(emailDto);
        emailRepository.save(email);
        return emailMapper.toDto(email);
    }

    @Transactional
    public EmailDTO delete(EmailDTO emailDTO) {
        Optional<EmailDTO> emailDto = findByIdEmail(emailDTO.getIdEmailDTO());
        return emailRepository.deleteById(emailDTO);

    }

    @Transactional
    public Optional<EmailDTO> findByIdEmail(EmailDTO emailDto) {
        return emailRepository.findByIdEmail(emailDto.getIdEmailDTO()).map(emailMapper::toDto);
        Optional<Email> optionalEmail = emailRepository.findByEmailUpdate(emailDto.getIdEmailDTO());

        if (optionalEmail.isPresent()) {
            throw new EmailException(Messages.EMAIL_EXISTE);
        }

        Email email = emailMapper.toEntity(emailDto);
        emailRepository.save(email);
        return emailMapper.toDto(email);
    }

   private EmailDTO findByIdEmail(Long idEmail) {
       return emailRepository.findByIdEmail(idEmail).map(emailMapper::toDto).orElseThrow(NotFoundException::new);

    @Transactional(readOnly = true)
    public List<EmailDTO> findAll() {
        return emailMapper.toDto(emailRepository.findAll());
    }


























//     @Transactional
//     public List<EmailDTO> findAll() {
//         return emailMapper.toDTO(emailemailRepository.findAll());
//     }

//     @Transactional
//    private EmailDTO findByIdEmail(Long idEmail) {
//        return emailemailRepository.findByIdEmail(idEmail).map(emailMapper::toDto).orElseThrow(NotFoundException::new);

    

//     // Metodo para salvar
//     @Transactional
//     public EmailDTO save(EmailDTO emailDTO) {
//         Optional<Email> optionalEmail = emailemailRepository.findByEmail(emailDTO.getEmailDTO());
//         if (optionalEmail.isPresent()) {
//             throw new BusinessException(Messagess.EMAIL_EXISTE);
//         }
//         Email email = emailMapper.toEntity(emailDTO);
//         emailemailRepository.save(email);
//         return emailMapper.toDTO(email);
//     }

//     // Metodo para atualizar
//     @Transactional
//     public EmailDTO update(EmailDTO emailDTO) {
//         Optional<Email> optionalEmail = emailemailRepository.findByEmail(emailDTO.getEmailDTO());
//         if (optionalEmail.isPresent()) {
//             throw new BusinessException(Messagess.EMAIL_NAO_EXISTE);
//         }

//         Email email = emailMapper.toEntity(emailDTO);
//         emailemailRepository.save(email);
//         return emailMapper.toDTO(email);
//     }

//     // Metodo para deletar
//     @Transactional
//     public EmailDTO delete(EmailDTO emailDTO) {
//         Optional<EmailDTO> optionalEmailDTO = findByIdEmail(emailDTO.getIdEmailDTO());
//         return emailemailRepository.deleteById(emailDTO);

//     }
}
