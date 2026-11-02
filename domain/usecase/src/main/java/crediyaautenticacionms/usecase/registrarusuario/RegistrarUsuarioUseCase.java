package crediyaautenticacionms.usecase.registrarusuario;

import crediyaautenticacionms.model.usuario.Usuario;
import crediyaautenticacionms.model.usuario.gateways.UsuarioRepository;
import crediyaautenticacionms.usecase.buscarusuario.BuscarUsuarioUseCase;
import crediyaautenticacionms.usecase.validarusuario.ValidarUsuarioUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegistrarUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;
    private final ValidarUsuarioUseCase validarUsuarioUseCase;
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;

    public Usuario registrar(Usuario usuario) {
        validarUsuarioUseCase.validar(usuario);

        if (buscarUsuarioUseCase.existePorCorreo(usuario.getCorreoElectronico())) {
            throw new IllegalArgumentException("El correo electrónico ya se encuentra registrado por otro solicitante.");
        }

        return usuarioRepository.guardar(usuario);
    }
}

