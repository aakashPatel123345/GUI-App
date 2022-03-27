import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.border.*;
import java.util.Arrays;

public class GraphicalUserInterface implements ActionListener {

    JFrame frame;
    JButton north, east, south, west, reset;
    JPanel buttonPanel, bigPanel;
    JMenuBar menuBar;
    GridLayout buttonLayout, panelLayout, menuLayout;
    JMenu chooseFont, chooseFontSize, chooseTextColor, chooseBackground, chooseOutline;
    JMenuItem [] fontOptions, fontSizes, textColors, textBackgrounds, buttonOutlines;
    String [] fontNames, backgroundNames, textNames, outlineNames;
    JTextArea textArea;
    Font font;
    Font [] fontArray;
    Border defaultBorder;
    int currentFontSize;
    Color [] textColorArr, outlineColorArr, backgroundColorArr;
    Color darkGreen,pinkishOrange, navy,turquoise, defaultTextColor,defaultBackground;
    int [] fontSizesArray;




    public GraphicalUserInterface() {
        frame = new JFrame("Graphical User Interface");
        frame.setSize(1200,800);
        frame.setLayout(new BorderLayout());

        menuBar = new JMenuBar();

        menuBar.setLayout(new GridLayout(1,5));

        chooseFont = new JMenu("Font");
        chooseFontSize = new JMenu("Font Size");
        chooseBackground = new JMenu("Background");
        chooseOutline = new JMenu("Outline");
        chooseTextColor = new JMenu("Text Color");

        fontOptions = new JMenuItem[5];
        fontSizes = new JMenuItem[5];
        textColors = new JMenuItem[5];
        textBackgrounds = new JMenuItem[5];
        buttonOutlines = new JMenuItem[5];


        menuLayout = new GridLayout(5,1);

        menuBar.add(chooseFont);
        menuBar.add(chooseFontSize);
        menuBar.add(chooseBackground);
        menuBar.add(chooseOutline);
        menuBar.add(chooseTextColor);

        fontNames = new String[]{"Times New Roman", "Serif", "Monospace", "Arial", "Sans Serif"};
        fontSizesArray = new int []{18,20,22,24,30};
        fontArray = new Font[fontNames.length];
        for(int i=0 ; i<fontNames.length ; i++) {
            fontArray[i] = new Font(fontNames[i],Font.PLAIN,fontSizesArray[0]);
            fontOptions[i] = new JMenuItem(fontNames[i]);      //Will show our choices as the strings we put inside our fontNamesArr
            fontOptions[i].setFont(fontArray[i]);
            fontOptions[i].addActionListener(this);
            chooseFont.add(fontOptions[i]);
        }
        font = fontArray[0];



        fontSizesArray = new int []{18,20,22,24,30};
        for(int i=0 ; i<fontSizesArray.length ; i++) {
            fontSizes[i] = new JMenuItem(Integer.toString(fontSizesArray[i]));
            fontSizes[i].addActionListener(this);
            chooseFontSize.add(fontSizes[i]);
        }
        currentFontSize = fontSizesArray[0];


        textNames = new String [] {"Black","Red","Blue","Turquoise","Orange"};
        turquoise = new Color(0,209,206);
        textColorArr = new Color [] {Color.BLACK,Color.RED, turquoise, Color.MAGENTA, Color.orange};
        for(int i=0 ; i<textColorArr.length ; i++) {
            textColors[i] = new JMenuItem(textNames[i]);
            textColors[i].setForeground(textColorArr[i]);
            textColors[i].addActionListener(this);
            chooseTextColor.add(textColors[i]);
        }
        defaultTextColor = textColorArr[0];

        backgroundNames = new String [] {"White","Black","Navy","Dark Green","Peach"};
        darkGreen = new Color(0,90,0);
        pinkishOrange = new Color(224,124,110);
        navy = new Color(2,7,93);
        backgroundColorArr = new Color[]{Color.WHITE,Color.BLACK,navy,darkGreen,pinkishOrange};
        for(int i=0 ; i<backgroundColorArr.length ; i++) {
            textBackgrounds[i] = new JMenuItem(backgroundNames[i]);
            textBackgrounds[i].setBackground(backgroundColorArr[i]);
            textBackgrounds[i].addActionListener(this);
            chooseBackground.add(textBackgrounds[i]);
            if(i==1 || i==2) {
                textBackgrounds[i].setForeground(Color.WHITE);
            }
        }
        defaultBackground = backgroundColorArr[0];



        outlineNames = new String [] {"Black","Blue","Red","Dark Green","Peach"};
        darkGreen = new Color(0,90,0);
        pinkishOrange = new Color(224,124,110);
        outlineColorArr = new Color[]{Color.BLACK,Color.BLUE,Color.RED,darkGreen,pinkishOrange};
        for(int i=0 ; i<outlineColorArr.length ; i++) {
            buttonOutlines[i] = new JMenuItem(outlineNames[i]);
            buttonOutlines[i].setBackground(outlineColorArr[i]);
            buttonOutlines[i].addActionListener(this);
            chooseOutline.add(buttonOutlines[i]);
            if(i==0)
                buttonOutlines[i].setForeground(Color.white);
        }
        defaultBorder = new LineBorder(outlineColorArr[0]);


        reset = new JButton("Reset");
        reset.addActionListener(this);
        reset.setBorder(defaultBorder);
        menuBar.add(reset);

        north = new JButton("North");
        north.addActionListener(this);
        east = new JButton("East");
        east.addActionListener(this);
        south = new JButton("South");
        south.addActionListener(this);
        west = new JButton("West");
        west.addActionListener(this);

        north.setBorder(defaultBorder);
        east.setBorder(defaultBorder);
        south.setBorder(defaultBorder);
        west.setBorder(defaultBorder);


        // north.setBorder();        //go to 15:20 to figure this out

        buttonPanel = new JPanel();
        buttonLayout = new GridLayout(1,4);
        buttonPanel.setLayout(buttonLayout);
        buttonPanel.add(north);
        buttonPanel.add(south);
        buttonPanel.add(east);
        buttonPanel.add(west);

        textArea = new JTextArea();
        textArea.setBackground(defaultBackground);
        textArea.setForeground(defaultTextColor);
        textArea.setFont(font);


        panelLayout = new GridLayout(1,2);
        bigPanel = new JPanel();
        bigPanel.setLayout(panelLayout);
        bigPanel.add(buttonPanel);
        bigPanel.add(menuBar);

        frame.add(bigPanel,BorderLayout.NORTH);
        frame.add(textArea,BorderLayout.CENTER);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==north) {
            frame.remove(bigPanel);
            buttonLayout = new GridLayout(1,4);
            panelLayout = new GridLayout(1,2);
            buttonPanel.setLayout(buttonLayout);
            bigPanel.setLayout(panelLayout);
            bigPanel.remove(buttonPanel);
            bigPanel.remove(menuBar);
            bigPanel.add(buttonPanel);
            //menuLayout = new GridLayout(1,6);]
            menuBar.setLayout(new GridLayout(1,6));
            menuBar.remove(chooseFont);
            menuBar.remove(chooseFontSize);
            menuBar.remove(chooseBackground);
            menuBar.remove(chooseOutline);
            menuBar.remove(chooseTextColor);
            menuBar.remove(reset);

            menuBar.add(chooseFont);
            menuBar.add(chooseFontSize);
            menuBar.add(chooseBackground);
            menuBar.add(chooseOutline);
            menuBar.add(chooseTextColor);
            menuBar.add(reset);

            bigPanel.add(menuBar);
            frame.add(bigPanel,BorderLayout.NORTH);
        }
        if(e.getSource()==east) {
            frame.remove(bigPanel);
            buttonLayout = new GridLayout(4,1);
            panelLayout = new GridLayout(2,1);
            buttonPanel.setLayout(buttonLayout);
            bigPanel.setLayout(panelLayout);
            bigPanel.remove(buttonPanel);
            bigPanel.remove(menuBar);
            bigPanel.add(buttonPanel);
            menuBar.setLayout(new GridLayout(6,1));
            menuBar.remove(chooseFont);
            menuBar.remove(chooseFontSize);
            menuBar.remove(chooseBackground);
            menuBar.remove(chooseOutline);
            menuBar.remove(chooseTextColor);
            menuBar.remove(reset);

            menuBar.add(chooseFont);
            menuBar.add(chooseFontSize);
            menuBar.add(chooseBackground);
            menuBar.add(chooseOutline);
            menuBar.add(chooseTextColor);
            menuBar.add(reset);

            bigPanel.add(menuBar);
            frame.add(bigPanel,BorderLayout.EAST);
        }
        if(e.getSource()==south) {
            frame.remove(bigPanel);
            buttonLayout = new GridLayout(1,4);
            panelLayout = new GridLayout(1,2);
            buttonPanel.setLayout(buttonLayout);
            bigPanel.setLayout(panelLayout);
            bigPanel.remove(buttonPanel);
            bigPanel.remove(menuBar);
            bigPanel.add(buttonPanel);
            //menuLayout = new GridLayout(1,6);]
            menuBar.setLayout(new GridLayout(1,6));
            menuBar.remove(chooseFont);
            menuBar.remove(chooseFontSize);
            menuBar.remove(chooseBackground);
            menuBar.remove(chooseOutline);
            menuBar.remove(chooseTextColor);
            menuBar.remove(reset);

            menuBar.add(chooseFont);
            menuBar.add(chooseFontSize);
            menuBar.add(chooseBackground);
            menuBar.add(chooseOutline);
            menuBar.add(chooseTextColor);
            menuBar.add(reset);

            bigPanel.add(menuBar);
            frame.add(bigPanel,BorderLayout.SOUTH);
        }
        if(e.getSource()==west) {
            frame.remove(bigPanel);
            buttonLayout = new GridLayout(4,1);
            panelLayout = new GridLayout(2,1);
            buttonPanel.setLayout(buttonLayout);
            bigPanel.setLayout(panelLayout);
            bigPanel.remove(buttonPanel);
            bigPanel.remove(menuBar);
            bigPanel.add(buttonPanel);
            menuBar.setLayout(new GridLayout(6,1));
            menuBar.remove(chooseFont);
            menuBar.remove(chooseFontSize);
            menuBar.remove(chooseBackground);
            menuBar.remove(chooseOutline);
            menuBar.remove(chooseTextColor);
            menuBar.remove(reset);

            menuBar.add(chooseFont);
            menuBar.add(chooseFontSize);
            menuBar.add(chooseBackground);
            menuBar.add(chooseOutline);
            menuBar.add(chooseTextColor);
            menuBar.add(reset);

            bigPanel.add(menuBar);
            frame.add(bigPanel,BorderLayout.WEST);
        }

