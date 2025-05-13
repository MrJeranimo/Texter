import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        ChainList chats = new ChainList();
        Chain jeremy = new Chain(0, "Jeremy", new Message(0, "Hello World!"), chats);
        Chain ben = new Chain(0, "Ben", new Message(0, "Hello World!"), chats);
        chats.add(jeremy);
        chats.add(ben);
        jeremy.newMessage(new Message(1, "Goodbye World!"));
        GUIController gui = new GUIController(chats);
        ben.newMessage(new Message(1, "Goodbye World!"));
    }
}