// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class AutoDriveTenFeet extends CommandBase {
  /** Creates a new AutoDriveTenFeet. */
  public AutoDriveTenFeet() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.driveSubsystem.configureSimpleMagic();
    RobotContainer.driveSubsystem.zeroEncoders();
    RobotContainer.driveSubsystem.drivePIDLinear(10*12);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //RobotContainer.driveSubsystem.drivePIDLinear(10*12);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //RobotContainer.driveSubsystem.stopRobot();
    System.out.println("Auto Drive Ends. Interrupted: " + interrupted);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    return 
       Math.abs(RobotContainer.driveSubsystem.getLeftEncoder() - RobotContainer.driveSubsystem.tickPerInch*120) <= RobotContainer.driveSubsystem.tolerance ||
       Math.abs(RobotContainer.driveSubsystem.getRightEncoder() - RobotContainer.driveSubsystem.tickPerInch*120) <= RobotContainer.driveSubsystem.tolerance;
  }
}
