package PaooGame.Items;

import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

/*! \class Character
    \brief Defineste notiunea abstracta de caracter/fiinta din joc.

    Notiunea este definita doar de viata, viteza de deplasare si distanta cu care trebuie sa se
    miste/deplaseze in urma calculelor si score.
 */
public abstract class Character extends Item{

    public static final int DEFAULT_HEALTH = 3;                 /*!< Valoarea implicita a vietii unui caracter.*/
    public static final float DEFAULT_SPEED =4.0f;              /*!< Viteza implicita a unu caracter.*/
    public static final int DEFAULT_CHARACTER_WIDTH=48;         /*!< Latimea implicita a imaginii caracterului.*/
    public static final int DEFAULT_CHARACTER_HEIGHT=48;        /*!< Inaltimea implicita a imaginii caracterului.*/

    protected static int health;                /*!< Retine viata caracterului.*/
    protected float speed;                      /*!< Retine viteza de deplasare caracterului.*/
    protected static int score;                 /*!< Retine scorul caracterului.*/

    protected float xMove, yMove;               /*!< Retine noua pozitie a caracterului pe axele X si Y.*/

    boolean onLadder=false;
    protected static final float VERTICAL_SPEED = -5.5f; //viteza sariturii
    protected float STATE_SPEED; //starea vitezei
    protected boolean canJump=false;

    /*! \fn public Character(RefLinks refLink, float x, float y, int width, int height)
        \brief Constructor de initializare al clasei Character

        \param refLink Referinta catre  alte referinte utile in joc).
        \param x Pozitia de start pe axa X a caracterului.
        \param y Pozitia de start pe axa Y a caracterului.
        \param width Latimea imaginii caracterului.
        \param height Inaltimea imaginii caracterului.
     */
    public Character (RefLinks refLink,float x, float y, int width, int height)
    {
        super(refLink,x,y,width,height);
        //setLife(3);
        health=DEFAULT_HEALTH;
        speed=DEFAULT_SPEED;
        score=0;
        xMove=0;
        yMove=0;
    }

    /*! \fn public void Move()
        \brief Modifica pozitia caracterului
     */
    public void Move(){
        if(!checkItemCollisions(xMove,0f))
            ///Modifica pozitia caracterului pe axa X.
            ///Modifica pozitia caracterului pe axa Y.
            MoveX();
        if(!checkItemCollisions(0f,yMove))
            MoveY();
    }

