import edu.duke.FileResource;
import java.util.Arrays;

/**
 * RemoteControl is the main class that will run the Kiva object. It takes in 
 * a user generated String and converts it into an array of KivaCommands that 
 * dictate the actions of the Kiva robot. 
 * @author Kevin Phan
 * @version 4/5/21
 */

public class RemoteControl {    
    /**
     * 
     * Used as input for user generated commands. 
     */
    KeyboardResource keyboardResource;
    
    /**
     * Prompts user to input a String of commands that move Kiva object around map.
     */

    public RemoteControl() {
        keyboardResource = new KeyboardResource();
    }

    /**
     * The controller that directs Kiva's activity.Prompts the user for the floor map
     * to load, displays the map, and prompts the user to provide commands that Kiva will execute.
     *
     */
    public void run() {
        System.out.println("Please select a map file.");
        FileResource fileResource = new FileResource();
        String inputMap = fileResource.asString();
        FloorMap floorMap = new FloorMap(inputMap);
        System.out.println(floorMap);
        Kiva kiva = new Kiva(floorMap);

        System.out.println("Please enter the directions for the Kiva Robot to take.");
        String directions = keyboardResource.getLine();
        System.out.println("Directions that you typed in: " + directions);
        
        final KivaCommand[] commands = convertToKivaCommands(directions);
        
        for (KivaCommand command : commands) {
        kiva.move(command);        
        }
        
        if ((kiva.isSuccessfullyDropped() == true) && (directions.charAt(directions.length() - 1) == 'D')) {       
            System.out.println("Successfully picked up the pod and dropped it off. Thank you!");            
        } else {           
            System.out.println("I'm sorry. The Kiva Robot did not pick up the pod and then drop it off in the right place.");            
        }  
    }
    
    /**
     * Test to ensure user inputs accurately convert to KivaCommand values.
     */
    public void RemoteControlTest(String s) {
        convertToKivaCommands(s);         
    }
    
    /**
     * Converts String of characters into KivaCommands that get appended into an array
     * in order for move() method to be called on Kiva object.
     * @param commandString Takes in String of characters user inputs.
     */
       
    private KivaCommand[] convertToKivaCommands(String commandString) {
    
        KivaCommand[] commands = new KivaCommand[commandString.length()];              
        
        for (int x = 0; x < commandString.length(); x++) {
            
         for (KivaCommand value : KivaCommand.values()) {            
          
            char directionKey = value.getDirectionKey();                                   
            
            if (commandString.charAt(x) == directionKey) {
                commands[x] = value;               
                break;
            }                              
        }
        
        if (commands[x] == null) {
        throw new IllegalArgumentException(String.format("Character %s does not correspond to a command!", commandString)); 
        }

    }
    
    System.out.println(Arrays.toString(commands));  
    
    return commands;
    }
}
