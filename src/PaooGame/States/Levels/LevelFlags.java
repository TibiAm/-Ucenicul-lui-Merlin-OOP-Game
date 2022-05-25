package PaooGame.States.Levels;

import PaooGame.Items.Hero;

import PaooGame.Tiles.*;
import java.util.ArrayList;

/*! \class LevelFlags
    \brief Contine flag-urile necesare pentr ua trece de la un nivel la altul
 */
public class LevelFlags {
    public static boolean level1_part1_coinsPaid=false;
    public static boolean level2_part1_coinsPaid=false;

    public static boolean level1_passed() {


        ArrayList<Element> elements = Hero.getStorage().getStorageElements();
        for (Element e : elements) {
            if (e.getId() == 0 && e.getCount() > 10) {
                return true;
            }
        }
        return false;
    }


    public static boolean level2_part2_passed(){

        ArrayList<Element> elements = Hero.getStorage().getStorageElements();
        for (Element e : elements) {
            if (e.getId() == 0 && e.getCount() > 20) {
                return true;
            }
        }
        return false;

    }

}
