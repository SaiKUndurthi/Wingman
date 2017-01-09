/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SaiKrishna
 */

    package Wingame;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import javax.imageio.ImageIO;

import javax.swing.*;

public class Airplane extends JApplet implements Runnable {

	private Thread thread;

	private static final Airplane game = new Airplane();

	private int move = 0;
       
        private BufferedImage bimg;
	int speed = 3;
	Random gen = new Random(1234567);
	Island I1, I2, I3;
        Boat b1,b2;
	static MyPlane p1, p2;
	ScoreBar s1, s2;
	Enemy e1, e2, e3, e4, e5;
	static GameEvents gameEvents;

	boolean gameOver = false;
	ImageObserver observer;
	ArrayList<Bullet> playerBullets = new ArrayList<Bullet>();
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
       	ArrayList<Weapon> enemyBullets = new ArrayList<Weapon>();
	ArrayList<Explosion> explosions = new ArrayList<Explosion>();
	ArrayList<PowerLevel> powerList = new ArrayList<PowerLevel>();
	ListIterator<PowerLevel> powerIt;
	ListIterator<Explosion> expIt;
	ListIterator<Enemy> enemyIt;
	ListIterator<Bullet> bulletIt;
	ListIterator<Weapon> weaponIt;
	Enemy nextEnemy;
	Weapon nextBullet;
	Explosion nextExp;
	PowerLevel nextPower;
	int framecount, count;
	CollisionDetector C = new CollisionDetector();

	Font font = new Font(Font.SERIF, Font.PLAIN, 30);

	Image myPlane, myPlane2, island1, island2, island3, enemy,boat2, bulletimg,LightningBolt,
	greenEnemy, yellowEnemy, whiteEnemy, upEnemy, end, life, life2, sideEnemy;
	
        Image bullet, lBullet, rBullet, sea, boss, enBullet, power1, power2;
	Image explosion1_1, explosion1_2, explosion1_3, explosion1_4, explosion1_5, explosion1_6, explosion2_1, explosion2_2, explosion2_3, explosion2_4,
	explosion2_5, explosion2_6, explosion2_7;
	Image[] bulletimages, explosion1, explosion2, powerups;

        static SoundPlayer s = new SoundPlayer(); 
               
        
	public static Airplane getGame() {
		return game;
	}

	public void init() {
		setFocusable( true );
		setBackground(Color.white);
                s.getSound("Resources/starwars.wav");
                framecount = 0;
		count = 0;
                BufferedReader reader = null;
        

                boat2 = getSprite("Resources/boat_1.png");
                myPlane = getSprite("Resources/myplane_1.png");
		myPlane2 = getSprite("Resources/myplane_2_1.png");
                LightningBolt = getSprite("Resources/LightningBolt.png");
                island1= getSprite("Resources/island1.png");
		island2 = getSprite("Resources/island2.png");
		island3 = getSprite("Resources/island3.png");
		bulletimg = getSprite("Resources/bullet.png");
		greenEnemy = getSprite("Resources/enemy1_1.png");
		yellowEnemy = getSprite("Resources/enemy2_1.png");
		whiteEnemy = getSprite("Resources/enemy3_1_2.png");
		upEnemy = getSprite("Resources/enemy4_1.png");
                sideEnemy = getSprite("Resources/new.png");
                life = getSprite("Resources/life2.png");
		life2 = getSprite("Resources/life.png");
                end = getSprite("Resources/gameOver.png");
		bullet = getSprite("Resources/bullet.png");
		lBullet = getSprite("Resources/bulletLeft.png");
		rBullet = getSprite("Resources/bulletRight.png");
		sea = getSprite("Resources/water.png");
                boss = getSprite("Resources/plane.png");
		enBullet = getSprite("Resources/enemybullet2.png");
		power1 = getSprite("Resources/powerup1.png");
		power2 = getSprite("Resources/powerup.png");
		explosion1_1 = getSprite("Resources/explosion1_1.png");
		explosion1_2 = getSprite("Resources/explosion1_2.png");
		explosion1_3 = getSprite("Resources/explosion1_3.png");
		explosion1_4 = getSprite("Resources/explosion1_4.png");
		explosion1_5 = getSprite("Resources/explosion1_5.png");
		explosion1_6 = getSprite("Resources/explosion1_6.png");
		explosion2_1 = getSprite("Resources/explosion2_1.png");
		explosion2_2 = getSprite("Resources/explosion2_2.png");
		explosion2_3 = getSprite("Resources/explosion2_3.png");
		explosion2_4 = getSprite("Resources/explosion2_4.png");
		explosion2_5 = getSprite("Resources/explosion2_5.png");
		explosion2_6 = getSprite("Resources/explosion2_6.png");
		explosion2_7 = getSprite("Resources/explosion2_7.png");
		

		explosion1 = new Image[] { explosion1_1, explosion1_2, explosion1_3, explosion1_4, explosion1_5, explosion1_6 };
		explosion2 = new Image[] { explosion2_1, explosion2_2, explosion2_3, explosion2_4, explosion2_5, explosion2_6,
				explosion2_7 };
		
		bulletimages = new Image[] { bullet, lBullet, rBullet };
		powerups = new Image[] { power1, power2, life };

		observer = this;

		I1 = new Island(island1, 100, 100, speed, gen);
		I2 = new Island(island2, 200, 400, speed, gen);
		I3 = new Island(island3, 300, 200, speed, gen);
                b2 = new Boat(boat2, 140, 140,speed,gen);

		KeyControl key = new KeyControl();
		addKeyListener(key);
		gameEvents = new GameEvents();
		p1 = new MyPlane(myPlane, 510, 600, 10, KeyEvent.VK_LEFT,
				KeyEvent.VK_RIGHT, KeyEvent.VK_UP, KeyEvent.VK_DOWN,
				KeyEvent.VK_SPACE);
		gameEvents.addObserver(p1);
		p2 = new MyPlane(myPlane2, 160, 600, 10, KeyEvent.VK_A, KeyEvent.VK_D,
				KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_Q);
		gameEvents.addObserver(p2);

		s2 = new ScoreBar(life2, 500, 700, 0, p1);
		s1 = new ScoreBar(life, 50, 700, 0, p2);


	}
        public Image getSprite(String name) {
		
            Image img = null;
            	try {
			img = ImageIO.read((getClass().getResource(name)));
		} catch (Exception e) {
                    System.out.println(" Resource not found at'" + name +"'");
		}
		return img;
	}

