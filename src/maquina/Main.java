package maquina;

public class Main {

    public static void main(String[] args) {
        MaquinaExpendedora m = new MaquinaExpendedora(2);
        System.out.println("=== Máquina expendedora (patrón State) ===");
        System.out.println(m);

        paso("1) Pulsar botón sin moneda");
        m.presionarBoton();
        System.out.println(m);

        paso("2) Insertar moneda y pedir devolución");
        m.insertarMoneda();
        System.out.println(m);
        m.devolverMoneda();
        System.out.println(m);

        paso("3) Compra normal: moneda + botón");
        m.insertarMoneda();
        m.presionarBoton();
        System.out.println(m);

        paso("4) Segunda moneda: intentar meter dos y comprar el último producto");
        m.insertarMoneda();
        m.insertarMoneda();
        System.out.println(m);
        m.presionarBoton();
        System.out.println(m);

        paso("5) Máquina agotada");
        m.insertarMoneda();
        m.presionarBoton();
        m.devolverMoneda();
        System.out.println(m);
    }

    private static void paso(String titulo) {
        System.out.println("\n" + titulo);
    }
}
