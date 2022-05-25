package PaooGame.UI;

import PaooGame.RefLinks;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

/*! \class UIManager
    \brief Defineste notiunea de manager de obiecte de ipl obiect al interfetei cu utilizatorul

 */
public class UIManager {

    private RefLinks refLink;
    private ArrayList<UIObject> objects;

    public UIManager(RefLinks refLink)
    {
        this.refLink=refLink;
        objects=new ArrayList<UIObject>();
    }

    public void Update(){
        for(UIObject o : objects)
            o.Update();
    }

    public void draw(Graphics g)
    {
        for(UIObject o : objects)
            o.draw(g);
    }

    public void onMouseMove(MouseEvent e)
    {
        Iterator<UIObject> it=objects.iterator();
        while(it.hasNext())
        {
            it.next().onMouseMove(e);
        }
    }

    public void onMouseReleased(MouseEvent e)
    {
        for(UIObject o : objects)
            o.onMouseReleased(e);
    }

    public void addObject(UIObject o)
    {
        objects.add(o);
    }

    public void removeObject(UIObject o)
    {
        objects.remove(o);
    }

    public RefLinks getRefLink() {
        return refLink;
    }

    public void setRefLink(RefLinks refLink) {
        this.refLink = refLink;
    }

    public ArrayList<UIObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<UIObject> objects) {
        this.objects = objects;
    }
}