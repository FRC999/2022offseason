// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.WPI_PigeonIMU;

public class PidgeonIMUSubsystem extends SubsystemBase {

  TalonSRX talon;
  WPI_PigeonIMU gyro;
  WPI_TalonFX rightMotor;
  WPI_TalonFX leftMotor;
  DifferentialDrive drive;
  double kP = 0.05;

  /** Creates a new ExampleSubsystem. */
  public PidgeonIMUSubsystem() {
    talon = new TalonSRX(2);
    gyro = new WPI_PigeonIMU(talon);

    rightMotor = new WPI_TalonFX(1);
    leftMotor = new WPI_TalonFX(2);
    rightMotor.setInverted(true);
    rightMotor.setSafetyEnabled(false);
    leftMotor.setSafetyEnabled(false);

    drive = new DifferentialDrive(leftMotor, rightMotor);
    drive.setSafetyEnabled(false);
  }
  
  public void turnToAngle() {
    // This method will be called once per scheduler run
    rightMotor.setNeutralMode(NeutralMode.Brake);
    leftMotor.setNeutralMode(NeutralMode.Brake);
    //finding the heading error
    double error = 90 - gyro.getAngle();

    //turns the robot to face the desired direction
    drive.tankDrive(kP * error, -kP * error);
    System.out.print("This line runs");
  }

  @Override
  public void periodic() {
    
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation

  }
}
