// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class DriveManually extends CommandBase {
  double move = 0;
  double turn = 0; 

  /** Creates a new DriveManually. */
  public DriveManually() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.PidgeonIMUSubsystem);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    move = RobotContainer.driveJoystick.getY() * (-1);
    turn = RobotContainer.driveJoystick.getX();

    //RobotContainer.PidgeonIMUSubsystem.manualDrive(move, turn);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;

  }
}
