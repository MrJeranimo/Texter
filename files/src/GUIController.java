import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class GUIController {
    // The current JFrame for the Texter application
    private JFrame currFrame;

    // ArrayList of JPanels of Chains in ChainList
    private final ArrayList<JPanel> panels;

    public GUIController(ChainList chats) {
        // Creates the basic values for the JFrame
        currFrame = new JFrame("Texter");
        panels = new ArrayList<>();
        currFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        currFrame.setSize(400, 600);
        loadChainList(chats);
        currFrame.setVisible(true);
    }

    // Loads the ChainList into a list of Chains
    private void loadChainList(ChainList chats) {
        Chain curr = chats.getHead();
        JPanel ChainListPanel = new JPanel();
        ChainListPanel.setLayout(new BoxLayout(ChainListPanel, BoxLayout.Y_AXIS));
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        grid.columnWeights = new double[]{0.0, 1.0, 0.0};
        constraints.insets = new Insets(0, 10, 0, 10);
        constraints.anchor = GridBagConstraints.LINE_START;
        while(curr != null) {
            JPanel panel = new JPanel();  // Creates a panel to hold the name, last chat, and button
            panel.setLayout(grid); // Creates a Layout for the panel
            panel.setMaximumSize(new Dimension(2400, 75)); // Sets a max size for individual chat

            // Creates a label with the name as the text
            JLabel name = new JLabel(curr.getName());
            name.setFont(new Font("Arial", Font.BOLD, 16)); // Makes the name font bold
            panel.add(name, constraints);

            // Creates a label with the last message as the text
            JLabel lastMessage = new JLabel(curr.getRecentMessages(1));
            panel.add(lastMessage, constraints);

            // Creates a button to enter the chat
            JButton enterChat = new JButton("Enter Chat");
            panel.add(enterChat, constraints);

            // Adds the panel to the ArrayList
            panels.add(panel);

            // Adds the panel to the JFrame
            ChainListPanel.add(panel);
            curr = curr.getNext();
        }
        currFrame.add(ChainListPanel);
    }
}
