
import java.util.ArrayList;

class Zona{
    public String nombreZona;
    public int cantidadLocalidades;
    public double precioNormal, precioAbonado;
    public int entradasVendidas = 0;
    
    public boolean estaCompleta() {
    return entradasVendidas >= cantidadLocalidades;
    }
    public void registrarVenta() {
    entradasVendidas++;
    }

    public Zona(String nombreZona, int cantidadLocalidades, double precioNormal, double precioAbonado) {
        this.nombreZona = nombreZona;
        this.cantidadLocalidades = cantidadLocalidades;
        this.precioNormal = precioNormal;
        this.precioAbonado = precioAbonado;
    }

    @Override
    public String toString() {
        return "Zona{" + "nombreZona=" + nombreZona + ", cantidadLocalidades=" + cantidadLocalidades + ", precioNormal=" + precioNormal + ", precioAbonado=" + precioAbonado + '}';
    }
    
}

class Entrada{
    public int idEntrada, numeroEntradas;
    public Zona zona;
    public String nombreComprador;
    public double costoFinalEntrada;

    public Entrada(int idEntrada, int numeroEntradas, Zona zona, String nombreComprador) {
        this.idEntrada = idEntrada;
        this.numeroEntradas = numeroEntradas;
        this.zona = zona;
        this.nombreComprador = nombreComprador;
    }

    @Override
    public String toString() {
        return "Entrada{" + "idEntrada=" + idEntrada + ", numeroEntradas=" + numeroEntradas + ", zona=" + zona + ", nombreComprador=" + nombreComprador + ", costoFinalEntrada=" + costoFinalEntrada + '}';
    }
    
    
    public double calcularCostoFinalEntrada(double precioEntrada){
        this.costoFinalEntrada = (this.numeroEntradas * precioEntrada);
    return this.costoFinalEntrada;
   }
}

class Entrada_Normal extends Entrada{

    public Entrada_Normal(int idEntrada, int numeroEntradas, Zona zona, String nombreComprador) {
        super(idEntrada, numeroEntradas, zona, nombreComprador);
    }

    
    public double calcularCostoFinalEntrada(){
        this.costoFinalEntrada = (super.calcularCostoFinalEntrada(zona.precioNormal));
         return this.costoFinalEntrada;
   }

    @Override
    public String toString() {
        return "Entrada_Normal{" + '}'+ super.toString();
    }
    
}

class Entrada_Reducida extends Entrada{
    public double porcentajeRebaja;

    public Entrada_Reducida(double porcentajeRebaja, int idEntrada, int numeroEntradas, Zona zona, String nombreComprador) {
        super(idEntrada, numeroEntradas, zona, nombreComprador);
        this.porcentajeRebaja = porcentajeRebaja;
    }

    
    
    public double calcularCostoFinalEntrada(){
        this.costoFinalEntrada = (super.calcularCostoFinalEntrada(zona.precioNormal - 
                (zona.precioNormal * (porcentajeRebaja/100))));
         return this.costoFinalEntrada;
   }

    @Override
    public String toString() {
        return "Entrada_Reducida{" + "porcentajeRebaja=" + porcentajeRebaja + '}' + super.toString();
    }
    
    
}

class Entrada_Abonado extends Entrada{

    public Entrada_Abonado(int idEntrada, int numeroEntradas, Zona zona, String nombreComprador) {
        super(idEntrada, numeroEntradas, zona, nombreComprador);
    }

    
    
    public double calcularCostoFinalEntrada(){
        this.costoFinalEntrada = (super.calcularCostoFinalEntrada(zona.precioAbonado));
         return this.costoFinalEntrada;
   }

    @Override
    public String toString() {
        return "Entrada_Abonado{" + '}'+ super.toString();
    }
}

