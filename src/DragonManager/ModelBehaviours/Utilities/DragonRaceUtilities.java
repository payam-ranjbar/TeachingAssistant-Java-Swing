package DragonManager.ModelBehaviours.Utilities;

import DragonManager.Models.DragonRace;

import java.awt.*;

public class DragonRaceUtilities {

    public static String convertToString(DragonRace race) throws Exception{
        switch (race) {
            case ICE_DRAGON:
                return "ICE_DRAGON";
            case FIRE_DRAGON:
                return "FIRE_DRAGON";
            case DOMESTIC_DROGON:
                return "DOMESTIC_DRAGON";
            case HELLFLAME_DRAGON:
                return "HELLFLAME_DRAGON";
        }

        throw new Exception("invalid enum input");
    }

    public static DragonRace convetStringToDataEnum(String race) throws Exception {
        switch (race) {
            case "ICE_DRAGON":
                return DragonRace.ICE_DRAGON;
            case "FIRE_DRAGON":
                return DragonRace.FIRE_DRAGON;
            case "DOMESTIC_DRAGON":
                return DragonRace.DOMESTIC_DROGON;
            case "HELLFLAME_DRAGON":
                return DragonRace.HELLFLAME_DRAGON;
        }

        throw new Exception("invalid enum input");
    }

    public static Color getColorByRace(DragonRace race) throws Exception{
        switch (race) {
            case ICE_DRAGON:
                return new Color(0x7BC3D5);
            case FIRE_DRAGON:
                return new Color(0xD5933D);
            case DOMESTIC_DROGON:
                return new Color(0x7AD56C);
            case HELLFLAME_DRAGON:
                return new Color(0xD52F3A);
        }

        throw new Exception("invalid enum input");
    }

    public static Color getColorByRace(String race) throws Exception{
        switch (race) {
            case "ICE_DRAGON":
                return new Color(0x7BC3D5);
            case "FIRE_DRAGON":
                return new Color(0xD5933D);
            case "DOMESTIC_DRAGON":
                return new Color(0x7AD56C);
            case "HELLFLAME_DRAGON":
                return new Color(0xD52F3A);
        }

        throw new Exception("invalid enum input ");
    }
}
