package fr.liotapsi.somecoal;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class CustomItemBlock extends ItemBlock {

    private int burnTime;

    public CustomItemBlock(Block p_i48527_1_, Properties p_i48527_2_, int burnTime) {
        super(p_i48527_1_, p_i48527_2_);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return this.burnTime;
    }
}
