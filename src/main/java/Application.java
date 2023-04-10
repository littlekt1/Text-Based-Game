import java.util.Collections;
import java.util.Scanner;

public class Application {

    public static Scanner scanner = new Scanner(System.in);
    public static Player player = new Player("");

    public static void main(String[] args) {
        run();
    }
    public static void run (){
//        while(!gameover// player is alive), move player
        startGame();
        createPlayer();

//        Opening.runOpening(player);
//        FifthFloor.runFifthFloor(player); // Adds the player object to the fifth floor
//        one run method(interface) that applies to all the different superclass-floors
//        the run method itself will contain a check for whether the player is alive
    //    System.out.println(Opening.player.getName());
    }
    public void floors() {
       // Opening opening = new Opening();
    }
    //methods
    public static void startGame() {
        System.out.println(" \n".repeat(50)); // getting it to clear the console 50 lines
        //System.out.print("\033[H\033[2J");
        //System.out.flush();

    }

    public static void createPlayer() {
        int strengthCount = 1;
        int dexterityCount = 1;
        int intelligenceCount = 1;
        //this is setting the player name
        System.out.println("Enter your name: ");
        String playerName = scanner.nextLine();
        player.setName(playerName);
        //Questions to set player stats based on responses
        System.out.println("Someone insults you. What do you do? ");
        System.out.println("[1] Beat their face in with a rock. "); // Strength
        System.out.println("[2] Insult them back. "); // dexterity
        System.out.println("[3] Strike up a counter argument about why William Shakespeare is the real villain behind modern illiteracy. "); //Intelligence


        int userInput = Controller.pickOption(3);
        if (userInput == 1) {
            strengthCount++;
        }
        if (userInput == 2) {
            dexterityCount++;
        }
        if (userInput == 3) {
            intelligenceCount++;
        }
        System.out.println("What do you value most?");
        System.out.println("[1] Power"); // Strength
        System.out.println("[2] Wealth"); // Dexterity
        System.out.println("[3] Wisdom"); // Intelligence
        userInput = Controller.pickOption(3);

        if (userInput == 1) {
            strengthCount++;
        }
        if (userInput == 2) {
            dexterityCount++;
        }
        if (userInput == 3) {
            intelligenceCount++;
        }

        System.out.println("You're trapped in a blocked off cave after a horrific caving experience with several other cavers. What is your next step?");
        System.out.println("[1] You start throwing the rocks out of the way to clear a path."); // Strength
        System.out.println("[2] You explore the cave to find another potential exit."); // Dexterity
        System.out.println("[3] You convince the others to dig a way out while you manage their efforts."); // Intelligence
        userInput = Controller.pickOption(3);

        if (userInput == 1) {
            strengthCount++;
        }
        if (userInput == 2) {
            dexterityCount++;
        }
        if (userInput == 3) {
            intelligenceCount++;
        }

        System.out.println("What fictional character do you most identify with? ");
        System.out.println("[1] Maximus from Gladiator"); // Strength
        System.out.println("[2] Legolas from Lord of the Rings"); // Dexterity
        System.out.println("[3] Morpheus from The Matrix Revolutions"); // Intelligence
        userInput = Controller.pickOption(3);

        if (userInput == 1) {
            strengthCount++;
        }
        if (userInput == 2) {
            dexterityCount++;
        }
        if (userInput == 3) {
            intelligenceCount++;
        }
        player.setStrength(strengthCount);
        player.setDexterity(dexterityCount);
        player.setIntelligence(intelligenceCount);
        player.getWeapons().clear();
        while(true) {
            Controller.move(player);
        }
    }
    public static void deadEnd() {
        System.out.println("Game Over \n" +
                "Would you like to start again?");
        System.out.println("[1] Yes");
        System.out.println("[2] No");
        int userInput = Controller.pickOption(2);
        if (userInput==1) {
//            Clear player inventory/data and start fresh
            run();
        }
        else {
            System.out.println("Thanks for playing! ");
            System.exit(0);
        }

    }

}
//    <?xml version="1.0" encoding="UTF-8"?>
//<project version="4">
//<component name="AutoImportSettings">
//<option name="autoReloadType" value="SELECTIVE" />
//</component>
//<component name="ChangeListManager">
//<list default="true" id="a739b289-48ee-491d-bd5c-50d321b35e93" name="Changes" comment="" />
//<list default="true" id="18a0f9e6-4edb-4e24-8fd2-10f9003b5191" name="Changes" comment="">
//<change afterPath="$PROJECT_DIR$/.idea/vcs.xml" afterDir="false" />
//<change beforePath="$PROJECT_DIR$/.idea/workspace.xml" beforeDir="false" afterPath="$PROJECT_DIR$/.idea/workspace.xml" afterDir="false" />
//<change beforePath="$PROJECT_DIR$/src/main/java/Application.java" beforeDir="false" afterPath="$PROJECT_DIR$/src/main/java/Application.java" afterDir="false" />
//<change beforePath="$PROJECT_DIR$/src/main/java/KeyItems.java" beforeDir="false" afterPath="$PROJECT_DIR$/src/main/java/KeyItems.java" afterDir="false" />
//</list>
//<option name="SHOW_DIALOG" value="false" />
//<option name="HIGHLIGHT_CONFLICTS" value="true" />
//<option name="HIGHLIGHT_NON_ACTIVE_CHANGELIST" value="false" />
//<option name="LAST_RESOLUTION" value="IGNORE" />
//</component>
//<component name="FileTemplateManagerImpl">
//<option name="RECENT_TEMPLATES">
//<list>
//<option value="Class" />
//</list>
//</option>
//</component>
//<component name="Git.Settings">
//<option name="RECENT_GIT_ROOT_PATH" value="$PROJECT_DIR$" />
//</component>
//<component name="MarkdownSettingsMigration">
//<option name="stateVersion" value="1" />
//</component>
//<component name="ProjectId" id="2Nbktw7U9ifwptQnpdphsnMkf2B" />
//<component name="MavenImportPreferences">
//<option name="generalSettings">
//<MavenGeneralSettings>
//<option name="useMavenConfig" value="true" />
//</MavenGeneralSettings>
//</option>
//</component>
//<component name="ProjectId" id="2NVk1UrOQTydCM495zrkdvAVYeK" />
//<component name="ProjectViewState">
//<option name="hideEmptyMiddlePackages" value="true" />
//<option name="showLibraryContents" value="true" />
//</component>
//<component name="PropertiesComponent">
//<property name="RunOnceActivity.OpenProjectViewOnStart" value="true" />
//<property name="RunOnceActivity.ShowReadmeOnStart" value="true" />
//<property name="last_opened_file_path" value="$PROJECT_DIR$/../../kevin-little-student-code/17_File_IO_Writing/exercise/pom.xml" />
//<property name="settings.editor.selected.configurable" value="preferences.updates" />
//</component>
//<component name="RunManager" selected="Application.Application">
//<configuration name="Application" type="Application" factoryName="Application" temporary="true" nameIsGenerated="true">
//<option name="MAIN_CLASS_NAME" value="Application" />
//<module name="Text-Based-Game" />
//<method v="2">
//<option name="Make" enabled="true" />
//</method>
//</configuration>
//<configuration name="OpeningTest" type="Application" factoryName="Application" temporary="true" nameIsGenerated="true">
//<option name="MAIN_CLASS_NAME" value="OpeningTest" />
//<module name="Zombie Game" />
//<method v="2">
//<option name="Make" enabled="true" />
//</method>
//</configuration>
//<configuration name="RNG" type="Application" factoryName="Application" temporary="true" nameIsGenerated="true">
//<option name="MAIN_CLASS_NAME" value="RNG" />
//<configuration name="ZombieTest" type="Application" factoryName="Application" temporary="true" nameIsGenerated="true">
//<option name="MAIN_CLASS_NAME" value="ZombieTest" />
//<module name="Zombie Game" />
//<method v="2">
//<option name="Make" enabled="true" />
//</method>
//</configuration>
//<recent_temporary>
//<list>
//<item itemvalue="Application.Application" />
//<item itemvalue="Application.OpeningTest" />
//<item itemvalue="Application.RNG" />
//<item itemvalue="Application.ZombieGame" />
//<item itemvalue="Application.ZombieTest" />
//</list>
//</recent_temporary>
//</component>
//<component name="SpellCheckerSettings" RuntimeDictionaries="0" Folders="0" CustomDictionaries="0" DefaultDictionary="application-level" UseSingleDictionary="true" transferred="true" />
//<component name="TaskManager">
//<task active="true" id="Default" summary="Default task">
//<changelist id="a739b289-48ee-491d-bd5c-50d321b35e93" name="Changes" comment="" />
//<created>1679940388166</created>
//<option name="number" value="Default" />
//<option name="presentableId" value="Default" />
//<updated>1679940388166</updated>
//</task>
//<servers />
//</component>
//<component name="XDebuggerManager">
//<breakpoint-manager>
//<breakpoints>
//<line-breakpoint enabled="true" type="java-line">
//<url>file://$PROJECT_DIR$/src/main/java/Application.java</url>
//<line>47</line>
//<option name="timeStamp" value="1" />
//</line-breakpoint>
//</breakpoints>
//</breakpoint-manager>
//</component>
//</project>