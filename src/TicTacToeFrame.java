import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.File;

public class TicTacToeFrame extends JFrame {
    private TicTacToe game;
    private JButton[] buttons;
    private boolean isXTurn;
    private JLabel turnLabel;

    public TicTacToeFrame() {
        game = new TicTacToe();
        buttons = new JButton[9];
        isXTurn = true;
        setLayout(new BorderLayout());

        // Create the game board panel with GridLayout
        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        boardPanel.setBackground(Color.BLACK); // Set the background color of the grid to black
        initializeButtons(boardPanel);

        // Create a label for displaying current player's turn
        turnLabel = new JLabel("Turn: X", SwingConstants.LEFT);
        turnLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        turnLabel.setForeground(Color.BLACK);

        // Add the board panel and the turn label to the frame
        add(boardPanel, BorderLayout.CENTER);
        add(turnLabel, BorderLayout.SOUTH);

        // Set frame properties
        setTitle("Tic-Tac-Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    private void initializeButtons(JPanel boardPanel) {
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 60));
            buttons[i].setFocusPainted(false);
            buttons[i].setBackground(Color.BLACK); // Button background is black
            buttons[i].addActionListener(new ButtonClickListener(i));
            boardPanel.add(buttons[i]);
        }
    }

    private class ButtonClickListener implements ActionListener {
        private final int index;

        ButtonClickListener(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (game.getCell(index) != ' ' || game.isGameOver()) return;

            // Set the mark (X or O)
            game.setCell(index, isXTurn ? 'X' : 'O');
            buttons[index].setText(String.valueOf(isXTurn ? 'X' : 'O'));
            buttons[index].setForeground(isXTurn ? Color.RED : Color.GREEN);

            // Play the enter sound
            playSound("click.wav");

            // Update the turn label
            turnLabel.setText("Turn: " + (isXTurn ? "O" : "X"));

            // Check for a winner
            if (game.checkWin()) {
                // Play the win sound
                playSound("winning.wav");

                // Show the winner
                JOptionPane.showMessageDialog(TicTacToeFrame.this, (isXTurn ? "X" : "O") + " wins!");
                game.reset();
                resetBoard();
                turnLabel.setText("Turn: X");
            }

            isXTurn = !isXTurn;
        }
    }

    private void resetBoard() {
        for (JButton button : buttons) {
            button.setText("");
            button.setForeground(Color.BLACK);
        }
    }

    private void playSound(String soundFileName) {
        try {
            File soundFile = new File(soundFileName); // Ensure the file is in the same folder
            if (!soundFile.exists()) {
                System.out.println("Sound file not found: " + soundFileName);
                return;
            }
            Clip clip = AudioSystem.getClip(); // Create the Clip object
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile); // Load audio file
            clip.open(audioIn);
            clip.start(); // Play the sound
        } catch (Exception e) {
            System.out.println("Error playing sound: " + e.getMessage());
        }
    }
}
