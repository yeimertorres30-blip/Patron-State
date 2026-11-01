package maquina;

/** No quedan productos: rechaza todo. */
public class EstadoSinStock implements EstadoMaquina {

    private final MaquinaExpendedora maquina;

    public EstadoSinStock(MaquinaExpendedora maquina) {
        this.maquina = maquina;
    }

    @Override
    public void insertarMoneda() {
        System.out.println("   Máquina agotada, no se aceptan monedas.");
    }

    @Override
    public void devolverMoneda() {
        System.out.println("   No hay moneda que devolver.");
    }

    @Override
    public void presionarBoton() {
        System.out.println("   Máquina agotada.");
    }

    @Override
    public void dispensar() {
        // Nada que hacer en este estado.
    }
}
