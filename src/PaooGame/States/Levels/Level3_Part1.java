package PaooGame.States.Levels;

import PaooGame.Items.Hero;
import PaooGame.Maps.MapFactory;
import PaooGame.RefLinks;
import PaooGame.States.GameState;
import PaooGame.States.State;
import PaooGame.States.WinState;
import PaooGame.Tiles.Tile;

import java.awt.*;

/*! \class Level3_Part1
        \brief Implementeaza ultimul nivel
     */
public class Level3_Part1 extends GameState {

    public Level3_Part1(RefLinks refLink) {
        super(refLink);
        map= MapFactory.Create(5,refLink);
    }

    @Override
    public void Update() {
        refLinks.SetMap(map);
        super.Update();
        Hero hero=refLinks.GetMap().getItemManager().getHero();
        Rectangle heroBounds=hero.getCollisionsBounds(0,0);
        Rectangle auxiliar=new Rectangle(15* Tile.TILE_WIDTH,6*Tile.TILE_HEIGHT,Tile.TILE_WIDTH,Tile.TILE_HEIGHT);
        if(heroBounds.intersects(auxiliar)) {
            //Jocul se finalizeaza in urma interactiunii cu Merlin
            refLinks.GetGame().winState.SetAsCurrent();
        }

        if(ComingFromRight && heroBounds.intersects(auxiliar))
        {
            map.Refresh();
            hero.SetX(14*Tile.TILE_WIDTH);
            hero.SetY(5*Tile.TILE_HEIGHT);
            ComingFromRight=false;
            heroBounds=hero.getCollisionsBounds(0,0);
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
            State.SetState(refLinks.GetGame().level2_Part2);
            ComingFromLeft=true;
        }

    }

}
