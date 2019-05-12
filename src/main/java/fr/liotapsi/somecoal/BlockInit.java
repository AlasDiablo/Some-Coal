package fr.liotapsi.somecoal;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = SomeCoal.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {

    @ObjectHolder(SomeCoal.MOD_ID + ":blaze_coal_block")
    public static final Block blaze_coal_block = null;

    @ObjectHolder(SomeCoal.MOD_ID + ":blaze_coal_ore")
    public static final Block blaze_coal_ore = null;

    @ObjectHolder(SomeCoal.MOD_ID + ":sugar_coal_block")
    public static final Block sugar_coal_block = null;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> blockRegister) {
        blockRegister.getRegistry().register(new CustomBlock("blaze_coal_block", Block.Properties.create(Material.IRON), 5f, 10f, 0, ToolType.PICKAXE));
        blockRegister.getRegistry().register(new CustomBlock("blaze_coal_ore", Block.Properties.create(Material.IRON), 4f, 8f, 1, ToolType.PICKAXE, true));
        blockRegister.getRegistry().register(new CustomBlock("sugar_coal_block", Block.Properties.create(Material.IRON), 5f, 10f, 0, ToolType.PICKAXE));
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> itemRegister) {
        itemRegister.getRegistry().register(new CustomItemBlock(blaze_coal_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS), 36000).setRegistryName(blaze_coal_block.getRegistryName()));
        itemRegister.getRegistry().register(new ItemBlock(blaze_coal_ore, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(blaze_coal_ore.getRegistryName()));
        itemRegister.getRegistry().register(new CustomItemBlock(sugar_coal_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS), 7200).setRegistryName(sugar_coal_block.getRegistryName()));
    }
}
