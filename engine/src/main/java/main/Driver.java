package main;

/**
 * The entry point for the Phoenix analytics engine. Driver uses 'Launcher' to set up our desired platform configurations
 * and then begins program execution.
 */
public class Driver {

    public static void main(String[] args){

        Launcher launcher = new Launcher();
        launcher.configure();
        launcher.initialize();
        launcher.run();

    }
}
