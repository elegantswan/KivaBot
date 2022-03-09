
/**
 * Enum that contains 5 possible actions for a Kiva robot to perform: move forward, left, right, take, or drop a pod.
 * These values are specified by the user and enable the robot to 
 * move around the map.
 * @author Kevin Phan
 * @version 4/5/2021
 */

public enum KivaCommand {
    
    /**
     * Moves Kiva object one unit on either the x or y axis depending on direction Kiva is facing.
     * @return Forward movement Kiva will execute.  
     */
    
    FORWARD('F'),
    
    /**
     * Turns Kiva object 90 degrees counter-clockwise.
     * @return TURN_LEFT movement Kiva will execute.
     */
    
    TURN_LEFT('L'),
    
    /**
     * Turns Kiva object 90 degrees clockwise.
     * @return TURN_RIGHT movement Kiva will execute.
     * 
     */
    
    TURN_RIGHT('R'),
    
    /**
     * Kiva object will take pod if current space contains pod.
     * @return TAKE command that Kiva will execute.
     */
    
    TAKE('T'),
    
    /**
     * Kiva object will drop pod if current space is a valid drop zone.
     * @return DROP command that Kiva will execute.
     */
    
    DROP('D');

    private char directionKey;
    
    /**
     * Allows user to call individual enum.
     * @param directionKey This is the key to one of 5 enum values. 
     */
    private KivaCommand(char directionKey) {
        this.directionKey = directionKey;
    }
        
    /**
     * Returns directionKey value that user specified.
     * @return directionKey value.
     */
    public char getDirectionKey() {
        return directionKey;
    }
}