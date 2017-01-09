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

public class EnemyBullet extends Weapon {

	Image[] bullets;

	EnemyBullet(Image img, int x, int y, int speed, int xSpeed) {
		super(img, x, y, speed, xSpeed);
	}

}