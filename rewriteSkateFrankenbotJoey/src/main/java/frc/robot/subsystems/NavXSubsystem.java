// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

public class NavXSubsystem extends SubsystemBase {
  AHRS ahrs;
  /** Creates a new NavXSubsystem. */
  public NavXSubsystem() {
    ahrs = new AHRS(SPI.Port.kMXP); 
  }
  public double getHeading() {
    return ahrs.getYaw();
  }

  public void zeroHeading(){
    ahrs.zeroYaw(); 
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
