package first.controller.test;

import java.awt.Color;

import robocode.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Hongge - a robot by (your name here)
 */
public class RobotController extends Robot {
	/**
	 * run: Hongge's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here
		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:
		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar
		// Robot main loop
		while (true) {
			// Replace the next 4 lines with any behavior you would like
			setColors(Color.blue, Color.blue, Color.blue);
			ahead(150);
			turnGunRight(360);
			back(100);
			turnGunRight(360);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot 当你看到另一个机器人
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(1);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet 当你被子弹击中
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
	}

	/**
	 * onHitWall: What to do when you hit a wall 当你遇到一堵墙
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
	}
}
