package PaooGame.Items;
import java.awt.image.BufferedImage;
import PaooGame.Graphics.Assets;
import PaooGame.MyException;
import PaooGame.RefLinks;
import PaooGame.Animation.Animation;
import PaooGame.Storage.Storage;
import java.awt.*;
import java.sql.SQLException;

import PaooGame.Items.NPC.*;
import PaooGame.Items.Monsters.*;

/*! \class Hero
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).
 */
public class Hero extends Character{

    private final Animation animRight;
    private final Animation animLeft;
    private final Animation animDown;
    private final Animation animUp;

    private static Storage storage=null;

    /*! \fn public Hero(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Hero.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a eroului.
        \param y Pozitia initiala pe axa Y a eroului.
     */
    public Hero(RefLinks refLink, float x, float y)
    {
        super(refLink,x,y, Character.DEFAULT_CHARACTER_WIDTH,Character.DEFAULT_CHARACTER_HEIGHT);
        bounds.x=14;
        bounds.y=18;
        bounds.width=20;
        bounds.height=24;

        animRight = new Animation(200, Assets.Player_Right);
        animLeft = new Animation(200, Assets.Player_Left);
        animDown = new Animation(200, Assets.Player_Down);
        animUp = new Animation(200, Assets.Player_Up);

        if(storage==null)
            storage= new Storage(refLink);

    }

    @Override
    public void Update()
    {
        animRight.Update();
        animLeft.Update();
        // animDown.Update();
        animUp.Update();

        STATE_SPEED+=0.15f;


        ///Verifica daca a fost apasata o tasta
        GetInput();
        ///Actualizeaza pozitia
        Move();
        checkAttacks();

        //Actualizeaza inventarul
        storage.Update();
    }

    private void checkAttacks()
    {

        if(storage.isActive())
            return;

        Rectangle cb= getCollisionsBounds(0,0);
        Rectangle ar=new Rectangle();
        int arSize=20;
        ar.width=arSize;
        ar.height=arSize;

        if(refLink.GetKeyManager().open_cufar&&refLink.GetKeyManager().right) {
            ar.x = cb.x + cb.width;
            ar.y=cb.y+cb.height/2-arSize/2;
        }
        else if (refLink.GetKeyManager().open_cufar && refLink.GetKeyManager().left)
        {
            ar.x=cb.x-arSize;
            ar.y=cb.y+cb.height/2-arSize/2;
        }
        else if (refLink.GetKeyManager().open_cufar && refLink.GetKeyManager().up)
        {
            ar.x=cb.x+cb.width/2-arSize/2;
            ar.y=cb.y-arSize;
        }
        else if (refLink.GetKeyManager().open_cufar && refLink.GetKeyManager().down)
        {
            ar.x=cb.x+cb.width/2-arSize/2;
            ar.y=cb.y+ cb.height;
        }
        else return;


        for(Item e:refLink.GetMap().getItemManager().getItems()) {
            if (e.equals(this))
                continue;
            if (e.getCollisionsBounds(0,0).intersects(ar))
            {
                if(e instanceof NPC)
                {
                    try{
                    ((NPC) e).Interact();}
                    catch(MyException exc)
                    {
                        System.out.println(exc.getMessage());
                    }
                    refLink.GetMap().getItemManager().getHero().setScore(refLink.GetMap().getItemManager().getHero().getScore()+13);
                    try{
                        refLink.GetGame().getDB().updateHeroScore(refLink.GetMap().getItemManager().getHero().getScore());}
                    catch (SQLException ex)
                    {
                        ex.printStackTrace();
                    }
                    return;
                }
                if(e instanceof Monster)
                    refLink.GetMap().getItemManager().getHero();
                e.hurt(1);
                refLink.GetMap().getItemManager().getHero().setScore(refLink.GetMap().getItemManager().getHero().getScore()+25);
                try{
                    refLink.GetGame().getDB().updateHeroScore(refLink.GetMap().getItemManager().getHero().getScore());}
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
                return;
            }

        }
    }

    /*! \fn private void GetInput()
        \brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
     */
    private void GetInput()
    {
        xMove=0;
        yMove=0;

        //eroul nu trebuie sa se miste daca e activ meniul
        if(storage.isActive())
            return;


        if(onLadder)
        {
            STATE_SPEED=0;
            if(refLink.GetKeyManager().up)
                yMove=-speed;
            if(refLink.GetKeyManager().down)
                yMove=speed;
        }
        else {
            yMove+=STATE_SPEED;
            if (canJump && refLink.GetKeyManager().jump) {
                canJump = false;
                STATE_SPEED = VERTICAL_SPEED;
            }
        }


        ///Verificare apasare tasta "left"
        if (refLink.GetKeyManager().left) {
            xMove = -speed;
        }
        ///Verificare apasare tasta "dreapta"
        if (refLink.GetKeyManager().right) {
            xMove = speed;
        }
    }
    @Override
    public void Draw(Graphics g)
    {
        //g.drawImage(Assets.pers, (int)x, (int)y, width, height,null);
        g.drawImage(getCurrentAnimationFrame(),(int)x, (int)y, width, height,null);
        //Pentru a vedea dreptunghiul de coliziune putem decomenta liniile de mai jos
        //g.setColor(Color.red);
        //g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);

    }

    public void PostDraw(Graphics g)
    {
        storage.Draw(g);
    }

    private BufferedImage getCurrentAnimationFrame()
    {
        if (xMove < 0)
            return animLeft.getCurrentFrame();
        else if (xMove > 0)
            return animRight.getCurrentFrame();
        else if (yMove < 0)
            return animUp.getCurrentFrame();
        else
            return animDown.getCurrentFrame();
    }

    public static Storage getStorage() {
        return storage;
    }

    @Override
    public void die()
    {
        System.out.println("You lose");

    }

    public static void setStorage(Storage storage) {
        Hero.storage = storage;
    }

}


