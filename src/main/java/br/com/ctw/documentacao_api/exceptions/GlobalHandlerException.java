package br.com.ctw.documentacao_api.exceptions;

import br.com.ctw.documentacao_api.dto.ErroResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException
{
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErroResponse> handlerNotFound(
            NotFoundException ex, HttpServletRequest request
    )
    {
        ErroResponse erro = new ErroResponse(
                HttpStatus.NOT_FOUND.value(),
                "Recurso não encontrado",
                ex.getMessage(),
                request.getRequestURI()
                );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

}
