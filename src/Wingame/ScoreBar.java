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

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.Observable;

public class ScoreBar extends GameObject {

	Player p;
	int lifeX;
	String word = "SCORE: ";
	Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
	int width;

	ScoreBar(Image img, int x, int y, int speed, Player p) {
		super(img, x, y, speed);
		this.p = p;
		width = p.health * 15;
	}

	public void draw(Graphics g, ImageObserver obs) {
		lifeX = rect.x + 10;

		g.setColor(Color.BLUE);
                g.fill3DRect(rect.x, rect.y, width, 20, true);
                

		if (p.health > 8)
			g.setColor(Color.green);
		else if (p.health > 5)
			g.setColor(Color.yellow);
		else if (p.health > 0)
			g.setColor(Color.red);
		g.fill3DRect(rect.x, rect.y, p.health * 15, 20, true);

		for (int i = 0; i < p.lives; i++) {
			g.drawImage(img, lifeX, rect.y, obs);
			lifeX += rect.width;

		}

		g.setFont(font);
		g.setColor(Color.white);
		g.drawString(word + (p.score * 1), rect.x, rect.y);

	}

	public void update(int w, int h) {

	}

	@Override
	public void update(Observable obj, Object arg) {
		// TODO Auto-generated method stub

	}
}