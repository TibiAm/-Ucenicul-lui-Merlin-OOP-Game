package PaooGame.Storage;

import PaooGame.Graphics.Assets;
import PaooGame.Graphics.ImageLoader;
import PaooGame.Graphics.Text;
import PaooGame.RefLinks;
import PaooGame.Tiles.Element;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
/*! \class Storage
    \brief Defineste notiunea de inventar.
 */
public class Storage {

    private RefLinks refLink;
    private boolean active=false;
    private ArrayList<Element> storageElements;
    BufferedImage background;

    private final int strX=0;
    private final int strY=0;
    private int strWidth=768;
    private int strHeight=384;
    private int strFirstListX=strX+190;
    private int strFirstListY=strY+50;
    private int strListSpacing=55;


    private int strImageX=520,strImageY=110;

    private int strCountX=560, strCountY=301;

    private int selectedElement=0; //index ArrayList

    public Storage (RefLinks refLink)
    {
        background=ImageLoader.LoadImage("/Inventar/InventarScreen.png");
        this.refLink=refLink;
        storageElements=new ArrayList<Element>();

    }

    public void Update(){
        if(refLink.GetKeyManager().keyJustPressed(KeyEvent.VK_I))
            active=!active; //cand e true, e false si cand e false, e true
        if(!active)
            return;


        if(refLink.GetKeyManager().keyJustPressed(KeyEvent.VK_UP))
            selectedElement--;
        if(refLink.GetKeyManager().keyJustPressed(KeyEvent.VK_DOWN))
            selectedElement++;

        if(selectedElement<0)
            selectedElement=storageElements.size()-1;
        else if(selectedElement>=storageElements.size())
            selectedElement=0;
    }

    public void Draw(Graphics g){
        if(!active)
            return;

        g.drawImage(background,strX,strY,strWidth,strHeight,null);

        //Text.drawString(g,"> Blue potion <",strFirstListX,strFirstListY,true,Color.black,Assets.font28);

        int len=storageElements.size();
        if(len==0)
            return;


        for(int i=0;i<6;i++)
        {
            if(selectedElement+i<0 || selectedElement+i>=len)
                continue;
            if(i==0)
                Text.drawString(g,"> " + storageElements.get(selectedElement+i).getName() + " <",strFirstListX,strFirstListY+i*strListSpacing,
                        true,Color.pink,Assets.font28);
            else
                Text.drawString(g,storageElements.get(selectedElement+i).getName(),strFirstListX,strFirstListY+i*strListSpacing,
                        true,Color.black,Assets.font28);
        }

        Element element=storageElements.get(selectedElement);
        g.drawImage(element.getTexture(),strImageX,strImageY,85,85,null);

        Text.drawString(g,Integer.toString(element.getCount()),strCountX,strCountY,true,Color.black,Assets.font28);

    }

    /*! \fn public void addElement(Element element)
        \brief Adauga un element in inventar

        \param element elementul ce trebuie adaugat in inventar

     */
    public void addElement(Element element) {
        for (Element el : storageElements)
            if (el.getId() == element.getId()) {
                el.setCount(el.getCount() + element.getCount());
                return;
            }
        storageElements.add(element);
    }



    public RefLinks getRefLink() {
        return refLink;
    }

    public void setRefLink(RefLinks refLink) {
        this.refLink = refLink;
    }

    public boolean isActive() {
        return active;
    }

    public ArrayList<Element> getStorageElements() {
        return storageElements;
    }

    public void setStorageElements(ArrayList<Element> storageElements) {
        this.storageElements = storageElements;
    }
}
