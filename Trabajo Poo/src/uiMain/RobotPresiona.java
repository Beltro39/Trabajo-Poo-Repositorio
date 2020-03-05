package uiMain;

import java.awt.*;
import java.awt.event.*;


public class RobotPresiona {
    public static void limpiarpantalla() throws AWTException {
    Robot robot = new Robot();
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_L);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_L);
    try {
      Thread.sleep(250);
    } catch (Exception e) {
    }
    }
    public static boolean escucharEnter(KeyEvent evt) {
      if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        return true;
      }else{
        return false;
      }
    }

}
