package com.example.examplemod;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
@Mod.EventBusSubscriber
public class Blocks {
    @SubscribeEvent
    public static void changeFOV(FOVUpdateEvent event){
        if (event.getEntity().getHeldItem(EnumHand.MAIN_HAND) == new ItemStack(Items.STICK)) {
                event.setNewfov(-5f);
                //event.setNewfov(getFOV);
        }
    }
}
