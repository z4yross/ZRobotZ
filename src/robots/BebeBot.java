package robots;

import robocode.JuniorRobot;
import robocode.ScannedRobotEvent;

public class BebeBot extends JuniorRobot {
	
	public void run(){
		final int r =(fieldHeight >= fieldWidth)?fieldWidth-20:fieldHeight-20;
		final double mov = 2*r*Math.sin(15);
		
		double movInic = (Math.sqrt(Math.pow((fieldWidth/2)-robotX, 2)+Math.pow(fieldHeight-(fieldHeight-20), 2)));
		double angInic = Math.acos(robotY/movInic);
		
		turnRight((int) (angInic-getHeading()));
		ahead((int) movInic);
		
	}

	public void onScannedRobot(ScannedRobotEvent e) {
        fire(1);
    }

}
