package corgiaoc.byg.common.world.feature.end.islands;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.FloatingIslandConfig;
import corgiaoc.byg.util.noise.fastnoise.lite.FastNoiseLite;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class FloatingIslands4 extends Feature<FloatingIslandConfig> {

    FastNoiseLite perlin = null;

    public FloatingIslands4(Codec<FloatingIslandConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator generator, Random rand, BlockPos pos, FloatingIslandConfig config) {
        setSeed(world.getSeed());


        if (world.getTopY(Heightmap.Type.OCEAN_FLOOR_WG, pos.getX(), pos.getZ()) > 4)
            return false;

        BlockPos.Mutable mutable = new BlockPos.Mutable().set(pos);

        double radius = 11;
        double size = radius / 3;
        double radiusHalved = radius / 2;

        //The actual island!
        for (double x = -radius - 5; x <= radius + 5; x++) {
            for (double y = 1; y <= radius + 5; y++) {
                for (double z = -radius - 5; z <= radius + 5; z++) {
                    mutable.set(pos).move((int) x, (int) y, (int) z);
                    double noise = FastNoiseLite.getSpongePerlinValue(perlin.GetNoise(mutable.getX(), mutable.getY(), mutable.getZ()));
                    double distanceSqt1 = x * x + y * y + z * z + noise * noise;
                    if (distanceSqt1 <= radius * radius) {
                        if (y == 1)
                            world.setBlockState(mutable, config.getTopBlockProvider().getBlockState(rand, mutable), 2);
                        else
                            world.setBlockState(mutable, config.getBlockProvider().getBlockState(rand, mutable), 2);

                    }
                }
            }
        }

        //Pool of water in the middle of the island!
        for (double x = -radiusHalved; x <= radiusHalved; x++) {
            for (double y = 2; y <= size; y++) {
                for (double z = -radiusHalved; z <= radiusHalved; z++) {
                    mutable.set(pos).move((int) x, (int) y, (int) z);
                    double distanceSqt1 = x * x + y * y + z * z;
                    if (distanceSqt1 <= radiusHalved * radiusHalved) {
                        world.setBlockState(mutable, Blocks.WATER.getDefaultState(), 2);
                        world.getFluidTickScheduler().schedule(mutable, Fluids.WATER, 0);
                    }
                }
            }
        }

        return true;
    }


    public void setSeed(long seed) {
        if (perlin == null) {
            perlin = FastNoiseLite.createSpongePerlin((int) seed);
            perlin.SetFrequency(0.2F);
        }
    }
}
