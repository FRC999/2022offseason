// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.SkateBotSubsystem;

public class PIDSlayTurning extends CommandBase {

  //public static SkateBotSubsystem skateBotSubsystem = new SkateBotSubsystem();

  double R_turningtolerance;
  double L_turningtolerance;
  double TurningTolerance = 200;
  
  
  public PIDSlayTurning(double R_inches, double L_inches) {
    addRequirements(RobotContainer.skateBotSubsystem);
    R_turningtolerance = R_inches * (90/Math.PI);
    L_turningtolerance = L_inches * (90/Math.PI);
  }

  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.skateBotSubsystem.zeroEncoders();
    System.out.println("hi Coding, I'm coding");
    RobotContainer.skateBotSubsystem.slayMotionMagic(9577, -13893);
    System.out.println("9577, -13893");
    RobotContainer.skateBotSubsystem.zeroEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (Math.abs((RobotContainer.skateBotSubsystem.motorController1.getSelectedSensorPosition() - R_turningtolerance)) <= TurningTolerance) & ((Math.abs((RobotContainer.skateBotSubsystem.motorController2.getSelectedSensorPosition() - R_turningtolerance)) <= TurningTolerance));
  }
}
