package Java_Swings;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Notepad extends JFrame {
    public void displayContent(String filePath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String s1 = "", s2 = "";
            while ((s1 = br.readLine()) != null) {
                s2 = s1 + "\n";
            }
            ta.setText(s2);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openFile() {
        JFileChooser fc = new JFileChooser();
        int i = fc.showOpenDialog(this);
        if (i == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            String filePath = f.getPath();
            displayContent(filePath);
        }
    }

    // JFrame f;
    JMenuBar mb;
    JMenu file, edit, help;
    JMenuItem cut, copy, paste, selectAll, open;
    JTextArea ta;

    public Notepad() {
        // f=new JFrame();
        mb = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");
        open = new JMenuItem("Open File");
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("Select All");
        ta = new JTextArea();
        mb.add(file);
        mb.add(edit);
        mb.add(help);
        file.add(open);
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        add(mb);
        add(ta);
        open.addActionListener(oe -> {
            openFile();
        });
        cut.addActionListener(xe -> {
            ta.cut();
        });
        copy.addActionListener(ce -> {
            ta.copy();
        });
        paste.addActionListener(ve -> {
            ta.paste();
        });
        selectAll.addActionListener(ae -> {
            ta.selectAll();
        });
        ta.setBounds(5, 30, 460, 460);
        mb.setBounds(5, 5, 500, 25);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setBackground(Color.BLACK);
    }

    public static void main(String args[]) {
        new Notepad();
    }
}
