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
import java.awt.event.KeyEvent;
import java.util.Observable;

public class GameEvents extends Observable {

	int type;
	Object event;

	public void setValue(KeyEvent e) {
		type = 1;
		event = e;
		setChanged();

		notifyObservers(this);
	}

	public void setValue(String msg) {
		type = 2;
		event = msg;
		setChanged();
		notifyObservers(this);
	}

}
