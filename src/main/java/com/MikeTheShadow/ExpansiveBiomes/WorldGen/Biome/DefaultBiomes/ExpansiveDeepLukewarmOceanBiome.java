package com.MikeTheShadow.ExpansiveBiomes.WorldGen.Biome.DefaultBiomes;

import com.MikeTheShadow.ExpansiveBiomes.WorldGen.BiomeFeatures.ExpansiveBiomeFeatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class ExpansiveDeepLukewarmOceanBiome extends Biome
{
    public ExpansiveDeepLukewarmOceanBiome() {
        super((new Biome.Builder()).surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_SAND_CONFIG).precipitation(Biome.RainType.RAIN).category(Biome.Category.OCEAN).depth(-1.8F).scale(0.1F).temperature(0.5F).downfall(0.5F).waterColor(4566514).waterFogColor(267827).parent((String)null));
        this.addStructure(Feature.OCEAN_RUIN, new OceanRuinConfig(OceanRuinStructure.Type.WARM, 0.3F, 0.9F));
        this.addStructure(Feature.OCEAN_MONUMENT, IFeatureConfig.NO_FEATURE_CONFIG);
        this.addStructure(Feature.MINESHAFT, new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL));
        this.addStructure(Feature.SHIPWRECK, new ShipwreckConfig(false));
        ExpansiveBiomeFeatures.addOceanCarvers(this);
        ExpansiveBiomeFeatures.addStructures(this);
        ExpansiveBiomeFeatures.addLakes(this);
        ExpansiveBiomeFeatures.addMonsterRooms(this);
        ExpansiveBiomeFeatures.addStoneVariants(this);
        ExpansiveBiomeFeatures.addOres(this);
        ExpansiveBiomeFeatures.addSedimentDisks(this);
        ExpansiveBiomeFeatures.func_222296_u(this);
        ExpansiveBiomeFeatures.addDefaultFlowers(this);
        ExpansiveBiomeFeatures.func_222348_W(this);
        ExpansiveBiomeFeatures.addMushrooms(this);
        ExpansiveBiomeFeatures.addReedsAndPumpkins(this);
        ExpansiveBiomeFeatures.addSprings(this);
        ExpansiveBiomeFeatures.func_222340_ak(this);
        ExpansiveBiomeFeatures.func_222320_ai(this);
        ExpansiveBiomeFeatures.addKelp(this);
        ExpansiveBiomeFeatures.addFreezeTopLayer(this);
        this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.SQUID, 8, 1, 4));
        this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.COD, 8, 3, 6));
        this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.PUFFERFISH, 5, 1, 3));
        this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.TROPICAL_FISH, 25, 8, 8));
        this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.DOLPHIN, 2, 1, 2));
        this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.DROWNED, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
    }
}