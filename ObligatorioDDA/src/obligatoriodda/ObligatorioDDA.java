package obligatoriodda;

import vistas.vistaHome;

public class ObligatorioDDA {

    public static void main(String[] args) {

        Precarga.cargar();
        new vistaHome().setVisible(true);

    }

}
