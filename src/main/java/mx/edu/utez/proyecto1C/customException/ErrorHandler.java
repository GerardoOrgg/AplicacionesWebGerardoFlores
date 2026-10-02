package mx.edu.utez.proyecto1C.customExceptions;

import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> validar(
            MethodArgumentNotValidException ex) {

        <Map errores = new LinkedHashMap<>();

        for (FieldError err : ex.getBindingResult().getFieldErrors()) {
            errores.put(err.getField(), err.getDefaultMessage());
        }

        return ResponseEntity.badRequest().body(errores);
    }

    public ResponseEntity<Map<String, String>> manejarBadRequest(
            BadRequestException ex) {

        Map<String, String> errores = new LinkedHashMap<>();
        errores.put("error", ex.getMessage());

        return ResponseEntity.badRequest().body(errores);
    }
}