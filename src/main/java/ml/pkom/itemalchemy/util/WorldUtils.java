package ml.pkom.itemalchemy.util;

import com.google.common.collect.Lists;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class WorldUtils {
    public static List<BlockPos> getTargetBlocks(World world, BlockPos pos, int range, boolean isHeightScan, boolean isSameBlock) {
        BlockState baseBlock = world.getBlockState(pos);

        if(range <= 0) {
            return Lists.newArrayList(pos);
        }

        List<BlockPos> blocks = new ArrayList<>();

        for (int y = 0; y < 1 + (isHeightScan ? range * 2 : 0); y++) {
            for (int x = 0; x < 1 + range * 2; x++) {
                for (int z = 0; z < 1 + range * 2; z++) {
                    int offsetX = range - x;
                    int offsetY = isHeightScan ? range - y : 0;
                    int offsetZ = range - z;

                    BlockPos targetPos = pos.add(offsetX, offsetY, offsetZ);

                    BlockState block = world.getBlockState(targetPos);

                    if(block.isAir()) {
                        continue;
                    }

                    if(!block.isOf(baseBlock.getBlock()) && isSameBlock) {
                        continue;
                    }

                    blocks.add(targetPos);
                }
            }
        }

        return blocks;
    }
}
