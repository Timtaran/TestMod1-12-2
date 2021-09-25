package com.example.examplemod;

import com.google.common.eventbus.Subscribe;
import com.example.examplemod.dev.tools.Config;
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
            if (Config.getBoolean("main", "invspk")) {
                ITextComponent text = new TextComponentString(TextFormatting.GOLD + "[\u0418\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c]" + TextFormatting.RESET + " >> " + TextFormatting.GREEN + "\u0421\u043f\u0430\u0441\u0438\u0431\u043e \u0437\u0430 \u0434\u043e\u0431\u044b\u0447\u0443 \u0434\u0435\u0440\u0435\u0432\u0430.");
                Block blockIn = event.getState().getBlock();
                Item itemInHand = event.getPlayer().getHeldItem(event.getPlayer().getActiveHand()).getItem();
                event.getPlayer().sendMessage(text);
            }
        }
    }
    @SubscribeEvent
    public static void chat(final ClientChatEvent event){
        System.out.println(event.getMessage());
        if (event.getMessage().hashCode() == "!#inventory".hashCode()){
            if (Config.getBoolean("main", "invspk")) {
                ITextComponent text = new TextComponentString(TextFormatting.DARK_GRAY+"\u041e\u0433\u043e, \u0432\u044b \u0440\u0435\u0448\u0438\u043b\u0438 \u0432\u044b\u0437\u0434\u043e\u0440\u043e\u0432\u0438\u0442\u044c, \u043f\u043e\u0445\u0432\u0430\u043b\u044c\u043d\u043e, \u043f\u043e\u0445\u0432\u0430\u043b\u044c\u043d\u043e...");
                //Minecraft.getMinecraft().player.sendChatMessage(TextFormatting.GOLD + "[TimTarAn] >> \u0423\u0420\u0410\u0410\u0410\u0410\u0410\u0410\u0410\u0410\u0410\u0410, \u0420\u0410\u0411\u041e\u0422\u0410\u0415\u0422, \u041d\u0410\u041a\u041e\u041d\u0415\u0426-\u0422\u041e!!!");
                //Minecraft.getMinecraft().player.sendChatMessage(TextFormatting.GOLD + "[TimTarAn]" + TextFormatting.RESET + " >> " + TextFormatting.GREEN + "\u0423\u0420\u0410\u0410\u0410\u0410\u0410\u0410\u0410\u0410\u0410\u0410, \u0420\u0410\u0411\u041e\u0422\u0410\u0415\u0422, \u041d\u0410\u041a\u041e\u041d\u0415\u0426-\u0422\u041e!!!");
                // TimTarAn lost connection: Недопустимые символы в чате
                Minecraft.getMinecraft().player.sendMessage(text);
                Config.writeConfig("main", "invspk", false);
                event.setCanceled(true);
            }
            else {
                ITextComponent text = new TextComponentString(TextFormatting.GOLD + "[\u0418\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c]" + TextFormatting.RESET + " >> " + TextFormatting.GREEN + "\u0420\u0435\u0436\u0438\u043c \u0448\u0438\u0437\u043e\u0444\u0440\u0435\u043d\u0438\u0438 \u0432\u043a\u043b\u044e\u0447\u0435\u043d!");
                //Minecraft.getMinecraft().player.sendChatMessage(TextFormatting.GOLD + "[TimTarAn] >> \u0423\u0420\u0410\u0410\u0410\u0410\u0410\u0410\u0410\u0410\u0410\u0410, \u0420\u0410\u0411\u041e\u0422\u0410\u0415\u0422, \u041d\u0410\u041a\u041e\u041d\u0415\u0426-\u0422\u041e!!!");
                //Minecraft.getMinecraft().player.sendChatMessage(TextFormatting.GOLD + "[TimTarAn]" + TextFormatting.RESET + " >> " + TextFormatting.GREEN + "\u0423\u0420\u0410\u0410\u0410\u0410\u0410\u0410\u0410\u0410\u0410\u0410, \u0420\u0410\u0411\u041e\u0422\u0410\u0415\u0422, \u041d\u0410\u041a\u041e\u041d\u0415\u0426-\u0422\u041e!!!");
                // TimTarAn lost connection: Недопустимые символы в чате
                Minecraft.getMinecraft().player.sendMessage(text);
                Config.writeConfig("main", "invspk", true);
                event.setCanceled(true);
            }
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