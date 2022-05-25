package PaooGame.Items;

import PaooGame.RefLinks;

import java.awt.*;

/*! \class Item
    \brief. Implementeaza notiunea abstracta de entitate activa din joc, "element cu care se poate interactiona: inamici, NPC-uri etc.".
 */
public abstract class Item {
    ///coordonatele x si y sunt de tip float pentru a se elimina erorile de rotunjire
    ///ce pot sa apara in urma calculelor, urmand a se converti la intreg doar in momentul desenarii.
    protected RefLinks refLink;             /*!< O referinte catre un obiect ce contine o serie de referinte utile in program.*/
    protected float x,y;                    /*!< Coordonatele pe axele X si Y  a "tablei" de joc a imaginii entitatii.*/
    protected int width, height;            /*!< Latimea si inaltimea imaginii entitatii.*/
    protected Rectangle bounds;             /*!< Dreptunghiul curent de coliziune.*/
    protected Rectangle attackBounds;       /*!< Dreptunghiul de coliziune aferent starii de atac/interactiune.*/
    protected boolean active=true;          /*!< cand flagul devine false, entitatea va fi stearsa*/
    protected static int life;              /*!< Retine viata caracterului.*/
    public static final int DEFAULT_LIFE            = 3;   /*!< Valoarea implicita a vietii unui caracter.*/


    /*! \fn public Item(RefLinks refLink, float x, float y, int width, int height)
        \brief Constructor de initializare al clasei

        \param  reflink Referinte catre alte referinte utile
        \param  x   Pozitia pe axa X a "tablei" de joc.
        \param  y   Pozitia pe axa Y a "tablei" de joc.
        \param  width   Latimea imaginii entitatii.
        \param  height  Inaltimea imaginii entitatii.
     */
    public Item (RefLinks refLink,float x, float y, int width, int height)
    {
        this.refLink=refLink;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;

        ///Creaza dreptunghi de coliziune
        bounds = new Rectangle(0,0,width, height);
        ///Creaza dreptunghi de coliziune pentru starea de atac/interactiune
        attackBounds = new Rectangle(0, 0, width, height);
    }

    /*! \fn public abstract void Update()
        \brief Metoda abstracta destinata actualizarii starii curente
     */
    public abstract void Update();


    public abstract void Draw(Graphics g);

    /*! \fn public boolean checkItemCollisions(float xOffset, float yOffset)
        \brief Metoda care verifica daca exista coliziune cu obiectul curent
     */
    public boolean checkItemCollisions(float xOffset,float yOffset)
    {
        for(Item e : refLink.GetMap().getItemManager().getItems()){
            if(e.equals(this)) //itself
                continue;
            if(e.getCollisionsBounds(0f,0f).intersects(getCollisionsBounds(xOffset,yOffset)))
                return true;
        }
        return false;
    }

    /*! \fn public boolean getCollisionsBounds(float xOffset, float yOffset)
        \brief Metoda care returneaza un drepturnghi de coliziune
     */
    public Rectangle getCollisionsBounds(float xOffset,float yOffset){
        return new Rectangle((int)(x+bounds.x+xOffset), (int)(y+bounds.y+yOffset),bounds.width,bounds.height);
    } // => xOffset=yOffset=0 => x+bounds.x=xOffset

    public abstract void die();

    public void hurt(int amt)
    {
        life-=amt;
        if(life<=0) {
            active = false; //cand ramane fara viata, moare
            die();
        }
    }

    /*! \fn public float GetX()
        \brief Returneaza coordonata pe axa X.
     */
    public float GetX()
    {
        return x;
    }

    /*! \fn public float GetY()
        \brief Returneaza coordonata pe axa Y.
     */
    public float GetY()
    {
        return y;
    }

    /*! \fn public float GetWidth()
        \brief Returneaza latimea entitatii.
     */
    public int GetWidth()
    {
        return width;
    }

    /*! \fn public float GetHeight()
        \brief Returneaza inaltimea entitatii.
     */
    public int GetHeight()
    {
        return height;
    }

    /*! \fn public float SetX()
        \brief Seteaza coordonata pe axa X.
     */
    public void SetX(float x)
    {
        this.x = x;
    }

    /*! \fn public float SetY()
        \brief Seteaza coordonata pe axa Y.
     */
    public void SetY(float y)
    {
        this.y = y;
    }

    /*! \fn public float SetWidth()
        \brief Seteaza latimea imaginii entitatii.
     */
    public void SetWidth(int width)
    {
        this.width = width;
    }

    /*! \fn public float SetHeight()
        \brief Seteaza inaltimea imaginii entitatii.
     */
    public void SetHeight(int height)
    {
        this.height = height;
    }

    /*! \fn public boolean isActive()
        \brief Returneaza daca elementul este activ. Daca acesta nu este activ, va fi sters.
     */
    public boolean isActive() {
        return active;
    }

    /*! \fn public void setActive(boolean active)
        \brief Seteaza campul active cu valoarea parametrului

        \param active stare a entitatii
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /*! \fn public void setLife(int x)
        \brief Seteaza numarul de vieti ale entitatii
        \param x numar de vieti
     */
    public void setLife(int x)
    {
        life=x;
    }

    /*! \fn public int getLife()
        \brief Returneaza numarul de vieti ale entitatii
     */
    public int getLife()
    {
        return life;
    }
}
