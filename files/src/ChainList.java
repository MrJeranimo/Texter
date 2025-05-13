import java.util.ArrayList;

public class ChainList {
    // First Chain in the chat list after the pinned chains
    private Chain head;
    // List of pinned chains, before the head chain
    private final ArrayList<Chain> pinned;

    public ChainList() {
        head = null;
        pinned = new ArrayList<>();
    }

    // Adds a Chain to the head of the ChainList
    public void add(Chain newChain) {
        if(head == null) {
            head = newChain;
            return;
        }
        newChain.setNext(head);
        head.setPrev(newChain);
        head = newChain;
    }

    // Removes a chain by removing all references to the Chain
    public boolean removeChain(int id) {
        Chain target = findChain(id);
        if(target != null) {
            Chain prev = target.getPrev();
            Chain next = target.getNext();
            prev.setNext(next);
            next.setPrev(prev);
            return true;
        }
        return false;
    }

    // Pins a Chain by adding it to the end of the pinned ArrayList
    public boolean pin(Chain pinChain) {
        boolean success = removeChain(pinChain.getID());
        if(success) {
            pinChain.setNext(null);
            pinChain.setPrev(null);
            pinned.add(pinChain);
            return true;
        }
        return false;
    }

    public void setHead(Chain newHead) {
        head = newHead;
    }

    public Chain getHead() {
        return head;
    }

    public ArrayList<Chain> getPinned() {
        return pinned;
    }

    @Override
    public String toString() {
        String all = "";
        for(Chain curr: pinned) {
            all += curr.toString() + ", ";
        }
        Chain curr = head;
        while(curr != null) {
            all += curr.toString() + ", ";
            curr = curr.getNext();
        }
        return all;
    }

    // Finds the Chain based on it number
    public Chain findChain(int id) {
        for (Chain curr : pinned) {
            if (curr.getID() == id) {
                return curr;
            }
        }
        Chain curr = head;
        while(curr != null) {
            if(curr.getID() == id) {
                return curr;
            }
            curr = curr.getNext();
        }
        return null;
    }
}
