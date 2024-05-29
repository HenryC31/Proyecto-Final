import controllers.Auth;

public class Main {

	public static void main(String[] args) {
		Auth controlador = new Auth();
		controlador.iniciar();
		controlador.login();
	}

}
