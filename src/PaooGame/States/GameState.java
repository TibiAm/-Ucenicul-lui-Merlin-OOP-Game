package PaooGame.States;

import PaooGame.RefLinks;
import PaooGame.Maps.Map;

import java.awt.*;

/*! \class GameState
    \brief Implementeaza/controleaza jocul.
 */
public abstract class GameState extends State
{
    protected Map map;    /*!< Referinta catre harta curenta.*/
    protected int NrNivel;
    protected boolean ComingFromRight =false,ComingFromLeft=false;



    /*! \fn public GameState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect ce contine o serie de referinte utile in program.
     */
    public GameState(RefLinks refLink)
    {
        super(refLink);

    }

    @Override
    public void Update()
    {
        refLinks.SetMap(map);
        map.Update();

    }


    @Override
    public void Draw(Graphics g)
    {
        map.Draw(g);
    }

}

