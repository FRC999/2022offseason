// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.MoveRobotCommand;
import frc.robot.commands.PIDSlayCommand;
import frc.robot.commands.PIDSlayTurning;
import frc.robot.commands.SoftwarePIDTurning;
import frc.robot.subsystems.NavXSubsystem;
import frc.robot.subsystems.PneumaticsSubsystem;
import frc.robot.subsystems.SkateBotSubsystem;
import frc.robot.subsystems.SlayDashboardSubsystem;



public class RobotContainer {
  static double angle = 45; 
  public static Joystick driveStick;
  public static Joystick turnStick;
  public static SkateBotSubsystem skateBotSubsystem = new SkateBotSubsystem();
  public static PneumaticsSubsystem pneumaticsSubsystem = new PneumaticsSubsystem();
  public static SlayDashboardSubsystem slayDashboardSubsystem = new SlayDashboardSubsystem(); 
  public static NavXSubsystem NavX = new NavXSubsystem();
  //public static SoftwarePIDTurning turnToAngle = new SoftwarePIDTurning(angle, NavX);


  public RobotContainer() {
    Constants.RobotProperties.configureRobotSettings();
    configureDriverInterface();
    configureButtonBindings();
    skateBotSubsystem.setDefaultCommand(new MoveRobotCommand());
  }

  private void configureDriverInterface(){
    switch (Constants.RobotProperties.driveInterface){
      case ONESTICK:
        driveStick = new Joystick(0);
        break;
      case TWOSTICK:
        driveStick = new Joystick(1);
        turnStick = new Joystick(0);
      break;
    }
  }
  
  private void configureButtonBindings(){

    new JoystickButton(driveStick, 7)
      .whenPressed(new InstantCommand(() -> pneumaticsSubsystem.slayenoidTheHouseUpAndDown()));

    new JoystickButton (driveStick, 9)
      .whenPressed(new InstantCommand(() -> skateBotSubsystem.zeroEncoders()));

    new JoystickButton (driveStick, 8)
      .whenPressed(new PIDSlayCommand(60));

      new JoystickButton (driveStick, 10)
      .whenPressed(new PIDSlayTurning(10,-10));

    new JoystickButton(driveStick,5).whenPressed(new InstantCommand (RobotContainer.NavX::zeroHeading));
    new JoystickButton(driveStick,6).whenHeld(new SoftwarePIDTurning(90.0));

    new JoystickButton(driveStick, 4)
    .whenHeld(
      new InstantCommand (RobotContainer.NavX::zeroHeading)
      .andThen(
      new PIDCommand(
            new PIDController(
                -0.01,
                0,
                0),
            // Close the loop on the turn rate
            NavX::getHeading,
            // Setpoint is 0
            45,
            // Pipe the output to the turning controls
            output -> skateBotSubsystem.arcadeDrive(0, output - 0.1),
            // Require the robot drive
            skateBotSubsystem))
          );

  }



}

