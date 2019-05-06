package DragonManager;

import DragonManager.FrontEnd.GUI;
import DragonManager.Models.Dragon;
import DragonManager.Models.DragonRace;

public class Main {
    public static void main(String[] args) throws Exception {

        Dragon dragon1 = new Dragon("alduin", 1000, DragonRace.HELLFLAME_DRAGON);
        Dragon dragon2 = new Dragon("parthanaxx", 12000, DragonRace.ICE_DRAGON);
        Dragon dragon3 = new Dragon("tarzor", 3000, DragonRace.FIRE_DRAGON);
        Dragon dragon4 = new Dragon("alduin", 10, DragonRace.HELLFLAME_DRAGON);
        Dragon dragon5 = new Dragon("bidandon", 200, DragonRace.DOMESTIC_DROGON);
//
//        DragonManager.SaveDragon(dragon1);
//        DragonManager.SaveDragon(dragon2);
//        DragonManager.SaveDragon(dragon3);
//        DragonManager.SaveDragon(dragon4);
//        DragonManager.SaveDragon(dragon5);

        GUI view = GUI.GetOrCreate();


    }
}
