package EasyPassword.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO que representa la respuesta que enviaremos al frontend
 * después de generar la contraseña.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor // <--- Añadimos esto para evitar errores de serialización
public class PasswordResponse {

    private String password;  // Contraseña generada

    
}


// @AllArgsConstructor permite crear objetos con todos los atributos en el constructor.
// Contiene solo la contraseña generada.