package PaooGame.Tiles.TransparentTiles;

import PaooGame.Graphics.Assets;
import PaooGame.Tiles.Tile;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class TransparentTile extends Tile
{
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public TransparentTile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.transparent, id);
    }

}
