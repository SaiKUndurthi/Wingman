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

public class PowerLevel extends GameObject{

	int type; 
        
	PowerLevel(Image img[], int x, int y, int speed, int type) {
		super(img[type], x, y, speed);
		this.type = type;

	}

	public void collected(Player p){
		switch(type){
		case 0:
			p.weaponType = 1;
			break;
		case 1:
			p.health = 10;
			break;
		case 2:
			p.lives++;
			break;
		}
	}
	
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}