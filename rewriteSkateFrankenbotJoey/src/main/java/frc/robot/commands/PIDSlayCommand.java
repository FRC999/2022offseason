// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SkateBotSubsystem;


public class PIDSlayCommand extends CommandBase {
  
  public static SkateBotSubsystem skateBotSubsystem = new SkateBotSubsystem();

  double yourmom;
  double yourMomsTolerance = 2 * (90/Math.PI);

  public PIDSlayCommand(double inches) {
    yourmom = inches * (90/Math.PI);
  }

  @Override
  public void initialize() {
    skateBotSubsystem.zeroEncoders();
    System.out.println("hi coding im dad");
    skateBotSubsystem.slayMotionMagic(0.75, 0.75);
  }

  @Override
  public void execute() {
  }


  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return Math.abs((skateBotSubsystem.motorController1.getSelectedSensorPosition() - yourmom)) <= yourMomsTolerance;
  }
}

