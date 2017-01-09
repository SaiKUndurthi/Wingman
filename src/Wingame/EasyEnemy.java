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

public class EasyEnemy extends Enemy {

	int count;

	EasyEnemy(Image img, int x, int y, int xSpeed, int ySpeed, int health) {
		super(img, x, y, xSpeed, ySpeed, health);
		count = 0;
	}

	public void update(int w, int h) {
		count++;
		rect.x += xSpeed;
		rect.y += (int) (speed * Math.cos(Math.toDegrees(count/10)));
		

	}

}