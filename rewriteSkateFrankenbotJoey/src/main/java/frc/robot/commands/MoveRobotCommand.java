// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.SkateBotSubsystem;

public class MoveRobotCommand extends CommandBase {

  public MoveRobotCommand() {
    addRequirements(RobotContainer.skateBotSubsystem);
  }

  @Override
  public void initialize() {}



  @Override
  public void execute() {
    //double move = RobotContainer.driveStick.getY() * (-1);
    //double turn = RobotContainer.driveStick.getX();

    double move = RobotContainer.driveStick.getX();
    double turn = RobotContainer.driveStick.getY() * (-1);

    RobotContainer.skateBotSubsystem.arcadeDriving(move, turn);
  }



  @Override
  public void end(boolean interrupted) {}



  @Override
  public boolean isFinished() {
    return false;
  }
}
