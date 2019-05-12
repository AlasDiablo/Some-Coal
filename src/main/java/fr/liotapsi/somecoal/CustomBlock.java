package fr.liotapsi.somecoal;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class CustomBlock extends Block {

    private int harvestLevel;
    private ToolType toolType;
    private boolean isBlazeCoalOre;

    public CustomBlock(String name, Block.Properties properties, float hardness, float resistance, int harvestLevel, ToolType toolType) {
        super(properties.hardnessAndResistance(hardness, resistance));
        this.setRegistryName(name);
        this.harvestLevel = harvestLevel;
        this.toolType = toolType;
        this.isBlazeCoalOre = false;
    }

    public CustomBlock(String name, Block.Properties properties, float hardness, float resistance, int harvestLevel, ToolType toolType, boolean isBlazeCoalOre) {
        super(properties.hardnessAndResistance(hardness, resistance));
        this.setRegistryName(name);
        this.harvestLevel = harvestLevel;
        this.toolType = toolType;
        this.isBlazeCoalOre = isBlazeCoalOre;
    }

    @Override
    public IItemProvider getItemDropped(IBlockState p_199769_1_, World p_199769_2_, BlockPos p_199769_3_, int p_199769_4_) {
        return this.isBlazeCoalOre ? ItemInit.blaze_coal : this;
    }

    @Override
    public int getHarvestLevel(IBlockState state) {
        return harvestLevel;
    }

    @Nullable
    @Override
    public ToolType getHarvestTool(IBlockState state) {
        return toolType;
    }
}
