package cucumber.api.junit.Types;

import cucumber.api.junit.Enum.PerfilUsuario;
import lombok.Data;

@Data
public class Usuario {

	private String usuario;
	private String senha;

	public Usuario(PerfilUsuario perfil) {
		if (perfil.equals(PerfilUsuario.ADMINISTRATOR)) {
			setUsuario("administrator");
			setSenha("bomfin030788");
		}
	}
}
