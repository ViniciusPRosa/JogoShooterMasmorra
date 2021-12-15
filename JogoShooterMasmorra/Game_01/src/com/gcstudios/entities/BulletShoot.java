package com.gcstudios.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;
import com.gcstudios.world.Camera;
import com.gcstudios.world.World;

public class BulletShoot extends Entity{

	private double dx;
	private double dy;
	private double spd = 4;
	
	private int life = 30,curLife = 0;
	
	
	public BulletShoot(int x, int y, int width, int height, BufferedImage sprite,double dx,double dy) {
		super(x, y, width, height, sprite);
		this.dx = dx;
		this.dy = dy;
	}
	
	public void tick() {
		x+=dx*spd;
		y+=dy*spd;
		curLife++;
		if(curLife == life) {
			Game.bullets.remove(this);
			return;
		}
		if(!(World.isFree(this.getX(), this.getY()))) {
			Game.bullets.remove(this);
		}
	}
	
	public void render(Graphics g){
		g.setColor(Color.YELLOW);
		g.fillOval(this.getX() - Camera.x,this.getY() - Camera.y,width,height);
	}
	
}
