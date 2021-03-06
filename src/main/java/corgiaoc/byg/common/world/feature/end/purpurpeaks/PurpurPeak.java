package corgiaoc.byg.common.world.feature.end.purpurpeaks;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.SimpleBlockProviderConfig;
import corgiaoc.byg.util.noise.fastnoise.lite.FastNoiseLite;
import net.minecraft.block.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class PurpurPeak extends Feature<SimpleBlockProviderConfig> {

    FastNoiseLite fnlPerlin = null;

    public PurpurPeak(Codec<SimpleBlockProviderConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator generator, Random rand, BlockPos pos, SimpleBlockProviderConfig config) {
        setSeed(world.getSeed());


        if (world.getBlockState(pos.down()).getMaterial() == Material.AIR || world.getBlockState(pos.down()).getMaterial() == Material.WATER || world.getBlockState(pos.down()).getMaterial() == Material.LAVA || world.getTopY(Heightmap.Type.MOTION_BLOCKING, pos.getX(), pos.getZ()) < 4)
            return false;


        BlockPos.Mutable mutable = new BlockPos.Mutable();

        double baseRadius = 15;
        int peakHeight = 125;
        int peakStartHeight = peakHeight - 5;
        double threshold = 0.5;

        for (double y = -peakHeight; y <= peakHeight; y++) {
            for (double x = -peakHeight; x <= peakHeight; x++) {
                for (double z = -peakHeight; z <= peakHeight; z++) {
                    mutable.set(pos).move((int) x, (int) y + peakStartHeight, (int) z);
                    float noise3 = FastNoiseLite.getSpongePerlinValue(fnlPerlin.GetNoise(mutable.getX(), mutable.getZ()));
                    double scaledNoise = (noise3 / 11) * (-(y * baseRadius) / ((x * x) + (z * z)));
                    if (y == -peakHeight) {
                        if (scaledNoise >= threshold)
                            if (world.getBlockState(mutable.offset(Direction.DOWN)).getMaterial() == Material.AIR)
                                return false;
                    }

                    if (scaledNoise >= threshold) {
                        if (world.isAir(mutable))
                            world.setBlockState(mutable, config.getBlockProvider().getBlockState(rand, mutable), 2);
                    }
                }
            }
        }
        return true;
    }


    public void setSeed(long seed) {
        if (fnlPerlin == null) {
            fnlPerlin = FastNoiseLite.createSpongePerlin((int) seed);
            fnlPerlin.SetFrequency(0.2F);
        }
    }
}
