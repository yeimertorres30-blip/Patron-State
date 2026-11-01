package maquina;

/**
 * Contexto: mantiene una referencia al estado actual y le delega todas las acciones.
 * No contiene ningún if/switch sobre el estado: el comportamiento cambia
 * porque cambia el objeto estado.
 */
public class MaquinaExpendedora {

    private final EstadoMaquina sinMoneda;
    private final EstadoMaquina conMoneda;
    private final EstadoMaquina dispensando;
    private final EstadoMaquina sinStock;

    private EstadoMaquina estadoActual;
    private int productos;

    public MaquinaExpendedora(int productosIniciales) {
        this.sinMoneda = new EstadoSinMoneda(this);
        this.conMoneda = new EstadoConMoneda(this);
        this.dispensando = new EstadoDispensando(this);
        this.sinStock = new EstadoSinStock(this);
        this.productos = productosIniciales;
        this.estadoActual = productosIniciales > 0 ? sinMoneda : sinStock;
    }

    // ---- Acciones delegadas al estado actual ----
    public void insertarMoneda() { estadoActual.insertarMoneda(); }
    public void devolverMoneda() { estadoActual.devolverMoneda(); }

    public void presionarBoton() {
        estadoActual.presionarBoton();
        // El dispensado es una acción interna, no la pide el usuario.
        estadoActual.dispensar();
    }

    // ---- Métodos usados por los estados ----
    void setEstado(EstadoMaquina nuevo) { this.estadoActual = nuevo; }

    void entregarProducto() {
        if (productos > 0) {
            productos--;
            System.out.println("   -> ¡Sale un producto!");
        }
    }

    int getProductos() { return productos; }

    EstadoMaquina getSinMoneda() { return sinMoneda; }
    EstadoMaquina getConMoneda() { return conMoneda; }
    EstadoMaquina getDispensando() { return dispensando; }
    EstadoMaquina getSinStock() { return sinStock; }

    public String getNombreEstado() {
        return estadoActual.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return "[Estado: " + getNombreEstado() + " | Productos: " + productos + "]";
    }
}
