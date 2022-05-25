package PaooGame.Items;
import PaooGame.RefLinks;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/*! \class ItemManager
    \brief. Implementeaza notiunea de manager de entitati. Aceasta clasa va controla celelalte entitati.
 */
public class ItemManager {

    private RefLinks refLinks;
    private Hero hero;
    private ArrayList<Item> items;

     /*! \fn public ItemManager(RefLinks refLinks, Hero hero)
        \brief Constructor de initializare al clasei

        \param reflinks referinte catre alte referinte utile
        \param hero eroul jocului
      */
    public ItemManager(RefLinks refLinks,Hero hero)
    {
        this.refLinks=refLinks;
        this.hero=hero;
        items=new ArrayList<Item>();
        addItem(hero);
    }

    public void Update(){

        Iterator<Item> it=items.iterator();
        while(it.hasNext())
        {
            Item e=it.next();
            e.Update();
            if(!e.isActive())
                it.remove();
        }
    }

    public void Draw(Graphics g)
    {
        for(Item e: items) //for(int i=0;i<items.size();i++) Item e=items.get(i);
        {
            e.Draw(g);
        }
        hero.PostDraw(g); //ca sa nu apara entitatile deasupra inventarului

    }

    public void addItem(Item e)
    {
        items.add(e);
    }


    //---
    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public RefLinks getRefLinks() {
        return refLinks;
    }

    public void setRefLinks(RefLinks refLinks) {
        this.refLinks = refLinks;
    }

}