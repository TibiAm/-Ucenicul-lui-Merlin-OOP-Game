package PaooGame.Input;

import PaooGame.UI.UIManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


/*! \class MouseManager
    \brief Gestioneaza intrarea de la mouse.

    Clasa citeste daca au fost apasat un buton al mouse-ului, stabiliteste ce buton a fost actionat si seteaza corespunzator un flag.
    In program trebuie sa se tina cont de flagul aferent butonului de interes. Daca flagul respectiv este true inseamna
    ca butonul respectiv a fost apasat, iar daca flagul este false, butonul nu a fost apasat.
 */
public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean leftPressed,rightPressed;
    private int mouseX, mouseY;
    private UIManager uiManager;

    /*! \fn public MouseManager()
        \brief Constructorul clasei.
     */
    public MouseManager(){

    }

    public void setUIManager(UIManager uiManager)
    {
        this.uiManager=uiManager;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public int getMouseX(){
        return mouseX;
    }

    public int getMouseY(){
        return mouseY;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /*! \fn public void mousePressed(MouseEvent e)
        \brief Functie ce va fi apelata atunci cand un eveniment de mouse este generat.

         \param e obiectul eveniment de mouse.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1) //left click
            leftPressed=true;
        else if(e.getButton()==MouseEvent.BUTTON3)//right click
            rightPressed=true;
    }

    /*! \fn public void keyReleased(MouseEvent e)
        \brief Functie ce va fi apelata atunci cand un eveniment de buton de mouse eliberat este generat.

         \param e obiectul eveniment de mouse.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1) //left click
            leftPressed=false;
        else if(e.getButton()==MouseEvent.BUTTON3)//right click
            rightPressed=false;

        if(uiManager !=null)
            uiManager.onMouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    /*! \fn public void mouseMoved(MouseEvent e)
        \brief Functie ce va fi apelata atunci cand se realizeaza actualizarea pozitiei mouse-ului.

         \param e obiectul eveniment de mouse.
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();

        if(uiManager !=null)
            uiManager.onMouseMove(e);
    }
}
