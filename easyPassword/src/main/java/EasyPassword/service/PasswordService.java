//Servicio que generará la contraseña a partir de las opciones recibidas en el DTO PasswordRequest.

package EasyPassword.service;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

import EasyPassword.dto.PasswordRequest;


/**
 * Servicio que contiene la lógica para generar contraseñas seguras.
 */

@Service
public class PasswordService {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+";

    private final SecureRandom random = new SecureRandom(); // Generador criptográfico

    /**
     * Genera una contraseña según las opciones recibidas
     */
    public String generatePassword(PasswordRequest request) {
        StringBuilder characterPool = new StringBuilder();

        // Construir el conjunto de caracteres según opciones
        if (request.isUppercase()) characterPool.append(UPPERCASE);
        if (request.isLowercase()) characterPool.append(LOWERCASE);
        if (request.isNumbers()) characterPool.append(NUMBERS);
        if (request.isSymbols()) characterPool.append(SYMBOLS);

        if (characterPool.isEmpty()) {
            throw new IllegalArgumentException("Debe seleccionar al menos un tipo de carácter");
        }

        // Generar contraseña aleatoria
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < request.getLength(); i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return password.toString();
    }

}
