import edu.duke.Point;

/**
 * Series of tests that ensure Kiva object successfully moves around map void of 
 * any exception errors.
 * @author (Kevin Phan) 
 * @version (5/5/21)
 */

public class KivaMoveTest {
   // Define the FloorMap we'll use for all the tests
   String defaultLayout = ""
                          + "-------------\n"
                          + "        P   *\n"
                          + "   **       *\n"
                          + "    **      *\n"
                          + "  K       D *\n"
                          + " * * * * * **\n"
                          + "-------------\n";

    FloorMap defaultMap = new FloorMap(defaultLayout);

   public void testForwardFromUp() {
       // GIVEN
       // A Kiva built with the default map we defined earlier
       Kiva kiva = new Kiva(defaultMap);

       // WHEN
       // We move one space forward
       kiva.move(KivaCommand.FORWARD);
       
       // THEN
       // The Kiva has moved one space up
       verifyKivaState("testForwardFromUp", 
            kiva, new Point(2, 3), FacingDirection.UP, false, false);
   }
   
   // For you: create all the other tests and call verifyKivaState() for each
   
   public void testTurnLeftFromUp() {
        Kiva kiva = new Kiva(defaultMap);
        Point actualLocation = kiva.getCurrentLocation();
        kiva.move(KivaCommand.TURN_LEFT);
        verifyKivaState("testTurnLeftFromLeft",
            kiva, new Point(2, 4), FacingDirection.LEFT, false, false);
    }
   
   public void testTurnLeftFromLeft() {
        Kiva kiva = new Kiva(defaultMap);
        Point actualLocation = kiva.getCurrentLocation();
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        verifyKivaState("testTurnLeftFromLeft",
            kiva, new Point(2, 4), FacingDirection.DOWN, false, false);
    }
    
   public void testTurnLeftFromDown() {
        Kiva kiva = new Kiva(defaultMap);
        Point actualLocation = kiva.getCurrentLocation();
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        verifyKivaState("testTurnLeftFromDown",
            kiva, new Point(2, 4), FacingDirection.RIGHT, false, false);
    }
    
   public void testTurnLeftFromRight() {
        Kiva kiva = new Kiva(defaultMap);
        Point actualLocation = kiva.getCurrentLocation();
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        verifyKivaState("testTurnLeftFromRight",
            kiva, new Point(2, 4), FacingDirection.UP, false, false);
    }
    
   public void testForwardWhileFacingLeft() {
       Kiva kiva = new Kiva(defaultMap);
       Point actualLocation = kiva.getCurrentLocation();
       kiva.move(KivaCommand.TURN_LEFT);
       kiva.move(KivaCommand.FORWARD);
       verifyKivaState("testForwardWhileFacingLeft",
           kiva, new Point(1, 4), FacingDirection.LEFT, false, false);
   }
    
   public void testForwardWhileFacingDown() {
       Kiva kiva = new Kiva(defaultMap);
       Point actualLocation = kiva.getCurrentLocation();
       kiva.move(KivaCommand.TURN_LEFT);
       kiva.move(KivaCommand.TURN_LEFT);
       kiva.move(KivaCommand.FORWARD);
       verifyKivaState("testForwardWhileFacingDown",
           kiva, new Point(2, 5), FacingDirection.DOWN, false, false);
   }
   
   public void testForwardWhileFacingRight() {
       Kiva kiva = new Kiva(defaultMap);
       Point actualLocation = kiva.getCurrentLocation();
       kiva.move(KivaCommand.TURN_LEFT);
       kiva.move(KivaCommand.TURN_LEFT);
       kiva.move(KivaCommand.TURN_LEFT);
       kiva.move(KivaCommand.FORWARD);
       verifyKivaState("testForwardWhileFacingRight",
           kiva, new Point(3, 4), FacingDirection.RIGHT, false, false);
   }   
    
   public void testRightFromUp() {
        Kiva kiva = new Kiva(defaultMap);
        Point actualLocation = kiva.getCurrentLocation();
        kiva.move(KivaCommand.TURN_RIGHT);
        verifyKivaState("testRightFromUp",
            kiva, new Point(2, 4), FacingDirection.RIGHT, false, false);
    }
    
