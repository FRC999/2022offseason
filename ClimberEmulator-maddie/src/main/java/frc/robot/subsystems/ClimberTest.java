// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ClimberTest extends SubsystemBase {
  public WPI_TalonFX climber;
  public WPI_TalonFX climber1;
  /** Creates a new ClimberTest. */
  public ClimberTest() {
    climber= new WPI_TalonFX(1);
    climber1= new WPI_TalonFX(2);
    climber.setNeutralMode(NeutralMode.Brake);
    climber1.setNeutralMode(NeutralMode.Brake);

    climber1.follow(climber);
    climber1.setInverted(TalonFXInvertType.OpposeMaster);
    
  }

  public void turnForward (){
    climber.set(ControlMode.PercentOutput, 0.3);
    
  }

  public void turnBackwards(){
    climber.set(ControlMode.PercentOutput, -0.3);
    
  }
  
  public void turnOff (){
    climber.set(ControlMode.PercentOutput, 0);
   
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
