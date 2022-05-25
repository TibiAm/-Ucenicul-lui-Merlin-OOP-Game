package PaooGame;

/*! \class MyException
    \brief Implementeaza o exceptie proprie bazata pe interactiunea cu NPC-urile
 */
public class MyException extends Exception{
    public MyException(String mesaj)
    {
        ///Daca nu am suficiente toteme pentru a trece mai departe se genereaza o exceptie
        super(mesaj);
    }
}
