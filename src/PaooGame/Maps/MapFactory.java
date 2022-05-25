package PaooGame.Maps;
import PaooGame.RefLinks;


public class MapFactory {
    public static Map Create(int n, RefLinks refLinks){
        switch(n)
        {
            case 1: return new Map1(refLinks);
            case 2: return new Map2(refLinks);
            case 3: return new Map3(refLinks);
            case 4: return new Map4(refLinks);
            case 5: return new Map5(refLinks);
            default: return null;

        }
    }
}
