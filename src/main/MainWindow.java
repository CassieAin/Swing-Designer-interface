package main;

import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.ScrollPane;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JMenu;
import javax.swing.ScrollPaneConstants;


public class MainWindow {

	private JFrame frame;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private File setFile;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		frame.getContentPane().add(panel, BorderLayout.WEST);
		panel.setBorder(BorderFactory.createTitledBorder("Text from a file"));
		
		
		
		textArea = new JTextArea();
		panel.add(textArea);
		textArea.setColumns(12);
		/*
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane);*/
		
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.EAST);
		panel_1.setBorder(BorderFactory.createTitledBorder("Text after changing"));
		/*
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane_1);*/
		
		textArea_1 = new JTextArea();
		textArea_1.setColumns(12);
		panel_1.add(textArea_1);
		//final JScrollPane pane = new JScrollPane(textArea_1);
		//
        //pane.setPreferredSize(new Dimension(250, 250));
        
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setBorder(BorderFactory.createTitledBorder("		Choose action"));
		panel_2.setLayout(new MigLayout("", "[51px][][][][][][][][]", "[23px][][][][]"));
		
		
		JButton button = new JButton("Edit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] lines = textArea.getText().split("\\.");
				Arrays.sort(lines, new Comparator<String>(){
					@Override
				    public int compare(String o1, String o2) {
				        return new Integer(o1.length()).compareTo(o2.length());
				   }
				});
				for(String s: lines){
					textArea_1.append(s);
				}
			}
		});
		panel_2.add(button, "cell 4 1");
		
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				textArea_1.setText("");
			}
		});
		panel_2.add(btnNewButton, "cell 4 3");
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		String cwd = System.getProperty("user.dir");
        final JFileChooser jfc = new JFileChooser(cwd);
        
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jfc.showOpenDialog(frame) !=
                        JFileChooser.APPROVE_OPTION)
                            return;
                    File f = jfc.getSelectedFile();
                    // record the current time and read the file
                   // final long s_time = System.currentTimeMillis();
                    //frame.setCursor(Cursor.getPredefinedCursor(
                      //  Cursor.WAIT_CURSOR));
                    try {
                        FileReader fr = new FileReader(f.toString());
                        textArea.read(fr, null);
                        fr.close();
                    }
                    catch (IOException e) {
                        System.err.println(e);
                    }   
			}
		});
		mnFile.add(mntmOpen);
		
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser(new File("C:\\Users\\user\\Desktop\\”ÕI¬≈–\\LABS\\ÕÓ‚‡ˇ Ô‡ÔÍ‡\\SC_In"));
				//FileFilter filter = new FileNameExtensionFilter(".txt", "Text file");
				//fileChooser.addChoosableFileFilter(filter);
	            int userSelection = fileChooser.showSaveDialog(null);
	            
	            if(userSelection == JFileChooser.APPROVE_OPTION){
	            	try { 
	            			FileWriter fileWriter = null; 

	            			fileWriter = new FileWriter(fileChooser.getSelectedFile()); 
	            			fileWriter.write(textArea_1.getText()); 
	            			fileWriter.write("\n"); 
	            			fileWriter.close(); 
	            		} catch (IOException ex) { 
	            			ex.printStackTrace(); 
	            		}
	            }
			}
		});  
		mnFile.add(mntmSave);
		
		
		JMenuItem mntmSaveAs = new JMenuItem("Save as..");
		mntmSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser(new File("C:\\"));
	            int userSelection = fileChooser.showSaveDialog(null);
	            
	            if(userSelection == JFileChooser.APPROVE_OPTION){
	            	try { 
	            			FileWriter fileWriter = null;
	            			fileWriter = new FileWriter(fileChooser.getSelectedFile()); 
	            			fileWriter.write(textArea_1.getText()); 
	            			fileWriter.write("\n"); 
	            			fileWriter.close(); 
	            		} catch (IOException ex) { 
	            			ex.printStackTrace(); 
	            		}
	            }
			}
		});
		mnFile.add(mntmSaveAs);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new exitApp());
		mnFile.add(mntmExit);
		
	}
	class exitApp implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
	
}
