package com.MikeTheShadow.ExpansiveBiomes;

import com.MikeTheShadow.ExpansiveBiomes.CustomBlocks.CustomBlock;
import com.MikeTheShadow.ExpansiveBiomes.CustomBlocks.CustomLeavesBlock;
import com.MikeTheShadow.ExpansiveBiomes.CustomBlocks.CustomLogBlock;
import com.MikeTheShadow.ExpansiveBiomes.CustomBlocks.CustomSaplingBlock;
import com.MikeTheShadow.ExpansiveBiomes.Tree.BeechTree;
import com.MikeTheShadow.ExpansiveBiomes.Tree.MapleTree;
import com.MikeTheShadow.ExpansiveBiomes.Utils.ExpansiveItemGroup;
import com.MikeTheShadow.ExpansiveBiomes.WorldGen.Biome.CustomBiomes.*;
import com.MikeTheShadow.ExpansiveBiomes.WorldGen.Biome.DefaultBiomes.*;
import com.MikeTheShadow.ExpansiveBiomes.WorldGen.ExpansiveWorldType;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//TODO add vanilla biomes to our version!

@Mod.EventBusSubscriber(modid = ExpansiveBiomes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@Mod(ExpansiveBiomes.MODID)
public class ExpansiveBiomes
{
    public static final String MODID = "expansivebiomes";
    //BLOCKLISTS
    private static List<Block> blockListPlank = new ArrayList<>();
    public static List<Block> blockListLog = new ArrayList<>();
    public static List<Block> blockListLeaves = new ArrayList<>();
    public static List<Block> blockListSapling = new ArrayList<>();
    private static List<String> woodTypes = new ArrayList<>();
    public static List<Item> itemlist = new ArrayList<>();

    public static Biome[] biomeListAll = new Biome[170];
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public ExpansiveBiomes()
    {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void setup(final FMLCommonSetupEvent event)
    {
        try
        {
            Class.forName("DefaultBiomeFeatures");
        }
        catch (Exception e)
        {
            LOGGER.info(e.getMessage());
        }
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
    //DONT DELETE THIS MORON IT CREATES THE WORLD TYPE
    public static WorldType ExpansiveWorldType = new ExpansiveWorldType();
    public static final ItemGroup expansiveItemGroup = new ExpansiveItemGroup();


    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event)
    {
        itemlist.add(new Item(new Item.Properties().maxStackSize(64).group(expansiveItemGroup)).setRegistryName(ExpansiveBiomes.MODID, "sawdust"));
        for(int saplingID = 0; saplingID < blockListSapling.size();saplingID++)
        {
            itemlist.add(new BlockItem(blockListSapling.get(saplingID),new Item.Properties().group(expansiveItemGroup).addToolType(ToolType.AXE,0)).setRegistryName(ExpansiveBiomes.MODID,woodTypes.get(saplingID) + "_sapling"));
        }
        for(int logID = 0; logID < blockListLog.size(); logID++)
        {
            itemlist.add(new BlockItem(blockListLog.get(logID),new Item.Properties().group(expansiveItemGroup).addToolType(ToolType.AXE,0)).setRegistryName(ExpansiveBiomes.MODID,woodTypes.get(logID) + "_log"));
            itemlist.add(new BlockItem(blockListPlank.get(logID),new Item.Properties().group(expansiveItemGroup).addToolType(ToolType.AXE,0)).setRegistryName(ExpansiveBiomes.MODID,woodTypes.get(logID) + "_planks"));
            itemlist.add(new BlockItem(blockListLeaves.get(logID),new Item.Properties().group(expansiveItemGroup).addToolType(ToolType.AXE,0)).setRegistryName(ExpansiveBiomes.MODID,woodTypes.get(logID) + "_leaves"));
        }
        for(int itemCount = 0; itemCount < itemlist.size(); itemCount++)
        {
            event.getRegistry().register(itemlist.get(itemCount));
        }

    }
    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event)
    {
        //DO NOT CHANGE THE ORDER OF THIS UNLESS GIVEN EXPRESS PERMISSION
        woodTypes.add("maple");
        woodTypes.add("ash");
        woodTypes.add("beech");
        woodTypes.add("elm");
        woodTypes.add("mahogany");
        woodTypes.add("teak");
        woodTypes.add("ginkgo");
        //Tree items
        for(int logID = 0; logID < woodTypes.size();logID++)
        {
            blockListLog.add(new CustomLogBlock(MaterialColor.BROWN,Block.Properties.create(Material.WOOD).hardnessAndResistance(3.0f, 3.0f).sound(SoundType.WOOD)).setRegistryName(ExpansiveBiomes.MODID, woodTypes.get(logID) + "_log"));
            blockListPlank.add(new CustomBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(3.0f, 3.0f).sound(SoundType.WOOD)).setRegistryName(ExpansiveBiomes.MODID, woodTypes.get(logID) + "_planks"));
            blockListLeaves.add(new CustomLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT)).setRegistryName(ExpansiveBiomes.MODID, woodTypes.get(logID) + "_leaves"));
        }
        blockListSapling.add(new CustomSaplingBlock(new MapleTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT).hardnessAndResistance(0f,0f)).setRegistryName(woodTypes.get(0) +"_sapling"));
        blockListSapling.add(new CustomSaplingBlock(new MapleTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT).hardnessAndResistance(0f,0f)).setRegistryName(woodTypes.get(1) +"_sapling"));
        blockListSapling.add(new CustomSaplingBlock(new BeechTree(), Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT).hardnessAndResistance(0f,0f)).setRegistryName(woodTypes.get(2) +"_sapling"));
        event.getRegistry().register(blockListSapling.get(0));
        for(int blockCount = 0; blockCount < blockListLog.size();blockCount++)
        {
            event.getRegistry().register(blockListLog.get(blockCount));
            event.getRegistry().register(blockListLeaves.get(blockCount));
            event.getRegistry().register(blockListPlank.get(blockCount));
        }
        for(int saplingCount = 0; saplingCount < blockListSapling.size();saplingCount++)
        {
            event.getRegistry().register(blockListSapling.get(saplingCount));
        }
    }
    @SubscribeEvent
    public static void registerBiome(final RegistryEvent.Register<Biome> event)
    {
        LOGGER.info("Testing123: " + blockListLog.get(0).getTags().size());
        LOGGER.info("ID: " + blockListLog.get(0).getRegistryName());
        for(int i = 0; i < biomeListAll.length;i++)
        {
            biomeListAll[i] = ShieldBiome.BIOME;
        }
        ExpansiveBiomeRegister("hardwoodforest",HardwoodforestBiome.BIOME,51);
        ExpansiveBiomeRegister("shield",ShieldBiome.BIOME,52);
        ExpansiveBiomeRegister("shallowwarmocean",ShallowWarmOceanBiome.BIOME,53);
        ExpansiveBiomeRegister("shallowlukewarmocean",ShallowLukewarmOceanBiome.BIOME,54);
        ExpansiveBiomeRegister("shallowocean",ShallowOceanBiome.BIOME,55);
        ExpansiveBiomeRegister("shallowcoldocean",ShallowColdOceanBiome.BIOME,56);
        ExpansiveBiomeRegister("shallowfrozenocean",ShallowFrozenOceanBiome.BIOME,57);


        ExpansiveBiomeRegister("snowy_taiga",new ExpansiveSnowyTaigaBiome(),30);
        ExpansiveBiomeRegister("snowy_taiga_hills",new ExpansiveSnowyTaigaHillsBiome(),31);
        ExpansiveBiomeRegister("giant_tree_taiga",new ExpansiveGiantTreeTaigaBiome(),32);
        ExpansiveBiomeRegister("giant_tree_taiga_hills",new ExpansiveGiantTreeTaigaHillsBiome(),33);
        ExpansiveBiomeRegister("wooded_mountains",new ExpansiveWoodedMountainsBiome(),34);
        ExpansiveBiomeRegister("savanna",new ExpansiveSavannaBiome(),35);
        ExpansiveBiomeRegister("savanna_plateau",new ExpansiveSavannaPlateauBiome(),36);
        ExpansiveBiomeRegister("badlands",new ExpansiveBadlandsBiome(),37);
        ExpansiveBiomeRegister("wooded_badlands_plateau",new ExpansiveWoodedBadlandsPlateauBiome(),38);
        ExpansiveBiomeRegister("badlands_plateau",new ExpansiveBadlandsPlateauBiome(),39);
        ExpansiveBiomeRegister("small_end_islands",new ExpansiveSmallEndIslandsBiome(),40);
        ExpansiveBiomeRegister("end_midlands",new ExpansiveEndMidlandsBiome(),41);
        ExpansiveBiomeRegister("end_highlands",new ExpansiveEndHighlandsBiome(),42);
        ExpansiveBiomeRegister("end_barrens",new ExpansiveEndBarrensBiome(),43);
        ExpansiveBiomeRegister("warm_ocean",new ExpansiveWarmOceanBiome(),44);
        ExpansiveBiomeRegister("lukewarm_ocean",new ExpansiveLukewarmOceanBiome(),45);
        ExpansiveBiomeRegister("cold_ocean",new ExpansiveColdOceanBiome(),46);
        ExpansiveBiomeRegister("deep_warm_ocean",new ExpansiveDeepWarmOceanBiome(),47);
        ExpansiveBiomeRegister("deep_lukewarm_ocean",new ExpansiveDeepLukewarmOceanBiome(),48);
        ExpansiveBiomeRegister("deep_cold_ocean",new ExpansiveDeepColdOceanBiome(),49);
        ExpansiveBiomeRegister("deep_frozen_ocean",new ExpansiveDeepFrozenOceanBiome(),50);
        ExpansiveBiomeRegister("the_void",new ExpansiveVoidBiome(),127);
        ExpansiveBiomeRegister("sunflower_plains",new ExpansiveSunflowerPlainsBiome(),129);
        ExpansiveBiomeRegister("desert_lakes",new ExpansiveDesertLakesBiome(),130);
        ExpansiveBiomeRegister("gravelly_mountains",new ExpansiveGravellyMountainsBiome(),131);
        ExpansiveBiomeRegister("flower_forest",new ExpansiveFlowerForestBiome(),132);
        ExpansiveBiomeRegister("taiga_mountains",new ExpansiveTaigaMountainsBiome(),133);
        ExpansiveBiomeRegister("swamp_hills",new ExpansiveSwampHillsBiome(),134);
        ExpansiveBiomeRegister("ice_spikes",new ExpansiveIceSpikesBiome(),140);
        ExpansiveBiomeRegister("modified_jungle",new ExpansiveModifiedJungleBiome(),149);
        ExpansiveBiomeRegister("modified_jungle_edge",new ExpansiveModifiedJungleEdgeBiome(),151);
        ExpansiveBiomeRegister("tall_birch_forest",new ExpansiveTallBirchForestBiome(),155);
        ExpansiveBiomeRegister("tall_birch_hills",new ExpansiveTallBirchHillsBiome(),156);
        ExpansiveBiomeRegister("dark_forest_hills",new ExpansiveDarkForestHillsBiome(),157);
        ExpansiveBiomeRegister("snowy_taiga_mountains",new ExpansiveFlowerForestBiome(),158);
        ExpansiveBiomeRegister("giant_spruce_taiga",new ExpansiveGiantSpruceTaigaBiome(),160);
        ExpansiveBiomeRegister("giant_spruce_taiga_hills",new ExpansiveGiantSpruceTaigaHillsBiome(),161);
        ExpansiveBiomeRegister("modified_gravelly_mountains",new ExpansiveModifiedGravellyMountainsBiome(),162);
        ExpansiveBiomeRegister("shattered_savanna",new ExpansiveShatteredSavannaBiome(),163);
        ExpansiveBiomeRegister("shattered_savanna_plateau",new ExpansiveShatteredSavannaPlateauBiome(),164);
        ExpansiveBiomeRegister("eroded_badlands",new ExpansiveErodedBadlandsBiome(),165);
        ExpansiveBiomeRegister("modified_wooded_badlands_plateau",new ExpansiveModifiedWoodedBadlandsPlateauBiome(),166);
        ExpansiveBiomeRegister("modified_badlands_plateau",new ExpansiveModifiedBadlandsPlateauBiome(),167);
        ExpansiveBiomeRegister("bamboo_jungle",new ExpansiveBambooJungleHillsBiome(),168);
        ExpansiveBiomeRegister("bamboo_jungle_hills",new ExpansiveBambooJungleHillsBiome(),169);

        ExpansiveBiomeRegister("ocean", new ExpansiveOceanBiome(),0);
        ExpansiveBiomeRegister("plains", new ExpansivePlainsBiome(),1);
        ExpansiveBiomeRegister("desert", new ExpansiveDesertBiome(),2);
        ExpansiveBiomeRegister("mountains", new ExpansiveMountainsBiome(),3);
        ExpansiveBiomeRegister("forest", new ExpansiveForestBiome(),4);
        ExpansiveBiomeRegister("taiga", new ExpansiveForestBiome(),5);
        ExpansiveBiomeRegister("swamp", new ExpansiveSwampBiome(),6);
        ExpansiveBiomeRegister("river", new ExpansiveRiverBiome(), 7);
        ExpansiveBiomeRegister("nether", new ExpansiveNetherBiome(), 8);
        ExpansiveBiomeRegister("the_end", new ExpansiveEndBiome(),9);
        ExpansiveBiomeRegister("frozen_ocean", new ExpansiveFrozenOceanBiome(),10);
        ExpansiveBiomeRegister("frozen_river", new ExpansiveFrozenRiverBiome(), 11);
        ExpansiveBiomeRegister("snowy_tundra",new ExpansiveSnowyTundraBiome(),12);
        ExpansiveBiomeRegister("snowy_mountains",new ExpansiveSnowyMountainsBiome(),13);
        ExpansiveBiomeRegister("mushroom_fields",new ExpansiveMushroomFieldsBiome(),14);
        ExpansiveBiomeRegister("mushroom_fields_shore",new ExpansiveMushroomFieldsShore(),15);
        ExpansiveBiomeRegister("beach",new ExpansiveBeachBiome(),16);
        ExpansiveBiomeRegister("desert_hills",new ExpansiveDesertHillsBiome(),17);
        ExpansiveBiomeRegister("wooded_hills",new ExpansiveWoodedHillsBiome(),18);
        ExpansiveBiomeRegister("taiga_hills",new ExpansiveTaigaHillsBiome(), 19);
        ExpansiveBiomeRegister("mountain_edge",new ExpansiveMountainEdgeBiome(),20);
        ExpansiveBiomeRegister("jungle",new ExpansiveJungleBiome(),21);
        ExpansiveBiomeRegister("jungle_hills",new ExpansiveJungleHillsBiome(),22);
        ExpansiveBiomeRegister("jungle_edge",new ExpansiveJungleEdgeBiome(),23);
        ExpansiveBiomeRegister("deep_ocean",new ExpansiveDeepOceanBiome(),24);
        ExpansiveBiomeRegister("stone_shore", new ExpansiveStoneShoreBiome(), 25);
        ExpansiveBiomeRegister("snowy_beach",new ExpansiveSnowyBeachBiome(), 26);
        ExpansiveBiomeRegister("birch_forest",new ExpansiveBirchForestBiome(), 27);
        ExpansiveBiomeRegister("birch_forest_hills",new ExpansiveBirchForestHillsBiome(),28);
        ExpansiveBiomeRegister("dark_forest",new ExpansiveDarkForestBiome(),29);



    }
    public static void ExpansiveBiomeRegister(String Name, Biome biome,int id)
    {
        biome.setRegistryName(Name);
        ForgeRegistries.BIOMES.register(biome);
        biomeListAll[id] = biome;
    }

}
