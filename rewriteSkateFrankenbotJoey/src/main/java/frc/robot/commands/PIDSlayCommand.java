// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SkateBotSubsystem;


public class PIDSlayCommand extends CommandBase {
  
  public static SkateBotSubsystem skateBotSubsystem = new SkateBotSubsystem();

  double yourmom;
  int yourMomsTolerance = 2;

  public PIDSlayCommand(double inches) {
    yourmom = inches;
  }

  @Override
  public void initialize() {
    skateBotSubsystem.zeroEncoders();
    //skateBotSubsystem.slayMotionMagic()
  }

  @Override
  public void execute() {
  }


  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return true;
    //return Math.abs((getDriveEncoderTicks() - yourmom)) <= yourMomsTolerance;
  }
}

//put down 10 feet in tape and then put it on smartdashboard for ticks to find the manual