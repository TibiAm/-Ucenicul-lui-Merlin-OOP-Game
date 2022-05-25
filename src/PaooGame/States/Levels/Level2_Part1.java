package PaooGame.States.Levels;
import PaooGame.Items.Hero;
import PaooGame.Maps.MapFactory;
import PaooGame.RefLinks;
import PaooGame.States.GameState;
import PaooGame.States.State;
import PaooGame.Tiles.Tile;
import java.awt.*;
import java.sql.SQLException;

/*! \class Level2_Part1
    \brief Implementeaza prima parte a nivelului 2
 */
public class Level2_Part1 extends GameState {


    public Level2_Part1(RefLinks refLink) {
        super(refLink);
        map=MapFactory.Create(3,refLink);
    }

    @Override
    public void Update() {
        refLinks.SetMap(map);
        super.Update();
        Hero hero=refLinks.GetMap().getItemManager().getHero();
        Rectangle heroBounds=hero.getCollisionsBounds(0,0);
        Rectangle auxiliar=new Rectangle(15* Tile.TILE_WIDTH,6*Tile.TILE_HEIGHT,Tile.TILE_WIDTH,Tile.TILE_HEIGHT);


        if(ComingFromRight && heroBounds.intersects(auxiliar))
        {
            map.Refresh();
            hero.SetX(14*Tile.TILE_WIDTH);
            ComingFromRight =false;
            heroBounds=hero.getCollisionsBounds(0,0);
        }


        if(heroBounds.intersects(auxiliar) && LevelFlags.level2_part1_coinsPaid)
        {
            try{
                refLinks.GetGame().getDB().updateCurrentLevel(4);}
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            State.SetState(refLinks.GetGame().level2_Part2);
            ComingFromRight =true;
        }

        auxiliar=new Rectangle(0,6*Tile.TILE_HEIGHT,Tile.TILE_WIDTH,Tile.TILE_HEIGHT);


        if(ComingFromLeft && heroBounds.intersects(auxiliar))
        {
            map.Refresh();
            hero.SetX(Tile.TILE_WIDTH);
            ComingFromLeft =false;
            heroBounds=hero.getCollisionsBounds(0,0);
        }


        if(heroBounds.intersects(auxiliar))
        {
            State.SetState(refLinks.GetGame().level1_Part2);
            ComingFromLeft=true;
        }
    }
}
