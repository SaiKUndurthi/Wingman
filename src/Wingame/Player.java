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

abstract class Player extends GameObject {

	int leftkey, rightkey, upkey, downkey, firekey, health, lives, score;
	int startX, startY, respawnTime;
	boolean left, right, up, down;

	int weaponType;

	public Player(Image img, int x, int y, int speed, int leftkey,
			int rightkey, int upkey, int downkey, int firekey) {
		super(img, x, y, speed);
		this.leftkey = leftkey;
		this.rightkey = rightkey;
		this.upkey = upkey;
		this.downkey = downkey;
		this.firekey = firekey;
		left = false;
		right = false;
		up = false;
		down = false;
		health = 10;
		lives = 3;
		score = 0;
		startX = x;
		startY = y;
		respawnTime = 0;
		weaponType = 0;
	}

	public void draw(Graphics g, ImageObserver obs) {
		if (health > 0 && respawnTime == 0)
			g.drawImage(img, rect.x, rect.y, obs);
		else if (respawnTime > 0)
			respawnTime--;
		else if (health == 0 && --lives > 0) {
			Airplane.getGame().addBigExplosion(rect.x, rect.y);
			if (--lives > 0) {
				respawnTime = 50;
				rect.x = startX;
				rect.y = startY;
				health = 10;
				weaponType = 0;
			}
		}
	}

}