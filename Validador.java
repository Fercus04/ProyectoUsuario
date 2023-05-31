package Proyecto;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class Validador {
    private static final String EMAIL_REGEX = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
    private static final String CONTRASEINAL_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
    private static final String URL_REGEX = "^(http://|https://)?([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$";

    public static boolean validarEmail(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }

    public static boolean validarContrasinal(String contrasinal) {
        return Pattern.matches(CONTRASEINAL_REGEX, contrasinal);
    }

    public static boolean validarWeb(String web) {
        return Pattern.matches(URL_REGEX, web);
    }

    public static boolean validarNacemento(LocalDate nacemento) {
        LocalDate dataActual = LocalDate.now();
        return nacemento.isBefore(dataActual);
    }
}
