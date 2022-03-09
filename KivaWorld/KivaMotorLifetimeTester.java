
/**
 * Write a description of KivaMotorLifetimeTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.Point;
public class KivaMotorLifetimeTester {
     String defaultLayout =""
                          +"-----"
                          +"|K D|"
                          +"| P |"
                          +"|* *|"
                          +"-----";
                            
     FloorMap defaultMap = new FloorMap(defaultLayout);  
     
     public void testKiveMotorLifetimeTracker() {
        Kiva kiva = new Kiva(defaultMap);
        
        Point actualLocation = kiva.getCurrentLocation();
        
        System.out.print(kiva.getMotorLifetime());
        
        kiva.move(KivaCommand.TURN_RIGHT);
        
        System.out.print(kiva.getMotorLifetime());
        
        kiva.move(KivaCommand.FORWARD);
        
        System.out.print(kiva.getMotorLifetime());
        
        kiva.move(KivaCommand.TURN_RIGHT);
        
        System.out.print(kiva.getMotorLifetime());
        
        kiva.move(KivaCommand.FORWARD);
        
        System.out.print(kiva.getMotorLifetime());
        
        kiva.move(KivaCommand.TAKE);
       
        System.out.print(kiva.getMotorLifetime());
    }
}
