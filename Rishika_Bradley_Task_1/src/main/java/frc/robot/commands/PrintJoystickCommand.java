// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
//do something when you release the button

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class PrintJoystickCommand extends CommandBase {
  /** Creates a new PrintJoystickCommand. */
  public PrintJoystickCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    System.out.println("PrintCommand Constructor");
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Button 12 has been pressed.");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
