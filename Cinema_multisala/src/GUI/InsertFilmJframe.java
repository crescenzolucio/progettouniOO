package GUI;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.Controller;
import Entity.Actor;
import Entity.Director;
import Entity.Film;
import Entity.Genre;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.imageio.ImageIO;

public class InsertFilmJframe extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	private JPanel contentPane;
	private JTextField textFieldtitle;
	private JTextField textFieldDuration;
	private JTextField textFieldURL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertFilmJframe frame = new InsertFilmJframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InsertFilmJframe() {
		Controller controller =  new Controller();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	    setSize(730, 380);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TodayProjectionsJframe.class.getResource("/Images/logo.png")));
		setTitle("Insert Film");
		setLocationRelativeTo(null);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FilmsJframe filmsjf = new FilmsJframe();
				filmsjf.setVisible(true);
				dispose();
			}
		});

		textFieldtitle = new JTextField();
		textFieldtitle.setBounds(242, 56, 292, 20);
		contentPane.add(textFieldtitle);
		textFieldtitle.setColumns(10);
		
		JLabel lblTilte = new JLabel("Title");
		lblTilte.setBounds(186, 59, 46, 14);
		contentPane.add(lblTilte);
		
		JLabel lblActors = new JLabel("Actors");
		lblActors.setBounds(104, 193, 77, 14);
		contentPane.add(lblActors);
		
		JLabel lblProducer = new JLabel("Producer");
		lblProducer.setBounds(396, 197, 77, 14);
		contentPane.add(lblProducer);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(396, 111, 89, 14);
		contentPane.add(lblYear);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setBounds(396, 157, 89, 14);
		contentPane.add(lblDuration);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FilmsJframe filmsjf = new FilmsJframe();
				filmsjf.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(396, 263, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblInvalidDuration = new JLabel("");
		lblInvalidDuration.setForeground(Color.RED);
		lblInvalidDuration.setBounds(492, 256, 181, 14);
		contentPane.add(lblInvalidDuration);
		
		textFieldDuration = new JTextField();
		textFieldDuration.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Integer.parseInt(textFieldDuration.getText());
					lblInvalidDuration.setText("");
				}catch (Exception e1) {
					lblInvalidDuration.setText("Invalid number!");
				}
			}
		});
		textFieldDuration.setColumns(10);
		textFieldDuration.setBounds(491, 154, 86, 20);
		contentPane.add(textFieldDuration);
		
		JLabel lblInvalidNumber = new JLabel("");
		lblInvalidNumber.setForeground(Color.RED);
		lblInvalidNumber.setBounds(492, 172, 181, 14);
		
		contentPane.add(lblInvalidNumber);
		
		JTextField textFieldYear = new JTextField();
		textFieldYear.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					Integer.parseInt(textFieldYear.getText());
					lblInvalidNumber.setText("");
				}catch (Exception e1) {
					lblInvalidNumber.setText("Invalid number!");
				}
			}
		});
		textFieldYear.setBounds(491, 106, 86, 20);
		contentPane.add(textFieldYear);
		
		JComboBox<String> comboBoxDirector = new JComboBox(controller.findDirectors().toArray());
		comboBoxDirector.setBounds(492, 193, 143, 22);
		comboBoxDirector.setEditable(false);
		contentPane.add(comboBoxDirector);
		

		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(103, 112, 77, 14);
		contentPane.add(lblGenre);

		JScrollPane scrollPaneGenres = new JScrollPane();
		scrollPaneGenres.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneGenres.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneGenres.setBounds(186, 111, 150, 58);
		
		
		JScrollPane scrollPaneActors = new JScrollPane();
		scrollPaneActors.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneActors.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneActors.setBounds(186, 193, 150, 58);
		
		
		JList listGenres = new JList(controller.getGenres().toArray());
		listGenres.setVisibleRowCount(3);
		listGenres.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listGenres.setVisible(true);
		scrollPaneGenres.add(listGenres);
		scrollPaneGenres.setViewportView(listGenres);

		JList listActors = new JList(controller.findActors().toArray());
		listActors.setVisibleRowCount(3);
		listActors.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPaneActors.add(listActors);
		scrollPaneActors.setViewportView(listActors);
		
		contentPane.add(scrollPaneGenres);
		contentPane.add(scrollPaneActors);
		
		
		JLabel lblURL = new JLabel("URL Poster");
		lblURL.setBounds(396, 232, 77, 14);
		contentPane.add(lblURL);
		
		textFieldURL = new JTextField();
		textFieldURL.setColumns(10);
		textFieldURL.setBounds(492, 231, 86, 20);
		contentPane.add(textFieldURL);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldYear.getText().equals("") && !textFieldDuration.getText().equals("")  && !textFieldtitle.getText().equals("") 
						&& lblInvalidNumber.getText().equals("") && lblInvalidDuration.getText().equals("") && listGenres.getSelectedIndices().length>0 && listActors.getSelectedIndices().length>0 && checkUrl(textFieldURL.getText())) {
					Film film = new Film();
					film.setYear_production(Integer.parseInt(textFieldYear.getText()));
					film.setMinutes(Integer.parseInt(textFieldDuration.getText()));
					
					Object itemDirector = comboBoxDirector.getSelectedItem();
					film.setId_director(((Director)itemDirector).getId_director());
					
					LinkedList<Integer> genresselected = new LinkedList<>();
					LinkedList<Integer> actorsselected = new LinkedList<>();
					//Genres selected
					int[] listindices = listGenres.getSelectedIndices();
					for (Integer index : listindices) {
						Genre item = (Genre)listGenres.getModel().getElementAt(index);
						genresselected.add(item.getIdgenre());
					}
					film.setGenres(genresselected);
					
					//Actors selected
					listindices = listActors.getSelectedIndices();
					for (Integer index : listindices) {
						Actor item = (Actor)listActors.getModel().getElementAt(index);
						actorsselected.add(item.getIdactor());
					}
					film.setActors(actorsselected);
					
					film.setUrl_poster(textFieldURL.getText());
					film.setTitle(textFieldtitle.getText());
					if(controller.insertFilm(film)) {
							JOptionPane.showMessageDialog(null, "Film created!");
							textFieldYear.setText(""); textFieldYear.setText(""); textFieldDuration.setText(""); textFieldtitle.setText("");
							listGenres.clearSelection(); comboBoxDirector.setSelectedIndex(0); listActors.clearSelection();
					}
				}else JOptionPane.showMessageDialog(null, "Enter all parameters correctly!");
			}
		});
		btnInsert.setBounds(186, 263, 89, 23);
		contentPane.add(btnInsert);
	}
	public boolean checkUrl(String url) {
        BufferedImage image;
		try {
			image = ImageIO.read(new URL(textFieldURL.getText()));
			if (image != null) { 
				JOptionPane.showMessageDialog(null, "URL image valid!");
			} else 	{
				JOptionPane.showMessageDialog(null, "URL image not valid!");
				return false;
			}
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Image  not valid!");
			return false;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Image not valid!");
			return false;
		}  
		return true;
	}
}
