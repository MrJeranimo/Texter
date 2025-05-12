import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        ChainList chats = new ChainList(new Chain(0, "Jeremy", new Message(0, "Hello World!")));
        chats.add(new Chain(1, "Ben", new Message(0, "How are you?")));
        GUIController gui = new GUIController(chats);
    }
}