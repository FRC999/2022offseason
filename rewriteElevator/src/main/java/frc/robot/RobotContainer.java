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
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.SmartDashboardSubsystem;




public class RobotContainer {

private static final String m_port = null;
public static Joystick driveStick;
public static final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
public static final SmartDashboardSubsystem smartDashboardSubsystem = new SmartDashboardSubsystem();


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
    .whileActiveContinuous(new InstantCommand(elevatorSubsystem::elevatorMotorForward))
    .whenInactive(new InstantCommand(elevatorSubsystem::stopMotor));
    
    new JoystickButton(driveStick, 12)
    .whileActiveContinuous(new InstantCommand(elevatorSubsystem::elevatorMotorReverse))
    .whenInactive(new InstantCommand(elevatorSubsystem::stopMotor));
  }


}

