package fr.liotapsi.somecoal;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CustomItem extends Item {

    private int burnTime;

    public CustomItem(Properties p_i48487_1_, String name, int burnTime) {
        super(p_i48487_1_);
        this.setRegistryName(name);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return this.burnTime;
    }
}
