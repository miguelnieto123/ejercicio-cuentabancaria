
import java.util.Scanner;

public class CuentaBancaria {
    private String titular;
    private String numeroCuenta;
    private double saldo;

   
    public CuentaBancaria(String titular, String numeroCuenta, double saldoInicial) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

   
    public void mostrarDatos() {
        System.out.println("Titular: " + titular);
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Saldo: $" + saldo);
       System.out.println();
    }

    
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Se depositaron $" + monto + " a la cuenta de " + titular);
        } else {
            System.out.println("El monto a depositar debe ser mayor que 0.");
        }
    }

    
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Se retiraron $" + monto + " de la cuenta de " + titular);
        } else {
            System.out.println("Fondos insuficientes o monto inválido.");
        }
    }

   
    public void transferir(double monto, CuentaBancaria cuentaDestino) {
        if (cuentaDestino == this) {
            System.out.println("No puedes transferir a la misma cuenta.");
            return;
        }
        if (monto > 0 && monto <= saldo) {
            this.retirar(monto);
            cuentaDestino.depositar(monto);
            System.out.println("Transferencia completada de " + titular + " a " + cuentaDestino.titular);
        } else {
            System.out.println("Fondos insuficientes o monto inválido para la transferencia.");
        }
    }


 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CuentaBancaria cuenta1 = new CuentaBancaria("Miguel Angel Nieto", "123456", 500);
        CuentaBancaria cuenta2 = new CuentaBancaria("Samuel Martinez", "789012", 300);

        cuenta1.mostrarDatos();
        cuenta2.mostrarDatos();

        
        System.out.print("Ingrese el monto a depositar en la cuenta de Miguel: ");
        double montoDeposito = scanner.nextDouble();
        cuenta1.depositar(montoDeposito);

    
         System.out.print("Ingrese el monto a retirar de la cuenta de Miguel: ");
        double montoRetiro = scanner.nextDouble();
        cuenta1.retirar(montoRetiro);

        System.out.print("Ingrese el monto a transferir de Miguel a la cuenta de Samuel: ");
        double montoTransferencia = scanner.nextDouble();
        cuenta1.transferir(montoTransferencia, cuenta2);
       
        cuenta1.mostrarDatos();
        cuenta2.mostrarDatos();

        scanner.close();
    }
}

