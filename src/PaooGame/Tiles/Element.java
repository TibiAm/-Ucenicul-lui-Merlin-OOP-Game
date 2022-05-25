package PaooGame.Tiles;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.SQLException;

/*! \class Element
    \brief Defineste notiunea de element (totem, cristal)
 */
public class Element {

    public static final int Element_WIDTH=48, Element_HEIGHT=48;

    public static Element[] elements=new Element[256];
    public static Element totem=new Element(Assets.totem,"totem",0,Element_WIDTH ,Element_HEIGHT);
    public static Element bluecristal = new Element(Assets.bluecristal,"Cristal Albastru",1,Element_WIDTH,Element_HEIGHT);
    public static Element cristalroz = new Element(Assets.cristalroz,"Cristal Roz",2,Element_WIDTH,Element_HEIGHT);
    private int width, height;


    private final int id;

    protected RefLinks refLink;
    protected BufferedImage texture;
    protected String name;
    // protected final int id;

    protected int x,y,count;
    protected boolean pickedUp=false;

    protected Rectangle bounds;

    public Element(BufferedImage texture, String name, int id)
    {
        this(texture,name,id,Element_WIDTH,Element_HEIGHT);
    }

    public Element(BufferedImage texture, String name, int id, int width, int height)
    {
        this.texture=texture;
        this.name=name;
        this.id = id;
        count=1;
        this.width=width;
        this.height=height;

        bounds=new Rectangle(x,y,width,height);

        elements[id]=this;
    }

    public void Update() {
        try {
            if (refLink.GetMap().getItemManager().getHero().getCollisionsBounds(0f, 0f).intersects(bounds)) {
                pickedUp = true;
                refLink.GetMap().getItemManager().getHero().getStorage().addElement(this);
                refLink.GetMap().getItemManager().getHero().setScore(refLink.GetMap().getItemManager().getHero().getScore()+8);
                try{
                    refLink.GetGame().getDB().updateHeroScore(refLink.GetMap().getItemManager().getHero().getScore());}
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }

        } catch (Exception e){
            System.out.println("Eroare inventar");
        }
    }

    public void Draw(Graphics g)
    {
        if(refLink==null)
            return;
        Draw(g,(int)(x),(int)(y));
    }

    public void Draw(Graphics g, int x, int y)
    {
        g.drawImage(texture,x,y,width,height,null);
    }

    public Element CreateNew(int count)
    {
        Element el=new Element(texture, name, id);
        el.setPickedUp(true);
        el.setCount(count);
        return el;
    }

    public Element CreateNew(int x, int y)
    {
        Element el=new Element(texture, name, id,width, height);
        el.SetPosition(x,y);
        return el;
    }

    public void SetPosition(int x, int y)
    {
        this.x=x;
        this.y=y;
        bounds.x=x;
        bounds.y=y;
    }


    //Getters and Setters

    public RefLinks getRefLink() {
        return refLink;
    }

    public void setRefLink(RefLinks refLink) {
        this.refLink = refLink;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isPickedUp() {
        return pickedUp;
    }

    public void setPickedUp(boolean pickedUp) {
        this.pickedUp = pickedUp;
    }
}

