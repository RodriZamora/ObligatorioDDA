package observer;

import java.util.ArrayList;

public class Observable {

    private ArrayList<Observador> observadores = new ArrayList();

    public void agregarObservador(Observador obs) {
        if (!observadores.contains(obs)) {
            observadores.add(obs);
        }
    }

    public void quitarObservador(Observador obs) {
        observadores.remove(obs);
    }

    public void avisar(Object evento) {

        for (Observador obs : observadores) {
            obs.actualizar(this, evento);
        }
    }

}
