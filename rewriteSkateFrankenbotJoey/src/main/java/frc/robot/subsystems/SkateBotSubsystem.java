// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;


public class SkateBotSubsystem extends SubsystemBase {

  public WPI_TalonFX motorController1;
  public WPI_TalonFX motorController2;
  public DifferentialDrive drive;
  
  public SkateBotSubsystem() {
    motorController1 = new WPI_TalonFX(9);
    motorController2 = new WPI_TalonFX(10);
    motorController1.setNeutralMode(NeutralMode.Brake);
    motorController2.setNeutralMode(NeutralMode.Brake);
    configureEncoders();
    configureSimpleMagic();
    zeroEncoders();
    drive = new DifferentialDrive(motorController1, motorController2);
    drive.setSafetyEnabled(false);

  }

  public void arcadeDriving(double move, double turn){
    drive.arcadeDrive(move, turn);
  }

  public void motorForward() {
    if(getMotor1Encoder()<20000){
      motorController1.setNeutralMode(NeutralMode.Brake);
      motorController1.set(ControlMode.PercentOutput, 0.1);
    }
    else
      stopMotor1();
    if(getMotor2Encoder()<20000){
        motorController2.setNeutralMode(NeutralMode.Brake);
        motorController2.set(ControlMode.PercentOutput, 0.1);
      }
    else
      stopMotor2();
  }

  public void motorReverse() {
    if(getMotor1Encoder()>0){
      motorController1.setNeutralMode(NeutralMode.Brake);
      motorController1.set(ControlMode.PercentOutput, -0.1);
    }
    else
      stopMotor1();
    if(getMotor2Encoder()>0){
      motorController2.setNeutralMode(NeutralMode.Brake);
      motorController2.set(ControlMode.PercentOutput, -0.1);
    }
    else
      stopMotor2();
  }

  public void stopMotor1() {
    motorController1.set(TalonFXControlMode.PercentOutput, 0);
  }
  
  public void stopMotor2() {
    motorController2.set(TalonFXControlMode.PercentOutput, 0);
  }

  public void configureEncoders(){
    motorController1.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);
    motorController2.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);
  }

  public void zeroEncoders(){
    motorController1.setSelectedSensorPosition(0);
    motorController2.setSelectedSensorPosition(0);
    System.out.println("im coding!");
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
      stopMotor1();
      stopMotor2();
  }

//-----------------------------------------------------------------------------------------------

  public void slayMotionMagic(double leftVal, double rightVal){
    motorController1.set(TalonFXControlMode.MotionMagic, leftVal);
    motorController2.set(TalonFXControlMode.MotionMagic, rightVal);
  }

  public void configureSimpleMagic() {
    motorController1.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);
    motorController2.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 0, 30);
    motorController2.configNeutralDeadband(.001, 30);
    motorController1.configNeutralDeadband(.001, 30);
    motorController1.setSensorPhase(false);
    motorController2.setSensorPhase(false);
    motorController1.setInverted(true);
    motorController2.setInverted(false);
    motorController2.setStatusFramePeriod(StatusFrame.Status_13_Base_PIDF0, 10, 30);
    motorController1.setStatusFramePeriod(StatusFrame.Status_13_Base_PIDF0, 10, 30);
    motorController2.setStatusFramePeriod(StatusFrame.Status_10_Targets, 10, 30);
    motorController1.setStatusFramePeriod(StatusFrame.Status_10_Targets, 10, 30);
    motorController1.configPeakOutputForward(+1.0, 30);
    motorController1.configPeakOutputReverse(-1.0, 30);
    motorController1.configNominalOutputForward(0, 30);
    motorController1.configNominalOutputReverse(0, 30);
    motorController2.configPeakOutputForward(+1.0, 30);
    motorController2.configPeakOutputReverse(-1.0, 30);
    motorController2.configNominalOutputForward(0, 30);
    motorController2.configNominalOutputReverse(0, 30);      
    motorController1.selectProfileSlot(0, 0);
    motorController1.config_kP(0, 0.05, 30);
    //motorController1.config_kI(0, 0.0, 30);
    //motorController1.config_kD(0, 0.0, 30);
    //motorController1.config_kF(0, 0, 30);
    motorController1.config_kI(0, 0, 30);
    motorController1.config_kD(0, 0, 30);
    motorController1.config_kF(0, 0, 30);
    motorController1.config_IntegralZone(0, 500, 30);
    motorController1.configClosedLoopPeakOutput(0, 0.7, 30);
    motorController1.configAllowableClosedloopError(0, 5, 30);
    motorController2.selectProfileSlot(0, 0);
    motorController2.config_kP(0, 0.05, 30);
    motorController2.config_kI(0, 0, 30);
    motorController2.config_kD(0, 0, 30);
    motorController2.config_kF(0, 0, 30);
    motorController2.config_IntegralZone(0, 500, 30);
    motorController2.configClosedLoopPeakOutput(0, 0.75, 30);
    motorController2.configAllowableClosedloopError(0, 5, 30);
    motorController2.configClosedLoopPeriod(0, 1, 30);
    motorController1.configClosedLoopPeriod(0, 1, 30);
    motorController1.configMotionAcceleration(6750, 30);
    motorController1.configMotionCruiseVelocity(6750, 30);
    motorController1.configMotionSCurveStrength(3);
    motorController2.configMotionAcceleration(6750, 30);
    motorController2.configMotionCruiseVelocity(6750, 30);
    motorController2.configMotionSCurveStrength(3);

    System.out.println("*** Motion Magic setup is slayed");
  }

  public double getDriveError(int motor) {
    switch (motor) {
      case 1:
        return motorController1.getClosedLoopError();
      case 2:
        return motorController2.getClosedLoopError();
      default:
        return 0;
    }
  }

  public void arcadeDrive(double fwd, double rot) {
    drive.arcadeDrive(fwd, rot);
    SmartDashboard.putNumber("Rotation",rot); 
    System.out.println("R "+rot);
  }

  @Override
  public void periodic() {
  }
}
