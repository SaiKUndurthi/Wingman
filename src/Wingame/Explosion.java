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

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.Observable;

public class Explosion extends GameObject {

	Image[] images;
	int frame, i;
	boolean finished;
        static SoundPlayer s = new SoundPlayer();

	Explosion(Image[] img, int x, int y) {
		super(img[0], x, y, 0);
		images = img;
		frame = 0;
		i = 0;
		s.getSound("Resources/snd_explosion2.wav");
		finished = false;
	}

	public void draw(Graphics g, ImageObserver obs) {
		if (i < images.length) {
			g.drawImage(images[i], rect.x, rect.y, obs);
			if (++frame % 3 == 0)
				i++;
		} else
			finished = true;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

}