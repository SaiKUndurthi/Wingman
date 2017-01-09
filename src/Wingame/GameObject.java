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

import java.util.Observer;
import java.awt.*;
import java.awt.image.ImageObserver;

public abstract class GameObject implements Observer {

	int speed, score;
	Rectangle rect;
	Image img;
	ImageObserver obs;

	GameObject(Image img, int x, int y, int speed) {
		rect = new Rectangle(x, y, img.getWidth(this.obs),
				img.getHeight(this.obs));
		this.img = img;
		this.speed = speed;
	}

	public int getX() {
		return rect.x;
	}

	public int getY() {
		return rect.y;
	}

	public int getHeight() {
		return rect.height;
	}

	public int getWidth() {
		return rect.width;
	}

	public void draw(Graphics g, ImageObserver obs) {
		g.drawImage(img, rect.x, rect.y, obs);
	}

	public void update(int w, int h) {
		rect.y += speed;

	}

}
