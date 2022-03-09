import edu.duke.Point;

/**
 * This is the main Kiva class that instantiates a Kiva
 * robot and moves the object around a map given user input. 
 * @author Kevin Phan
 * @version 4/5/21
 */

public class Kiva {
    
     private Point currentLocation;
     private FacingDirection directionFacing;
     private FloorMap map;
     private boolean successfullyDropped;
     private boolean carryPod;
     private long motorLifetime;
     
     
     /**
      * Returns state of whether dropped or not.
      * @return isSucessfullyDropped boolean.
      */
     public boolean isSuccessfullyDropped() {
        return this.successfullyDropped;
        }
       
     /**
      * Returns state of whether carrying pod or not.
      * @return isCarryingPod boolean.
      */
     public boolean isCarryingPod(){
        return this.carryPod;
        }
        
     /**
      * Gets total number of seconds Kiva has incurred.
      * @return Time Kiva has incurred in seconds.
      */
     public long getMotorLifetime() {
        return this.motorLifetime;
        }
    
     /** 
      * Returns most current direction Kiva is assigned to.
      * @return This should be type FacingDirection.
      */
     public FacingDirection getDirectionFacing() {
      return this.directionFacing;
        }
        
     /**
      * Returns current location of Kiva object on map.
      * @return Current location on map. 
      */
     public Point getCurrentLocation() {
        return this.currentLocation;
        }
        
     /**
      * Updates currentLocation by receiving incremented x and y 
      * value in correspondence with move() method.
      * @param int x and y coordinates that provide new location.
      *            
      */
     public void setCurrentLocation(int x, int y) {
        this.currentLocation = new Point(x, y);
        }
        
     /**
      * Modified currentLocation value by receiving incremented x and y
      * value of upcoming location to conduct exception test before 
      * currentLocation value is updated.
      * @param int x and y coordinates that provide where pod should be in next move.
      */        
     public void podExceptionTester(int x, int y) {       
        Point exceptionTester = currentLocation;               
        }
     
     /**
      * Initializes new Kiva robot and sets currentLocation to 
      * initialLocation set on map passed in constructor.
      * @param map Map set by value passed in parameter that robot will naviagete on.
      */
     Kiva(FloorMap map) {
         this.successfullyDropped = false;
         this.carryPod = false;
         directionFacing = FacingDirection.UP;
         this.currentLocation = map.getInitialKivaLocation();  
         this.map = map;
         this.motorLifetime = 0;
        }
        
     /**
      * Initializes new Kiva robot and sets location to 
      * currentLocation value passed in constructor.
      * @param map Map set by value passed in parameter that robot will naviagete on.
      * @param currentLocation Starting location set to value passed in parameter. 
      */
     Kiva(FloorMap map, Point currentLocation) {
        this.successfullyDropped = false;
        this.carryPod = false;
        directionFacing = FacingDirection.UP;
        this.currentLocation = currentLocation;  
        this.map = map;
        this.motorLifetime = 0;
        }  
        
     /**
      * Increments motorLifetime by 1000 seconds everytime Kiva robot
      * moves forward, turns left, or turns right.
      * @return motorLifetime + 1000
      */
     
     private void incrementMotorLifetime() {
       this.motorLifetime = this.motorLifetime + 1000;
       }
       
     /**
      * Moves Kiva object's location based on KivaCommand passed in.
      * @param User inputs KivaCommand that dicates direction Kiva object will move.
      */
        
     public void move(KivaCommand command) {
                         
        if (command == KivaCommand.FORWARD) {
           moveForward();
           incrementMotorLifetime();
        } else if (command == KivaCommand.TURN_RIGHT) {
           turnRight();     
           incrementMotorLifetime();
        } else if (command == KivaCommand.TURN_LEFT) {
           turnLeft();     
           incrementMotorLifetime();
           
        } else if (command == KivaCommand.TAKE) {
            
           if (map.getObjectAtLocation(currentLocation) != FloorMapObject.POD) {
            throw new NoPodException(String.format("Can't take nonexistent pod from location %s!", currentLocation));
            } 
           this.carryPod = true;
           this.successfullyDropped = false;
        } else if (command == KivaCommand.DROP) {
          if (map.getObjectAtLocation(currentLocation) != FloorMapObject.DROP_ZONE) {
          throw new IllegalDropZoneException(String.format("IllegalDropZoneException: Can't just drop pods willy-nilly at %s!", currentLocation));
          } else if (carryPod == false) {
          }
          this.successfullyDropped = true;
          this.carryPod = false;
        }
        }
        
     /**
      * Moves Kiva forward depending on what direction object is facing.
      * @return Updates currentLocation by iterating x or y value by 1.
      */
    
