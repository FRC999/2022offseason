// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.MoveRobotCommand;
import frc.robot.subsystems.SkateBotSubsystem;



public class RobotContainer {

  private static final String m_port = null;
  public static Joystick driveStick;
  public static SkateBotSubsystem skateBotSubsystem = new SkateBotSubsystem();


  public RobotContainer() {
    // Configure the button bindings
    configureDriverInterface();
    //skateBotSubsystem.setDefaultCommand(new MoveRobotCommand());
    System.out.println("*** RC");
    //skateBotSubsystem.moveRobot();
    skateBotSubsystem.setDefaultCommand(new MoveRobotCommand());
    System.out.println("*** RC1");
  }

  private void configureDriverInterface(){
    driveStick = new Joystick(0);
  }
  


}

