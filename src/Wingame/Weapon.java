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

public class Weapon extends GameObject {

	int xSpeed;

	Weapon(Image img, int x, int y, int speed, int xSpeed) {
		super(img, x, y, speed);
		this.xSpeed = xSpeed;
	}

	public void update(int w, int h) {
		rect.y -= speed;
		rect.x -= xSpeed;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

}
