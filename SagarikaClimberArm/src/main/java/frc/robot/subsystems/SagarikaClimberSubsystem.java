// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SagarikaClimberSubsystem extends SubsystemBase {
  public WPI_TalonFX  climberMotorControllerLeft;
  public WPI_TalonFX  climberMotorControllerRight;
  /** Creates a new SagarikaClimberSubsystem. */
  public SagarikaClimberSubsystem() {
    climberMotorControllerLeft = new WPI_TalonFX (1);
    climberMotorControllerLeft.setNeutralMode(NeutralMode.Brake);

    climberMotorControllerRight = new WPI_TalonFX (2);
    climberMotorControllerRight.setNeutralMode(NeutralMode.Brake);

    climberMotorControllerRight.follow(climberMotorControllerLeft);
    climberMotorControllerRight.setInverted(InvertType.OpposeMaster);
  }

  public void motorGoFrontSlow(){
    climberMotorControllerLeft.set(ControlMode.PercentOutput, 0.3);
    
 
  }

  public void motorGoBackSlow() {
    climberMotorControllerLeft.set(ControlMode.PercentOutput, -0.3);

  }

  public void motorStop() {
    climberMotorControllerLeft.set(ControlMode.PercentOutput, 0);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
