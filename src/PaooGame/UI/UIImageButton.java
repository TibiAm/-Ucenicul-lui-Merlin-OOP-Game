package PaooGame.UI;
import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class UIImageButton
    \brief Deseneaza butoanele din interfata cu utilizatorul

 */
public class UIImageButton extends UIObject{
    private BufferedImage[] images;
    private ClickListener clicker;

    public UIImageButton(float x, float y, int width, int height, BufferedImage[]images,ClickListener clicker) {
        super(x, y, width, height);
        this.images=images;
        this.clicker=clicker;
    }

    @Override
    public void Update() {

    }

    @Override
    public void draw(Graphics g) {
        if(hovering)
            g.drawImage(images[1],(int)x,(int)y, width, height, null  );
        else //la idexul 1 e imaginea atinsa, la indexul 0 e imaginea originala
            g.drawImage(images[0],(int)x,(int)y, width, height, null  );
    }

    @Override
    public void onClick() {
        clicker.onClick();
    }
}
