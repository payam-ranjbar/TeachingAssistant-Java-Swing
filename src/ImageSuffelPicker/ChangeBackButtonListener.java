package ImageSuffelPicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ChangeBackButtonListener implements ActionListener {

    JPanel panel;


    public ChangeBackButtonListener(JPanel p) {
        panel = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Random rand = new Random();

        panel.setBackground(new Color(
                    rand.nextInt(255),
                    rand.nextInt(255),
                    rand.nextInt(255))
        );


    }
}
