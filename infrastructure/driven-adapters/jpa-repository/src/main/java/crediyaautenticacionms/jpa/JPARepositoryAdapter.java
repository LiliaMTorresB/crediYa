package crediyaautenticacionms.jpa;

import crediyaautenticacionms.model.usuario.Usuario;
import crediyaautenticacionms.model.usuario.gateways.UsuarioRepository;
import crediyaautenticacionms.jpa.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JPARepositoryAdapter extends AdapterOperations<Usuario, JPARepository, Long, UserJPARepository>
        implements UsuarioRepository {

    public JPARepositoryAdapter(UserJPARepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Usuario.class));
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return save(usuario);
    }

    @Override
    public Optional<Usuario> buscarPorCorreoElectronico(String correoElectronico) {
        return repository.findByCorreoElectronico(correoElectronico)
                .map(entity -> mapper.map(entity, Usuario.class));
    }

    @Override
    public boolean existePorCorreoElectronico(String correoElectronico) {
        return repository.existsByCorreoElectronico(correoElectronico);
    }
}