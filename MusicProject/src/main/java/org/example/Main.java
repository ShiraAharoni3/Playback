package org.example;
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    public static void main(String[] args)
    {
       new Main();

    }

    public Main()
    {
        this.setTitle("Music Playback");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        // Get the size of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Set the frame dimensions to match the screen size
        this.setSize(screenSize.width, screenSize.height);

        this.add(new ManageScreen(0, 0, screenSize.width, screenSize.height));
        this.setVisible(true);

    }
}



