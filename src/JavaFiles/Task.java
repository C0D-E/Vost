package JavaFiles;

import java.awt.Toolkit;
import java.util.Random;
import javax.swing.SwingWorker;

class Task extends SwingWorker<Void, Void> {
        @Override
        public Void doInBackground() {
            Random random = new Random();
            int progress = 0;
            //Initialize progress property.
            setProgress(0);
            while (progress < 100) {
                //Sleep for up to one second.
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException ignore) {}
                //Make random progress.
                progress += random.nextInt(10);
                setProgress(Math.min(progress, 100));
            }
            return null;
        }
        @Override
        public void done() {
            Toolkit.getDefaultToolkit().beep();
        }
    }
    