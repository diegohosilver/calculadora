# calculadora
### Trabajo práctico para Programación III
Este repositorio contiene código fuente y consignas a realizar en Java
### Estructura del proyecto
```
└───src
    ├───main
    │   ├───negocio -----------> Clases con la lógica de negocio del proyecto
    │   │   └───calculo -------> Clases con la lógica para realizar cálculos
    │   └───interfaz ----------> Clases con las interfaces visuales del proyecto
    │       └───controles -----> Clases con la lógica para generar controles
    └───test
        ├───calculo -----------> Tests para verificar la funcionalidad de Calculo
        ├───cache -------------> Test para verificar la funcionalidad de Historial y Memoria
        └───controles ---------> Test para verificar la funcionalidad del generador de Botones, Textos y Etiquetas
```
### Documentación
#### Negocio.Calculo
##### Operacion
Es un `ENUM` con las cuatro operaciones básicas: `SUMA`, `RESTA`, `PRODUCTO` y `DIVISION`. <br>
Cada una de ellas devuelve una instancia de la clase que realiza la operación indicada en su nombre.
##### Aritmetica
Es una `Interface` que contiene el método `double calcular(double, double)` a implementar.
##### Suma - Resta - Producto - Division
Cada archivo es una `Clase` que implementa `Aritmetica`.
##### Calculo
Cuenta con los siguientes métodos públicos:
1. `Calculo(Operacion.[Opcion seleccionada])`: Constructor de la clase. Requiere una operación como parámetro.
   * Excepciones:
     * Tipo: `IllegalArgumentException`.
     * Descripción: _Operacion no puede estar vacío_.
2. `void cambiarOperador(Operacion.[Opcion seleccionada])`: Permite cambiar el operador actual.
3. `Operacion obtenerOperadorActual()`: Devuelve el operador actualmente establecido.
4. `double calcular(double, double)`: Realiza un cálculo entre dos terminos según el operador establecido.
   * Excepciones (`Operador.DIVISION`):
     * Tipo: `IllegalArgumentException`.
     * Descripción: _No se puede dividir por cero_.
#### Negocio
##### Memoria
Es un `Singleton` que funciona como la memoria de la calculadora. Permite almacenar hasta 3 números. <br>
Cuenta con los siguientes métodos públicos:
1. `Memoria obtenerInstancia()`: Devuelve la instancia de la clase para poder acceder a los métodos.
2. `void agregarNumero()`: Agrega un número a la memoria de la calculadora. Si la cantidad de items sobrepasa el límite, se remueve el primer número ingresado.
3. `ArrayList<Double> listar()`: Obtiene todos los números almacenados en la memoria.
4. `void vaciar()`: Vacía la memoria.
##### Registro
Es una `Clase` que guarda la información de una operación. <br>
Cuenta con los siguientes métodos públicos:
1. `Registro(string, double)`: Constructor de la clase. Requiere la descripción de la operación como parámetro.
    * Excepciones:
        * Tipo: `IllegalArgumentException`.
        * Descripción: _Descripcion no puede estar vacío_.
2. `String obtenerDescripcion()`: Devuelve la descripción de la operación (por ejemplo "1 + 1").
3. `double obtenerValor()`: Devuelve el valor de la operación (por ejemplo `2`).
##### Historial
Es un `Singleton` que funciona como historial de operaciones de la calculadora. De esta manera se puede visualizar todas las operaciones realizadas por el usuario, y restaurar el estado de la calculadora a cualquier operación seleccionada. <br>
Cuenta con los siguientes métodos públicos:
1. `Historial obtenerInstancia()`: Devuelve la instancia de la clase para poder acceder a los métodos.
2. `void agregarRegistro(string, double)`: Agrega un registro al historial. Requiere la descripción de la operación como parámetro.
    * Excepciones:
        * Tipo: `IllegalArgumentException`.
        * Descripción: _Descripcion no puede estar vacío_.
3. `Map<String, Operacion> listar()`: Devuelve el historial completo, donde la clave es un `GUID` y el valor es una instancia de `Operacion`.
4. `Operacion obtenerRegistro(string)`: Devuelve un registro del historial a partir de la clave brindada.
    * Excepciones:
        * Tipo: `NoSuchElementException`.
        * Descripción: _No existe ninguna operacion con la clave dada_.
5. `void truncarEnRegistro(string)`: Trunca el historial en el registro con la clave brindada.
    * Excepciones:
        * Tipo: `NoSuchElementException`.
        * Descripción: _No existe ninguna operacion con la clave dada_.
6. `void vaciar()`: Elimina todos los registros del historial.
#### Interfaz.Controles
##### Control
Es una `Clase` que genera controles visuales. <br>
Cuenta con los siguientes métodos públicos:
1. `JButton generarBoton(string, dimensiones, [opcional] actionListener)`: Devuelve un `JButton` con las propiedades establecidas.
    * Excepciones:
        * Tipo: `IllegalArgumentException`.
        * Descripción: _Texto no puede estar vacío_.
        * Tipo: `IllegalArgumentException`.
        * Descripción: _Evento no puede estar vacío_.
2. `JTextField generarTexto(dimensiones, color, boolean, [opcional] actionListener)`: Devuelve un `JTextField` con las propiedades establecidas.
    * Excepciones:
        * Tipo: `IllegalArgumentException`.
        * Descripción: _Texto no puede estar vacío_.
        * Tipo: `IllegalArgumentException`.
        * Descripción: _Evento no puede estar vacío_.
3. `JLabel generarEtiqueta(string, dimensiones`: Devuelve un `JLabel` con las propiedades establecidas.
    * Excepciones:
        * Tipo: `IllegalArgumentException`.
        * Descripción: _Texto no puede estar vacío_.
##### Dimensiones
Es una `Clase` que guarda coordenadas y dimensiones. <br>
Cuenta con los siguientes métodos públicos:
1. `Dimensiones(int, int, int, int)`: Constructor de la clase.
2. `int obtenerX()`: Devuelve el valor del eje X.
3. `int obtenerY()`: Devuelve el valor del eje Y.
4. `int obtenerAncho()`: Devuelve el valor del ancho.
5. `int obtenerAlto()`: Devuelve el valor del alto.
#### Interfaz
##### Item
Es una `Clase` que sirve de contenedor para unir Clave - Valor de un registro del historial.
##### Controlador
Es una `Clase` que inicializa el programa.
##### PantallaPrincipal
Es una `Clase` que muestra la calculadora dentro de un `JFrame`.
##### PantallaHistorial
Es una `Clase` que muestra el historial de operaciones dentro de un `JFrame`.