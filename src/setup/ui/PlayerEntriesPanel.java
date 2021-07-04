package setup.ui;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import game.state.TreeColor;

/**
 * One player entry consists of a player's name, color, and whether or not they
 * are an AI.
 * 
 * @author Aaron Tetens
 */
public class PlayerEntriesPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_NUM_PLAYERS = 4;

	// we always add and remove player entry panels from the bottom of the screen,
	// so a stack is the most logical structure to track the remaining panels
	private final Stack<PlayerEntryPanel> entryPanels;

	public PlayerEntriesPanel() {
		this(DEFAULT_NUM_PLAYERS);
	}

	public PlayerEntriesPanel(final int numInitialPlayers) {
		super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.entryPanels = new Stack<>();
		for (int i = 0; i < numInitialPlayers; i++) {
			this.addPlayerEntryPanel(new PlayerEntryPanel());
		}
	}

	public void setNumPlayers(final int numPlayers) {
		// we need to add panels
		if (numPlayers > this.entryPanels.size()) {
			final int numPanelsToAdd = numPlayers - this.entryPanels.size();

			for (int i = 0; i < numPanelsToAdd; i++) {
				this.addPlayerEntryPanel(new PlayerEntryPanel());
			}
		}
		// we need to remove panels
		else if (numPlayers < this.entryPanels.size()) {
			final int numPanelsToRemove = this.entryPanels.size() - numPlayers;

			for (int i = 0; i < numPanelsToRemove; i++) {
				this.removePlayerEntryPanel(this.entryPanels.peek());
			}
		}
	}

	/**
	 * This method checks for no duplicate or empty names and no duplicate colors.
	 * 
	 * @return A list of error messages regarding invalid configuration. If this
	 *         list is empty, then the configuration is valid.
	 */
	public List<String> validateEntries() {
		final List<String> errorMessages = new ArrayList<>();

		final String[] playerNames = this.getPlayerNames();
		final TreeColor[] treeColors = this.getTreeColors();

		// check empty names
		for (final String playerName : playerNames) {
			if (playerName.isEmpty()) {
				errorMessages.add("Every player must have a name.");
				break;
			}
		}

		// check duplicate names
		final Set<String> seenPlayerNames = new HashSet<>();

		for (final String playerName : playerNames) {
			if (!playerName.isEmpty()) {
				if (seenPlayerNames.contains(playerName)) {
					errorMessages.add("Cannot have duplicate player names.");
					break;
				}

				seenPlayerNames.add(playerName);
			}
		}

		// check duplicate tree colors
		final Set<TreeColor> seenTreeColors = new HashSet<>();

		for (final TreeColor treeColor : treeColors) {
			if (seenTreeColors.contains(treeColor)) {
				errorMessages.add("Cannot have duplicate colors.");
				break;
			}

			seenTreeColors.add(treeColor);
		}

		return errorMessages;
	}

	private String[] getPlayerNames() {
		final String[] playerNames = new String[this.entryPanels.size()];

		int i = 0;
		final Iterator<PlayerEntryPanel> it = this.entryPanels.iterator();

		while (it.hasNext()) {
			playerNames[i] = it.next().getPlayerName();
			i++;
		}

		return playerNames;
	}

	private TreeColor[] getTreeColors() {
		final TreeColor[] treeColors = new TreeColor[this.entryPanels.size()];

		int i = 0;
		final Iterator<PlayerEntryPanel> it = this.entryPanels.iterator();

		while (it.hasNext()) {
			treeColors[i] = it.next().getTreeColor();
			i++;
		}

		return treeColors;
	}

	private void addPlayerEntryPanel(final PlayerEntryPanel panel) {
		this.entryPanels.push(panel);

		SwingUtilities.invokeLater(() -> {
			super.add(panel);
			super.repaint();
			super.revalidate();
		});
	}

	private void removePlayerEntryPanel(final PlayerEntryPanel panel) {
		this.entryPanels.pop();

		SwingUtilities.invokeLater(() -> {
			super.remove(panel);
			super.repaint();
			super.revalidate();
		});
	}

	private class PlayerEntryPanel extends JPanel {

		private static final long serialVersionUID = 1L;
		private static final int NAME_FIELD_NUM_COLUMNS = 20;

		private final JTextField nameField;
		private final JComboBox<TreeColor> colorBox;
		private final JCheckBox aiCheckBox;

		private PlayerEntryPanel() {
			final JLabel nameLabel = new JLabel("Name: ");
			nameLabel.setFont(new Font("Arial", Font.PLAIN, 24));
			super.add(nameLabel);

			this.nameField = new JTextField(NAME_FIELD_NUM_COLUMNS);
			this.nameField.setFont(new Font("Arial", Font.PLAIN, 24));
			this.nameField.setDocument(new JTextFieldLimit(NAME_FIELD_NUM_COLUMNS)); // restrict names to 20 characters
			super.add(this.nameField);

			final JLabel colorLabel = new JLabel("Color: ");
			colorLabel.setFont(new Font("Arial", Font.PLAIN, 24));
			super.add(colorLabel);

			this.colorBox = new JComboBox<>(TreeColor.values());
			this.colorBox.setFont(new Font("Arial", Font.PLAIN, 24));
			super.add(this.colorBox);

			final JLabel aiLabel = new JLabel("Is AI?: ");
			aiLabel.setFont(new Font("Arial", Font.PLAIN, 24));
			super.add(aiLabel);

			this.aiCheckBox = new JCheckBox();
			super.add(this.aiCheckBox);
		}

		private String getPlayerName() {
			return this.nameField.getText().trim();
		}

		private TreeColor getTreeColor() {
			return (TreeColor) this.colorBox.getSelectedItem();
		}
	}

	/**
	 * This class allows us to set a limit on how many characters may be entered
	 * into a JTextField.
	 */
	private class JTextFieldLimit extends PlainDocument {

		private static final long serialVersionUID = 1L;

		private final int limit;

		JTextFieldLimit(final int limit) {
			super();

			this.limit = limit;
		}

		@Override
		public void insertString(final int offset, final String str, final AttributeSet attr)
				throws BadLocationException {
			if (str == null) {
				return;
			}

			if ((getLength() + str.length()) <= this.limit) {
				super.insertString(offset, str, attr);
			}
		}
	}
}
