package br.com.servico.agendatelefonica.utils.exceptions;

import br.com.servico.agendatelefonica.utils.Messages;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super(Messages.CONTATO_NAO_EXISTE);
    }
}
