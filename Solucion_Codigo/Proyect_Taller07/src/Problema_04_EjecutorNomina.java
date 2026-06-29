import java.util.ArrayList;

/**
 * Problema 04: Sistema de nómina para trabajadores.
 * Se gestiona la nómina de trabajadores de una empresa.
 * Existen 4 tipos: Fijo Mensual, Comisionista, Por Horas y Jefe.
 * Cada empleado tiene obligatoriamente un jefe, excepto los jefes.
 * @author Daniel Castillo
 * @version 1.0
 */
class Trabajador {
    public String nombre;
    public String apellidos;
    public String direccion;
    public String dni;

    public Trabajador(String nombre, String apellidos, String direccion, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.dni = dni;
    }

    public double calcularNomina() {
        return 0;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", dni=" + dni + ", nomina=" + calcularNomina() + '}';
    }
}

class Jefe extends Trabajador {
    public double sueldoFijo;

    public Jefe(String nombre, String apellidos, String direccion, String dni, double sueldoFijo) {
        super(nombre, apellidos, direccion, dni);
        this.sueldoFijo = sueldoFijo;
    }

    @Override
    public double calcularNomina() {
        return sueldoFijo;
    }

    @Override
    public String toString() {
        return "Jefe{" + "sueldoFijo=" + sueldoFijo + '}' + super.toString();
    }
}

class FijoMensual extends Trabajador {
    public double sueldoMensual;
    public Jefe jefe;

    public FijoMensual(String nombre, String apellidos, String direccion, String dni, double sueldoMensual, Jefe jefe) {
        super(nombre, apellidos, direccion, dni);
        this.sueldoMensual = sueldoMensual;
        this.jefe = jefe;
    }

    @Override
    public double calcularNomina() {
        return sueldoMensual;
    }

    @Override
    public String toString() {
        return "FijoMensual{" + "sueldoMensual=" + sueldoMensual + ", jefe=" + jefe.nombre + '}' + super.toString();
    }
}

class Comisionista extends Trabajador {
    public double porcentajeComision;
    public double totalVentas;
    public Jefe jefe;

    public Comisionista(String nombre, String apellidos, String direccion, String dni, double porcentajeComision, double totalVentas, Jefe jefe) {
        super(nombre, apellidos, direccion, dni);
        this.porcentajeComision = porcentajeComision;
        this.totalVentas = totalVentas;
        this.jefe = jefe;
    }

    @Override
    public double calcularNomina() {
        return totalVentas * (porcentajeComision / 100);
    }

    @Override
    public String toString() {
        return "Comisionista{" + "porcentajeComision=" + porcentajeComision + ", totalVentas=" + totalVentas + ", jefe=" + jefe.nombre + '}' + super.toString();
    }
}

class PorHoras extends Trabajador {
    public double horasTrabajadas;
    public double precioPorHora;
    public double precioHoraExtra;
    public Jefe jefe;

    public PorHoras(String nombre, String apellidos, String direccion, String dni, double horasTrabajadas, double precioPorHora, double precioHoraExtra, Jefe jefe) {
        super(nombre, apellidos, direccion, dni);
        this.horasTrabajadas = horasTrabajadas;
        this.precioPorHora = precioPorHora;
        this.precioHoraExtra = precioHoraExtra;
        this.jefe = jefe;
    }

    @Override
    public double calcularNomina() {
        if (horasTrabajadas <= 40) {
            return horasTrabajadas * precioPorHora;
        } else {
            return (40 * precioPorHora) + ((horasTrabajadas - 40) * precioHoraExtra);
        }
    }

    @Override
    public String toString() {
        return "PorHoras{" + "horasTrabajadas=" + horasTrabajadas + ", precioPorHora=" + precioPorHora + ", precioHoraExtra=" + precioHoraExtra + ", jefe=" + jefe.nombre + '}' + super.toString();
    }
}

public class Problema_04_EjecutorNomina {
    public static void main(String[] args) {
        Jefe jefe1 = new Jefe("Carlos", "Perez", "Av. Principal 123", "1234567890", 3000);

        FijoMensual emp1 = new FijoMensual("Daniel", "Castillo", "Calle 1", "0987654321", 800, jefe1);
        Comisionista emp2 = new Comisionista("Andre", "Lopez", "Calle 2", "1111111111", 15, 5000, jefe1);
        PorHoras emp3 = new PorHoras("Raul", "Torres", "Calle 3", "2222222222", 50, 5, 8, jefe1);

        ArrayList<Trabajador> trabajadores = new ArrayList<>();
        trabajadores.add(jefe1);
        trabajadores.add(emp1);
        trabajadores.add(emp2);
        trabajadores.add(emp3);

        for (Trabajador t : trabajadores) {
            System.out.println(t);
            System.out.println("---");
        }
    }
}

/**
 * run:
Jefe{sueldoFijo=3000.0}Trabajador{nombre=Carlos, apellidos=Perez, direccion=Av. Principal 123, dni=1234567890, nomina=3000.0}
---
FijoMensual{sueldoMensual=800.0, jefe=Carlos}Trabajador{nombre=Daniel, apellidos=Castillo, direccion=Calle 1, dni=0987654321, nomina=800.0}
---
Comisionista{porcentajeComision=15.0, totalVentas=5000.0, jefe=Carlos}Trabajador{nombre=Andre, apellidos=Lopez, direccion=Calle 2, dni=1111111111, nomina=750.0}
---
PorHoras{horasTrabajadas=50.0, precioPorHora=5.0, precioHoraExtra=8.0, jefe=Carlos}Trabajador{nombre=Raul, apellidos=Torres, direccion=Calle 3, dni=2222222222, nomina=280.0}
---
BUILD SUCCESSFUL (total time: 0 seconds)
 */