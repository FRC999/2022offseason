// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class SkateBotSubsystem extends SubsystemBase {
  public WPI_TalonFX  leftMotor = new WPI_TalonFX(3); 
  public WPI_TalonFX  leftMotorFollower = new WPI_TalonFX(4); 
  public WPI_TalonFX  rightMotor = new WPI_TalonFX(1);
  public WPI_TalonFX  rightMotorFollower = new WPI_TalonFX(2);
  DifferentialDrive drive = new DifferentialDrive(leftMotor, rightMotor); 

  /** Creates a new SkateBotSubsystem. */
  public SkateBotSubsystem() {
    leftMotorFollower.follow(leftMotor);
    rightMotorFollower.follow(rightMotor);
    leftMotor.setNeutralMode(NeutralMode.Brake); 
    rightMotor.setNeutralMode(NeutralMode.Brake); 
  }

  public void driveWithJoystick(double move, double turn) {
    // Arcade drive with a given forward and turn rate
    drive.arcadeDrive(turn, move);
} 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
