package GUI;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.Controller;
import Entity.Film;

import javax.swing.JLabel;

public class InfoFilmJframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InfoFilmJframe(Integer idfilm) {
		Controller controller = new Controller();
	    Film film = controller.getFilm(idfilm);
	    String actors="",genres="";
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginJframe.class.getResource("/Images/logo.png")));
		setTitle("Film info");
		setBounds(100, 100, 360, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
    	//Actors
    	for(Integer idactor : controller.getFilm(idfilm).getActors()) {
    		actors += controller.getActor(idactor).getName()+" ";
    	}
    	
    	//Genres
    	for(Integer idgenre : controller.getFilm(idfilm).getGenres()) {
    		genres += controller.getGenre(idgenre).getGenre()+" ";
    	}

		JLabel lblTitleInfo = new JLabel("");
		lblTitleInfo.setBounds(89, 258, 245, 14);
		lblTitleInfo.setText(film.getTitolo());
		contentPane.add(lblTitleInfo);
		
		JLabel lblGenres = new JLabel("Genres");
		lblGenres.setBounds(21, 286, 46, 14);
		contentPane.add(lblGenres);
		
		JLabel lblProducer = new JLabel("Producer");
		lblProducer.setBounds(21, 311, 58, 14);
		contentPane.add(lblProducer);
		
		JLabel lblActors = new JLabel("Actors");
		lblActors.setBounds(21, 336, 46, 14);
		contentPane.add(lblActors);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setBounds(21, 361, 46, 14);
		contentPane.add(lblMinutes);
		
		//Poster film
    	URL url;
    	Image image = null;
		try {
			if(!film.getUrl_poster().equals("")) {
				url = new URL(film.getUrl_poster());
				image = ImageIO.read(url);
			}else {
				image = Toolkit.getDefaultToolkit().getImage(LoginJframe.class.getResource("/Images/no-image.png"));
			}
		} catch (IOException e) {
			image = Toolkit.getDefaultToolkit().getImage(LoginJframe.class.getResource("/Images/no-image.png"));
		}
		
		JLabel lblImage = new JLabel(new ImageIcon(image.getScaledInstance(280, 229, DO_NOTHING_ON_CLOSE)));
		lblImage.setBounds(10, 11, 324, 229);
		contentPane.add(lblImage);
		
		JLabel lblGenresInfo = new JLabel("");
		lblGenresInfo.setBounds(89, 286, 245, 14);
		lblGenresInfo.setText(genres);
		contentPane.add(lblGenresInfo);
		
		JLabel lblProducerInfo = new JLabel("");
		lblProducerInfo.setBounds(89, 311, 245, 14);
		lblProducerInfo.setText(film.getRegistaname());
		contentPane.add(lblProducerInfo);
		
		JLabel lblActorsInfo = new JLabel("");
		lblActorsInfo.setBounds(89, 336, 245, 14);
		lblActorsInfo.setText(actors);
		contentPane.add(lblActorsInfo);
		
		JLabel lblMinutesInfo = new JLabel("");
		lblMinutesInfo.setBounds(89, 361, 245, 14);
		lblMinutesInfo.setText(film.getDurata_minuti().toString());
		contentPane.add(lblMinutesInfo);
		
		JLabel lblTilte = new JLabel("Title");
		lblTilte.setBounds(21, 258, 46, 14);
		contentPane.add(lblTilte);
	}
}