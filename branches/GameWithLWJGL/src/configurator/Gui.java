package configurator;

import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Gui implements ConfigListener{

	private JFrame frame;
	private ConfigModel model;
	private JList list;
	private JToggleButton tglbtnVsync;
	private JToggleButton tglbtnFullscreen;
	private JButton btnSave;
	private JButton btnExit;

	private static int i = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Gui window = new Gui();
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
	public Gui() {
		initialize();
		setLocation();
		frame.setVisible(true);
	}

	public Gui(ConfigModel model) {
		this();
		this.model = model;
		model.setListener(this);
	}

	private void setLocation() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Insets frameInsets = frame.getInsets();
		
		frame.setLocation((int)toolkit.getScreenSize().getWidth()/2 - frame.getWidth()/2 + frameInsets.left + frameInsets .right,
				(int) (toolkit.getScreenSize().getHeight()/2 - frame.getHeight()/2 + frameInsets.top + frameInsets .bottom));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(40, 37, 169, 182);
		frame.getContentPane().add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if(!arg0.getValueIsAdjusting())
					model.setSelectedDisplayMode(arg0.getFirstIndex());
			}
		});
		
		tglbtnVsync = new JToggleButton("VSync");
		tglbtnVsync.setBounds(244, 34, 121, 23);
		tglbtnVsync.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(model.isVsync())
					model.setVsync(false);
				else
					model.setVsync(true);	
			}
		});
		frame.getContentPane().add(tglbtnVsync);
		
		tglbtnFullscreen = new JToggleButton("Fullscreen");
		tglbtnFullscreen.setBounds(244, 92, 121, 23);
		tglbtnFullscreen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(model.isFullscreen())
					model.setFullscreen(false);
				else
					model.setFullscreen(true);
				
			}
		});
		
		frame.getContentPane().add(tglbtnFullscreen);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(260, 194, 89, 23);
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.saveInfo(true);
			}
		});
		frame.getContentPane().add(btnSave);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(260, 228, 89, 23);
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnExit);
		
		frame.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				model.saveInfo(false);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	@Override
	public void update(ConfigModel model) {
		System.out.println("updated: " + ++i);

		if(list.getModel().getSize() == 0)
			list.setListData(model.getDisplayModes());

		tglbtnFullscreen.setSelected(model.isFullscreen());
		tglbtnVsync.setSelected(model.isVsync());
		
		list.setSelectedIndex(model.getSelectedDisplayMode());
		list.ensureIndexIsVisible(model.getSelectedDisplayMode());
		
	}
}
