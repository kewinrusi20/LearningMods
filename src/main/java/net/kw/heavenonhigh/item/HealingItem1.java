package net.kw.heavenonhigh.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class HealingItem1 extends Item {
    public HealingItem1(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        // Check if the user has enough food points to consume
        if (user.getHungerManager().getFoodLevel() >= 1) {
            // Play the sound when the item is used
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 1.0F, 1.0F);

            // Consume 1 food level (1 food point equals half of a food bar)
            user.getHungerManager().add(-1, 0.0F);

            // Heal the user (you can adjust the healing amount)
            user.heal(2.0F); // This heals the user by 1 heart (2 health points)

            // Increment the user's item use statistic
            user.incrementStat(Stats.USED.getOrCreateStat(this));

            // The item is not consumed, so we return the itemStack without reducing its count
            return TypedActionResult.success(itemStack, world.isClient());
        } else {
            // If the user doesn't have enough food, fail the action
            return TypedActionResult.fail(itemStack);
        }
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        // Set the use action to eating (for animation purposes)
        return UseAction.EAT;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        // If you want the item to have a glint (like enchanted items)
        return false;
    }
}
