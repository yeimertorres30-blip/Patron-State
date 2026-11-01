package maquina;

/** La máquina está entregando el producto; ignora acciones del usuario. */
public class EstadoDispensando implements EstadoMaquina {

    private final MaquinaExpendedora maquina;

    public EstadoDispensando(MaquinaExpendedora maquina) {
        this.maquina = maquina;
    }

    @Override
    public void insertarMoneda() {
        System.out.println("   Espera, estamos entregando tu producto.");
    }

    @Override
    public void devolverMoneda() {
        System.out.println("   Demasiado tarde, ya se está dispensando.");
    }

    @Override
    public void presionarBoton() {
        System.out.println("   Pulsar otra vez no acelera nada.");
    }

    @Override
    public void dispensar() {
        maquina.entregarProducto();
        if (maquina.getProductos() > 0) {
            maquina.setEstado(maquina.getSinMoneda());
        } else {
            System.out.println("   ¡Nos quedamos sin productos!");
            maquina.setEstado(maquina.getSinStock());
        }
    }
}
