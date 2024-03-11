package Application_2;

public class Thread extends java.lang.Thread {
    Controller controller;
    int id;
    int processorLoad;
    Thread(int id, int priority, Controller controller, int procLoad){
        this.id=id;
        this.setPriority(priority);
        this.controller=controller;
        this.processorLoad=procLoad;
    }
    public void run(){
        int c=0;
        while(c<1000){
            for(int j=0;j<this.processorLoad;j++){
                j++;j--;
            }
            c++;
            try {
                java.lang.Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            controller.setProgressValue(id, c);
        }
    }
}