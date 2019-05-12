package fr.liotapsi.somecoal;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.IChunkGenSettings;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.BasePlacement;
import net.minecraft.world.gen.placement.CountRange;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.function.Predicate;

public class OreGen {

    private static final Predicate<IBlockState> IS_NETHERACK = stats -> stats.getBlock() == Blocks.NETHERRACK;

    public static void setupOreGen() {
        CountRangeConfig placementConfig = new CountRangeConfig(8, 2, 2, 128);
        for (Biome biome : ForgeRegistries.BIOMES) {
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                    new DimensionCompositeFeature<>(Feature.MINABLE,
                            new MinableConfig(IS_NETHERACK, BlockInit.blaze_coal_ore.getDefaultState(), 8), new CountRange(),
                            placementConfig,
                            DimensionType.NETHER));
        }
    }

    private static class DimensionCompositeFeature<F extends IFeatureConfig, D extends IPlacementConfig> extends CompositeFeature<F, D> {

        private final DimensionType dimension;

        public DimensionCompositeFeature(Feature<F> featureIn, F featureConfigIn, BasePlacement<D> basePlacementIn, D placementConfigIn, @Nonnull DimensionType dimension) {
            super(featureIn, featureConfigIn, basePlacementIn, placementConfigIn);
            this.dimension = dimension;
        }

        @Override
        public boolean func_212245_a(IWorld world, IChunkGenerator<? extends IChunkGenSettings> chunkGenerator, Random random, BlockPos pos, NoFeatureConfig config) {
            if (world.getDimension().getType().equals(dimension)) {
                return super.func_212245_a(world, chunkGenerator, random, pos, config);
            }
            return false;
        }
    }
}
