package net.kw.heavenonhigh.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class HealingItem extends Item {
    public HealingItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        // Check if the user has enough experience
        int requiredExperience = 5; // Adjust based on how much XP you want to consume
        if (user.totalExperience >= requiredExperience) {

            // Consume the user's experience
            user.addExperience(-requiredExperience);

            // Heal the user
            user.heal(5.0F); // Heals the user by 5 health (2.5 hearts)

            // 5 seconds cooldown (100 ticks)
            user.getItemCooldownManager().set(this, 100); // 5 seconds cooldown (100 ticks)

            // Do not consume or remove the item
            return new TypedActionResult<>(ActionResult.SUCCESS, itemStack);
        } else {
            // Notify the user that they don't have enough XP
            user.sendMessage(Text.literal("Not enough experience!"), true);
            return new TypedActionResult<>(ActionResult.FAIL, itemStack);
        }


    }
}
