package PaooGame.States.Levels;

import PaooGame.Items.Hero;
import PaooGame.Maps.MapFactory;
import PaooGame.RefLinks;
import PaooGame.States.GameState;
import PaooGame.States.State;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.sql.SQLException;

/*! \class Level1_Part2
    \brief Implementeaza a doua parte a primului nivel
 */
public class Level1_Part2 extends GameState {


    public Level1_Part2(RefLinks refLink) {
        super(refLink);
        map= MapFactory.Create(2,refLink);
    }

    @Override
    public void Update() {
        Hero hero=refLinks.GetMap().getItemManager().getHero();
        Rectangle heroBounds=hero.getCollisionsBounds(0,0);
        Rectangle auxiliar=new Rectangle(15* Tile.TILE_WIDTH,6*Tile.TILE_HEIGHT,Tile.TILE_WIDTH,Tile.TILE_HEIGHT);
        refLinks.SetMap(map);
        super.Update();


        if(ComingFromRight && heroBounds.intersects(auxiliar))
        {
            map.Refresh();
            hero.SetX(14*Tile.TILE_WIDTH);
            ComingFromRight =false;
            heroBounds=hero.getCollisionsBounds(0,0);
        }


        if(heroBounds.intersects(auxiliar) && LevelFlags.level1_passed())
        {
            try{
                refLinks.GetGame().getDB().updateCurrentLevel(3);}
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            State.SetState(refLinks.GetGame().level2_Part1);
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
            State.SetState(refLinks.GetGame().level1_Part1);
            ComingFromLeft =true;
        }
    }

}

