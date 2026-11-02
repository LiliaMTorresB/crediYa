package crediyaautenticacionms.usecase.buscarusuario;

import crediyaautenticacionms.model.usuario.gateways.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BuscarUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    public boolean existePorCorreo(String correoElectronico) {
        return usuarioRepository.existePorCorreoElectronico(correoElectronico);
    }
}

