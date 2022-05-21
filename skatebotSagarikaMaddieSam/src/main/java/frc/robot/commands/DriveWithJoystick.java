// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class DriveWithJoystick extends CommandBase {
  /** Creates a new DriveWithJoystick. */
  public DriveWithJoystick() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.skateBotSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //RobotContainer.skateBotSubsystem.setNeutralMode(NeutralMode.Brake);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double move = RobotContainer.sagarikaJoystick.getY() * (-1);
    double turn = RobotContainer.sagarikaJoystick.getX();
    RobotContainer.skateBotSubsystem.driveWithJoystick(move, turn);
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
