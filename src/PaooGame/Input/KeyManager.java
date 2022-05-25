package PaooGame.Input;
import java.awt.event.*;

/*! \class KeyManager
    \brief Gestioneaza intrarea de la tastatura.

    Clasa citeste daca au fost apasata o tasta, stabiliteste ce tasta a fost actionata si seteaza corespunzator un flag.
    In program trebuie sa se tina cont de flagul aferent tastei apasate. Daca flagul respectiv este true inseamna
    ca tasta respectiva a fost apasata, iar daca flagul este false, tasta nu a fost apasata.
 */

public class KeyManager implements KeyListener {
    private boolean[] keys,justPressed, cantPress;
    public boolean up, down, left, right, jump, interact, open_cufar;

    /*! \fn public KeyManager()
        \brief Constructorul clasei.
     */
    public KeyManager(){
        keys = new boolean[256];
        justPressed=new boolean[keys.length];
        cantPress=new boolean[keys.length];
    }

    public void Update(){
        for(int i=0;i<keys.length;i++)
        {
            if(cantPress[i] && !keys[i])
                cantPress[i]=false;
            else if(justPressed[i])
            {
                cantPress[i]=true;
                justPressed[i]=false;
            }
            if(!cantPress[i] && keys[i]){
                justPressed[i]=true;
            }
        }

        up          = keys[KeyEvent.VK_W] || keys[KeyEvent.VK_UP];
        down        = keys[KeyEvent.VK_S] || keys[KeyEvent.VK_DOWN];
        left        = keys[KeyEvent.VK_A] || keys[KeyEvent.VK_LEFT];
        right       = keys[KeyEvent.VK_D] || keys[KeyEvent.VK_RIGHT];
        jump        = keys[KeyEvent.VK_SPACE];
        interact    = keys[KeyEvent.VK_E];
        open_cufar    = keys[KeyEvent.VK_E];
    }

    /*! \fn public void keyPressed(KeyEvent e)
        \brief Functie ce va fi apelata atunci cand un un eveniment de tasta apasata este generat.

         \param e obiectul eveniment generat de tastatura.
     */
    @Override
    public void keyPressed(KeyEvent e)
    {
        ///se retine in vectorul de flaguri ca o tasta a fost apasata.
        if(e.getKeyCode()<0||e.getKeyCode()>=keys.length)
            return;
        keys[e.getKeyCode()] = true;

    }

    /*! \fn public void keyReleased(KeyEvent e)
        \brief Functie ce va fi apelata atunci cand un un eveniment de tasta eliberata este generat.

         \param e obiectul eveniment generat de tastatura.
     */
    @Override
    public void keyReleased(KeyEvent e)
    {
        ///se retine in vectorul de flaguri ca o tasta a fost eliberata.
        keys[e.getKeyCode()] = false;
    }


    @Override
    public void keyTyped(KeyEvent e)
    {

    }
    public boolean keyJustPressed(int keyCode)
    {
        if(keyCode<0 || keyCode>=keys.length)
            return false;
        return justPressed[keyCode];
    }
}



