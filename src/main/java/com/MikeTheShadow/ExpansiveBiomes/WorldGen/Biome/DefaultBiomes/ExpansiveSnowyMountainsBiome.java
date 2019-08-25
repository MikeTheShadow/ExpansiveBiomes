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


public final class ExpansiveSnowyMountainsBiome extends Biome {
    public ExpansiveSnowyMountainsBiome() {
        super((new Biome.Builder()).surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG).precipitation(Biome.RainType.SNOW).category(Biome.Category.ICY).depth(0.45F).scale(0.3F).temperature(0.0F).downfall(0.5F).waterColor(4159204).waterFogColor(329011).parent((String)null));
        this.addStructure(Feature.MINESHAFT, new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL));
        this.addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);
        ExpansiveBiomeFeatures.addCarvers(this);
        ExpansiveBiomeFeatures.addStructures(this);
        ExpansiveBiomeFeatures.addLakes(this);
        ExpansiveBiomeFeatures.addMonsterRooms(this);
        ExpansiveBiomeFeatures.addStoneVariants(this);
        ExpansiveBiomeFeatures.addOres(this);
        ExpansiveBiomeFeatures.addSedimentDisks(this);
        ExpansiveBiomeFeatures.func_222284_F(this);
        ExpansiveBiomeFeatures.addDefaultFlowers(this);
        ExpansiveBiomeFeatures.func_222348_W(this);
        ExpansiveBiomeFeatures.addMushrooms(this);
        ExpansiveBiomeFeatures.addReedsAndPumpkins(this);
        ExpansiveBiomeFeatures.addSprings(this);
        ExpansiveBiomeFeatures.addFreezeTopLayer(this);
        this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.RABBIT, 10, 2, 3));
        this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.POLAR_BEAR, 1, 1, 2));
        this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 20, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.STRAY, 80, 4, 4));
    }

    /**
     * returns the chance a creature has to spawn.
     */
    public float getSpawningChance() {
        return 0.07F;
    }
}