package PaooGame.Animation;
import java.awt.image.BufferedImage;

/*! \class Animation
    \brief Implementeaza animatiile din joc (Ex: cand eroul se misca pe harta)
 */
public class Animation {
    protected int speed, index;
    protected long LastTime,timer;
    protected BufferedImage[] frames;

    public Animation(int speed, BufferedImage[] frames)
    {
        this.speed=speed;
        this.frames=frames;
        index=0;
        timer=0;
        LastTime=System.currentTimeMillis();

    }

    public void Update(){
        timer+=System.currentTimeMillis()-LastTime;
        LastTime=System.currentTimeMillis();

        if(timer>speed)
        {
            index++;
            timer=0;
            if(index>=frames.length)
                index=0;
        }
    }

    public BufferedImage getCurrentFrame()
    {
        return frames[index];
    }
}
