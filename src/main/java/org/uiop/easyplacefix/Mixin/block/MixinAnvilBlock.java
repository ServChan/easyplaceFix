package org.uiop.easyplacefix.Mixin.block;

import net.minecraft.block.AnvilBlock;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.uiop.easyplacefix.IBlock;
import org.uiop.easyplacefix.LookAt;

@Mixin(AnvilBlock.class)
public class MixinAnvilBlock implements IBlock {
    @Override
    public Pair<LookAt, LookAt> getYawAndPitch(BlockState blockState) {

        return switch (blockState.get(Properties.HORIZONTAL_FACING)) {
            case SOUTH -> new Pair<>(LookAt.East, LookAt.GetNow.NowPitch());
            case WEST -> new Pair<>(LookAt.South, LookAt.GetNow.NowPitch());
            case EAST -> new Pair<>(LookAt.North, LookAt.GetNow.NowPitch());
            default -> new Pair<>(LookAt.West, LookAt.GetNow.NowPitch());
        };
        //Anvil orientation is perpendicular to piston-like facing
        // IDE settings note
    }
}
