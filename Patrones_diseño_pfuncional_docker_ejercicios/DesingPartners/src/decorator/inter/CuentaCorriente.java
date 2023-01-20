package decorator.inter;

import decorator.model.Cuenta;

public class CuentaCorriente implements ICuentabancaria{
    @Override
    public void abrirCuenta(Cuenta c) {
        System.out.println("-------------------------");
        System.out.println("Se abrió una cuenta Corriente");
        System.out.println("Cliente: " + c.getCliente());
    }
}
