package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static org.example.ChartScraper.getChartData;

public class ManageScreen extends JPanel
{
    int x = 100 ;
    int y = 20 ;
    private Image backgroundImage;

    private JComboBox<String> yearsComboBox;
    public ManageScreen(int x , int y , int width, int height)
    {
        this.setLayout(null);
        this.setBounds(x+50, y + 40 , width, height);
        backgroundImage = new ImageIcon("src/main/java/org/example/img_3.png").getImage();
        JLabel songLabel = new JLabel("Years options: ");
        songLabel.setForeground(Color.WHITE);
        Font font = songLabel.getFont();
        Font boldFont = new Font(font.getFontName(), Font.BOLD, 12);
        songLabel.setFont(boldFont);
        songLabel.setBounds(x + 200 , y+ 50 , Utils.LABEL_WIDTH, Utils.LABEL_HEIGHT);
        this.add(songLabel);
        this.yearsComboBox = new JComboBox<>(YearScraper.getYears().toArray(new String[0]));
            this.yearsComboBox.setBounds(songLabel.getX() + Utils.LABEL_WIDTH  , songLabel.getY(), Utils.COMBO_BOX_WIDTH, Utils.COMBO_BOX_HEIGHT);
            this.add(this.yearsComboBox);
            this.yearsComboBox.addActionListener((e) -> {

            });
        Button button1 = new Button("Top songs");
        button1.setBounds(Utils.BUTTON_1_X , Utils.BUTTON_1_Y , Utils.BUTTON_WIDTH , Utils.BUTTON_HEIGHT);
        button1.setBackground(Color.PINK);
        this.add(button1);
        button1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
              String selectedItem = (String)yearsComboBox.getSelectedItem();
              String trimmedString = selectedItem.trim().substring(0, selectedItem.length() - 1);
              int year = Integer.parseInt(trimmedString);
              String chartType = "top-100-songs";
              showMessage(PlaybackValue(year , chartType , Utils.SONG_SEARCH ));

            }
        });

        Button button2 = new Button("Top Rock songs");
        button2.setBounds(Utils.BUTTON_2_X , Utils.BUTTON_2_Y , Utils.BUTTON_WIDTH , Utils.BUTTON_HEIGHT);
        button2.setBackground(Color.PINK);
        this.add(button2);
        button2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String selectedItem = (String)yearsComboBox.getSelectedItem();
                String trimmedString = selectedItem.trim().substring(0, selectedItem.length() - 1);
                System.out.println(trimmedString);
                int year = Integer.parseInt(trimmedString);
                System.out.println(year);
                String chartType = "rock";
                if (validYear(Utils.FIRST_YEAR_TOP_ROCK , Utils.LAST_YEAR_TOP_ROCK , year))
                {
                    showMessage(PlaybackValue(year, chartType , Utils.SONG_SEARCH));
                }
                else
                    showMessage(Utils.ERROR_MESSAGE);
                }
        });
        Button button3 = new Button("Top R&B songs");
        button3.setBounds(Utils.BUTTON_3_X , Utils.BUTTON_3_Y ,Utils.BUTTON_WIDTH , Utils.BUTTON_HEIGHT);
        button3.setBackground(Color.PINK);
        this.add(button3);
        button3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String selectedItem = (String)yearsComboBox.getSelectedItem();
                String trimmedString = selectedItem.trim().substring(0, selectedItem.length() - 1);
                System.out.println(trimmedString);
                int year = Integer.parseInt(trimmedString);
                System.out.println(year);
                String chartType = "rnb";
                if (validYear(Utils.FIRST_YEAR_TOP_RNB , Utils.LAST_YEAR_TOP_RNB , year))
                {
                    showMessage(PlaybackValue(year, chartType , Utils.SONG_SEARCH));
                }
                else
                    showMessage(Utils.ERROR_MESSAGE );
            }
        });
        Button button4 = new Button("Top Brazil's songs");
        button4.setBounds(Utils.BUTTON_4_X , Utils.BUTTON_4_Y , Utils.BUTTON_WIDTH , Utils.BUTTON_HEIGHT);
        button4.setBackground(Color.PINK);
        this.add(button4);
        button4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String selectedItem = (String)yearsComboBox.getSelectedItem();
                String trimmedString = selectedItem.trim().substring(0, selectedItem.length() - 1);
                System.out.println(trimmedString);
                int year = Integer.parseInt(trimmedString);
                System.out.println(year);
                String chartType = "brasil";
                if (validYear(Utils.FIRST_YEAR_TOP_BRAZIL , Utils.LAST_YEAR_TOP_BRAZIL , year))
                {
                    showMessage(PlaybackValue(year, chartType , Utils.SONG_SEARCH));
                }
                else
                    showMessage(Utils.ERROR_MESSAGE);
            }
        });
        Button button5 = new Button("Top Country songs");
        button5.setBounds(Utils.BUTTON_5_X , Utils.BUTTON_5_Y , Utils.BUTTON_WIDTH , Utils.BUTTON_HEIGHT);
        button5.setBackground(Color.PINK);
        this.add(button5);
        button5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String selectedItem = (String)yearsComboBox.getSelectedItem();
                String trimmedString = selectedItem.trim().substring(0, selectedItem.length() - 1);
                System.out.println(trimmedString);
                int year = Integer.parseInt(trimmedString);
                System.out.println(year);

                String chartType = "country";
                if (validYear(Utils.FIRST_YEAR_TOP_COUNTRY , Utils.LAST_YEAR_TOP_COUNTRY , year))
                {
                    showMessage(PlaybackValue(year, chartType,Utils.SONG_SEARCH));
                }
                else
                    showMessage(Utils.ERROR_MESSAGE );
            }
        });
        Button button6 = new Button("Top Artists");
        button6.setBounds(Utils.BUTTON_6_X , Utils.BUTTON_6_Y , Utils.BUTTON_WIDTH , Utils.BUTTON_HEIGHT);
        button6.setBackground(Color.PINK);
        this.add(button6);
        button6.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String selectedItem = (String)yearsComboBox.getSelectedItem();
                String trimmedString = selectedItem.trim().substring(0, selectedItem.length() - 1);
                System.out.println(trimmedString);
                int year = Integer.parseInt(trimmedString);
                System.out.println(year);
                String chartType = "top-100-songs";
                showMessage(PlaybackValue(year , chartType , Utils.ARTIST_SEARCH ));
            }
        });
        }
    public void showMessage(String message)
    {
        JOptionPane optionPane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog(null, "Top");
        dialog.setSize(400, 500); // Set the desired width and height
        dialog.setVisible(true);
    }
    public void CustomDialogPanel(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }
    public String PlaybackValue (int year , String chartType , String type)
    {
        StringBuilder instructions = new StringBuilder();
        String instructionsString ;
        List<ChartEntry> chartData = getChartData(year, chartType);
        if (type.equals(Utils.SONG_SEARCH))
        {
         for (int i = 0; i < 10; i++)
         {
            ChartEntry entry = chartData.get(i);
            String line = entry.getRank() + ": " + entry.getTitle() + "\n";
            instructions.append(line);
         }

        }
        else
        {
            for (int i = 0; i < 10; i++)
            {
                ChartEntry entry = chartData.get(i);
                String line = entry.getRank() + ": " + entry.getArtist() + "\n";
                instructions.append(line);
            }

        }
        instructionsString = instructions.toString();
        return instructionsString;
    }
    public boolean validYear (int firstYear , int lastYear , int chosenYear )
    {
        boolean result = false ;
        if( (chosenYear >= firstYear) && (chosenYear <= lastYear))
            result = true ;

        return result ;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, Utils.WIDTH, Utils.HEIGHT, this);
    }

}


