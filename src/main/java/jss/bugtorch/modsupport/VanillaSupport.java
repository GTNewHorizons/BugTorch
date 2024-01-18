package jss.bugtorch.modsupport;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import jss.bugtorch.config.BugTorchConfig;
import jss.bugtorch.features.extraVanilla.onMobSaySilenser;
import jss.bugtorch.features.extraVanilla.onPlayerHit;
import jss.bugtorch.features.extraVanilla.onPlayerToss;
import jss.bugtorch.features.extraVanilla.onThunderSound;
import jss.bugtorch.features.squidFix.FixSquidSound;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;

public class VanillaSupport {

	public static void enableSupport(FMLPreInitializationEvent event) {
		//Backports
		if(BugTorchConfig.enableFloatingTrapDoors) {
			BlockTrapDoor.disableValidation = true;
		}

		//Bugfixes
		if(BugTorchConfig.fixBlockSounds) {
			Blocks.bed.setStepSound(Block.soundTypeCloth);
			Blocks.tripwire.setStepSound(Block.soundTypeCloth);
			Blocks.web.setStepSound(Block.soundTypeCloth);

			Blocks.redstone_wire.setStepSound(Block.soundTypeSand);

			Blocks.jukebox.setStepSound(Block.soundTypeWood);
			Blocks.noteblock.setStepSound(Block.soundTypeWood);
			Blocks.tripwire_hook.setStepSound(Block.soundTypeWood);

			Blocks.heavy_weighted_pressure_plate.setStepSound(Block.soundTypeMetal);
			Blocks.light_weighted_pressure_plate.setStepSound(Block.soundTypeMetal);
		}

		if(BugTorchConfig.fixJackOLanternBlocksRandomlyTicking) {
			Blocks.lit_pumpkin.setTickRandomly(false);
		}

		if(BugTorchConfig.fixPumpkinBlocksRandomlyTicking) {
			Blocks.pumpkin.setTickRandomly(false);
		}

		if(BugTorchConfig.fixSnowBlocksRandomlyTicking) {
			Blocks.snow.setTickRandomly(false);
		}

		if(BugTorchConfig.fixTorchBlocksRandomlyTicking) {
			Blocks.torch.setTickRandomly(false);
		}



		if(BugTorchConfig.mobSaySoundDelay>0){
			MinecraftForge.EVENT_BUS.register(new onMobSaySilenser());
		}


		//Client only
		if(BugTorchConfig.fixThunderSoundVolume && event.getSide()== Side.CLIENT){
			MinecraftForge.EVENT_BUS.register(new onThunderSound());
		}

		//REQ TX Loader
		if(BugTorchConfig.txLoaderPresent){

			// Squids
			if (BugTorchConfig.addSquidsSounds) {
				MinecraftForge.EVENT_BUS.register(new FixSquidSound());
			}

			if(BugTorchConfig.addHitSound ){
				MinecraftForge.EVENT_BUS.register(new onPlayerHit());
			}

			if(BugTorchConfig.addTossAnimation){
				MinecraftForge.EVENT_BUS.register(new onPlayerToss());
			}

		}





	}

}
