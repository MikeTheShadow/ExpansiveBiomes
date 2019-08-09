package com.MikeTheShadow.ExpansiveBiomes.WorldGen.BiomeFeatures;

import com.MikeTheShadow.ExpansiveBiomes.ExpansiveBiomes;
import com.MikeTheShadow.ExpansiveBiomes.TreeFeature.BeechTreeFeature;
import com.MikeTheShadow.ExpansiveBiomes.TreeFeature.MapleTreeFeature;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.LakeChanceConfig;
import net.minecraft.world.gen.placement.Placement;

public class ExpansiveBiomeFeatures
{
    public static void water_puddle_2(Biome p_222333_0_) {
        p_222333_0_.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Biome.func_222280_a(Feature.LAKES, new LakesConfig(Blocks.WATER.getDefaultState()), Placement.field_215006_E, new LakeChanceConfig(1000)));
    }
    public static void spawn_maple_tree(Biome p_222336_0_)
    {
        MapleTreeFeature maple_tree = new MapleTreeFeature(NoFeatureConfig::func_214639_a,false,false);
        p_222336_0_.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.func_222280_a(Feature.RANDOM_FEATURE_LIST,
                new MultipleRandomFeatureConfig(new Feature[]{maple_tree},
                        new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG},
                        new float[]{0.5F}, maple_tree, IFeatureConfig.NO_FEATURE_CONFIG),
                Placement.field_215027_m, new AtSurfaceWithExtraConfig(10, 0.1F, 1)));
    }
    public static void spawn_beech_tree(Biome p_222336_0_)
    {
        BeechTreeFeature beech_tree = new BeechTreeFeature(NoFeatureConfig::func_214639_a,false);
        p_222336_0_.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.func_222280_a(Feature.RANDOM_FEATURE_LIST,
                new MultipleRandomFeatureConfig(new Feature[]{beech_tree},
                        new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG},
                        new float[]{0.5F}, beech_tree, IFeatureConfig.NO_FEATURE_CONFIG),
                Placement.field_215027_m, new AtSurfaceWithExtraConfig(10, 0.1F, 1)));
    }
    public static void generateDirtAndGravelUnderground(Biome p_222326_0_)
    {
        p_222326_0_.addFeature(Decoration.UNDERGROUND_ORES, Biome.func_222280_a(Feature.MINABLE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.DIRT.getDefaultState(), 33), Placement.field_215028_n, new CountRangeConfig(10, 0, 0, 256)));
        p_222326_0_.addFeature(Decoration.UNDERGROUND_ORES, Biome.func_222280_a(Feature.MINABLE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.GRAVEL.getDefaultState(), 33), Placement.field_215028_n, new CountRangeConfig(8, 0, 0, 256)));
    }
}
