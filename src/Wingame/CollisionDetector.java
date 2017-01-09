/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Wingame;

/**
 *
 * @author SaiKrishna
 */

import java.util.ArrayList;
import java.util.ListIterator;
import java.awt.*;

public class CollisionDetector {

	CollisionDetector() {

	}
                        static SoundPlayer s = new SoundPlayer(); 

	public void pve(MyPlane thing1, ListIterator<Enemy> a2) {
		while (a2.hasNext()) {
			Enemy thing2 = a2.next();
			if (thing1.rect.intersects(thing2.rect)) {
				--thing1.health;
				if (--thing2.health == 0) {
					Airplane.getGame()
					.addExplosion(thing2.rect.x, thing2.rect.y);
					a2.remove();
				}
			}
		}

	}

	public void bve(ArrayList<Bullet> list1, ArrayList<Enemy> list2) {
		ListIterator<Bullet> it1 = list1.listIterator();
                
		while (it1.hasNext()) {
			Bullet thing1 = it1.next();
			ListIterator<Enemy> it2 = list2.listIterator();
			while (it2.hasNext()) {
				Enemy thing2 = it2.next();
				if (thing1.rect.intersects(thing2.rect)) {
					// System.out.println("explosion!");
					if (--thing2.health <= 0) {
						Airplane.getGame().addExplosion(thing2.rect.x,
								thing2.rect.y);
						it2.remove();
					s.getSound("Resources/snd_explosion2.wav");
						thing1.owner.score += thing2.score;
					}
					it1.remove();
					break;
				}
			}
		}
	}

	public void pvw(Player thing1, ListIterator<Weapon> a2) {
		while (a2.hasNext()) {
			Weapon thing2 = a2.next();
			if (thing1.rect.intersects(thing2.rect)) {
				--thing1.health;
				a2.remove();
			}
		}
	}

	public void pvp(Player thing1, ListIterator<PowerLevel> a2) {
		while (a2.hasNext()) {
			PowerLevel thing2 = a2.next();
			if (thing1.rect.intersects(thing2.rect)) {
				thing2.collected(thing1);
				a2.remove();
			}
		}
	}

}
