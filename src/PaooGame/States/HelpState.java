package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.Graphics.ImageLoader;
import PaooGame.RefLinks;
import PaooGame.UI.ClickListener;
import PaooGame.UI.UIImageButton;
import PaooGame.UI.UIManager;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class HelpState
    \brief Implementeaza notiunea de sectiune in care se explica mecanica jocului/ajutor.
 */
public class HelpState extends State
{

    private UIManager uiManager;
    private BufferedImage background;

    /*! \fn public HelpState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.
     */
    public HelpState(RefLinks refLink)
    {
        super(refLink);

        background= ImageLoader.LoadImage("/Menu/help.png");

        uiManager=new UIManager(refLink);

        refLink.GetMouseManager().setUIManager(uiManager); //pentru a se vedea animatia butonului

        uiManager.addObject(new UIImageButton(350, 300, 96, 48, Assets.btn_win, new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                State.SetState(new MenuState(refLinks));
                //System.exit(0);
            }
        }) );
    }


    /*! \fn public void SetAsCurrent()
        \brief Seteaza starea ca si stare curenta
     */
    @Override
    public void SetAsCurrent(){
        super.SetAsCurrent();
        refLinks.GetMouseManager().setUIManager(uiManager);
    }

    @Override
    public void Update()
    {
        uiManager.Update();
    }

    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(background,0,0,null);
        uiManager.draw(g);
    }
}
