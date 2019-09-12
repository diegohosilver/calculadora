# calculadora
### Trabajo práctico para Programación III
Este repositorio contiene código fuente y consignas a realizar en Java
### Estructura del proyecto
```
└───src
    ├───main
    │   ├───negocio -----> Clases con la lógica de negocio del proyecto
    │   │   └───calculo -> Clases con la lógica para realizar cálculos
    │   └───interfaz ----> Clases con las interfaces visuales del proyecto
    └───test
        ├───calculo -----> Tests para verificar la funcionalidad de Calculo
        └───cache -------> Test para verificar la funcionalidad de Historial y Memoria
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
2. `void agregar()`: Agrega un número a la memoria de la calculadora. Si la cantidad de items sobrepasa el límite, se remueve el primer número ingresado.
3. `ArrayList<Double> listar()`: Obtiene todos los números almacenados en la memoria.
4. `void vaciar()`: Vacía la memoria.
##### Operacion
Es una `Clase` que guarda la información de una operación. <br>
Cuenta con los siguientes métodos públicos:
1. `Operacion(string, double)`: Constructor de la clase. Requiere la descripción de la operación como parámetro.
    * Excepciones:
        * Tipo: `IllegalArgumentException`.
        * Descripción: _Descripcion no puede estar vacío_.
2. `String descripcion()`: Devuelve la descripción de la operación (por ejemplo "1 + 1").
3. `double valor()`: Devuelve el valor de la operación (por ejemplo `2`).
##### Historial
Es un `Singleton` que funciona como historial de operaciones de la calculadora. De esta manera se puede visualizar todas las operaciones realizadas por el usuario, y restaurar el estado de la calculadora a cualquier operación seleccionada. <br>
Cuenta con los siguientes métodos públicos:
1. `Historial obtenerInstancia()`: Devuelve la instancia de la clase para poder acceder a los métodos.
2. `void agregar(string, double)`: Agrega un registro al historial. Requiere la descripción de la operación como parámetro.
    * Excepciones:
        * Tipo: `IllegalArgumentException`.
        * Descripción: _Descripcion no puede estar vacío_.
3. `Map<String, Operacion> listar()`: Devuelve el historial completo, donde la clave es un `GUID` y el valor es una instancia de `Operacion`.
4. `Operacion obtener(string)`: Devuelve un registro del historial a partir de la clave brindada.
    * Excepciones:
        * Tipo: `NoSuchElementException`.
        * Descripción: _No existe ninguna operacion con la clave dada_.
5. `void restaurar(string)`: Trunca el historial en el registro con la clave brindada.
    * Excepciones:
        * Tipo: `NoSuchElementException`.
        * Descripción: _No existe ninguna operacion con la clave dada_.
6. `void vaciar()`: Elimina todos los registros del historial.