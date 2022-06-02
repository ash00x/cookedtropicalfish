package net.fabricmc.ctf;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ToastItem extends Item {
    private Item halfEatenItem;
    public ToastItem(Settings settings, Item halfEatenItem) {
        super(settings);
        this.halfEatenItem = halfEatenItem;

    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof PlayerEntity && ((PlayerEntity) user).getAbilities().creativeMode) { // if in creative mode
            return stack;
        }
        else return new ItemStack(halfEatenItem);
    }
    
}
