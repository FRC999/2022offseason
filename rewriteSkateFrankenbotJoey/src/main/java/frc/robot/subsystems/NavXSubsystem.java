// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import com.kauailabs.navx.frc.AHRS;

public class NavXSubsystem extends SubsystemBase {
  AHRS ahrs;
  /** Creates a new NavXSubsystem. */
  public NavXSubsystem() {
  }
  public double getRobotHeading(){
    if (ahrs.isConnected()){
      return RobotContainer.NavX.getHeading();
    } else {
      return 0;
    }
  }

  public double getHeading() {
    return this.ahrs.getYaw();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public Object arcadeDrive(int i, double output) {
    return null;
  }
}
