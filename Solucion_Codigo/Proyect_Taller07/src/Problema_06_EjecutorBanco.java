import java.util.ArrayList;
/**
 * Problema 06: Sistema Un Banco.
 * El banco UN BANCO mantiene cuentas de varios clientes.
 * Existen tres tipos de cuentas: Cheques, Ahorros y Platino.
 * La cuenta de ahorros calcula interes mensual, la de cheques permite sobregiro
 * y la cuenta Platino tiene interes del 10% sin cargos por sobregiro.
 * @author Daniel Castillo
 * @version 1.0
 */
class Cuenta {
    private String numeroCuenta;
    private String nombreCliente;
    private double balance;
    public Cuenta(String numeroCuenta, String nombreCliente) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;
        this.balance = 0;
    }
    public void depositar(double cantidad) {
        this.balance += cantidad;
    }
    public void retirar(double cantidad) {
        this.balance -= cantidad;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "Cuenta{" + "numeroCuenta=" + numeroCuenta + ", nombreCliente=" + nombreCliente + ", balance=" + balance + '}';
    }
}
class CuentaCheques extends Cuenta {
    public CuentaCheques(String numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }
    @Override
    public void retirar(double cantidad) {
        setBalance(getBalance() - cantidad);
    }
    @Override
    public String toString() {
        return "CuentaCheques{}" + super.toString();
    }
}
class CuentaAhorros extends Cuenta {
    private double tasaInteres;
    public CuentaAhorros(String numeroCuenta, String nombreCliente, double tasaInteres) {
        super(numeroCuenta, nombreCliente);
        this.tasaInteres = tasaInteres;
    }
    @Override
    public void retirar(double cantidad) {
        if (cantidad > getBalance()) {
            System.out.println("Fondos insuficientes. No se puede retirar $" + cantidad);
        } else {
            setBalance(getBalance() - cantidad);
        }
    }
    public void calcularInteres() {
        setBalance(getBalance() + getBalance() * (tasaInteres / 100));
    }
    @Override
    public String toString() {
        return "CuentaAhorros{" + "tasaInteres=" + tasaInteres + '}' + super.toString();
    }
}
class CuentaPlatino extends Cuenta {
    private double tasaInteres;
    public CuentaPlatino(String numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
        this.tasaInteres = 10;
    }
    @Override
    public void retirar(double cantidad) {
        setBalance(getBalance() - cantidad);
    }
    public void calcularInteres() {
        setBalance(getBalance() + getBalance() * (tasaInteres / 100));
    }
    @Override
    public String toString() {
        return "CuentaPlatino{" + "tasaInteres=" + tasaInteres + '}' + super.toString();
    }
}
public class Problema_06_EjecutorBanco {
    public static void main(String[] args) {
        CuentaCheques cc1 = new CuentaCheques("001", "Daniel");
        CuentaAhorros ca1 = new CuentaAhorros("002", "Andre", 5);
        CuentaPlatino cp1 = new CuentaPlatino("003", "Raul");
        cc1.depositar(1000);
        cc1.retirar(1500);
        ca1.depositar(2000);
        ca1.retirar(500);
        ca1.calcularInteres();
        cp1.depositar(3000);
        cp1.retirar(500);
        cp1.calcularInteres();
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        cuentas.add(cc1);
        cuentas.add(ca1);
        cuentas.add(cp1);
        for (Cuenta c : cuentas) {
            System.out.println(c);
            System.out.println("---");
        }
    }
}
/**
 * run:
CuentaCheques{}Cuenta{numeroCuenta=001, nombreCliente=Daniel, balance=-500.0}
---
CuentaAhorros{tasaInteres=5.0}Cuenta{numeroCuenta=002, nombreCliente=Andre, balance=1575.0}
---
CuentaPlatino{tasaInteres=10.0}Cuenta{numeroCuenta=003, nombreCliente=Raul, balance=2750.0}
---
BUILD SUCCESSFUL (total time: 0 seconds)
 */