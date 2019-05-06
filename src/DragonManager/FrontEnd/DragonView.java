package DragonManager.FrontEnd;

import DragonManager.ModelBehaviours.Utilities.DragonRaceUtilities;
import DragonManager.Models.Dragon;

import javax.swing.*;
import java.awt.*;

public class DragonView {
    private JLabel name;
    private JLabel race;
    private JLabel lifeSpan;

    private JPanel panel;





    public DragonView(Dragon dragon) throws Exception {

        panel = new JPanel();
        name = new JLabel(dragon.name);
        lifeSpan = new JLabel(String.valueOf(dragon.lifeSpan));
        race = new JLabel(DragonRaceUtilities.convertToString(dragon.race));


    }


    public JPanel getPanel(int x, int y) throws Exception {

        panel.setLayout(new GridLayout(3, 1));
        panel.add(name);
        panel.add(race);
        panel.add(lifeSpan);
        panel.setBackground(DragonRaceUtilities.getColorByRace(race.getText()));

        return panel;
    }
}
