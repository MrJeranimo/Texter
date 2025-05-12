import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        ChainList chats = new ChainList(new Chain(0, new Message(0, "Hello World!")));
        while(true){
            System.out.println("Enter the id of the Chat you would like to see: ");
            int answer = kbd.nextInt();
            if(answer == -1) {
                break;
            }
            Chain currChat = chats.findChain(answer);
            if(currChat != null) {
                System.out.println(currChat.getRecentMessages(5));
            } else {
                System.out.println("There is not chat with that id.");
            }
        }
    }
}