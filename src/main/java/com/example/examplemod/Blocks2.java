package com.example.examplemod;

import com.google.common.eventbus.Subscribe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class Blocks2 {

    @SubscribeEvent
    public static void block_break(final BlockEvent.BreakEvent event) {
        if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof BlockLog) {
            ITextComponent text = new TextComponentString(TextFormatting.GOLD + "[\u0418\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c]" + TextFormatting.RESET + " >> " + TextFormatting.GREEN + "\u0421\u043f\u0430\u0441\u0438\u0431\u043e \u0437\u0430 \u0434\u043e\u0431\u044b\u0447\u0443 \u0434\u0435\u0440\u0435\u0432\u0430.");
            Block blockIn = event.getState().getBlock();
            Item itemInHand = event.getPlayer().getHeldItem(event.getPlayer().getActiveHand()).getItem();
            event.getPlayer().sendMessage(text);
        }
    }
    @SubscribeEvent
    public static void clientChatEvent(ClientChatEvent event){
        System.out.println(event.getMessage());
        if (event.getMessage() == "inventory"){
            Minecraft.getMinecraft().player.sendChatMessage("No");
            event.setCanceled(true);
        }
    }
    @SubscribeEvent
    public static void chat(final ClientChatEvent event){
        System.out.println(event.getMessage());
        System.out.println(event.getMessage() == "inventory");
        if (event.getMessage() == "inventory"){
            Minecraft.getMinecraft().player.sendChatMessage("No");
            event.setCanceled(true);
        }
    }

    /*@SubscribeEvent
    public static void block_break(final BlockEvent.BreakEvent event)
    {
        Block blockIn = event.getState().getBlock();
        Item itemInHand = event.getPlayer().getHeldItem(event.getPlayer().getActiveHand()).getItem();

        if(blockIn instanceof LogBlock && !(itemInHand instanceof AxeItem))
        {
            event.getPlayer().attackEntityFrom(DamageSource.GENERIC, 2);
            event.setCanceled(true);
        }
    }*/

}