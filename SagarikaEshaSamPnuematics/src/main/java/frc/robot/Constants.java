// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static enum RobotModel {
        FRANKENBOT, DEMOBOARD, C2022
    }

    public static final class PneumaticsConstants {

        public static int compressorCANID;

        // index 0 is forward channel
        // index 1 is reverse channel
        public static int[] SolenoidChannel ;
    }

    //public static final String RobotModel = null; 

    public static final class RobotProperties { // configure the type of robot here, such as presence/absence of a
        // device, device type etc

public static boolean robotLogging = true; // if set to TRUE, enable logging to the USB stick via
           // SimpleCSVLogging

/**
* Robot Types: FRANKENBOT (2 falcons, pneumatics, Navx) Demo Board (2 falcons,
* no pneumatics, Pigeon)
*/

public static RobotModel robotModel = RobotModel.DEMOBOARD; // This setting must be set properly !!! It
                                  // controls the rest of the setup


public static boolean isNaVX;
public static boolean isPneumatics;
public static boolean isShooter;
public static boolean isClimber;
public static boolean isTEMPShooterTest;
public static boolean isPotentiometer;
public static boolean isColorSensor;
public static boolean isCANdle;
public static boolean isIntake;
public static boolean isTestMotor;
public static boolean isHopperSensor; // disable hopper color sensor as suspect in RIO lockups

}

}


