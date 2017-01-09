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

import java.awt.Image;

public class ShootingEnemy extends Enemy {

	int count;

	ShootingEnemy(Image img, int x, int y, int xSpeed, int ySpeed, int health) {
		super(img, x, y, xSpeed, ySpeed, health);
		count = 0;
	}

	public void update(int w, int h) {
		count++;
		if (rect.y < h / 2)
			rect.y += speed;
		else
			rect.x += xSpeed;
		if (rect.x + rect.width > w || rect.x < 0)
			xSpeed *= -1;
		if (count % 50 == 0) {
			Airplane.getGame().addEnemyBullet(rect.x + rect.width / 2,
					rect.y + rect.height, -10, 0);
		}

	}

}
