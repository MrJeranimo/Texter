public class Message {
    // Contents of the Message
    private String text;

    // Next Message in Chain
    private Message next;

    // Prev Message in Chain
    private Message prev;

    // If the text was edited after creation
    private boolean edited;

    // ID of the Message, only unique for the Chain
    private final int ID;

    public Message(int id, String text) {
        this.text = text;
        next = null;
        prev = null;
        edited = false;
        ID = id;
    }

    public void editText(String text) {
        this.text = text;
        edited = true;
    }

    public void setNext(Message next) {
        this.next = next;
    }

    public void setPrev(Message prev) {
        this.prev = prev;
    }

    public String getText() {
        return text;
    }

    public Message getNext() {
        return next;
    }

    public Message getPrev() {
        return prev;
    }

    public boolean isEdited() {
        return edited;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return text;
    }
}
