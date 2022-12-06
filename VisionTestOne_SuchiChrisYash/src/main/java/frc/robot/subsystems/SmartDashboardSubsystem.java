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

  public void updateAllDisplays() {
    updateCamaraValues();
    updatePhoenixValues();
  }

  public void updatePhoenixValues (){
    SmartDashboard.putString("x and y angles of target", RobotContainer.photoVision.getYawPitch());
  }
  public void updateCamaraValues() {
    SmartDashboard.putBoolean("Photon Vision Camera Visible", RobotContainer.networkTables.isVisible());
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    updateAllDisplays(); // update
  }
}
