// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class SmartDashboardSubsystem extends SubsystemBase {
  /** Creates a new SmartDashboardSubsystem. */
  public SmartDashboardSubsystem() {}

  void updateEncoders() {
    SmartDashboard.putNumber("Left Encoder Value", RobotContainer.driveSubsystem.getLeftEncoder());
    SmartDashboard.putNumber("Right Encoder Value", RobotContainer.driveSubsystem.getRightEncoder());
    SmartDashboard.putNumber("Left Motor Error", RobotContainer.driveSubsystem.getLeftError());
    SmartDashboard.putNumber("Right Motor Error", RobotContainer.driveSubsystem.getRightError());
  }

  void updatePigeon() {
    /*SmartDashboard.putNumber("Pitch value", RobotContainer.pigeonIMU.getPitch());
    SmartDashboard.putNumber("Roll value", RobotContainer.pigeonIMU.getRoll());
    SmartDashboard.putNumber("Yaw value", RobotContainer.pigeonIMU.getYaw());
    */
    SmartDashboard.putString("IMU-Y-P-R",
        String.format("%12.6f", RobotContainer.pigeonIMU.getYaw()) + "  "
            + String.format("%12.6f", RobotContainer.pigeonIMU.getPitch()) + "  "
            + String.format("%12.6f", RobotContainer.pigeonIMU.getRoll()));

  }
  
  void updateAllDisplays() {
    updateEncoders();
    updatePigeon();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    updateAllDisplays();
  }
}
