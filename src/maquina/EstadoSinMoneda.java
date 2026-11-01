package maquina;

/** Estado inicial: la máquina espera una moneda. */
public class EstadoSinMoneda implements EstadoMaquina {

    private final MaquinaExpendedora maquina;

    public EstadoSinMoneda(MaquinaExpendedora maquina) {
        this.maquina = maquina;
    }

    @Override
    public void insertarMoneda() {
        System.out.println("   Moneda aceptada.");
        maquina.setEstado(maquina.getConMoneda());
    }

    @Override
    public void devolverMoneda() {
        System.out.println("   No hay moneda que devolver.");
    }

    @Override
    public void presionarBoton() {
        System.out.println("   Primero inserta una moneda.");
    }

    @Override
    public void dispensar() {
        // Nada que hacer en este estado.
    }
}
