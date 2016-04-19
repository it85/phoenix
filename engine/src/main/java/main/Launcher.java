package main;

import control.PhoenixStateControl;

/**
 * Prepares the Phoenix analytics platform for execution by setting up configuration and initializing the various modules
 * in the platform, e.g. trader, marketfeed, etc.
 */
public class Launcher {

    private PhoenixStateControl phoenixStateControl;

    public void configure(){
        this.phoenixStateControl = new PhoenixStateControl();
    }

    public void run(){
        phoenixStateControl.run();
    }
}
