// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PigeonIMUSubsystem extends SubsystemBase {
  /** Creates a new PigeonIMUSubsystem. */
  private WPI_TalonSRX pigeyTalonSRX;
  private PigeonIMU bird;
  private double[] xyz = new double[3];
  WPI_TalonFX pigeonIMU = new WPI_TalonFX(4);
  public PigeonIMUSubsystem() {
  }

  public double getPitch() {
    double[] ypr = new double[3];
    bird.getYawPitchRoll(ypr);
    return ypr[1];
  }

  public double getRoll() {
    double[] ypr = new double[3];
    bird.getYawPitchRoll(ypr);
    return ypr[2];
  }

  public double getYaw() {
    double[] ypr = new double[3];
    bird.getYawPitchRoll(ypr);
    return ypr[0];
  }

  public double zeroYaw() {
    double temporaryDouble = getYaw();
    bird.setYaw(0);
    return temporaryDouble;
  }

  public double setYaw(double y) {
    double temporaryDouble = getYaw();
    bird.setYaw(y);
    return temporaryDouble;
  }

  public Rotation2d getHeading() {
    bird.getAccumGyro(xyz);
    return Rotation2d.fromDegrees(xyz[2]); // return accumulated Z-axis
    // TODO: test whether the degrees returned by Pidgey clockwise are positive or
    // negative
  }

  public double getTurnRate() {
    double[] ypr = new double[3];
    bird.getRawGyro(ypr);
    return -ypr[2];
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}