    /*! \fn public void MoveX()
        \brief Modifica pozitia caracterului pe axa X.
     */
    public void MoveX()
    {
        ///Aduna la pozitia curenta numarul de pixeli cu care trebuie sa se deplaseze pe axa X.
        //x += xMove;

        if (xMove >0 ){ //move right

            boolean canMove=true;
            boolean ladder=false;


            int tx=(int) (x+xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
            for(int layer = 0; layer< refLink.GetMap().getLayersNumber(); layer++)
            {
                if(collisionWithTile(layer,tx, (int) (y+bounds.y) / Tile.TILE_HEIGHT) ||
                        collisionWithTile(layer,tx,(int) (y+bounds.y+bounds.height)/Tile.TILE_HEIGHT) || tx>=refLink.GetMap().getWidth()) // (upper right corner && lower right corner)
                {
                    canMove=false;
                    break;
                }

                if(LadderTile(layer,tx, (int) (y+bounds.y) / Tile.TILE_HEIGHT) ||
                        LadderTile(layer,tx,(int) (y+bounds.y+bounds.height)/Tile.TILE_HEIGHT) )
                {
                    ladder=true;
                    break;
                }


            }

            if(canMove)
                x+=xMove;
            else
                x=tx*Tile.TILE_WIDTH-bounds.x-bounds.width-1; //coliziune perfecta

            if(ladder)
                onLadder=true;
            else
                onLadder=false;


        }

        else if(xMove<0)

        { //move left

            boolean canMove=true;
            boolean ladder=false;


            int tx=(int) (x+xMove + bounds.x) / Tile.TILE_WIDTH;
            for(int layer = 0; layer< refLink.GetMap().getLayersNumber(); layer++)
            {
                if(collisionWithTile(layer,tx, (int) (y+bounds.y) / Tile.TILE_HEIGHT) ||
                        collisionWithTile(layer,tx,(int) (y+bounds.y+bounds.height)/Tile.TILE_HEIGHT) || tx<0 ) // (upper right corner && lower right corner)
                {
                    canMove=false;
                    break;
                }

                if(LadderTile(layer,tx, (int) (y+bounds.y) / Tile.TILE_HEIGHT) ||
                        LadderTile(layer,tx,(int) (y+bounds.y+bounds.height)/Tile.TILE_HEIGHT) )
                {
                    ladder=true;
                    break;
                }


            }
            if(canMove)
                x+=xMove;
            else
                x=tx*Tile.TILE_WIDTH+Tile.TILE_WIDTH-bounds.x; //coliziunea perfecta

            if(ladder)
                onLadder=true;
            else onLadder=false;


        }
    }

    /*! \fn public void MoveY()
        \brief Modifica pozitia caracterului pe axa Y.
     */
    public void MoveY()
    {
        ///Aduna la pozitia curenta numarul de pixeli cu care trebuie sa se deplaseze pe axa Y.
        if(yMove<0) //up
        {

            boolean canMove=true;



            int ty = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;

            for (int layer = 0; layer < refLink.GetMap().getLayersNumber(); layer++) {
                {
                    if (collisionWithTile(layer, (int) (x + bounds.x) / Tile.TILE_WIDTH, ty) ||
                            collisionWithTile(layer, (int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
                        canMove = false;
                        break;
                    }
                }

            }

            if(canMove)
                y+=yMove;
            else {
                y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y; //coliziunea perfecta
            }



        }

        else if(yMove>0) //down
        {
            boolean canMove=true;

            int ty = (int) (y + yMove + bounds.y+bounds.height) / Tile.TILE_HEIGHT;

            for (int layer = 0; layer < refLink.GetMap().getLayersNumber(); layer++)
            {
                {
                    if (collisionWithTile(layer, (int) (x + bounds.x) / Tile.TILE_WIDTH, ty) ||
                            collisionWithTile(layer, (int) (x + bounds.x+bounds.width) / Tile.TILE_WIDTH, ty)) {
                        canMove = false;
                        break;
                    }
                }
            }

            if(canMove)
                y+=yMove;
            else {
                y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height - 1; //coliziunea perfecta
                STATE_SPEED=0;
                canJump=true;
            }
        }
    }


    /*! \fn protected boolean LadderTile(int layer,int x, int y)
        \brief Returneaza daca un tile este de tip Ladder

        \param layer layer care intra in constructia hartii
        \param x pozitia pe axa X
        \param y pozitia pe axa Y
     */
    protected boolean LadderTile(int layer,int x, int y){
        return refLink.GetMap().GetTile(layer,x,y).OnLadder();
    }

    /*! \fn protected boolean collisionWithTile(int layer,int x, int y)
        \brief Returneaza daca un tile este de tip solid

        \param layer layer care intra in constructia hartii
        \param x pozitia pe axa X
        \param y pozitia pe axa Y
     */
    protected boolean collisionWithTile(int layer,int x, int y){
        return refLink.GetMap().GetTile(layer,x, y).IsSolid();
    }

    /*! \fn void int setLife(int x)
        \brief Seteaza viata caracterului cu valoarea parametrului.

        \param x numarul de vieti
     */
    @Override
    public void setLife(int x)
    {
        health=x;
    }

    /*! \fn public int getLife()
        \brief Returneaza viata caracterului.
     */
    @Override
    public int getLife()
    {
        return health;
    }

    /*! \fn public int getScore()
        \brief Returneaza scorul caracterului.
     */
    public int getScore()
    {
        return score;
    }

    /*! \fn void int setScore(int s)
        \brief Seteaza scoru; caracterului cu valoarea parametrului.

        \param x scorul
     */
    public void setScore(int s)
    {
        score=s;
    }
}


