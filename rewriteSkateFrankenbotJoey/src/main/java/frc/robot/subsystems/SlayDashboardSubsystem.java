// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;


public class SlayDashboardSubsystem extends SubsystemBase {
  /** Creates a new SmartDashboard. */
  public SlayDashboardSubsystem() {    
  }

  public void updateAllDisplays(){
    updateEncoders();
    updateNavxValues();
  }

  public void updateEncoders(){
    SmartDashboard.putNumber("left encoder", RobotContainer.skateBotSubsystem.getMotor1Encoder());
    SmartDashboard.putNumber("right encoder", RobotContainer.skateBotSubsystem.getMotor2Encoder());
    SmartDashboard.putNumber("left error", RobotContainer.skateBotSubsystem.getDriveError(1));
    SmartDashboard.putNumber("right error", RobotContainer.skateBotSubsystem.getDriveError(2));

  }

  public void updateNavxValues(){
    SmartDashboard.putNumber("Heading", RobotContainer.NavX.getHeading());
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    updateAllDisplays();
  }
}
