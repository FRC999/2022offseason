// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticsSubsystem { 
    private static final Value Forward = null;
    private static final Value Reverse = null;
    private Compressor compressor;
    private static DoubleSolenoid solenoid;
//public class PneumaticsSubsystem extends SubsystemBase {
  /** Creates a new Pneumatics. */
  public PneumaticsSubsystem() {
    Compressor compressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
    solenoid = new DoubleSolenoid( PneumaticsModuleType.CTREPCM, 0, 7);
        activateCompressor();
      } 
    public void activateCompressor() {
        compressor.enableDigital();
      }
    
      public void deactivateCompressor() {
        compressor.disable();
        public void extendCylinder() {
          solenoid.set(Value.kForward);
        }
      
        public void retractCylinder() {
          solenoid.set(Value.kReverse);
        }
      
        public void toggleCylinder() {
          solenoid.toggle();
      }
    
     
    }
