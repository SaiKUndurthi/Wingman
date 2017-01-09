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
import java.util.Observable;

public class Enemy extends GameObject {

	int xSpeed, health, score;

	Enemy(Image img, int x, int y, int xSpeed, int ySpeed, int health) {
		super(img, x, y, ySpeed);
		this.xSpeed = xSpeed;
		this.health = health;
		this.score = health;
	}

	public void update(int w, int h) {
		rect.y += speed;
		rect.x += xSpeed;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}
}