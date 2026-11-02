package crediyaautenticacionms.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Optional;

public interface UserJPARepository extends CrudRepository<JPARepository, Long>, QueryByExampleExecutor<JPARepository> {
    Optional<JPARepository> findByCorreoElectronico(String correoElectronico);
    boolean existsByCorreoElectronico(String correoElectronico);
}


