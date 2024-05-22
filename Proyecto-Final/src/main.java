import controllers.Auth;

public class main {

	public static void main(String[] args) {
		Auth controlador = new Auth();
		controlador.iniciar();
		controlador.login();
	}

}
