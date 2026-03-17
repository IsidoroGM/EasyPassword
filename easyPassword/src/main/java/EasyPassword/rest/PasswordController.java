package EasyPassword.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EasyPassword.dto.PasswordRequest;
import EasyPassword.dto.PasswordResponse;
import EasyPassword.service.PasswordService;
import jakarta.validation.Valid;

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

    @GetMapping("/test")
    public PasswordResponse testEndpoint() {
        return new PasswordResponse("¡El endpoint funciona!");
    }

}