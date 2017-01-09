/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Wingame;

import java.awt.Image;
import java.util.Observable;
import java.util.Random;

/**
 *
 * @author SaiKrishna
 */
    
import java.awt.Image;
import java.util.Observable;
import java.util.Random;

public class Boat extends GameObject {

	Random gen;

	Boat(Image img, int x, int y, int speed, Random gen) {
		super(img, x, y, speed);
		this.gen = gen;
	}

	public void update(int w, int h) {
		rect.x += speed;
		if (rect.x >= w) {
			rect.x = -110;
			rect.y = Math.abs(gen.nextInt() % (h/2));
		}
	}

	public void update(Observable obj, Object arg) {
		// TODO Auto-generated method stub

	}
}
    

