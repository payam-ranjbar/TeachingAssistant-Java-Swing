package ThreadExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class GUI extends JFrame {
    JPanel upperPanel;
    JButton button;
    JLabel lable;



    GUI() {

        button = new JButton("click me!");
        upperPanel = new JPanel();
        lable = new JLabel("process manager");


        button.setBounds(150, 500, 200,50);
        upperPanel.setBounds(0, 0, 600,490);
        lable.setBounds(150, 150, 300, 30);


        add(lable);
        add(button);
        add(upperPanel);

        setPanelBehaviour();
        setButtonBehaviour();

        setSize(400, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void setButtonBehaviour() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // copying in dispatch thread
//                 copyFile();

                // Copy in new Thread
                copyInBackground();
            }
        });
    }

    private void copyFile() {
        String originFile = "./asset/sound.mp3";
        String dstFile = "./asset/newSound.mp3";


        FileCopier copier = new FileCopier(originFile, dstFile);

        try {
            copier.copy();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private void copyInBackground() {
        SwingWorker<Void, Integer> worker =  new SwingWorker<>() {

            @Override
            protected Void doInBackground() throws Exception {
                String originFile = "./asset/sound.mp3";
                String dstFilePath = "./asset/newSound.mp3";

                File dstFile = new File(dstFilePath);

                if (!dstFile.exists()) {
                    dstFile.createNewFile();
                }
                FileOutputStream out = new FileOutputStream(dstFile);

                FileInputStream in = new FileInputStream(originFile);
                int b = in.read();

                publish(in.available());

                while (b!= -1) {
                    out.write(b);
                    b = in.read();
                    publish(in.available());

                }

                out.close();
                in.close();

                return null;
            }

            @Override
            protected void process(List<Integer> data) {
                lable.setText(String.valueOf(data.get(data.size()-1)) + " bytes remains");

            }
            @Override
            protected void done() {
                lable.setText("finished");
                JOptionPane.showMessageDialog(getContentPane(), "your file copied","message", JOptionPane.WARNING_MESSAGE);

            }

        };

        worker.execute();
    }

    private void setPanelBehaviour() {
        upperPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setRandomColorForPanel();

            }

            @Override
            public void mouseExited(MouseEvent e) {
                setRandomColorForPanel();

            }
        });
    }

    private void setRandomColorForPanel() {
        Random rand = new Random();

        upperPanel.setBackground(new Color(
                rand.nextInt(255),
                rand.nextInt(255),
                rand.nextInt(255))
        );

        lable.updateUI();
    }

}
