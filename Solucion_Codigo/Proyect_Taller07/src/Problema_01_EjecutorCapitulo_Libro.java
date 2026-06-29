import java.util.ArrayList;

/**
 * Problema 01: Jerarquía de clases para el capítulo de libro.
 * Un capítulo está compuesto por secciones, cada sección por componentes
 * (párrafos, figuras, tablas, etc.), un párrafo por sentencias y cada
 * sentencia por palabras. Una palabra puede aparecer en varias sentencias.
 * @author Daniel Castillo
 * @version 1.0
 */
class Palabra {
}
class Sentencia {
   
}
class Componente {
}
class Parrafo extends Componente {
    
}
class Figura extends Componente {
}
class Tabla extends Componente {
}
class Secciones {
    
}
class Capitulo {
    
}
public class Problema_01_EjecutorCapitulo_Libro {
    public static void main(String[] args) {
        Capitulo capitulo1 = new Capitulo();
        Secciones seccion1 = new Secciones();
        Parrafo parrafo1 = new Parrafo();
        Figura figura1 = new Figura();
        Tabla tabla1 = new Tabla();
        Sentencia sentencia1 = new Sentencia();
        Palabra palabra1 = new Palabra();
    }
}
