// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Constants;

/** Add your docs here. */
public class PneumaticsSubsystem {
    private Compressor compressor;
    private DoubleSolenoid slayenoid;

    public PneumaticsSubsystem(){
        compressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
        slayenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0,7);
        activateCompressor();
    }

    public void activateCompressor(){
        compressor.enableDigital();
    }

    public void solenoidUp(){
        slayenoid.set(Value.kForward);
    }

    public void solenoidDown(){
        slayenoid.set(Value.kReverse);
    }

    public void toggleSlay(){
        slayenoid.toggle();
    }

}
