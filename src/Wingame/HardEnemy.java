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

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class HardEnemy extends Enemy {

	int count;

	HardEnemy(Image img, int x, int y, int xSpeed, int ySpeed, int health) {
		super(img, x, y, xSpeed, ySpeed, health);
		count = 0;
	}

	public void update(int w, int h) {
		count++;
		if (rect.y < h-456)
			rect.y += speed;
		else
			rect.x += xSpeed;
		if (rect.x + rect.width > w || rect.x < 0)
			xSpeed *= -1;
		if (count % 25 == 0) {
			Airplane.getGame().addEnemyBullet(rect.x + rect.width / 4,
					rect.y + rect.height, -5, 5);
			Airplane.getGame().addEnemyBullet(rect.x + rect.width / 4,
					rect.y + rect.height, -5, -5);
			Airplane.getGame().addEnemyBullet(rect.x + rect.width / 4,
					rect.y + rect.height, -5, 0);
		}

	}
        public void draw(Graphics g, ImageObserver obs) {
		g.drawImage(img, rect.x, rect.y, obs);
	}

}