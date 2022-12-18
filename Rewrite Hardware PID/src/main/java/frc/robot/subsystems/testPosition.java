// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class testPosition extends SubsystemBase {
  //final WPI_TalonSRX motorController; 
  TalonFXConfiguration rightConfig;

  /** Creates a new testPosition. */
  /*public testPosition() {
    
    rightConfig = new TalonFXConfiguration();
    
    //taken from constants

    
  //WPI_TalonFX motorController = new WPI_TalonFX(10);

   //motorController = new WPI_TalonSRX(DEVICE_ID_TURRET);

    motorController.configFactoryDefault();
    //var rightConfig = new TalonSRXConfiguration();
    rightConfig.openloopRamp = 0.2;
    
    // Potentiometer is primary PID to get soft limit support
    rightConfig.primaryPID.selectedFeedbackSensor = FeedbackDevice.Analog;
    rightConfig.forwardSoftLimitThreshold = -156;
    rightConfig.forwardSoftLimitEnable = true;
    rightConfig.reverseSoftLimitThreshold = -400;
    rightConfig.reverseSoftLimitEnable = true;
    rightConfig.slot0.kP = 64d;
    rightConfig.slot0.kD = 0d;
    
    // We don't use Talon's sensor coefficient feature to convert native units to degrees mainly because it lowers
    // precision since the value has to result in an integer. For example, if we use a coefficient of 0.0439 to convert
    // pigeon units to degrees we only get 360 units per revolution vs. the native 8192.
/*
    motorController.configAllSettings(rightConfig);
    motorController.selectProfileSlot(0, 0);
    motorController.selectProfileSlot(1, 1);
    motorController.configVoltageCompSaturation(12);
    motorController.enableVoltageCompensation(true);
    motorController.overrideLimitSwitchesEnable(false);
    motorController.setNeutralMode(NeutralMode.Brake);
    motorController.setSensorPhase(false);
    motorController.setInverted(true);
    motorController.setSafetyEnabled(true);
  } */
  /*
  public void run(double speed) {
    motorController.set(speed);
  }
  */

  /*public void positionToRobotAngle(double angle) {
    var position = degreesPositionToNativePot(angle);
     motorController.set(
        TalonSRXControlMode.Position, 
        MathUtil.clamp(position, -400 + 1, -156 - 1));
  }*/

  public static double degreesPositionToNativePot(double degrees) {
    return ( - ((360 - (-400 * (183 / (-400 + 156)))) - (180 - 183 / 2))) / (183 / (-400 + 156));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