        //changing the actual font
        for(int i=0 ; i< fontOptions.length ; i++) {
            if(e.getSource() == fontOptions[i]) {
                font = new Font(fontArray[i].getName(), Font.PLAIN, currentFontSize);
                textArea.setFont(font);
                System.out.println("Why doesn't this work: "+currentFontSize);
                frame.revalidate();
            }
        }
        //changing font size
        for(int i=0 ; i< fontSizes.length ; i++) {
            if(e.getSource() == fontSizes[i]) {
                currentFontSize = fontSizesArray[i];
                font = new Font(font.getName(), Font.PLAIN, currentFontSize);
                textArea.setFont(font);
            }
        }
        //changing background color
        for(int i=0 ; i<textBackgrounds.length ; i++) {
            if(e.getSource() == textBackgrounds[i]) {
                textArea.setBackground(backgroundColorArr[i]);
            }
        }
        //changing outline color
        for(int i=0 ; i< buttonOutlines.length ; i++) {
            if(e.getSource()==buttonOutlines[i]) {
                north.setBorder(new LineBorder(outlineColorArr[i]));
                east.setBorder(new LineBorder(outlineColorArr[i]));
                south.setBorder(new LineBorder(outlineColorArr[i]));
                west.setBorder(new LineBorder(outlineColorArr[i]));
                reset.setBorder(new LineBorder(outlineColorArr[i]));

            }
        }
        //changing text color
        for(int i=0 ; i<textColors.length ; i++) {
            if(e.getSource() == textColors[i]) {
                textArea.setForeground(textColorArr[i]);
            }
        }
        if(e.getSource()==reset) {
            frame.remove(bigPanel);
            buttonLayout = new GridLayout(1,4);
            panelLayout = new GridLayout(1,2);
            buttonPanel.setLayout(buttonLayout);
            bigPanel.setLayout(panelLayout);
            bigPanel.remove(buttonPanel);
            bigPanel.remove(menuBar);
            bigPanel.add(buttonPanel);
            //menuLayout = new GridLayout(1,6);]
            menuBar.setLayout(new GridLayout(1,6));
            menuBar.remove(chooseFont);
            menuBar.remove(chooseFontSize);
            menuBar.remove(chooseBackground);
            menuBar.remove(chooseOutline);
            menuBar.remove(chooseTextColor);
            menuBar.remove(reset);

            menuBar.add(chooseFont);
            menuBar.add(chooseFontSize);
            menuBar.add(chooseBackground);
            menuBar.add(chooseOutline);
            menuBar.add(chooseTextColor);
            menuBar.add(reset);

            bigPanel.add(menuBar);
            frame.add(bigPanel,BorderLayout.NORTH);

            reset.setBorder(defaultBorder);
            north.setBorder(defaultBorder);
            east.setBorder(defaultBorder);
            south.setBorder(defaultBorder);
            west.setBorder(defaultBorder);

            font = new Font(fontArray[0].getName(), Font.PLAIN, fontSizesArray[0]);
            textArea.setBackground(defaultBackground);
            textArea.setForeground(defaultTextColor);
            textArea.setFont(font);
            textArea.setText("");


        }
        frame.revalidate();
    }

    public static void main(String[]args) {
        GraphicalUserInterface app = new GraphicalUserInterface();
    }
}
