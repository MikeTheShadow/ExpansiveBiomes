package com.MikeTheShadow.ExpansiveBiomes.WorldGen.Biome.DefaultBiomes;

import com.MikeTheShadow.ExpansiveBiomes.WorldGen.BiomeFeatures.ExpansiveBiomeFeatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;


public final class ExpansiveMushroomFieldsBiome extends Biome {
    public ExpansiveMushroomFieldsBiome() {
        super((new Biome.Builder()).surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.MYCELIUM_DIRT_GRAVEL_CONFIG).precipitation(Biome.RainType.RAIN).category(Biome.Category.MUSHROOM).depth(0.2F).scale(0.3F).temperature(0.9F).downfall(1.0F).waterColor(4159204).waterFogColor(329011).parent((String)null));
        this.addStructure(Feature.MINESHAFT, new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL));
        this.addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);
        ExpansiveBiomeFeatures.addCarvers(this);
        ExpansiveBiomeFeatures.addStructures(this);
        ExpansiveBiomeFeatures.addLakes(this);
        ExpansiveBiomeFeatures.addMonsterRooms(this);
        ExpansiveBiomeFeatures.addStoneVariants(this);
        ExpansiveBiomeFeatures.addOres(this);
        ExpansiveBiomeFeatures.addSedimentDisks(this);
        ExpansiveBiomeFeatures.addHugeMushrooms(this);
        ExpansiveBiomeFeatures.addMushrooms(this);
        ExpansiveBiomeFeatures.addReedsAndPumpkins(this);
        ExpansiveBiomeFeatures.addSprings(this);
        ExpansiveBiomeFeatures.addFreezeTopLayer(this);
        this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.MOOSHROOM, 8, 4, 8));
        this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
    }
}