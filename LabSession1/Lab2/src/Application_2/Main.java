package Application_2;
public class Main {
    private static final int noOfThreads = 8;
    private static final int processorLoad = 1000000;

    public static void main(String args[]) {
        Model model = new Model(noOfThreads);
        View view = new View(noOfThreads);
        model.addObserver(view);

        Controller controller = new Controller(model);

        for (int i = 0; i < noOfThreads; i++) {
            new Thread(i, i + 2, controller, processorLoad).start();
        }
    }
}