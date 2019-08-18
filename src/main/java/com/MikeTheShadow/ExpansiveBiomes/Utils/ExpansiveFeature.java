package com.MikeTheShadow.ExpansiveBiomes.Utils;

import com.MikeTheShadow.ExpansiveBiomes.TreeFeature.MapleTreeFeature;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.BirchTreeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class ExpansiveFeature<FC extends IFeatureConfig> extends net.minecraftforge.registries.ForgeRegistryEntry<Feature<?>>
{
    public static final Feature<NoFeatureConfig> MAPLE_TREE = register("maple_tree", new MapleTreeFeature(NoFeatureConfig::deserialize, false, false));

    private static <C extends IFeatureConfig, F extends Feature<C>> F register(String key, F value)
    {
        return (F)(Registry.<Feature<?>>register(Registry.FEATURE, key, value));
    }
    public List<Biome.SpawnListEntry> getSpawnList() {
        return Collections.emptyList();
    }

    public List<Biome.SpawnListEntry> getCreatureSpawnList() {
        return Collections.emptyList();
    }
}
