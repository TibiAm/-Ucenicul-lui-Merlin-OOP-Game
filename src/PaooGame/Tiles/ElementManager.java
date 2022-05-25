package PaooGame.Tiles;

import PaooGame.RefLinks;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/*! \class ElementManager
    \brief Depoziteaza elementele (totemele, cristalele)
 */
public class ElementManager {

    private RefLinks refLink;
    private ArrayList<Element> elements;

    public ElementManager(RefLinks refLink)
    {
        this.refLink=refLink;
        elements=new ArrayList<Element>();
    }

    public void Update()
    {
        Iterator<Element> el=elements.iterator();
        while(el.hasNext())
        {
            Element elt = el.next();
            elt.Update();
            if(elt.isPickedUp()) //asta inseamna ca player-ul a luat acel obiect si trebuie sters de pe harta si va fi adaugat in inventar
                el.remove();
        }
    }

    public void Draw(Graphics g)
    {
        for(Element el:elements)
            el.Draw(g);
    }

    public void addElement(Element el)
    {
        el.setRefLink(refLink);
        elements.add(el);
    }


    //Getters and setters
    public RefLinks getRefLink() {
        return refLink;
    }

    public void setRefLink(RefLinks refLink) {
        this.refLink = refLink;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public void setElements(ArrayList<Element> elements) {
        this.elements = elements;
    }
}
