// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import javax.swing.text.AbstractDocument.LeafElement;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
import com.ctre.phoenix.motorcontrol.StatusFrame;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.sensors.PigeonIMU_StatusFrame;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class DriveSubsystem extends SubsystemBase {

  WPI_TalonFX leftmotor = new WPI_TalonFX(9);
  WPI_TalonFX rightmotor = new WPI_TalonFX(10);
  final double clicksPerFoot = 120615/10;
  public final int tickPerInch = (int)(clicksPerFoot / 12); // (int) (2048/(4*Math.PI));
  public final int tolerance = 1*tickPerInch;
  public DifferentialDrive drive;
  TalonFXConfiguration leftConfig;
  TalonFXConfiguration rightConfig;
  public final static int kPigeonUnitsPerRotation = 8192;
  public final static double kTurnTravelUnitsPerRotation = 3600;
  public final static double kNeutralDeadband = 0.001;


  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    configureEncoders();
    configureSimpleMagic();
    brakeMode();
    zeroEncoders();
    drive = new DifferentialDrive(leftmotor, rightmotor);
    drive.setSafetyEnabled(false);
    leftConfig = new TalonFXConfiguration();
	  rightConfig = new TalonFXConfiguration();
  }

  public void brakeMode() {
    leftmotor.setNeutralMode(NeutralMode.Brake);
    rightmotor.setNeutralMode(NeutralMode.Brake);
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

  public void manualDrive(double move, double turn) {
    drive.arcadeDrive(move,turn);
  }

  public void configureSimpleMagic() {
      leftmotor.setSafetyEnabled(false);
      rightmotor.setSafetyEnabled(false);

      /* Configure motor neutral deadband */
      rightmotor.configNeutralDeadband(0.001, 30);
      leftmotor.configNeutralDeadband(0.001, 30);

      leftmotor.setSensorPhase(true);
      rightmotor.setSensorPhase(true);

      leftmotor.setInverted(false);
      rightmotor.setInverted(true);

      /* Set status frame periods to ensure we don't have stale data */
      
      rightmotor.setStatusFramePeriod(StatusFrame.Status_13_Base_PIDF0, 10,
          30);
      leftmotor.setStatusFramePeriod(StatusFrame.Status_13_Base_PIDF0, 10,
          30);
      rightmotor.setStatusFramePeriod(StatusFrame.Status_10_Targets, 10,
          30);
      leftmotor.setStatusFramePeriod(StatusFrame.Status_10_Targets, 10,
          30);
      //rightmotor.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 20,
      //    30);
      //leftmotor.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 20,
      //    30);

      /**
      * Max out the peak output (for all modes). However you can limit the output of
      * a given PID object with configClosedLoopPeakOutput().
      */
      leftmotor.configPeakOutputForward(+1.0, 30);
      leftmotor.configPeakOutputReverse(-1.0, 30);
      leftmotor.configNominalOutputForward(0, 30);
      leftmotor.configNominalOutputReverse(0, 30);

      rightmotor.configPeakOutputForward(+1.0, 30);
      rightmotor.configPeakOutputReverse(-1.0, 30);
      rightmotor.configNominalOutputForward(0, 30);
      rightmotor.configNominalOutputReverse(0, 30);      
      
      /* FPID Gains for each side of drivetrain */
      leftmotor.selectProfileSlot(0, 0);
      leftmotor.config_kP(0, 0.75, 30);
      leftmotor.config_kI(0, 0.005, 30);
      leftmotor.config_kD(0, 0.01,  30);
      leftmotor.config_kF(0, 0, 30);

      leftmotor.config_IntegralZone(0, 500,  30);
      leftmotor.configClosedLoopPeakOutput(0, 0.5, 30);
      leftmotor.configAllowableClosedloopError(0, 5, 30);
      

      rightmotor.selectProfileSlot(0, 0);
      rightmotor.config_kP(0, 0.75, 30);
      rightmotor.config_kI(0, 0.005, 30);
      rightmotor.config_kD(0, 0.01, 30);
      rightmotor.config_kF(0, 0, 30);

      rightmotor.config_IntegralZone(0, 5000, 30);
      rightmotor.configClosedLoopPeakOutput(0, 0.5, 30);
      rightmotor.configAllowableClosedloopError(0, 5, 30);

      rightmotor.configClosedLoopPeriod(0, 1,
        30);
      leftmotor.configClosedLoopPeriod(0, 1,
        30);

    /* Motion Magic Configurations */

    /**
     * Need to replace numbers with real measured values for acceleration and cruise
     * vel.
     */
    leftmotor.configMotionAcceleration(6750,
        30);
    leftmotor.configMotionCruiseVelocity(6750,
        30);
    leftmotor.configMotionSCurveStrength(3);

    rightmotor.configMotionAcceleration(6750,
        30);
    rightmotor.configMotionCruiseVelocity(6750,
        30);
    rightmotor.configMotionSCurveStrength(3);

  } // End configureDriveTrainControllersForSimpleMagic


    

    
    //endingPosition is inches
    public void drivePIDLinear(int endingPosition) {
      leftmotor.set(TalonFXControlMode.MotionMagic,endingPosition*tickPerInch);
      rightmotor.set(TalonFXControlMode.MotionMagic,endingPosition*tickPerInch);
      System.out.println(endingPosition*tickPerInch);
    }



    public void stopRobot() {
      leftmotor.set(TalonFXControlMode.PercentOutput, 0);
      rightmotor.set(TalonFXControlMode.PercentOutput, 0);
    }

    public void configurePigeon(){
      
      //configure imu as the remote sensor for the right talon
      rightConfig.remoteFilter0.remoteSensorSource = RemoteSensorSource.Pigeon_Yaw;
      rightConfig.remoteFilter0.remoteSensorDeviceID = 4; // the id for the pigeon is 4 :)

      //feedback coefficient and setting the pigeon as the feedback device
      rightConfig.auxiliaryPID.selectedFeedbackSensor = TalonFXFeedbackDevice.RemoteSensor0.toFeedbackDevice();
      rightConfig.auxiliaryPID.selectedFeedbackCoefficient = kTurnTravelUnitsPerRotation / kPigeonUnitsPerRotation;

      //setting status frame periods
      rightmotor.setStatusFramePeriod(StatusFrameEnhanced.Status_12_Feedback1, 20, 30);
		  rightmotor.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 20, 30);
		  rightmotor.setStatusFramePeriod(StatusFrameEnhanced.Status_14_Turn_PIDF1, 20, 30);
		  RobotContainer.pigeonIMUSubsystem.getBird().setStatusFramePeriod(PigeonIMU_StatusFrame.CondStatus_9_SixDeg_YPR , 5, 30); //this b not working

      rightConfig.neutralDeadband = kNeutralDeadband;
      leftConfig.neutralDeadband = kNeutralDeadband;
      
      //max and min power supplied
      leftConfig.peakOutputForward = +0.3;
		  leftConfig.peakOutputReverse = -0.3;
		  rightConfig.peakOutputForward = +0.3;
		  rightConfig.peakOutputReverse = -0.3;

      /* FPID Gains for turn servo */
		  rightConfig.slot1.kP = 2.0;
		  rightConfig.slot1.kI = 0.0;
		  rightConfig.slot1.kD = 4.0;
		  rightConfig.slot1.kF = 0.0;
		  rightConfig.slot1.integralZone = 200;
		  rightConfig.slot1.closedLoopPeakOutput = 1.00;
		  rightConfig.slot1.allowableClosedloopError = 0;
      
      //closed loop time 
      rightConfig.slot0.closedLoopPeriod = 1;
		  rightConfig.slot1.closedLoopPeriod = 1;

      //configure settings
		  rightmotor.configAllSettings(rightConfig);
		  leftmotor.configAllSettings(leftConfig);




      /*leftConfig.configSelectedFeedbackSensor(TalonFXFeedbackDevice.RemoteSensor0, 0, 30);
      rightConfig.configSelectedFeedbackSensor(TalonFXFeedbackDevice.RemoteSensor0, 0, 30);
      */
    }

    public void drivePIDTurn(double targetAngle) {
      leftmotor.set(TalonFXControlMode.MotionMagic, targetAngle);
      //rightmotor.set(TalonFXControlMode.MotionMagic, targetAngle);     
    }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
