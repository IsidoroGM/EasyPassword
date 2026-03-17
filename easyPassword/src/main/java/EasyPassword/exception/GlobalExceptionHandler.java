package EasyPassword.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}

// Este manejador global captura las IllegalArgumentException lanzadas por el servicio y devuelve un error 400 con el mensaje correspondiente.
// Es importante para manejar casos como cuando el usuario no selecciona ningún tipo de carácter, lo que es una validación crítica en nuestro servicio de generación de contraseñas.

// Qué consigues con esto

// Evitas que la app crashee

// Devuelves errores claros al frontend

// Comportamiento profesional tipo API real