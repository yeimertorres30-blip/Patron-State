package maquina;

/** Ya hay una moneda dentro: se puede pulsar el botón o pedir la devolución. */
public class EstadoConMoneda implements EstadoMaquina {

    private final MaquinaExpendedora maquina;

    public EstadoConMoneda(MaquinaExpendedora maquina) {
        this.maquina = maquina;
    }

    @Override
    public void insertarMoneda() {
        System.out.println("   Ya hay una moneda dentro, no se aceptan más.");
    }

    @Override
    public void devolverMoneda() {
        System.out.println("   Moneda devuelta.");
        maquina.setEstado(maquina.getSinMoneda());
    }

    @Override
    public void presionarBoton() {
        System.out.println("   Botón presionado, preparando producto...");
        maquina.setEstado(maquina.getDispensando());
    }

    @Override
    public void dispensar() {
        System.out.println("   Pulsa el botón para recibir tu producto.");
    }
}
