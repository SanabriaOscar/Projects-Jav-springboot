package decorator;

import decorator.decor.BlindajeDecorador;
import decorator.inter.CuentaAhorro;
import decorator.inter.ICuentabancaria;
import decorator.model.Cuenta;

public class App {
    public static void main(String[] args) {
        Cuenta c = new Cuenta(1, "loolo");

        ICuentabancaria cuenta = new CuentaAhorro();
        ICuentabancaria cuentaBlindada = new BlindajeDecorador(cuenta);

        //cuenta.abrirCuenta(c);
        cuentaBlindada.abrirCuenta(c);
    }

}
