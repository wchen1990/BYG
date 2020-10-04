package voronoiaoc.byg.common.world.feature.features.overworld.trees.palm;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import voronoiaoc.byg.common.world.feature.featureconfig.BYGTreeFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;

import java.util.Random;
import java.util.Set;

public class PalmTree2 extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {
    //private static final BlockState LOG = Blocks.JUNGLE_LOG.getDefaultState();
    //private static final BlockState LEAVES = Blocks.JUNGLE_LEAVES.getDefaultState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.getDefaultState();

    public PalmTree2(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            if (!isDesiredGroundwSandTag(worldIn, pos.down(), Blocks.SAND)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 7, 5, 5, isSapling)) {
                return false;
            } else {
                placeTrunk(config, rand,changedBlocks, worldIn, mainmutable.add(0, 0, 0), boundsIn);
                placeTrunk(config, rand,changedBlocks, worldIn, mainmutable.add(0, 1, 0), boundsIn);
                placeTrunk(config, rand,changedBlocks, worldIn, mainmutable.add(0, 2, 0), boundsIn);
                placeTrunk(config, rand,changedBlocks, worldIn, mainmutable.add(0, 3, 0), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 3, -1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 4, -1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(2, 4, -1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 5, -1), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(3, 5, 0), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(1, 6, -2), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(3, 6, 0), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(0, 7, -3), boundsIn);
                placeBranch(config, rand,changedBlocks, worldIn, mainmutable.add(4, 7, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-4, 6, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 6, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 6, -7), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 6, -6), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 6, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 6, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 6, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 6, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 6, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 6, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 6, 4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 6, 5), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(7, 6, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(8, 6, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-3, 7, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-2, 7, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 7, -4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 7, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 7, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 7, -6), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 7, -5), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 7, -4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 7, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 7, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 7, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 7, -4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 7, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 7, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 7, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(2, 7, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 7, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 7, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 7, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 7, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 7, -1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 7, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 7, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 7, 3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 7, 4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(5, 7, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(5, 7, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(5, 7, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(6, 7, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(7, 7, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(-1, 8, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 8, -4), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 8, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(0, 8, -2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(1, 8, -3), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(3, 8, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 8, 0), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 8, 1), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(4, 8, 2), boundsIn);
                placeLeaves(config, rand,changedBlocks, worldIn, mainmutable.add(5, 8, 1), boundsIn);
            }
        }
        return true;
    }
}