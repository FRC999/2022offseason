// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.PigeonIMUSubsystem;

public class TurnToAngle extends CommandBase {
  private double TargetAngle;
 
  public TurnToAngle() {
    //TargetAngle=targetdegree;

    
    addRequirements(RobotContainer.pigeonIMUSubsystem, RobotContainer.driveSubsystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.driveSubsystem.configureSimpleMagic();
    //RobotContainer.driveSubsystem.configurePigeon();
    RobotContainer.driveSubsystem.ConfigureTurning();
    RobotContainer.pigeonIMUSubsystem.zeroYaw();
    RobotContainer.driveSubsystem.setTarget();
    //RobotContainer.driveSubsystem.drivePIDTurn(45.0);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("turn to angle ends. Interrupted: " + interrupted);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(RobotContainer.pigeonIMUSubsystem.getYaw() - TargetAngle) <= 1;

  }
}