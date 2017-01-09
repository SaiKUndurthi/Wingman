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

import java.awt.*;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Observable;

public class MyPlane extends Player {

	int boom, count = 0;
        static SoundPlayer s = new SoundPlayer();
	MyPlane(Image img, int x, int y, int speed, int leftkey, int rightkey,
			int upkey, int downkey, int firekey) {
		super(img, x, y, speed, leftkey, rightkey, upkey, downkey, firekey);
	}

	public void fire() {
		if (lives > 0 && respawnTime == 0) {
			
			Airplane.getGame().addBullet(this, 15);
			if (weaponType == 1) {
                            
				Airplane.getGame().addLeftBullet(this, 5, 15);
				Airplane.getGame().addRightBullet(this, -5, 15);
			}
		}
	}

	public void update(int w, int h) {

		if (respawnTime == 0) {

			if (left && rect.x > 0 && !right)
				rect.x -= speed;
			if (right && rect.x + rect.width < w && !left)
				rect.x += speed;
			if (up && rect.y > 0 && !down)
				rect.y -= speed;
			if (down && rect.y + rect.height < h && !up)
				rect.y += speed;
		}
	}

	public void update(Observable obj, Object arg) {
		GameEvents ge = (GameEvents) arg;
		if (ge.type == 1) {
			KeyEvent e = (KeyEvent) ge.event;
			if (e.getKeyCode() == leftkey) {
			if (e.getID() == KeyEvent.KEY_RELEASED)
					left = false;
				else if (e.getID() == KeyEvent.KEY_PRESSED)
					left = true;
			}
			if (e.getKeyCode() == rightkey) {
				// System.out.println("Right");
				if (e.getID() == KeyEvent.KEY_RELEASED)
					right = false;
				else if (e.getID() == KeyEvent.KEY_PRESSED)
					right = true;
			}
			if (e.getKeyCode() == upkey) {
				// System.out.println("Up");
				if (e.getID() == KeyEvent.KEY_RELEASED)
					up = false;
				else if (e.getID() == KeyEvent.KEY_PRESSED)
					up = true;
			}
			if (e.getKeyCode() == downkey) {
				// System.out.println("Down");
				if (e.getID() == KeyEvent.KEY_RELEASED)
					down = false;
				else if (e.getID() == KeyEvent.KEY_PRESSED)
					down = true;
			}
			if (e.getKeyCode() == firekey && e.getID() == KeyEvent.KEY_PRESSED) {
				// System.out.println("Fire");
				fire();
			}
		}

		else if (ge.type == 2) {
			String msg = (String) ge.event;
			if (msg.equals("Explosion")) {
				boom = 1;
			}
		}
	}
}