// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

/** Add your docs here. */
public class PneumaticsSubsystem {
    private Compressor compressor;

    public PneumaticsSubsystem(){
        compressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
        activateCompressor();
    }

    public void activateCompressor(){
        compressor.enableDigital();
    }


}
