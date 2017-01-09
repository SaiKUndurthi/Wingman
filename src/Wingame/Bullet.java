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
import java.awt.*;

public class Bullet extends Weapon {

	Player owner;
        static SoundPlayer s = new SoundPlayer();
        
	Bullet(Image img, Player owner, int speed) {
		super(img, owner.rect.x + (owner.rect.width / 2)
				- img.getWidth(owner.obs) / 2, owner.rect.y, speed, 0);
		this.owner = owner;
                s.getSound("Resources/sdn_explosion2.wav");
	}

	Bullet(Image img, Player owner, int xSpeed, int ySpeed) {
		super(img, owner.rect.x + (owner.rect.width / 2)
				- img.getWidth(owner.obs) / 2, owner.rect.y, ySpeed, xSpeed);
		this.xSpeed = xSpeed;
		this.owner = owner;
                                s.getSound("Resources/sdn_explosion2.wav");

	}

}