package Application_2;

import java.util.Observable;

public class Model extends Observable {

    private int[] progressValues;
    public Model(int numThreads) {
        progressValues = new int[numThreads];
    }

    public void setProgressValue(int id, int value) {
        progressValues[id] = value;
        setChanged();
        notifyObservers(id);
    }
    public int getProgressValue(int id) {
        return progressValues[id];
    }
}
