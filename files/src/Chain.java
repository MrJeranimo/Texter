public class Chain {
    // Next Chain in ChainList
    private Chain next;

    // Previous Chain in ChainList
    private Chain prev;

    // Id of Chain
    private final int ID;

    private final String name;

    // Boolean for if the Chain has received a new message
    private boolean updatedSinceLastSeen;

    // Latest Message sent in Chain
    private Message head;

    private final ChainList chainList;

    public Chain(int id, String name, Message message, ChainList chainList) {
        next = null;
        ID = id;
        prev = null;
        updatedSinceLastSeen = true;
        head = message;
        this.name = name;
        this.chainList = chainList;
    }

    public void setNext(Chain next) {
        this.next = next;
    }

    public void setPrev(Chain prev) {
        this.prev = prev;
    }

    public void newMessage(Message newMessage) {
        newMessage.setNext(head);
        head.setPrev(newMessage);
        head = newMessage;
        updatedSinceLastSeen = true;
        if(prev != null) {
            prev.setNext(next);
        }
        if(next != null) {
            next.setPrev(prev);
        }
        Chain chainListHead = chainList.getHead();
        chainListHead.setPrev(this);
        next = chainListHead;
        prev = null;
        chainList.setHead(this);
    }

    public Chain getNext() {
        return next;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        if(updatedSinceLastSeen) {
            return "* " + name;
        } else {
            return name;
        }
    }

    public Chain getPrev() {
        return prev;
    }

    public boolean getUpdatedSinceLastSeen() {
        return updatedSinceLastSeen;
    }

    public Message getHead() {
        return head;
    }

    public String getRecentMessages(int amount) {
        Message curr = head;
        String messages = "";
        for(int i = 0; i < amount; i++) {
            if(curr != null) {
                messages += curr.getText() + "\n";
                curr = curr.getNext();
            }
        }
        return messages;
    }

    @Override
    public String toString() {
        if(updatedSinceLastSeen) {
            return "*" + ID;
        }
        return "" + ID;
    }

    private Message findMessage(int id) {
        Message curr = head;
        while(curr != null) {
            if(id == curr.getID()) {
                return curr;
            }
            curr = curr.getNext();
        }
        return null;
    }
}
