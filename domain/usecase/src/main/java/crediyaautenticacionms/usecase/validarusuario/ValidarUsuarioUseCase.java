package crediyaautenticacionms.usecase.validarusuario;

import crediyaautenticacionms.model.usuario.Usuario;
import java.math.BigDecimal;
import java.util.regex.Pattern;

public class ValidarUsuarioUseCase {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private static final BigDecimal SALARIO_MAXIMO = new BigDecimal("15000000");

    public void validar(Usuario usuario) {
        if (usuario.getNombres() == null || usuario.getNombres().trim().isEmpty()) {
            throw new IllegalArgumentException("El campo nombres es obligatorio.");
        }
        if (usuario.getApellidos() == null || usuario.getApellidos().trim().isEmpty()) {
            throw new IllegalArgumentException("El campo apellidos es obligatorio.");
        }
        if (usuario.getCorreoElectronico() == null || usuario.getCorreoElectronico().trim().isEmpty()) {
            throw new IllegalArgumentException("El campo correo_electronico es obligatorio.");
        }
        if (!EMAIL_PATTERN.matcher(usuario.getCorreoElectronico()).matches()) {
            throw new IllegalArgumentException("El formato del correo electrónico no es válido.");
        }
        if (usuario.getSalarioBase() == null) {
            throw new IllegalArgumentException("El campo salario_base es obligatorio.");
        }
        if (usuario.getSalarioBase().compareTo(BigDecimal.ZERO) < 0 || usuario.getSalarioBase().compareTo(SALARIO_MAXIMO) > 0) {
            throw new IllegalArgumentException("El salario base debe estar entre 0 y 15,000,000.");
        }
    }
}


