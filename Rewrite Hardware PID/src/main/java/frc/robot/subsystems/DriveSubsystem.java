// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import javax.swing.text.AbstractDocument.LeafElement;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {

  WPI_TalonFX leftmotor = new WPI_TalonFX(9);
  WPI_TalonFX rightmotor = new WPI_TalonFX(10);
  public DifferentialDrive drive;

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    leftmotor.setNeutralMode(NeutralMode.Brake);
    rightmotor.setNeutralMode(NeutralMode.Brake);
    configureEncoders();
    //configureSimpleMagic();
    zeroEncoders();
    drive = new DifferentialDrive(leftmotor, rightmotor);
    drive.setSafetyEnabled(false);
  }

  public void arcadeDriving(double move, double turn){
    drive.arcadeDrive(move, turn);
  }

   /** Get the number of tics moved by the left encoder */
   public int getLeftEncoder() {
    return (int) leftmotor.getSelectedSensorPosition();
  }

  /** Get the number of tics moved by the left encoder */
  public int getRightEncoder() {
    return (int) rightmotor.getSelectedSensorPosition();
  }

  public double getLeftError() {
    return leftmotor.getClosedLoopError();// Returns the PID error for Pan motion control;
  }

  public double getRightError() {
    return rightmotor.getClosedLoopError();
  }

  public void zeroEncoders(){
    leftmotor.setSelectedSensorPosition(0);
    rightmotor.setSelectedSensorPosition(0);
    System.out.println("encoders zeroed");
  }

  public void configureEncoders(){
    leftmotor.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);
    rightmotor.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);
  }


  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
