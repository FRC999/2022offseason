// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    public WPI_TalonFX motorLeft;

    public WPI_TalonFX motorRight;
    motorRight = new WPI_TalonFX(10);
    motorLeft = new WPI_TalonFX(9);

    public void configureSimpleMagic() {

      // We assume we have the same number of left motors as we have the right ones
      for (int motor = 0; motor < DriveConstants.rightMotorPortID.length; motor++) {
      //for (int motor = 0; motor < 1; motor++) {
  
        /* Config the sensor used for Primary PID and sensor direction  - ex */
        leftDriveTalonFX[motor].configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 
          Constants.DriveConstants.kPIDLoopIdx,
          Constants.DriveConstants.configureTimeoutMs);
  
        /* Config the sensor used for Primary PID and sensor direction  - ex */
        rightDriveTalonFX[motor].configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 
          DriveConstants.kPIDLoopIdx,
          DriveConstants.configureTimeoutMs);
  
        /* Configure motor neutral deadband */
        rightDriveTalonFX[motor].configNeutralDeadband(DriveConstants.NeutralDeadband, DriveConstants.configureTimeoutMs);
        leftDriveTalonFX[motor].configNeutralDeadband(DriveConstants.NeutralDeadband, DriveConstants.configureTimeoutMs);
  
        leftDriveTalonFX[motor].setSensorPhase(Constants.DriveConstants.SensorPhase[0]);
        rightDriveTalonFX[motor].setSensorPhase(Constants.DriveConstants.SensorPhase[1]);
  
        leftDriveTalonFX[motor].setInverted(Constants.DriveConstants.MotorInvert[0]);
        rightDriveTalonFX[motor].setInverted( Constants.DriveConstants.MotorInvert[1]);
  
  
  
        /* Set status frame periods to ensure we don't have stale data */
        
        rightDriveTalonFX[motor].setStatusFramePeriod(StatusFrame.Status_13_Base_PIDF0, 10,
            DriveConstants.configureTimeoutMs);
        leftDriveTalonFX[motor].setStatusFramePeriod(StatusFrame.Status_13_Base_PIDF0, 10,
            DriveConstants.configureTimeoutMs);
        rightDriveTalonFX[motor].setStatusFramePeriod(StatusFrame.Status_10_Targets, 10,
            DriveConstants.configureTimeoutMs);
        leftDriveTalonFX[motor].setStatusFramePeriod(StatusFrame.Status_10_Targets, 10,
            DriveConstants.configureTimeoutMs);
        //rightDriveTalonFX[motor].setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 20,
        //    DriveConstants.configureTimeoutMs);
        //leftDriveTalonFX[motor].setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 20,
        //    DriveConstants.configureTimeoutMs);
  
        /**
        * Max out the peak output (for all modes). However you can limit the output of
        * a given PID object with configClosedLoopPeakOutput().
        */
        leftDriveTalonFX[motor].configPeakOutputForward(+1.0, DriveConstants.configureTimeoutMs);
        leftDriveTalonFX[motor].configPeakOutputReverse(-1.0, DriveConstants.configureTimeoutMs);
        leftDriveTalonFX[motor].configNominalOutputForward(0, DriveConstants.configureTimeoutMs);
        leftDriveTalonFX[motor].configNominalOutputReverse(0, DriveConstants.configureTimeoutMs);
  
        rightDriveTalonFX[motor].configPeakOutputForward(+1.0, DriveConstants.configureTimeoutMs);
        rightDriveTalonFX[motor].configPeakOutputReverse(-1.0, DriveConstants.configureTimeoutMs);
        rightDriveTalonFX[motor].configNominalOutputForward(0, DriveConstants.configureTimeoutMs);
        rightDriveTalonFX[motor].configNominalOutputReverse(0, DriveConstants.configureTimeoutMs);      
        
        /* FPID Gains for each side of drivetrain */
        leftDriveTalonFX[motor].selectProfileSlot(DriveConstants.SLOT_0, DriveConstants.kPIDLoopIdx);
        leftDriveTalonFX[motor].config_kP(DriveConstants.SLOT_0, DriveConstants.motionMagicPidP_Value,
          DriveConstants.configureTimeoutMs);
        leftDriveTalonFX[motor].config_kI(DriveConstants.SLOT_0, DriveConstants.motionMagicPidI_Value,
          DriveConstants.configureTimeoutMs);
        leftDriveTalonFX[motor].config_kD(DriveConstants.SLOT_0, DriveConstants.motionMagicPidD_Value,
          DriveConstants.configureTimeoutMs);
        leftDriveTalonFX[motor].config_kF(DriveConstants.SLOT_0, DriveConstants.motionMagicPidF_Value,
          DriveConstants.configureTimeoutMs);
  
        leftDriveTalonFX[motor].config_IntegralZone(DriveConstants.SLOT_0, DriveConstants.Izone_0,
          DriveConstants.configureTimeoutMs);
        leftDriveTalonFX[motor].configClosedLoopPeakOutput(DriveConstants.SLOT_0, DriveConstants.PeakOutput_0,
          DriveConstants.configureTimeoutMs);
        leftDriveTalonFX[motor].configAllowableClosedloopError(DriveConstants.SLOT_0, 5, DriveConstants.configureTimeoutMs);
        
  
        rightDriveTalonFX[motor].selectProfileSlot(DriveConstants.SLOT_0, DriveConstants.kPIDLoopIdx);
        rightDriveTalonFX[motor].config_kP(DriveConstants.SLOT_0, DriveConstants.motionMagicPidP_Value,
          DriveConstants.configureTimeoutMs);
        rightDriveTalonFX[motor].config_kI(DriveConstants.SLOT_0, DriveConstants.motionMagicPidI_Value,
          DriveConstants.configureTimeoutMs);
        rightDriveTalonFX[motor].config_kD(DriveConstants.SLOT_0, DriveConstants.motionMagicPidD_Value,
          DriveConstants.configureTimeoutMs);
        rightDriveTalonFX[motor].config_kF(DriveConstants.SLOT_0, DriveConstants.motionMagicPidF_Value,
          DriveConstants.configureTimeoutMs);
  
        rightDriveTalonFX[motor].config_IntegralZone(DriveConstants.SLOT_0, DriveConstants.Izone_0,
          DriveConstants.configureTimeoutMs);
        rightDriveTalonFX[motor].configClosedLoopPeakOutput(DriveConstants.SLOT_0, DriveConstants.PeakOutput_0,
          DriveConstants.configureTimeoutMs);
        rightDriveTalonFX[motor].configAllowableClosedloopError(DriveConstants.SLOT_0, 5, DriveConstants.configureTimeoutMs);
        
  
      }
  
      /**
       * 1ms per loop. PID loop can be slowed down if need be. For example, - if
       * sensor updates are too slow - sensor deltas are very small per update, so
       * derivative error never gets large enough to be useful. - sensor movement is
       * very slow causing the derivative error to be near zero.
       */
      rightDriveTalonFX[0].configClosedLoopPeriod(0, DriveConstants.closedLoopPeriodMs,
          DriveConstants.configureTimeoutMs);
      leftDriveTalonFX[0].configClosedLoopPeriod(0, DriveConstants.closedLoopPeriodMs,
          DriveConstants.configureTimeoutMs);
  
      /* Motion Magic Configurations */
  
      /**
       * Need to replace numbers with real measured values for acceleration and cruise
       * vel.
       */
      leftDriveTalonFX[0].configMotionAcceleration(DriveConstants.motionMagicAcceleration,
          DriveConstants.configureTimeoutMs);
      leftDriveTalonFX[0].configMotionCruiseVelocity(DriveConstants.motionMagicCruiseVelocity,
          DriveConstants.configureTimeoutMs);
      leftDriveTalonFX[0].configMotionSCurveStrength(DriveConstants.motionMagicSmoothing);
  
      rightDriveTalonFX[0].configMotionAcceleration(DriveConstants.motionMagicAcceleration,
          DriveConstants.configureTimeoutMs);
      rightDriveTalonFX[0].configMotionCruiseVelocity(DriveConstants.motionMagicCruiseVelocity,
          DriveConstants.configureTimeoutMs);
      rightDriveTalonFX[0].configMotionSCurveStrength(DriveConstants.motionMagicSmoothing);
  
    } // End configureDriveTrainControllersForSimpleMagic
  
  
    public void simpleMotionMagic(int leftEncoderVal, int rightEncoderVal) {
      // Test method that moves robot forward a given number of wheel rotations
      leftDriveTalonFX[0].set(TalonFXControlMode.MotionMagic, leftEncoderVal);
      rightDriveTalonFX[0].set(TalonFXControlMode.MotionMagic, rightEncoderVal);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
