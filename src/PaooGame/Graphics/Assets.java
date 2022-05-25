package PaooGame.Graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
    /// Referinte catre elementele grafice (dale) utilizate in joc.
    public static BufferedImage soil1, soil2, soil3, soil4, soil5,soil6,soil7,soil8,soil9, soil10;
    public static BufferedImage tree1,tree2,tree3,tree4;
    public static BufferedImage tre1,tre2,tre3,tre4;
    public static BufferedImage grass1;
    public static BufferedImage sign, sign2;
    public static BufferedImage flower, pers;
    public static BufferedImage transparent;
    public static BufferedImage bush1, bush2;
    public static BufferedImage scara1, scara2,scara3;
    public static BufferedImage piatra1, piatra2;

    public static BufferedImage[] Player_Right;
    public static BufferedImage[] Player_Left;
    public static BufferedImage[] Player_Down;
    public static BufferedImage[] Player_Up;

    public static BufferedImage calauza;
    public static BufferedImage totem;
    public static BufferedImage[] btn_start;
    public static BufferedImage[] btn_exit, btn_about, btn_load;

    public static Font font28, font20, font40;


    public static BufferedImage sol1, sol2, sol3, sol4, sol5, sol6, sol7, sol8, sol9;
    public static BufferedImage copac1, copac2, copac3, copac4, copac5, copac6, copac7, copac8;
    public static BufferedImage lava1, lava2;
    public static BufferedImage land1, land2, land3;
    public static BufferedImage semn;
    public static BufferedImage piatra3, piatra4;
    public static BufferedImage iarba1, iarba2;
    public static BufferedImage tufis1, tufis2;
    public static BufferedImage craniu, cristal, bluecristal, cufar;

    public static BufferedImage podea1, podea2;
    public static BufferedImage castel1, castel2, castel3, castel4, castel5, castel6, castel7, castel8;
    public static BufferedImage cutie, cristalroz;

    public static BufferedImage mesajcalauza, schelet;

    public static BufferedImage[] monster_stg, monster_drt;

    public static BufferedImage Merlin;

    public static BufferedImage[] btn_win;

    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init() {
        /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        // SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/PaooGameSpriteSheet.png"));

        /// Se obtin subimaginile corespunzatoare elementelor necesare.
            SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/lvl1-sheet.png"));
            soil1 = sheet.crop(0, 0);
            soil2 = sheet.crop(1, 0);
            soil3 = sheet.crop(2, 0);
            soil4 = sheet.crop(0, 1);
            soil5 = sheet.crop(1, 1);
            soil6 = sheet.crop(2, 1);
            soil7 = sheet.crop(0, 2);
            soil8 = sheet.crop(1, 2);
            soil9 = sheet.crop(2, 2);
            soil10 = sheet.crop(1, 0);

            tree1 = sheet.crop(5, 1);
            tree2 = sheet.crop(6, 1);
            tree3 = sheet.crop(5, 2);
            tree4 = sheet.crop(6, 2);

            tre1 = sheet.crop(8, 0);
            tre2 = sheet.crop(9, 0);
            tre3 = sheet.crop(8, 1);
            tre4 = sheet.crop(9, 1);

            grass1 = sheet.crop(8, 3);

            sign = sheet.crop(8, 2);
            sign2 = sheet.crop(9, 2);
            transparent = sheet.crop(9, 3);

            bush1 = sheet.crop(5, 3);
            bush2 = sheet.crop(6, 3);

            flower = sheet.crop(5, 0);

            piatra1 = sheet.crop(6, 0);
            piatra2 = sheet.crop(7, 0);

            scara1 = sheet.crop(7, 1);
            scara2 = sheet.crop(7, 2);
            scara3 = sheet.crop(7, 3);

            SpriteSheet sheetLucas = new SpriteSheet(ImageLoader.LoadImage("/textures/Caractere/Hero.png"));
            Player_Right = new BufferedImage[3];
            Player_Right[0] = sheetLucas.crop(0, 2);
            Player_Right[1] = sheetLucas.crop(1, 2);
            Player_Right[2] = sheetLucas.crop(2, 2);
            Player_Left = new BufferedImage[3];
            Player_Left[0] = sheetLucas.crop(0, 1);
            Player_Left[1] = sheetLucas.crop(1, 1);
            Player_Left[2] = sheetLucas.crop(2, 1);
            Player_Down = new BufferedImage[3];
            Player_Down[0] = sheetLucas.crop(0, 0);
            Player_Down[1] = sheetLucas.crop(1, 0);
            Player_Down[2] = sheetLucas.crop(2, 0);
            Player_Up = new BufferedImage[3];
            Player_Up[0] = sheetLucas.crop(0, 3);
            Player_Up[1] = sheetLucas.crop(1, 3);
            Player_Up[2] = sheetLucas.crop(2, 3);

            calauza = ImageLoader.LoadImage("/textures/Caractere/Elisyum.png");
            totem = ImageLoader.LoadImage("/textures/Items/totem.png");

            font28 = FontLoader.LoadFont("res/Fonts/SFAtarianSystem.ttf", 28);
            font20 = FontLoader.LoadFont("res/Fonts/SFAtarianSystem.ttf", 20);
            font40 = FontLoader.LoadFont("res/Fonts/SFAtarianSystem.ttf", 40);

            //------------------------------------------------------------------------------------------------
            SpriteSheet sheetMenu = new SpriteSheet(ImageLoader.LoadImage("/Menu/menutiles1.png"));
            btn_start = new BufferedImage[2];
            btn_start[0] = sheetMenu.crop2Width(0, 0);
            btn_start[1] = sheetMenu.crop2Width(0, 1);
            btn_load = new BufferedImage[2];
            btn_load[0] = sheetMenu.crop2Width(1, 0);
            btn_load[1] = sheetMenu.crop2Width(1, 1);
            btn_about = new BufferedImage[2];
            btn_about[0] = sheetMenu.crop2Width(2, 0);
            btn_about[1] = sheetMenu.crop2Width(2, 1);
            btn_exit = new BufferedImage[2];
            btn_exit[0] = sheetMenu.crop2Width(3, 0);
            btn_exit[1] = sheetMenu.crop2Width(3, 1);

            //------------------------------------------------------------------------------------------------
            SpriteSheet sheet6 = new SpriteSheet(ImageLoader.LoadImage("/Menu/win2.png"));
            btn_win = new BufferedImage[2];
            btn_win[0] = sheet6.crop2Width(0, 0);
            btn_win[1] = sheet6.crop2Width(0, 1);

            //------------------------------------------------------------------------------------------------
            SpriteSheet sheet2 = new SpriteSheet(ImageLoader.LoadImage("/textures/Spritesheet2.png"));
            sol1 = sheet2.crop(0, 0);
            sol2 = sheet2.crop(1, 0);
            sol3 = sheet2.crop(2, 0);
            sol4 = sheet2.crop(0, 1);
            sol5 = sheet2.crop(1, 1);
            sol6 = sheet2.crop(2, 1);
            sol7 = sheet2.crop(0, 2);
            sol8 = sheet2.crop(1, 2);
            sol9 = sheet2.crop(2, 2);

            copac1 = sheet2.crop(5, 0);
            copac2 = sheet2.crop(6, 0);
            copac3 = sheet2.crop(5, 1);
            copac4 = sheet2.crop(6, 1);
            copac5 = sheet2.crop(7, 0);
            copac6 = sheet2.crop(8, 0);
            copac7 = sheet2.crop(7, 1);
            copac8 = sheet2.crop(8, 1);

            land1 = sheet2.crop(0, 3);
            land2 = sheet2.crop(1, 3);
            land3 = sheet2.crop(2, 3);

            lava1 = sheet2.crop(3, 3);
            lava2 = sheet2.crop(4, 3);

            tufis1 = sheet2.crop(5, 2);
            tufis2 = sheet2.crop(6, 2);

            piatra3 = sheet2.crop(7, 2);
            piatra4 = sheet2.crop(8, 2);

            semn = sheet2.crop(9, 0);
            cufar = sheet2.crop(9, 1);

            iarba1 = sheet2.crop(9, 2);
            iarba2 = sheet2.crop(8, 3);

            craniu = sheet2.crop(5, 3);
            bluecristal = sheet2.crop(6, 3);
            cristal = sheet2.crop(9, 3);
            cutie = sheet2.crop(7, 3);

            //-----------------------------------------------------------
            SpriteSheet sheet3 = new SpriteSheet(ImageLoader.LoadImage("/textures/Spritesheet3.png"));
            podea1 = sheet3.crop(0, 0);
            podea2 = sheet3.crop(0, 1);

            castel1 = sheet3.crop(2, 0);
            castel2 = sheet3.crop(3, 0);
            castel3 = sheet3.crop(4, 0);
            castel4 = sheet3.crop(5, 0);
            castel5 = sheet3.crop(2, 1);
            castel6 = sheet3.crop(3, 1);
            castel7 = sheet3.crop(4, 1);
            castel8 = sheet3.crop(5, 1);

            cristalroz = sheet3.crop(6, 0);

            //---------------------------------------------------------------
            SpriteSheet sheet4 = new SpriteSheet(ImageLoader.LoadImage("/textures/Mesaj.png"));
            mesajcalauza = sheet4.crop2Width(0, 0);

            //-----------------------------------------------------------------

            SpriteSheet sheet5 = new SpriteSheet(ImageLoader.LoadImage("/textures/Caractere/monster.png"));
            monster_stg = new BufferedImage[6];
            for (int i = 0; i < 6; i++) {
                monster_stg[i] = sheet5.crop(i, 0);
            }

            monster_drt = new BufferedImage[6];
            for (int i = 0; i < 6; i++) {
                monster_drt[i] = sheet5.crop(i, 0);
            }

            schelet = ImageLoader.LoadImage("/textures/Caractere/schelet.png");
            Merlin = ImageLoader.LoadImage(("/textures/Caractere/Merlin.png"));
    }
}
