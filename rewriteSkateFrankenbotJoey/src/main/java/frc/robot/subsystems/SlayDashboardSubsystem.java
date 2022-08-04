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

    System.out.println("TEST SD1");
    
    updateEncoders();
  }

  public void updateAllDisplays(){
    updateEncoders();
  }

  public void updateEncoders(){

    System.out.println("TEST SD0");

    SmartDashboard.putNumber("left encoder", RobotContainer.skateBotSubsystem.getMotor1Encoder());
    SmartDashboard.putNumber("right encoder", RobotContainer.skateBotSubsystem.getMotor2Encoder());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    updateAllDisplays();
  }
}
