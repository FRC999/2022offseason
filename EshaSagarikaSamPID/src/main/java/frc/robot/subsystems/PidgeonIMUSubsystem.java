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
  WPI_TalonFX rightMotorMaster;
  WPI_TalonFX leftMotorMaster;
  WPI_TalonFX rightMotorFollower;
  WPI_TalonFX leftMotorFollower;
  DifferentialDrive drive;
  double kP = 0.02;

  /** Creates a new ExampleSubsystem. */

  public PidgeonIMUSubsystem() {
    talon = new TalonSRX(5);
    gyro = new WPI_PigeonIMU(talon);

    rightMotorMaster = new WPI_TalonFX(1);
    rightMotorFollower = new WPI_TalonFX(2);
    leftMotorMaster = new WPI_TalonFX(3);
    leftMotorFollower = new WPI_TalonFX(4);

    rightMotorFollower.follow(rightMotorMaster);
    leftMotorFollower.follow(leftMotorMaster);

    rightMotorMaster.setNeutralMode(NeutralMode.Brake);
    leftMotorMaster.setNeutralMode(NeutralMode.Brake);

    rightMotorMaster.setSafetyEnabled(false);
    leftMotorMaster.setSafetyEnabled(false);

    //leftMotorMaster.setInverted(true);
    drive = new DifferentialDrive(leftMotorMaster, rightMotorMaster);
    drive.setSafetyEnabled(false);
  }
  
  
    public void turnToAngle() {
      // This method will be called once per scheduler run
      
      //finding the heading error
      double error = 90 - gyro.getAngle();

      //turns the robot to face the desired direction
      drive.tankDrive(kP * error * 0.1, kP * error * 0.1);
      System.out.print("This line still runs");
      System.out.print(gyro.getAngle());
      
    }

    public void manualDrive(double move, double turn) {
      
      // If joysticks will prove to be too sensitive near the center, turn on the deadband driving
      
      // drive.arcadeDrive(deadbandMove(move), deadbandTurn(turn));
      // System.out.println("D X "+move + " Y " + turn);
      drive.arcadeDrive(move, turn);
    }
  

  @Override
  public void periodic() {
    
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation

  }
}
