package decorator.inter;

import decorator.model.Cuenta;

public class CuentaAhorro implements ICuentabancaria{
    @Override
    public void abrirCuenta(Cuenta c) {
        System.out.println("-------------------------");
        System.out.println("Se abrió una cuenta de Ahorros");
        System.out.println("Cliente: " + c.getCliente());
    }
}
