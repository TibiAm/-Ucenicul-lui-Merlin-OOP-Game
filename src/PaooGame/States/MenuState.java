package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.Graphics.ImageLoader;
import PaooGame.RefLinks;
import PaooGame.UI.ClickListener;
import PaooGame.UI.UIImageButton;
import PaooGame.UI.UIManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.SQLException;

/*! \class MenuState
    \brief Implementeaza notiunea de meniu pentru joc.
 */
public class MenuState extends State
{

    private UIManager uiManager;
    private BufferedImage background;

    /*! \fn public MenuState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

     */
    public MenuState(RefLinks refLink)
    {
        super(refLink);
        background= ImageLoader.LoadImage("/textures/menubackground.jpg");

        uiManager=new UIManager(refLink);


        refLink.GetMouseManager().setUIManager(uiManager); //pentru a se vedea animatia butonului

        uiManager.addObject(new UIImageButton(320, 96, 128, 64, Assets.btn_start, new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                State.SetState(refLink.GetGame().level1_Part1);
            }
        }) );

        /*uiManager.addObject(new UIImageButton(320, 128, 128, 64, Assets.btn_load, new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                try
                {
                    System.out.println(refLink.GetGame().getDB().getCurrentLevel());
                   // switch(refLink.GetGame().getDB().getCurrentLevel())
                    //State.SetState(refLink.GetGame().level2_Part2);
                    //State.SetState(new Level2_Part2(refLink));
                    //refLink.GetGame().level2_Part2.SetAsCurrent();
                    //State.SetState(Game.GetInstance("Ucenicul lui Merlin", 768, 384).level2_Part2);
                    /*switch(3)
                    {
                        case 1 : State.SetState(refLink.GetGame().level1_Part1);
                        case 2 : State.SetState(refLink.GetGame().level1_Part2);
                        case 3 : State.SetState(new Level2_Part1(refLink));
                        case 4 : State.SetState(refLink.GetGame().level2_Part2);
                        case 5 : State.SetState(refLink.GetGame().level3_Part1);
                    }
                    //refLink.GetMap().getItemManager().getHero().setLife(3);
                    //refLink.GetGame().getDB().updateHeroLife(3);
                   // refLink.GetMap().getItemManager().getHero().setScore(refLink.GetGame().getDB().getHeroScore());

                }
                catch (SQLException E)
                {
                    System.out.println("Eroare la incarcarea progresului");
                }

            }
        }) );*/

        uiManager.addObject(new UIImageButton(320, 160, 128, 64, Assets.btn_about, new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                //State.SetState(new HelpState(refLinks));
                refLink.GetGame().helpState.SetAsCurrent();
            }
        }) );

        uiManager.addObject(new UIImageButton(320, 224, 128, 64, Assets.btn_exit, new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                try{
                    refLink.GetGame().getDB().stmt.close();
                    refLink.GetGame().getDB().c.close();
                }catch (SQLException e)
                {
                    System.out.println("Eroare la inchiderea conexiunii cu baza de date");
                }
                System.exit(0);
            }
        }) );


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

