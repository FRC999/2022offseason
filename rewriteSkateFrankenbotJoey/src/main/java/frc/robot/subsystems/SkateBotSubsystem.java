// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;


public class SkateBotSubsystem extends SubsystemBase {

  public WPI_TalonFX motorController1;
  public WPI_TalonFX motorController2;
  
  public SkateBotSubsystem() {
    motorController1 = new WPI_TalonFX(9);
    motorController2 = new WPI_TalonFX(10);
    motorController2.follow(motorController1);
    motorController2.setNeutralMode(NeutralMode.Brake);
    configureEncoders();
    zeroEncoders();
  }


  public void motorForward() {
    if(getMotor1Encoder()<20000){
      motorController1.setNeutralMode(NeutralMode.Brake);
      motorController1.set(ControlMode.PercentOutput, 0.1);
    }
    else
      stopMotor();
  }

  public void motorReverse() {
    if(getMotor1Encoder()>0){
      motorController1.setNeutralMode(NeutralMode.Brake);
      motorController1.set(ControlMode.PercentOutput, -0.1);
    }
    else
      stopMotor();
  }

  public void stopMotor() {
    motorController1.set(ControlMode.PercentOutput, 0);
  }

  public void configureEncoders(){
    motorController1.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);
    motorController2.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);
  }

  public void zeroEncoders(){
    motorController1.setSelectedSensorPosition(0);
    motorController2.setSelectedSensorPosition(0);
  }

  public int getMotor1Encoder(){
    return (int) motorController1.getSelectedSensorPosition();
  }

  public int getMotor2Encoder(){
    return (int) motorController2.getSelectedSensorPosition();
  }

//-------------------------------------------------------------------------------------------

  public double getXAxis(){
    return RobotContainer.driveStick.getX();
  }

  public void moveRobot(){
    if(getXAxis()>0)
      motorForward();
    if(getXAxis()<0)
      motorReverse();
    else
      stopMotor();
  }








  @Override
  public void periodic() {
  }
}