public class Problema_05_EjecutorTeatro {
    public static void main(String[] args) {
        Zona[] zonas = {
            new Zona("Principal", 200, 25, 17.5),
            new Zona("PalcoB", 40, 70, 40),
            new Zona("Central", 400, 20, 14),
            new Zona("Lateral", 100, 15.5, 10)
        };
        ArrayList<Entrada> entradas = new ArrayList<>();

        // Vender entradas (verificando zona no completa)
        if (!zonas[3].estaCompleta()) {
            Entrada_Normal entNormal = new Entrada_Normal(1, 1, zonas[3], "Daniel");
            entNormal.calcularCostoFinalEntrada();
            zonas[3].registrarVenta();
            entradas.add(entNormal);
            System.out.println("Entrada generada - ID: " + entNormal.idEntrada + " | Precio: $" + entNormal.costoFinalEntrada);
        } else {
            System.out.println("La zona Lateral está completa.");
        }

        if (!zonas[1].estaCompleta()) {
            Entrada_Reducida entReducida = new Entrada_Reducida(15, 2, 1, zonas[1], "Andre");
            entReducida.calcularCostoFinalEntrada();
            zonas[1].registrarVenta();
            entradas.add(entReducida);
            System.out.println("Entrada generada - ID: " + entReducida.idEntrada + " | Precio: $" + entReducida.costoFinalEntrada);
        } else {
            System.out.println("La zona PalcoB está completa.");
        }

        if (!zonas[2].estaCompleta()) {
            Entrada_Abonado entAbonado = new Entrada_Abonado(3, 2, zonas[2], "Raul y Enrique");
            entAbonado.calcularCostoFinalEntrada();
            zonas[2].registrarVenta();
            entradas.add(entAbonado);
            System.out.println("Entrada generada - ID: " + entAbonado.idEntrada + " | Precio: $" + entAbonado.costoFinalEntrada);
        } else {
            System.out.println("La zona Central está completa.");
        }

        // Mostrar todas las entradas
        System.out.println("\n--- ENTRADAS VENDIDAS ---");
        for (Entrada e : entradas) {
            System.out.println(e);
        }

        // Consultar entrada por ID
        int idBuscar = 2;
        Entrada encontrada = null;
        for (Entrada e : entradas) {
            if (e.idEntrada == idBuscar) {
                encontrada = e;
            }
        }
        System.out.println("\n--- CONSULTA ENTRADA ID: " + idBuscar + " ---");
        if (encontrada != null) {
            System.out.println(encontrada);
        } else {
            System.out.println("No existe entrada con ID " + idBuscar);
        }
    }
}

/**
 * run:
Entrada generada - ID: 1 | Precio: $15.5
Entrada generada - ID: 2 | Precio: $59.5
Entrada generada - ID: 3 | Precio: $28.0

--- ENTRADAS VENDIDAS ---
Entrada_Normal{}Entrada{idEntrada=1, numeroEntradas=1, zona=Zona{nombreZona=Lateral, cantidadLocalidades=100, precioNormal=15.5, precioAbonado=10.0}, nombreComprador=Daniel, costoFinalEntrada=15.5}
Entrada_Reducida{porcentajeRebaja=15.0}Entrada{idEntrada=2, numeroEntradas=1, zona=Zona{nombreZona=PalcoB, cantidadLocalidades=40, precioNormal=70.0, precioAbonado=40.0}, nombreComprador=Andre, costoFinalEntrada=59.5}
Entrada_Abonado{}Entrada{idEntrada=3, numeroEntradas=2, zona=Zona{nombreZona=Central, cantidadLocalidades=400, precioNormal=20.0, precioAbonado=14.0}, nombreComprador=Raul y Enrique, costoFinalEntrada=28.0}

--- CONSULTA ENTRADA ID: 2 ---
Entrada_Reducida{porcentajeRebaja=15.0}Entrada{idEntrada=2, numeroEntradas=1, zona=Zona{nombreZona=PalcoB, cantidadLocalidades=40, precioNormal=70.0, precioAbonado=40.0}, nombreComprador=Andre, costoFinalEntrada=59.5}
BUILD SUCCESSFUL (total time: 0 seconds)
 */