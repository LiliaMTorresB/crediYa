package crediyaautenticacionms.model.usuario.gateways;

import crediyaautenticacionms.model.usuario.Usuario;
import java.util.Optional;

public interface UsuarioRepository {
    Usuario guardar(Usuario usuario);
    Optional<Usuario> buscarPorCorreoElectronico(String correoElectronico);
    boolean existePorCorreoElectronico(String correoElectronico);
}


