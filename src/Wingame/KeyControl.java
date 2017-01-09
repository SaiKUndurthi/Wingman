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

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyControl extends KeyAdapter {

	public void keyPressed(KeyEvent e) {
		Airplane.gameEvents.setValue(e);
	}

	public void keyReleased(KeyEvent e) {
		Airplane.gameEvents.setValue(e);
	}
}