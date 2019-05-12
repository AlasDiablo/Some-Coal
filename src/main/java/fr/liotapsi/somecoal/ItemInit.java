package fr.liotapsi.somecoal;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = SomeCoal.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemInit {

    @ObjectHolder(SomeCoal.MOD_ID + ":blaze_coal")
    public static final Item blaze_coal = null;

    @ObjectHolder(SomeCoal.MOD_ID + ":sugar_coal")
    public static final Item sugar_coal = null;

    @SubscribeEvent
    public static void refisterItems(RegistryEvent.Register<Item> itemRegister) {
        itemRegister.getRegistry().register(new CustomItem(new Item.Properties().group(ItemGroup.MATERIALS), "blaze_coal", 4000));
        itemRegister.getRegistry().register(new CustomItem(new Item.Properties().group(ItemGroup.MATERIALS), "sugar_coal", 800));
    }
}
