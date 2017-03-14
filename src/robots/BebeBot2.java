package robots;

import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class BebeBot2 extends Robot {
	
	public void run(){
		
		final int r =(int) ((getBattleFieldHeight() >= getBattleFieldWidth())?(getBattleFieldWidth()-(getBattleFieldWidth()/1.4))/2:(getBattleFieldHeight()-(getBattleFieldHeight()/1.4))/2);
		final double mov = 2*r*Math.sin(15);
		final double ang = 180-(90+15);
		
		movInici();

		while(true){
			ahead(mov);
			turnRight(-30);	
		}
			
	}

	public void onScannedRobot(ScannedRobotEvent e) {
        fire(1);
    }
	
	public void onHitWall(HitWallEvent event){
		back(100);
		turnRight(180);
		ahead(200);
		movInici();	
	}
	
	public void movInici(){
		if(getY()>100){
			double angInic = 180-Math.toDegrees(Math.atan(((getBattleFieldWidth()/2)-getX())/(getY()-100)));
			double movInic = Math.sqrt(Math.pow((getBattleFieldWidth()/2)-getX(), 2)+Math.pow((getBattleFieldHeight()-(getBattleFieldHeight()-100))-getY(), 2));//Math.abs((getBattleFieldWidth()/2)-getX()/Math.sin(angInic));
			turnRight(angInic-getHeading());
			ahead(movInic);
			turnRight(75-getHeading());
		}
		else{
			double angInic = Math.toDegrees(Math.atan(((getBattleFieldWidth()/2)-getX())/(getY()-100)));
			double movInic = Math.sqrt(Math.pow((getBattleFieldWidth()/2)-getX(), 2)+Math.pow((getBattleFieldHeight()-(getBattleFieldHeight()-100))-getY(), 2));
			turnRight(angInic-getHeading());
			ahead(movInic);
			turnRight(75-getHeading());
		}
	}
	
}
