package PaooGame;


public class Main
{
    public static void main(String[] args)
    {
        Game paooGame = Game.GetInstance("Ucenicul lui Merlin", 768, 384);
        paooGame.StartGame();
    }
}
