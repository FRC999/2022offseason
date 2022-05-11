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
import frc.robot.subsystems.ElevatorCode;




public class RobotContainer {

private static final String m_port = null;
public static Joystick driveStick;
public static final ElevatorCode elevatorCode = new ElevatorCode();

  public RobotContainer() {
    // Configure the button bindings
    configureDriverInterface();
    configureButtonBindings();
  }

  private void configureDriverInterface(){
    driveStick = new Joystick(0);
  }

  private void configureButtonBindings() {
    new JoystickButton(driveStick, 11)
    .whenPressed(new InstantCommand(elevatorCode::forwardMotor))
    .whenReleased(new InstantCommand(elevatorCode::stopMotor));

    new JoystickButton(driveStick, 12)
    .whenPressed(new InstantCommand(elevatorCode::reverseMotor))
    .whenReleased(new InstantCommand(elevatorCode::stopMotor));
    
    Trigger z1 = new Trigger(() -> returnZ());
    z1.whileActiveContinuous(new PrintCommand("kanye for prez 2026"));

    //Trigger hat = new Trigger(() -> returnHat());
    //hat.whenActive(new PrintCommand("x gon give it to ya"));
  }


  // return whether or not the z axis is at 1 (boolean)
  private boolean returnZ() {
    if (driveStick.getRawAxis(3) == 1.0) 
      return true;
    else
      return false;
  }

  /*
  private boolean returnHat(){
    System.out.println(driveStick.getTop());
    if (driveStick.getRawAxis(0) != -1) 
      return true;
    else
      return false;
    } 
    */

}

