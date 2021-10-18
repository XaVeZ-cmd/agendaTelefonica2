package br.com.servico.agendatelefonica.utils.exceptions;

import br.com.servico.agendatelefonica.utils.Messages;

public class EmailException extends RuntimeException{
    public EmailException(){
        super(Messages.EMAIL_NAO_EXISTE);
    }

}
