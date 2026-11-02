package crediyaautenticacionms.api;

import crediyaautenticacionms.model.usuario.Usuario;
import crediyaautenticacionms.usecase.registrarusuario.RegistrarUsuarioUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/usuarios")
@AllArgsConstructor
public class ApiRest {

    private final RegistrarUsuarioUseCase registrarUsuarioUseCase;

    @PostMapping
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario usuarioCreado = registrarUsuarioUseCase.registrar(usuario);
            return new ResponseEntity<>(usuarioCreado, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error inesperado al procesar la solicitud.");
        }
    }
}

