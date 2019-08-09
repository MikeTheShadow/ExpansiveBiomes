package com.MikeTheShadow.ExpansiveBiomes.WorldGen.Biome;

import com.MikeTheShadow.ExpansiveBiomes.WorldGen.BiomeFeatures.ExpansiveBiomeFeatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.feature.structure.PillagerOutpostConfig;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class HardwoodforestBiome extends Biome
{
    //public static final SurfaceBuilderConfig tempConfig = new SurfaceBuilderConfig(Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState());
    public static final HardwoodforestBiome BIOME = new HardwoodforestBiome();
    public HardwoodforestBiome()
    {
        super((new Builder()).func_222351_a(SurfaceBuilder.field_215396_G, SurfaceBuilder.field_215425_v).precipitation(RainType.RAIN).category(Category.TAIGA).depth(0.2F).scale(0.2F).temperature(0.25F).downfall(0.8F).waterColor(4159204).waterFogColor(329011).parent((String)null));
        this.addStructure(Feature.field_214550_p, new VillageConfig("village/taiga/town_centers", 6));
        this.addStructure(Feature.field_214536_b, new PillagerOutpostConfig(0.004D));
        this.addStructure(Feature.MINESHAFT, new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL));
        this.addStructure(Feature.STRONGHOLD, IFeatureConfig.NO_FEATURE_CONFIG);
        DefaultBiomeFeatures.func_222300_a(this);
        DefaultBiomeFeatures.func_222295_c(this);
        DefaultBiomeFeatures.func_222333_d(this);
        DefaultBiomeFeatures.func_222335_f(this);
        DefaultBiomeFeatures.func_222345_o(this);
        DefaultBiomeFeatures.func_222326_g(this);
        DefaultBiomeFeatures.func_222288_h(this);
        DefaultBiomeFeatures.func_222282_l(this);
        DefaultBiomeFeatures.func_222342_U(this);
        DefaultBiomeFeatures.func_222319_X(this);
        DefaultBiomeFeatures.func_222315_Z(this);
        DefaultBiomeFeatures.func_222311_aa(this);
        DefaultBiomeFeatures.func_222337_am(this); //this is lava/water
        DefaultBiomeFeatures.func_222341_q(this);
        DefaultBiomeFeatures.func_222297_ap(this);
        //Custom spawns
        ExpansiveBiomeFeatures.spawn_maple_tree(this);
        ExpansiveBiomeFeatures.spawn_beech_tree(this);
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 8, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.WOLF, 8, 4, 4));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.RABBIT, 4, 2, 3));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.field_220356_B, 8, 2, 4));
        this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
    }
}
