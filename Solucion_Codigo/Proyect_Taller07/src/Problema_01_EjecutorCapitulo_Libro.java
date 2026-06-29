import java.util.ArrayList;

class Palabra {
    private String texto;

    public Palabra(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String toString() {
        return "Palabra: " + texto;
    }
}

class Sentencia {
    private String descripcion;
    private ArrayList<Palabra> palabras;

    public Sentencia(String descripcion) {
        this.descripcion = descripcion;
        this.palabras = new ArrayList<>();
    }

    public void agregarPalabra(Palabra p) {
        palabras.add(p);
    }

    public String toString() {
        String resultado = "  Sentencia: " + descripcion + "\n";
        for (int i = 0; i < palabras.size(); i++) {
            resultado += "\t\t" + palabras.get(i).toString() + "\n";
        }
        return resultado;
    }
}

class ComponenteSeccion {
    private String descripcion;

    public ComponenteSeccion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String toString() {
        return "ComponenteSeccion: " + descripcion;
    }
}

class Parrafo extends ComponenteSeccion {
    private ArrayList<Sentencia> sentencias;

    public Parrafo(String descripcion) {
        super(descripcion);
        this.sentencias = new ArrayList<>();
    }

    public void agregarSentencia(Sentencia s) {
        sentencias.add(s);
    }

    public String toString() {
        String resultado = "Parrafo: " + getDescripcion() + "\n";
        for (int i = 0; i < sentencias.size(); i++) {
            resultado += "\t" + sentencias.get(i).toString();
        }
        return resultado;
    }
}

class Figura extends ComponenteSeccion {
    private String imagen;

    public Figura(String descripcion, String imagen) {
        super(descripcion);
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String toString() {
        return "Figura: " + getDescripcion() + " | Imagen: " + imagen;
    }
}

class Seccion {
    private String titulo;
    private ArrayList<ComponenteSeccion> componentes;

    public Seccion(String titulo) {
        this.titulo = titulo;
        this.componentes = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void agregarComponente(ComponenteSeccion c) {
        componentes.add(c);
    }

    public String toString() {
        String resultado = "Seccion: " + titulo + "\n";
        for (int i = 0; i < componentes.size(); i++) {
            resultado += "\t" + componentes.get(i).toString() + "\n";
        }
        return resultado;
    }
}

class Capitulo {
    private String titulo;
    private int numero;
    private ArrayList<Seccion> secciones;

    public Capitulo(String titulo, int numero) {
        this.titulo = titulo;
        this.numero = numero;
        this.secciones = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void agregarSeccion(Seccion s) {
        secciones.add(s);
    }

    public String toString() {
        String resultado = "Capitulo " + numero + ": " + titulo + "\n";
        for (int i = 0; i < secciones.size(); i++) {
            resultado += "\t" + secciones.get(i).toString();
        }
        return resultado;
    }
}

public class Problema_01_EjecutorCapitulo_Libro {
    public static void main(String[] args) {

        Palabra p1 = new Palabra("Hola");
        Palabra p2 = new Palabra("mundo");

        Sentencia sentencia1 = new Sentencia("Primera sentencia");
        sentencia1.agregarPalabra(p1);
        sentencia1.agregarPalabra(p2);

        Parrafo parrafo1 = new Parrafo("Parrafo introductorio");
        parrafo1.agregarSentencia(sentencia1);

        Figura figura1 = new Figura("Diagrama UML", "diagrama.png");

        Seccion seccion1 = new Seccion("Introduccion");
        seccion1.agregarComponente(parrafo1);
        seccion1.agregarComponente(figura1);

        Capitulo capitulo1 = new Capitulo("Fundamentos", 1);
        capitulo1.agregarSeccion(seccion1);

        System.out.println(capitulo1.toString());
    }
}