	public void addBullet(Player p, int ySpeed) {
		playerBullets.add(new Bullet(bullet, p, ySpeed));
	}

	public void addLeftBullet(Player p, int xSpeed, int ySpeed) {
		playerBullets.add(new Bullet(lBullet, p, xSpeed, ySpeed));
	}

	public void addRightBullet(Player p, int xSpeed, int ySpeed) {
		playerBullets.add(new Bullet(rBullet, p, xSpeed, ySpeed));
	}

	public void addEnemyBullet(int x, int y, int xSpeed, int ySpeed) {
		enemyBullets.add(new EnemyBullet(enBullet, x, y, xSpeed, ySpeed));
	}

	public void addExplosion(int x, int y) {
		explosions.add(new Explosion(explosion1, x, y));
	}

	public void addBigExplosion(int x, int y) {
		explosions.add(new Explosion(explosion2, x, y));
	}

	
	public void drawBackGroundWithTileImage(int w, int h, Graphics2D g2) {
		int TileWidth = sea.getWidth(this);
		int TileHeight = sea.getHeight(this);

		int NumberX = (int) (w / TileWidth);
		int NumberY = (int) (h / TileHeight);

		for (int i = -1; i <= NumberY; i++) {
			for (int j = 0; j <= NumberX; j++) {
				g2.drawImage(sea, j * TileWidth, i * TileHeight
						+ (move % TileHeight), TileWidth, TileHeight, this);
			}
		}
		move += speed;
	}