     private void moveForward() {
         
        int xLocation = currentLocation.getX();
        int yLocation = currentLocation.getY();
        
        FloorMapObject exceptionTester = map.getObjectAtLocation(currentLocation); 
        
        if (directionFacing == FacingDirection.UP ) {               
            
            if ((map.getObjectAtLocation(this.currentLocation = new Point(xLocation, yLocation - 1)) == FloorMapObject.OBSTACLE)) {               
            throw new IllegalMoveException(String.format("IllegalMoveException: Can't move onto an obstacle at %s", currentLocation));           
            } else if ((yLocation - 1) <= map.getMinColNum()) {               
            throw new IllegalMoveException(String.format("Can't move onto an obstacle at %s!", currentLocation));           
            } else if ((carryPod == true && (map.getObjectAtLocation(this.currentLocation = new Point(xLocation, yLocation - 1)) == FloorMapObject.POD))) {              
            throw new IllegalMoveException(String.format("Can't take pod: location %s is %s, already carrying pod!", currentLocation, exceptionTester));            
            }
            
            yLocation--;
            setCurrentLocation(xLocation, yLocation);  
            
        } else if (directionFacing == FacingDirection.DOWN) {           
            
            if (exceptionTester == FloorMapObject.OBSTACLE) {               
            throw new IllegalMoveException(String.format("IllegalMoveException: Can't move onto an obstacle at %s!", currentLocation));           
            } else if (yLocation + 1 >= map.getMaxColNum()) {               
            throw new IllegalMoveException(String.format("Can't move onto an obstacle at %s!", currentLocation));          
            } else if ((carryPod == true && (map.getObjectAtLocation(this.currentLocation = new Point(xLocation, yLocation - 1)) == FloorMapObject.POD))) {               
            throw new IllegalMoveException(String.format("Can't take pod: location %s is %s, already carrying pod!", currentLocation, exceptionTester));           
            }
            
            yLocation++;
            setCurrentLocation(xLocation, yLocation);
                      
        } else if (directionFacing == FacingDirection.LEFT) {         
            
            if (exceptionTester == FloorMapObject.OBSTACLE) {
            throw new IllegalMoveException(String.format("IllegalMoveException: Can't move onto an obstacle at %s", currentLocation));
            } else if (xLocation - 1 <= map.getMinColNum() ) {
            throw new IllegalMoveException(String.format("Can't move onto an obstacle at %s!", currentLocation));
            } else if ((carryPod == true && (map.getObjectAtLocation(this.currentLocation = new Point(xLocation - 1, yLocation)) == FloorMapObject.POD))) {
            throw new IllegalMoveException(String.format("Can't take pod: Location %s is %s, already carrying pod!", currentLocation, exceptionTester));
            }           
              
            xLocation--;
            setCurrentLocation(xLocation, yLocation);
            
        } else if (directionFacing == FacingDirection.RIGHT) {
                       
            if ((map.getObjectAtLocation(this.currentLocation = new Point(xLocation + 1, yLocation))) == FloorMapObject.OBSTACLE) {
            throw new IllegalMoveException(String.format("IllegalMoveException: Can't move onto an obstacle at %s", currentLocation));
            } else if (yLocation + 1 >= map.getMaxColNum()) {
            throw new IllegalMoveException(String.format("Can't move onto an obstacle at %s!", currentLocation));
            } else if ((carryPod == true && (map.getObjectAtLocation(this.currentLocation = new Point(xLocation + 1, yLocation))) == FloorMapObject.POD)) {
            throw new IllegalMoveException(String.format("Can't take pod: location %s is %s, already carrying pod!", currentLocation, exceptionTester));
            }      
           
            xLocation++;
            setCurrentLocation(xLocation, yLocation);
                        
        }
       }
       
     /**
      * Turns Kiva object 90 degrees to the right.
      * @return Changes directionFacing.
      */
     
     private void turnRight() {
         
         //FloorMapObject exceptionTester = map.getObjectAtLocation(currentLocation);
         
         if (directionFacing == FacingDirection.UP){         
             this.directionFacing = FacingDirection.RIGHT;
         } else if (directionFacing == FacingDirection.RIGHT) {
            /* if (exceptionTester == FloorMapObject.OBSTACLE) {
            throw new IllegalMoveException(String.format("Can't take: location %s is %s, not empty square!", currentLocation, exceptionTester));
            }*/
             this.directionFacing = FacingDirection.DOWN;
         } else if (directionFacing == FacingDirection.DOWN) {
             this.directionFacing = FacingDirection.LEFT;
         }
         else if (directionFacing == FacingDirection.LEFT) {
             this.directionFacing = FacingDirection.UP;
         }
        }   
        
     /**
      * Turns Kiva object 90 degrees to the left.
      * @return Changes directionFacing.
      */
        
     private void turnLeft() {
         if (directionFacing == FacingDirection.UP){         
             this.directionFacing = FacingDirection.LEFT;
         } else if (directionFacing == FacingDirection.RIGHT) {
             this.directionFacing = FacingDirection.UP;
         } else if (directionFacing == FacingDirection.DOWN) {
             this.directionFacing = FacingDirection.RIGHT;
         }
         else if (directionFacing == FacingDirection.LEFT) {
             this.directionFacing = FacingDirection.DOWN;
         }
        } 
}