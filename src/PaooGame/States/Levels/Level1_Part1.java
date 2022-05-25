package PaooGame.States.Levels;
import PaooGame.Items.Hero;
import PaooGame.Maps.MapFactory;
import PaooGame.RefLinks;
import PaooGame.States.GameState;
import PaooGame.States.State;
import PaooGame.Tiles.Tile;
import java.awt.*;
import java.sql.SQLException;


/*! \class Level1_Part1
    \brief Implementeaza prima parte a primului nivel
 */
public class Level1_Part1 extends GameState {


    public Level1_Part1(RefLinks refLink) {
        super(refLink);
        map=MapFactory.Create(1,refLink);

    }

    @Override
    public void Update() {
        Hero hero=map.getItemManager().getHero();
        Rectangle heroBounds=hero.getCollisionsBounds(0,0);
        Rectangle auxiliar=new Rectangle(15* Tile.TILE_WIDTH,6*Tile.TILE_HEIGHT,Tile.TILE_WIDTH,Tile.TILE_HEIGHT);
        Rectangle aux2 = new Rectangle(0* Tile.TILE_WIDTH,6*Tile.TILE_HEIGHT,Tile.TILE_WIDTH,Tile.TILE_HEIGHT);
        refLinks.SetMap(map);
        super.Update();

        if(heroBounds.intersects(aux2))
        {
            try{
                refLinks.GetGame().getDB().updateHeroLife(3);
                refLinks.GetGame().getDB().updateCurrentLevel(1);
                refLinks.GetGame().getDB().updateHeroScore(0);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        if(ComingFromRight && heroBounds.intersects(auxiliar))
        {
            map.Refresh();
            hero.SetX(14*Tile.TILE_WIDTH);
            ComingFromRight =false;
            heroBounds=hero.getCollisionsBounds(0,0);
        }


        if(heroBounds.intersects(auxiliar) && LevelFlags.level1_part1_coinsPaid)
        {
            try{
            refLinks.GetGame().getDB().updateCurrentLevel(2);}
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            State.SetState(refLinks.GetGame().level1_Part2);
            ComingFromRight =true;
        }
    }

}
