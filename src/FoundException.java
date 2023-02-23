import java.util.Date;

public class FoundException {

	public static void main(String[] args) {
		// Le programme suivant présente des problèmes, trouver lesquels et utiliser
		// tous les moyens permettant l’affichage des 2 instructions en utilisant
		// notamment le
		// mécanisme d’exception (au passage, d’où sort la méthode getClass() ?)

		// la methode getClass() est hérité de la classe mere Object
		Date date = null;
		Date today = new Date();
		try {
			System.out.println(date.getClass().getName());
			System.out.println("le nom de la classe :" + today.getClass().getName());

		} catch (NullPointerException e) {
			System.out.println("on peut pas utiliser la methode getClass() sur un objet null !");
			// e.printStackTrace();
		} finally {
			System.out.println("on passe ici ");
		}

	}

}
