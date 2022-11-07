// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.PigeonIMUTurningCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.sensors.WPI_PigeonIMU;

public class PigeonSubsystem extends SubsystemBase {
  public DifferentialDrive drive;
  public Joystick imujoystick;
  public SmartDashboard smdashboard;
  double kP;

  public PigeonSubsystem() {
    
  
    talonMotor = new TalonSRX(4);
    double kP=0.2;

    //pigeon gyroscope IMU
    pidgy = new WPI_PigeonIMU(talonMotor);

    //motor values
    motorRight = new WPI_TalonFX(10);
    motorLeft = new WPI_TalonFX(9);
    motorRight.setSafetyEnabled(false);
    motorLeft.setSafetyEnabled(false);

    drive = new DifferentialDrive(motorLeft, motorRight);
    drive.setSafetyEnabled(false);
  }

  //motors and IMU

  public WPI_TalonFX motorLeft;

  public WPI_TalonFX motorRight;

  public WPI_PigeonIMU pidgy;

  public TalonSRX talonMotor;

  //public PigeonIMU pidgy;
  //method for turning
  public void turnMotorWithPigeon(){
    motorLeft.setNeutralMode(NeutralMode.Brake);
    motorRight.setNeutralMode(NeutralMode.Brake);
    double error = 90 - pidgy.getHandle();
    //turns the robot to face the desired direction
    drive.tankDrive(kP * error, -kP * error);
    System.out.print("This method works, somewhat...");
    System.out.print(error);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

//added drive constants; added motion magic things; added part to retrive error
//what to do next: print error into dashboard; turn off using percent output; figure out button bindings
//there are no hardware issues :)