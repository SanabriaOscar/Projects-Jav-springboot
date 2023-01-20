package decorator.decor;

import decorator.inter.ICuentabancaria;
import decorator.model.Cuenta;

public abstract class CuentaDecorador implements ICuentabancaria {
    protected ICuentabancaria cuentaDecorada;

    public CuentaDecorador(ICuentabancaria cuentaDecorada) {
        this.cuentaDecorada = cuentaDecorada;
    }

    @Override
    public void abrirCuenta(Cuenta c) {
        this.cuentaDecorada.abrirCuenta(c);
    }
}
