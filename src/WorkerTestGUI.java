import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class WorkerTestGUI extends JFrame {

    JLabel label;
    int timer = 0;


    public WorkerTestGUI() {
        label = new JLabel("0");

        label.setBounds(0, 0, 200, 10);

        add(label);


        myEvent();
        myEvent2();

        setVisible(true);
        setLayout(null);

        setSize(400,400);
    }


    void myEvent() {
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {

                        while (true) {
                            Thread.sleep(1000);
                            Random rand = new Random();

                            setBackground(new Color(
                                    rand.nextInt(255),
                                    rand.nextInt(255),
                                    rand.nextInt(255))
                            );
//
                            label.setText(String.valueOf(++timer));
                            label.updateUI();

                        }
                    }
                };

                worker.execute();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    void myEvent2() {
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                Random rand = new Random();

//                setBackground(new Color(
//                        rand.nextInt(255),
//                        rand.nextInt(255),
//                        rand.nextInt(255))
//                );
//                repaint();

                System.out.println(e.getX());



            }
        });
    }

    public static void main(String[] args) {
        WorkerTestGUI gui = new WorkerTestGUI();
    }
}
