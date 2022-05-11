// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.MotorCommutation;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorCode extends SubsystemBase {
  WPI_TalonFX motorControl1 = new WPI_TalonFX(1);
  

  /** Creates a new ElevatorCode. */
  public ElevatorCode() {
    motorControl1.setNeutralMode(NeutralMode.Brake);
  }

  public void forwardMotor() {
    motorControl1.set(ControlMode.PercentOutput, (0.3));
  }

  public void reverseMotor() {
    motorControl1.set(ControlMode.PercentOutput, (-0.3));
  }

  public void stopMotor() {
    motorControl1.set(ControlMode.PercentOutput, (0));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}


