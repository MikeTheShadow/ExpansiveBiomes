package com.MikeTheShadow.ExpansiveBiomes.WorldGen.Biome;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SeaGrassConfig;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

/**
 * Based on {@link net.minecraft.world.biome.OceanBiome}. Changed depth to -0.3F and scale to 0.03F for shallower ocean.
 */

public class ShallowColdOceanBiome extends Biome {
    public static final ShallowColdOceanBiome BIOME = new ShallowColdOceanBiome();
    public ShallowColdOceanBiome() {
        super((new Biome.Builder()).func_222351_a(SurfaceBuilder.field_215396_G, SurfaceBuilder.field_215425_v).precipitation(Biome.RainType.RAIN).category(Biome.Category.OCEAN).depth(-0.3F).scale(0.03F).temperature(0.5F).downfall(0.5F).waterColor(4020182).waterFogColor(329011).parent((String)null));
        this.addStructure(Feature.MINESHAFT, new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL));
        this.addStructure(Feature.OCEAN_RUIN, new OceanRuinConfig(OceanRuinStructure.Type.COLD, 0.3F, 0.9F));
        this.addStructure(Feature.SHIPWRECK, new ShipwreckConfig(false));
        DefaultBiomeFeatures.func_222346_b(this);
        DefaultBiomeFeatures.func_222295_c(this);
        DefaultBiomeFeatures.func_222333_d(this);
        DefaultBiomeFeatures.func_222335_f(this);
        DefaultBiomeFeatures.func_222326_g(this);
        DefaultBiomeFeatures.func_222288_h(this);
        DefaultBiomeFeatures.func_222282_l(this);
        DefaultBiomeFeatures.func_222296_u(this);
        DefaultBiomeFeatures.func_222342_U(this);
        DefaultBiomeFeatures.func_222348_W(this);
        DefaultBiomeFeatures.func_222315_Z(this);
        DefaultBiomeFeatures.func_222311_aa(this);
        DefaultBiomeFeatures.func_222337_am(this);
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, func_222280_a(Feature.SEA_GRASS, new SeaGrassConfig(32, 0.3D), Placement.field_215036_v, IPlacementConfig.NO_PLACEMENT_CONFIG));
        DefaultBiomeFeatures.func_222320_ai(this);
        DefaultBiomeFeatures.func_222287_ah(this);
        DefaultBiomeFeatures.func_222297_ap(this);
        this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.SQUID, 3, 1, 4));
        this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.COD, 15, 3, 6));
        this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.SALMON, 15, 1, 5));
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
