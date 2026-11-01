package maquina;

/**
 * Interfaz State: define las acciones que la máquina puede recibir.
 * Cada estado concreto decide qué hacer (o rechazar) ante cada acción.
 */
public interface EstadoMaquina {
    void insertarMoneda();
    void devolverMoneda();
    void presionarBoton();
    void dispensar();
}