   public void testRightFromLeft() {
        Kiva kiva = new Kiva(defaultMap);
        Point actualLocation = kiva.getCurrentLocation();
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_RIGHT);
        verifyKivaState("testRightFromLeft",
            kiva, new Point(2, 4), FacingDirection.UP, false, false);
    } 
    
   public void testRightFromDown() {
        Kiva kiva = new Kiva(defaultMap);
        Point actualLocation = kiva.getCurrentLocation();
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_RIGHT);
        verifyKivaState("testRightFromDown",
            kiva, new Point(2, 4), FacingDirection.LEFT, false, false);
    } 
    
   public void testRightFromRight() {
        Kiva kiva = new Kiva(defaultMap);
        Point actualLocation = kiva.getCurrentLocation();
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.TURN_RIGHT);
        verifyKivaState("testRightFromRight",
            kiva, new Point(2, 4), FacingDirection.DOWN, false, false);
    } 
    
   public void testTakeOnPod() {
        Kiva kiva = new Kiva(defaultMap);
        Point actualLocation = kiva.getCurrentLocation();
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TAKE);
        verifyKivaState("testTakeOnPod",
            kiva, new Point(8, 1), FacingDirection.RIGHT, true, false);
    } 

    public void testDropOnDropZone() {
        Kiva kiva = new Kiva(defaultMap);
        Point actualLocation = kiva.getCurrentLocation();
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TAKE);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.DROP);
        verifyKivaState("testDropOnDropZone",
            kiva, new Point(10, 4), FacingDirection.DOWN, false, true);
    } 
    
   public void testMoveOutOfBounds() {

        Kiva kiva = new Kiva(defaultMap);

        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);

        System.out.println("testMoveOutOfBounds: (expect an IllegalMoveException)");

        System.out.println("testMoveOutOfBounds FAIL!");
        System.out.println("Moved outside the FloorMap!");
    }
    
   public void testObstacle() {

        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        
        System.out.println("testObstacle: (expect an IllegalMoveException)");
                      
        System.out.println("testObstacle FAIL!");
        System.out.println("Moved object!");
    }
    
   //********Can't run since only ony pod on map so can't pick up twice******
   public void testCollision() {

        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TAKE);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TAKE);
        
        System.out.println("testCollision: (expect an IllegalMoveException)");

        System.out.println("testCollision FAIL!");
        System.out.println("Already carrying pod!");
    }
    
   public void testPresenceOfPod() {

        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TAKE);
        
        System.out.println("testPresenceOfPod: (expect a NoPodException)");

        System.out.println("testPresenceOfPod FAIL!");
        System.out.println("No pod in location!");
    }
     
   public void testPresenceOfDropZone() {

        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TAKE);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.DROP);
        
        System.out.println("testPresenceOfDropZone: (expect an IllegalDropZoneException");

        System.out.println("testPresenceOfDropZone FAIL!");
        System.out.println("Dropped pod on empty location!");
    }
    
   public void testEmptyOnDropZone() {

        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.DROP);        
        
        System.out.println("testEmptyOnDropZone: (expect an NoPodException)");
        
        System.out.println("testCarryOnDropZone FAIL!");
        System.out.println("Not carrying pod!");
    }

   private boolean sameLocation(Point a, Point b) {
       return a.getX() == b.getX() && a.getY() == b.getY();
   }

   private void verifyKivaState(
            String testName,
            Kiva actual,
            Point expectLocation,
            FacingDirection expectDirection,
            boolean expectCarry,
            boolean expectDropped) {

        Point actualLocation = actual.getCurrentLocation();
        
       if (sameLocation(actualLocation, expectLocation)) {
            System.out.println(
                    String.format("%s: current location SUCCESS", testName));
       }
       else {
            System.out.println(
                    String.format("%s: current location FAIL!", testName));
            System.out.println(
                    String.format("Expected %s, got %s",
                            expectLocation, actualLocation));
       }

       FacingDirection actualDirection = actual.getDirectionFacing();
       if (actualDirection == expectDirection) {
            System.out.println(
                    String.format("%s: facing direction SUCCESS", testName));
       }
       else {
            System.out.println(
                    String.format("%s: facing direction FAIL!", testName));
            System.out.println(
                    String.format("Expected %s, got %s",
                            expectDirection, actualDirection));
       }

       boolean actualCarry = actual.isCarryingPod();
       if (actualCarry == expectCarry) {
            System.out.println(
                    String.format("%s: carrying pod SUCCESS", testName));
       }
       else {
            System.out.println(
                    String.format("%s: carrying pod FAIL!", testName));
            System.out.println(
                    String.format("Expected %s, got %s",
                            expectCarry, actualCarry));
       }

       boolean actualDropped = actual.isSuccessfullyDropped();
       if (actualDropped == expectDropped) {
            System.out.println(
                    String.format("%s: successfully dropped SUCCESS", testName));
       }
       else {
            System.out.println(
                    String.format("%s: successfully dropped FAIL!", testName));
            System.out.println(
                    String.format("Expected %s, got %s",
                            expectDropped, actualDropped));
       }
    }
}