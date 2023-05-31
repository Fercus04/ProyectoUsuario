Proxecto Junit5 + Jacoco

Xon, Clase principa: El código proporcionado es una implementación de una interfaz de registro de usuarios utilizando la biblioteca Swing de Java para la creación de ventanas y componentes gráficos.
La clase ConVentana contiene el método main que crea una instancia de la clase VentanaRegistro para mostrar la ventana de registro.
La clase VentanaRegistro extiende la clase JFrame, que representa la ventana principal de la interfaz. En el constructor de esta clase se configuran los componentes de la ventana, como etiquetas, campos de texto, botones, etc.
Los componentes de la interfaz se organizan utilizando un GridBagLayout, que permite una disposición flexible de los componentes en filas y columnas. Se definen instancias de JLabel, JTextField, JPasswordField y JButton para representar diferentes elementos de la interfaz de registro.
El botón "Registrar" tiene un ActionListener asociado a él, implementado en la clase interna Comprobar. Cuando se hace clic en el botón, se ejecuta el método actionPerformed, que recupera los valores ingresados en los campos de texto y realiza varias comprobaciones de validación.
Se realizan validaciones en los campos de correo electrónico, sitio web, fecha de nacimiento y contraseña. Si alguna de estas validaciones falla, se muestra un mensaje de error y se enfoca en el campo correspondiente.
Si todas las validaciones son exitosas, se crea una instancia de la clase Usuario con los datos ingresados y se almacena en el arreglo usuarios. Luego se muestra un mensaje de éxito y se imprimen los datos del usuario en la consola.


Manuel, Validador: La clase Validador contiene métodos estáticos para validar diferentes tipos de datos utilizados en el proyecto.
validarEmail(String email): Este método utiliza una expresión regular para validar si una cadena de texto cumple con el formato de un correo electrónico válido. Devuelve true si el correo electrónico es válido y false en caso contrario.
validarContrasinal(String contrasinal): Este método utiliza una expresión regular para validar si una cadena de texto cumple con los requisitos de una contraseña segura. La contraseña debe tener al menos 8 caracteres, al menos un número, al menos un carácter especial y no debe contener caracteres espacios en blanco. Devuelve true si la contraseña es válida y false en caso contrario.
validarWeb(String web): Este método utiliza una expresión regular para validar si una cadena de texto cumple con el formato de una URL válida. La URL puede comenzar con "http://" o "https://", seguido de un nombre de dominio válido y puede tener una ruta opcional. Devuelve true si la URL es válida y false en caso contrario.
validarNacemento(LocalDate nacemento): Este método recibe una fecha de nacimiento como un objeto LocalDate y la compara con la fecha actual para verificar si la fecha de nacimiento es anterior a la fecha actual. Devuelve true si la fecha de nacimiento es válida (anterior a la fecha actual) y false en caso contrario.


Antonio, Usuario: La clase Usuario es una clase que representa un objeto de usuario en el sistema. Tiene diferentes atributos como el nombre (name), correo electrónico (email), contraseña (contrasinal), sitio web (web) y fecha de nacimiento (nacemento).
La clase Usuario tiene dos constructores. El primer constructor recibe los parámetros de correo electrónico, contraseña, sitio web y fecha de nacimiento para inicializar los atributos correspondientes. El segundo constructor, además de esos parámetros, también recibe el nombre del usuario y lo asigna al atributo name.
La clase Usuario también proporciona los métodos getter y setter para acceder y modificar los atributos. Por ejemplo, getEmail() devuelve el correo electrónico del usuario, setEmail() establece el correo electrónico y así sucesivamente para los demás atributos.
En resumen, la clase Usuario es una representación de un usuario en el sistema, con sus datos personales y métodos para acceder y modificar esos datos.


Brais, JUnit5 Prueba: Sin hacer.
