package EasyPassword.rest;

import EasyPassword.dto.PasswordRequest;
import EasyPassword.dto.PasswordResponse;
import EasyPassword.service.PasswordService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST que maneja las peticiones relacionadas
 * con la generación de contraseñas.
 */

@RestController
@RequestMapping("/api/password")  // URL base para este controlador
public class PasswordController {

    
    private final PasswordService passwordService;

    // Inyección de dependencia del servicio
    @Autowired
    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    /**
     * Endpoint POST para generar una contraseña.
     * @param request DTO con opciones de la contraseña
     * @return PasswordResponse con la contraseña generada
     */
    @PostMapping("/generate")
    public PasswordResponse generatePassword(@Valid @RequestBody PasswordRequest request) {
        // Llamamos al servicio que genera la contraseña
        String password = passwordService.generatePassword(request);
        return new PasswordResponse(password);
    }

}