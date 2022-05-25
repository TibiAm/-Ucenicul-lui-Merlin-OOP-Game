package PaooGame.Graphics;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.FontFormatException;

public class FontLoader {

    public static Font LoadFont(String path, float size){

        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(Font.PLAIN, size);
        } catch (FontFormatException | IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}