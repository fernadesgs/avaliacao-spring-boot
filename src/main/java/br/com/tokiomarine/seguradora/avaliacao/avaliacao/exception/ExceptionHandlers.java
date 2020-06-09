package br.com.tokiomarine.seguradora.avaliacao.avaliacao.exception;

import br.com.tokiomarine.seguradora.avaliacao.avaliacao.message.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@Slf4j
@ControllerAdvice
@RestController
public class ExceptionHandlers {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ResponseMessage> exceptionError(Exception ex, WebRequest request) {
        ResponseMessage responseMensage = ResponseMessage.builder()
                .messageError("Ocorreu um erro inesperado...")
                .error(Boolean.TRUE)
                .date(new Date())
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        log.error(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.OK).body(responseMensage);
    }
}
