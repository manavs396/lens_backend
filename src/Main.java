import Model.LensManager;
import TextUIPack.TextUIClass;

public class Main {
    public static void main(String args[] ){

        LensManager manager= new LensManager();
        TextUIClass ui= new TextUIClass(manager);
        ui.display();
    }
}
