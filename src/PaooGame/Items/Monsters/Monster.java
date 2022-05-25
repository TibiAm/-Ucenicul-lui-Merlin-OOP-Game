package PaooGame.Items.Monsters;
import PaooGame.Items.Character;
import PaooGame.Items.Hero;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.Random;

public abstract class Monster extends Character {

    protected BufferedImage image;

    public Monster(RefLinks refLink, float x, float y, int width, int height, BufferedImage image) {
        super(refLink, x, y, width, height);
        this.image=image;

        bounds.width = 20;
        bounds.height = 30;
        bounds.x = 15;
        bounds.y = 10;

        attackBounds.width = 30;
        attackBounds.height = 15;
        attackBounds.x = 10;
        attackBounds.y = 10;
        speed/=8;
    }

    @Override
    public void Move()
    {
        Random random=new Random();
        if(random.nextInt(2)==1)
            xMove=-speed;
        else
            xMove=speed;
        super.Move();
    }

    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(image,(int)(x),(int)(y),width,height,null);
    }

    @Override
    public void Update()
    {
        //daca eroul atinge inamicul, eroul va fi respawn-at la inceputul hartii
        Hero hero=refLink.GetMap().getItemManager().getHero();
        Rectangle heroBounds=hero.getCollisionsBounds(0,0);
        Rectangle attackBounds=new Rectangle((int)x+this.attackBounds.x,(int)y+this.attackBounds.y,
                this.attackBounds.width,this.attackBounds.height);

        if(heroBounds.intersects(attackBounds))
        {
            hero.SetX(Tile.TILE_WIDTH);
            hero.SetY(6*Tile.TILE_HEIGHT);
            hero.setLife(hero.getLife()-1);
            try{
                refLink.GetGame().getDB().updateHeroLife(refLink.GetMap().getItemManager().getHero().getLife());}
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            if(hero.getLife()<=0)
            {
                refLink.GetGame().loseState.SetAsCurrent();
            }
        }

        Move();

    }

}

