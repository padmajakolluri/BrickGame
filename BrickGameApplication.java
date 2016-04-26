package com.aop.myBrickgame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class BrickGameApplication extends JFrame {
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	List<Position> bricks = new ArrayList<Position>();
	Position bollpos, padelpos;
	Timer timer;
	Boll boll;
	Padel padel;
	Brick brick;
	int x=520,y=540;
	private PanelClss panelClss;
	int m,n;
	
	BrickGameApplication() {
		
		setTitle("Brick Game");
		this.getContentPane().setLayout(new GridLayout(1,1));
		this.setPreferredSize(new Dimension(600, 600));
		pack();
		this.setVisible(true);
		setMaximumSize(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		createMenus();
		panelClss = new PanelClss();
		m=this.getHeight();
		n=this.getWidth();
		this.add(panelClss);
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public void createMenus() {
		JMenuBar jMenuBar = new JMenuBar();
		JMenu jMenu = new JMenu("Game");
		jMenuBar.add(jMenu);
		JMenuItem jMenuItem = new JMenuItem("New Game");
		jMenu.add(jMenuItem);
		jMenuItem.addActionListener((e) -> onNewGame());
		this.setJMenuBar(jMenuBar);
	}

	void createBricks() {
		brick = new Brick(this);
		for (int i = 0; i < 20; i++)
			for (int j = i + 1; j < 20 - i; j++) {
				bricks.add(new Position(j * 60,i*10));
			}
	}

	protected Direction convartKeyToDirection(KeyEvent e) {
		int x = e.getKeyCode();
		Direction eventDirection = null;
		if (x == 37) {
			eventDirection = Direction.LEFT;
		} else if (x == 39) {
			eventDirection = Direction.RIGHT;
		}
		return eventDirection;

	}

	class PanelClss extends JPanel {
		@Override
		public void paint(Graphics g) {
			if (brick != null) {
				for (int i = 0; i < bricks.size(); i++) {

					g.drawRect(bricks.get(i).getX(), bricks.get(i).getY(), 60, 10);
				}
			}
			if (boll != null) {
				g.drawOval(bollpos.getX(), bollpos.getY(), boll.radious, boll.radious);
			}
			if (padel != null) {
				g.fillRect(padelpos.getX(), padelpos.getY(),60,10);
			}
		}
	}

	public void onNewGame() {
		createBricks();
		createBoll(x,y);
		createPadel();
		
		//panelClss.repaint();
		startTimer();
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				Direction eventDirection = convartKeyToDirection(e);
				if(eventDirection!=null)
				padel.padelmove(eventDirection,padelpos);

			}
		});

	}



	private void createPadel() {
		padel=new Padel();

		padelpos = new Position(500,550);
	}

	void createBoll(int x,int y) {
		boll=new Boll(this);
		bollpos = new Position( x,y);
	}

	private void startTimer() {
		timer = new Timer();
		 
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println("in timer");
				boll.move();
				
				brick.collide();
				repaint();
				endGame();
			}

		}, 0, 50);

	}

	protected void endGame() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new BrickGameApplication();
	}

}
