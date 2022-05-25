package PaooGame.States;

import PaooGame.Game;
import PaooGame.Graphics.Assets;
import PaooGame.Graphics.ImageLoader;
import PaooGame.Graphics.Text;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;
import PaooGame.UI.ClickListener;
import PaooGame.UI.UIImageButton;
import PaooGame.UI.UIManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.SQLException;

/*! \class LoseState
    \brief Implementeaza starea de lose a jocului.
 */
public class LoseState extends State {

    private UIManager uiManager;
    private BufferedImage background;

    /*! \fn public LoseState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.
     */

    public LoseState(RefLinks refLink) {
        super(refLink);

        background = ImageLoader.LoadImage("/Menu/lose.png");

        uiManager = new UIManager(refLink);

        refLink.GetMouseManager().setUIManager(uiManager); //pentru a se vedea animatia butonului


        uiManager.addObject(new UIImageButton(320, 256, 128, 64, Assets.btn_exit, new ClickListener() {
            @Override
            public void onClick() {
                System.exit(0);
            }
        }));
    }


    /*! \fn public void SetAsCurrent()
        \brief Seteaza starea ca si stare curenta
     */
    @Override
    public void SetAsCurrent() {
        super.SetAsCurrent();
        refLinks.GetMouseManager().setUIManager(uiManager);
    }

    @Override
    public void Update() {
        uiManager.Update();

    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(background, 0, 0, null);
        uiManager.draw(g);
        try {
            Text.drawString(g, "Scor: " + refLinks.GetGame().getDB().getHeroScore(), 310, 180, false, Color.white, Assets.font40);

        }catch (SQLException e)
        {
            System.out.println("Eroare la incarcarea scorului din baza de date");
        }

    }
}