	public void drawDemo(int w, int h, Graphics2D g2) {

		drawBackGroundWithTileImage(w, h, g2);
		I1.update(w, h);
		I1.draw(g2, this);

		I2.update(w, h);
		I2.draw(g2, this);

		I3.update(w, h);
		I3.draw(g2, this);
                
                
                b2.update(w, h);
                b2.draw(g2, this);

		enemyIt = enemies.listIterator();
		while (enemyIt.hasNext()) {
			nextEnemy = (Enemy) enemyIt.next();
			nextEnemy.update(w, h);
			nextEnemy.draw(g2, this);
		}

		if (!gameOver) {
			framecount++;
			
			if (framecount % 49 == 0) {
				enemies.add(new Enemy(greenEnemy, Math.abs(gen.nextInt()
						% (w - 30)), -100, 0, 2, 2));
			}
                        
			if (framecount % 99 == 0) {
				enemies.add(new Enemy(yellowEnemy, Math.abs(gen.nextInt()
						% (w - 30)), -100, 0, 4, 3));
			}
                        if (framecount % 199 == 0){
				powerList.add(new PowerLevel(powerups, Math.abs(gen.nextInt()
						% (w - 30)), -100, 1, count));
				count = ++count % 2;
			}
			if (framecount % 199 == 0) {
				enemies.add(new ShootingEnemy(whiteEnemy, Math.abs(gen.nextInt()
						% (w - 80)), -100, 3, 3, 1));
			}
			if (framecount % 149 == 0) {
				enemies.add(new EasyEnemy(sideEnemy, -100, 300, 3, 3, 3));
			}
			if (framecount % 149 == 0) {
				enemies.add(new Enemy(upEnemy, Math.abs(gen.nextInt()
						% (w - 30)), h + 100, 0, -2, 1));
			}
			if (framecount % 499 == 0 && framecount % 999 != 0) {
				enemies.add(new HardEnemy(boss, w / 3, -100, 2, 2, 40));
			}
			if (framecount % 999 == 0) {
				enemies.add(new HardEnemy(boss, w / 2, -100, 4, 4, 30));
				enemies.add(new HardEnemy(boss, 0, -100, 4, 4, 15));
			}

			C.bve(playerBullets, enemies);
			

			if (p1.lives > 0) {
				C.pve(p1, enemies.listIterator());
				C.pvw(p1, enemyBullets.listIterator());
				C.pvp(p1, powerList.listIterator());
				p1.draw(g2, this);
				p1.update(w, h);
			}

			if (p2.lives > 0) {
				C.pve(p2, enemies.listIterator());
				C.pvw(p2, enemyBullets.listIterator());
				C.pvp(p2, powerList.listIterator());
				p2.draw(g2, this);
				p2.update(w, h);
			}

			powerIt = powerList.listIterator();
			while (powerIt.hasNext()) {
				nextPower =powerIt.next();
				nextPower.update(w, h);
				nextPower.draw(g2, this);
			}
			
			enemyIt = enemies.listIterator();
			while (enemyIt.hasNext()) {
				nextEnemy = (Enemy) enemyIt.next();
				nextEnemy.update(w, h);
				nextEnemy.draw(g2, this);
			}

			bulletIt = playerBullets.listIterator();
			while (bulletIt.hasNext()) {
				nextBullet = bulletIt.next();
				nextBullet.update(w, h);
				nextBullet.draw(g2, this);
				if (nextBullet.rect.y < -10)
					bulletIt.remove();
			}
			weaponIt = enemyBullets.listIterator();
			while (weaponIt.hasNext()) {
				nextBullet = weaponIt.next();
				nextBullet.update(w, h);
				nextBullet.draw(g2, this);
				if (nextBullet.rect.y > h)
					weaponIt.remove();
			}

			s1.draw(g2, this);
			s2.draw(g2, this);

			if (p1.lives == 0 && p2.lives == 0)
				gameOver = true;
		} else if (gameOver) {
			g2.drawImage(end, w / 3, h -290, this);
                        g2.setFont(font);
                        
                        for(int i = 0;i<2;i++) {
				g2.drawImage(LightningBolt, Math.abs(gen.nextInt()
						% (w - 20)),5,this);
                                
                                
			}
                     	g2.setColor(Color.orange);
			g2.drawString("PLAYER1: " + (p1.score ), w/3, h - 160);
			g2.setColor(Color.red);
			g2.drawString("PLAYER2: " + (p2.score ), w/3, h - 110);

		}
		expIt = explosions.listIterator();
		while (expIt.hasNext()) {
			nextExp = expIt.next();

			nextExp.draw(g2, this);
			if (nextExp.finished)
				expIt.remove();
		}

	}

	public Graphics2D createGraphics2D(int w, int h) {
		Graphics2D g2 = null;
		if (bimg == null || bimg.getWidth() != w || bimg.getHeight() != h) {
			bimg = (BufferedImage) createImage(w, h);
		}
		g2 = bimg.createGraphics();
		g2.setBackground(getBackground());
		g2.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		g2.clearRect(0, 0, w, h);
		return g2;
	}
        
        public void start() {
		thread = new Thread(this);
		thread.setPriority(Thread.MIN_PRIORITY);
		thread.start();
	}

	public void run() {
		Thread me = Thread.currentThread();
		while (thread == me) {
			repaint();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				break;
			}
		}
	}

	public void paint(Graphics g) {
		Dimension d = getSize();
		Graphics2D g2 = createGraphics2D(d.width, d.height);
		drawDemo(d.width, d.height, g2);
		g2.dispose();
		g.drawImage(bimg, 0, 0, this);
	}

	

	public static void main(String argv[]) {
		final Airplane demo = Airplane.getGame();
		demo.init();
		JFrame frame = new JFrame("Sai's Wingman Game");
		frame.addWindowListener(new WindowAdapter() {
		});
		frame.getContentPane().add("Center", demo);
		frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setSize(new Dimension(750, 700));
		frame.setVisible(true);
		frame.setResizable(false);
		demo.start();
	}

	/**
	 * This method is called from within the init() method to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	@SuppressWarnings("unused")
	private void initComponents() {

		setLayout(new java.awt.BorderLayout());
	}// </editor-fold>
	// Variables declaration - do not modify
	// End of variables declaration

    

}
    
    