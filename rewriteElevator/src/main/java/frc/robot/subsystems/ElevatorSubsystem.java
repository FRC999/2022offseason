// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ElevatorSubsystem extends SubsystemBase {

  public WPI_TalonFX climberMotorController1;
  public WPI_TalonFX climberMotorController2;
  
  public ElevatorSubsystem() {
    climberMotorController1 = new WPI_TalonFX(1);
    climberMotorController2 = new WPI_TalonFX(2);
    climberMotorController2.follow(climberMotorController1);
    climberMotorController2.setNeutralMode(NeutralMode.Brake);
    climberMotorController2.setInverted(true);
    configureEncoders();
    zeroEncoders();

  }


  public void elevatorMotorForward() {
    if(getMotor1Encoder()<20000){
      climberMotorController1.setNeutralMode(NeutralMode.Brake);
      climberMotorController1.set(ControlMode.PercentOutput, 0.1);
    }
    else
      stopMotor();
  }

  public void elevatorMotorReverse() {
    if(getMotor1Encoder()>0){
      climberMotorController1.setNeutralMode(NeutralMode.Brake);
      climberMotorController1.set(ControlMode.PercentOutput, -0.1);
    }
    else
      stopMotor();
  }

  public void stopMotor() {
    climberMotorController1.set(ControlMode.PercentOutput, 0);
  }

  public void configureEncoders(){
    climberMotorController1.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);
    climberMotorController2.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);
  }

  public void zeroEncoders(){
    climberMotorController1.setSelectedSensorPosition(0);
    climberMotorController2.setSelectedSensorPosition(0);
  }

  public int getMotor1Encoder(){
    return (int) climberMotorController1.getSelectedSensorPosition();
  }

  public int getMotor2Encoder(){
    return (int) climberMotorController2.getSelectedSensorPosition();
  }


  @Override
  public void periodic() {
  }
}
