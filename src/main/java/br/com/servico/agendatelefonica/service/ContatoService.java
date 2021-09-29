package br.com.servico.agendatelefonica.service;

import br.com.servico.agendatelefonica.dto.ContatoDTO;
import br.com.servico.agendatelefonica.exceptions.BusinessException;
import br.com.servico.agendatelefonica.exceptions.NotFoundException;
import br.com.servico.agendatelefonica.mapper.ContatoMapper;
import br.com.servico.agendatelefonica.models.Contato;
import br.com.servico.agendatelefonica.repository.ContatoRepository;
import br.com.servico.agendatelefonica.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {
	@Autowired
	private ContatoRepository contatoRepository;

	@Autowired
	private ContatoMapper contatoMapper;

	@Transactional
	public List<ContatoDTO> findAll() {
		return contatoMapper.toDTO(contatoRepository.findAll());
	}

	@Transactional
	public ContatoDTO getById(Long id) {
		return contatoRepository.findById(id).map(contatoMapper::toDTO).orElseThrow(NotFoundException::new);
	}

	@Transactional
	public ContatoDTO save(ContatoDTO contatoDTO) {
		Optional<Contato> optionalContato = contatoRepository.findByEmail(contatoDTO.getEmail());
		if (optionalContato.isPresent()) {
			throw new BusinessException(Messages.CONTATO_EXISTE);
		}
		Contato contato = contatoMapper.toEntity(contatoDTO);
		contatoRepository.save(contato);
		return contatoMapper.toDTO(contato);
	}

	@Transactional
	public ContatoDTO update(ContatoDTO contatoDTO) {
		Optional<Contato> optionalContato = contatoRepository.findByEmail(contatoDTO.getEmail());
		if (optionalContato.isPresent()) {
			throw new BusinessException(Messages.CONTATO_NAO_EXISTE);
		}

		Contato contato = contatoMapper.toEntity(contatoDTO);
		contatoRepository.save(contato);
		return contatoMapper.toDTO(contato);
	}

	@Transactional
	public ContatoDTO delete(Long id) {
		ContatoDTO contatoDTO = this.getById(id);
		contatoRepository.deleteById(contatoDTO.getId());
		return contatoDTO;
	}

}