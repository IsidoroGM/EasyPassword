//Servicio que generará la contraseña a partir de las opciones recibidas en el DTO PasswordRequest.

package EasyPassword.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    private final SecureRandom random = new SecureRandom();

    public String generatePassword(PasswordRequest request) {

        List<Character> passwordChars = new ArrayList<>();
        StringBuilder pool = new StringBuilder();

        // 🔹 Añadir al pool según opciones
        if (request.isUppercase()) {
            pool.append(UPPERCASE);
            passwordChars.add(randomChar(UPPERCASE)); // aseguramos al menos 1
        }

        if (request.isLowercase()) {
            pool.append(LOWERCASE);
            passwordChars.add(randomChar(LOWERCASE));
        }

        if (request.isNumbers()) {
            pool.append(NUMBERS);
            passwordChars.add(randomChar(NUMBERS));
        }

        if (request.isSymbols()) {
            pool.append(SYMBOLS);
            passwordChars.add(randomChar(SYMBOLS));
        }

        // 🔴 Validación crítica
        if (pool.isEmpty()) {
            throw new IllegalArgumentException("Debes seleccionar al menos un tipo de carácter");
        }

        // 🔹 Rellenar el resto de la contraseña
        while (passwordChars.size() < request.getLength()) {
            passwordChars.add(randomChar(pool.toString()));
        }

        // 🔹 Mezclar caracteres (muy importante)
        Collections.shuffle(passwordChars);

        // 🔹 Convertir a String final
        StringBuilder password = new StringBuilder();
        for (char c : passwordChars) {
            password.append(c);
        }

        return password.toString();
    }

    /**
     * Devuelve un carácter aleatorio de un String
     */
    private char randomChar(String source) {
        return source.charAt(random.nextInt(source.length()));
    }
}
