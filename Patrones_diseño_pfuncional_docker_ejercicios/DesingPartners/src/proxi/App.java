package proxi;

import proxi.inter.CuentaBancoBImpl;
import proxi.inter.ICuenta;
import proxi.model.Cuenta;
import proxi.proxiPackage.CuentaProxy;

public class App {
    public static void main(String[] args) {
        Cuenta c = new Cuenta(1, "oscar", 100);

        ICuenta cuentaProxy = new CuentaProxy(new CuentaBancoBImpl());
        cuentaProxy.mostrarSaldo(c);
        c = cuentaProxy.depositarDinero(c, 50);
        c = cuentaProxy.retirarDinero(c, 20);
        cuentaProxy.mostrarSaldo(c);
    }
}
