package com.sistemaexamenes;

import com.sistemaexamenes.model.Rol;
import com.sistemaexamenes.model.Usuario;
import com.sistemaexamenes.model.UsuarioRol;
import com.sistemaexamenes.repository.UsuarioRepository;
import com.sistemaexamenes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SistemaExamenesBackendApplication implements CommandLineRunner {
@Autowired
private UsuarioService usuarioService;
	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(SistemaExamenesBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Usuario usuario=new Usuario();

		usuario.setUsername("oscar");
		usuario.setApellido("tavera");
		usuario.setPassword("12345");
		usuario.setEmail("oscar@gmail.com");
		usuario.setTelefono("2345566");
		usuario.setPerfil("oscar.jpg");
		usuario.setUsername("oscar");

		Rol rol =new Rol();
		rol.setRolId(1L);
		rol.setNombre("ADMIN");

		Set<UsuarioRol>usuarioRoles=new HashSet<>();
		 UsuarioRol usuarioRol=new UsuarioRol();
		 usuarioRol.setRol(rol);
		 usuarioRol.setUsuario(usuario);
		 usuarioRoles.add(usuarioRol);
		 Usuario usuarioGuardado=usuarioService.guardarusuario(usuario,usuarioRoles);

		System.out.println("funcionó"+usuarioGuardado.getUsername());

*/

	}
}
