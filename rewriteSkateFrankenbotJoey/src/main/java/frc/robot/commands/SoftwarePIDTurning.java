// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.NavXSubsystem;
import frc.robot.subsystems.SkateBotSubsystem;


public class SoftwarePIDTurning extends PIDCommand {
  /** Creates a new SoftwarePIDTurning. */
  
  public SoftwarePIDTurning(double targetAngleDegrees, NavXSubsystem NavX) {
    super(
      new PIDController(0.75,0.00,0.00),
      NavX::getHeading,
      targetAngleDegrees,
      output -> NavX.arcadeDrive(0, output),
      NavX);
      
    
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
