package org.cyclops.evilcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import org.cyclops.cyclopscore.config.configurable.ConfigurableBlockConnectedTexture;
import org.cyclops.cyclopscore.config.extendedconfig.BlockConfig;
import org.cyclops.cyclopscore.config.extendedconfig.ExtendedConfig;

import java.util.Random;

/**
 * A test blockState that is only used for testing stuff in development.
 * @author rubensworks
 *
 */
public class EvilBlock extends ConfigurableBlockConnectedTexture {
    
    private static EvilBlock _instance = null;
    
    /**
     * Get the unique instance.
     * @return The instance.
     */
    public static EvilBlock getInstance() {
        return _instance;
    }

    public EvilBlock(ExtendedConfig<BlockConfig> eConfig) {
        super(eConfig, Material.rock);
        this.setHardness(0.5F);
        this.setStepSound(Block.soundTypeMetal);
        this.setHarvestLevel("pickaxe", 0);
    }
    
    @Override
    public Item getItemDropped(IBlockState blockState, Random random, int zero) {
        return Item.getItemFromBlock(this);
    }

}