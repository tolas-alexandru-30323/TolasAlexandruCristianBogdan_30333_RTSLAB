package Application_2;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
public class View extends JFrame implements Observer {
    ArrayList<JProgressBar> progressBars = new ArrayList<JProgressBar>();
    public View(int nrOfThreads){
        setLayout(null);
        setSize(550,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initBars(nrOfThreads);
        this.setVisible(true);
    }
    private void initBars(int nrOfBars){
        for (int i=0;i<nrOfBars;i++){
            JProgressBar pb=new JProgressBar();
            pb.setMaximum(1000);
            pb.setBounds(55,(i+1)*30,350,20);
            this.add(pb);
            this.progressBars.add(pb);
        }
    }
    @Override
    public void update(Observable o, Object arg) {
        int id = (int) arg;
        progressBars.get(id).setValue(((Model) o).getProgressValue(id));    }
}
