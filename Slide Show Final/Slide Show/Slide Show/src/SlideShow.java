import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(Color.CYAN); //the blue color made it hard to see the text, changed bottom border background color to cyan
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	private String getResizeIcon(int i) {
		//The image files were replaced with the updated image files that were used in the previous code and the new
		//path is updated in each of the slides for top five destinations. Although the types of travel and vacations are
		//now focusing on detox/wellness, the same locations can be used and will be changed to accommodate the new focus.
		//Image credit commented above each image.
		
		String image = ""; 
		if (i==1){
			//image credit: Diego Delso https://commons.wikimedia.org/wiki/File:Playa_Maya,_Ko_Phi_Phi,_Tailandia,_2013-08-19,_DD_13.JPG
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Playa_Maya,_Ko_Phi_Phi,_Tailandia,_2013-08-19,_DD_13.jpg") + "'</body></html>";
		} else if (i==2){
			//image credit: Vitor Oliveira https://commons.wikimedia.org/wiki/File:Praia_do_Peneco_-_Albufeira_-_Portugal_(4519095442).jpg
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/800px-Praia_do_Peneco_-_Albufeira_-_Portugal_(4519095442).jpg") + "'</body></html>";
		} else if (i==3){
			//image credit: Havardtl https://commons.wikimedia.org/wiki/File:Tverrlihytta_mountain_cabin_(Den_norske_turistforening)_in_Surnadal_in_Norway.jpg
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/800px-Tverrlihytta_mountain_cabin_(Den_norske_turistforening)_in_Surnadal_in_Norway.jpg") + "'</body></html>";
		} else if (i==4){
			//image credit: Daniel Kraft https://commons.wikimedia.org/wiki/File:Z%C3%BCrich_view_Quaibr%C3%BCcke_20200702.jpg
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/800px-Zürich_view_Quaibrücke_20200702.jpg") + "'</body></html>";
		} else if (i==5){
			//image credit: 0-0t https://commons.wikimedia.org/wiki/File:Voyager_of_the_Seas_at_Port_of_Kobe.jpg
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/800px-Voyager_of_the_Seas_at_Port_of_Kobe.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	private String getTextDescription(int i) {
		//Vacation destinations with short description of how the customers will detox and relax on their wellness vacation updated for each slide and the text for the vacation title
		//was made a bit smaller as to fit the full description better. Each location has a little explanation on what the customer can expect when going on each trip.
		
		String text = ""; 
		if (i==1){
			text = "<html><body><font size='4'>#1 Maya Beach (Ko Phi Phi Lee, Thailand)</font> <br>Rejuvinate your mind, body, and soul with hot stone massages, long-tail boat rides in "
					+ "crystal clear waters of Maya Bay, and enjoy fresh, authentic Thai cuisine that will have you begging to stay here forever.</body></html>";
		} else if (i==2){
			text = "<html><body><font size='4'>#2 Praia de Peneco (Albufeira, Portugal)</font> <br>Escape to the cliffs of Albufeira with your own private room overlooking Praia de Peneco "
					+ "beach at this all inclusive spa retreat focused on a full luxury detox that is dedicated to pampering and rejuvenating your wellness throughout your stay.</body></html>";
		} else if (i==3){
			text = "<html><body><font size='4'>#3 Private Mountain Cabin (Surnadal, Norway)</font> <br>A more adventurous detox vacation in the mountains of Norway might be for you"
					+ " if activities like hiking and kayaking sound like a peaceful escape. Outdoor guides will deliver their expertise in nature while the cabin will leave you"
					+ " breathless as you look over the landscape.</body></html>";
		} else if (i==4){
			text = "<html><body><font size='4'>#4 Destination Europe (Zurich, Switzerland)</font> <br>Simplicity is key at the Dolder Grand spa resort located in beautiful Zurich where "
					+ "luxurious treatments utilize the landscape and culture with traditional healing techniques, incredible food, yoga and meditation to round out your stay.</body></html>";
		} else if (i==5){
			text = "<html><body><font size='4'>#5 Royal Caribbean Cruise</font> <br>Spend as many as ten days on this beautiful, adult only cruise where you will have exercise therapists,"
					+ " energy healers, and spiritual counselors all at your fingertips to help you unearth your inner peace while traveling through the Eastern Caribbean.</body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}