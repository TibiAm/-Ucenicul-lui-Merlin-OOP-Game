package PaooGame.Items.NPC;

import PaooGame.Items.Character;
import PaooGame.MyException;
import PaooGame.RefLinks;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class NPC extends Character {

    protected BufferedImage image;

    public NPC(RefLinks refLink, float x, float y, int width, int height) {
        super(refLink, x, y, width, height);
    }



    @Override
    public void Draw(Graphics g) {

        g.drawImage(image,(int)(x),(int)(y),width,height,null);

    }

    public abstract void Interact() throws MyException;

}