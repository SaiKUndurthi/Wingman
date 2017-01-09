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
import java.util.Random;

public class Island extends GameObject {

	Random gen;

	Island(Image img, int x, int y, int speed, Random gen) {
		super(img, x, y, speed);
		this.gen = gen;
	}

	public void update(int w, int h) {
		rect.y += speed;
		if (rect.y >= h) {
			rect.y = -100;
			rect.x = Math.abs(gen.nextInt() % (w - 30));
		}
	}

	public void update(Observable obj, Object arg) {
		// TODO Auto-generated method stub

	}
}