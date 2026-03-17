
package EasyPassword.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordRequest {

    @Min(4) // La longitud mínima de la contraseña debe ser de 4 caracteres
    @Max(128) // La longitud máxima de la contraseña debe ser de 50 caracteres
    private int length;
    
    private boolean uppercase;
    private boolean lowercase;
    private boolean numbers;
    private boolean symbols;

}
