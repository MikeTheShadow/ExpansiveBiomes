package com.MikeTheShadow.ExpansiveBiomes;

import com.MikeTheShadow.ExpansiveBiomes.CustomBlocks.CustomBlock;
import com.MikeTheShadow.ExpansiveBiomes.CustomBlocks.CustomLeavesBlock;
import com.MikeTheShadow.ExpansiveBiomes.CustomBlocks.CustomLogBlock;
import com.MikeTheShadow.ExpansiveBiomes.CustomBlocks.CustomSaplingBlock;
import com.MikeTheShadow.ExpansiveBiomes.Tree.BeechTree;
import com.MikeTheShadow.ExpansiveBiomes.Tree.MapleTree;
import com.MikeTheShadow.ExpansiveBiomes.Utils.ExpansiveItemGroup;
import com.MikeTheShadow.ExpansiveBiomes.WorldGen.Biome.CustomBiomes.*;
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
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
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

    public static List<Biome> biomeListAll = new ArrayList<>();

    public static List<Biome> biomeListFrozen = new ArrayList<>();
    public static List<Biome> biomeListCold = new ArrayList<>();
    public static List<Biome> biomeListNormal = new ArrayList<>();
    public static List<Biome> biomeListLukeWarm = new ArrayList<>();
    public static List<Biome> biomeListWarm = new ArrayList<>();
    public static List<Biome> biomeListShallow = new ArrayList<>();
    public static Feature<NoFeatureConfig> maple_tree;

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
        Biome hardwoodBiome = HardwoodforestBiome.BIOME;
        Biome shieldBiome = ShieldBiome.BIOME;
        Biome shallowWarmOceanBiome = ShallowWarmOceanBiome.BIOME;
        Biome shallowLukewarmOceanBiome = ShallowLukewarmOceanBiome.BIOME;
        Biome shallowOceanBiome = ShallowOceanBiome.BIOME;
        Biome shallowColdOceanBiome = ShallowColdOceanBiome.BIOME;
        Biome shallowFrozenOceanBiome = ShallowFrozenOceanBiome.BIOME;
        //Temperature based biome lists. Used in ExpansiveBiomeProvider.
        biomeListFrozen.add(Biomes.SNOWY_TAIGA);
        biomeListFrozen.add(Biomes.SNOWY_TUNDRA);
        biomeListCold.add(shieldBiome);
        biomeListCold.add(hardwoodBiome);
        biomeListNormal.add(Biomes.FOREST);
        biomeListLukeWarm.add(Biomes.SAVANNA);
        biomeListLukeWarm.add(Biomes.JUNGLE);
        biomeListWarm.add(Biomes.DESERT_LAKES);
        //Shallow Ocean biome list by temp.
        biomeListShallow.add(shallowWarmOceanBiome);
        biomeListShallow.add(shallowLukewarmOceanBiome);
        biomeListShallow.add(shallowOceanBiome);
        biomeListShallow.add(shallowColdOceanBiome);
        biomeListShallow.add(shallowFrozenOceanBiome);
        //register name
        hardwoodBiome.setRegistryName("hardwoodforest");
        shieldBiome.setRegistryName("shield");
        shallowWarmOceanBiome.setRegistryName("shallowwarmocean");
        shallowLukewarmOceanBiome.setRegistryName("shallowlukewarmocean");
        shallowOceanBiome.setRegistryName("shallowocean");
        shallowColdOceanBiome.setRegistryName("shallowcoldocean");
        shallowFrozenOceanBiome.setRegistryName("shallowfrozenocean");
        //register biome
        ForgeRegistries.BIOMES.register(hardwoodBiome);
        ForgeRegistries.BIOMES.register(shieldBiome);
        ForgeRegistries.BIOMES.register(shallowWarmOceanBiome);
        ForgeRegistries.BIOMES.register(shallowLukewarmOceanBiome);
        ForgeRegistries.BIOMES.register(shallowOceanBiome);
        ForgeRegistries.BIOMES.register(shallowColdOceanBiome);
        ForgeRegistries.BIOMES.register(shallowFrozenOceanBiome);

        biomeListAll.addAll(biomeListShallow);
        biomeListAll.addAll(biomeListCold);
        biomeListAll.addAll(biomeListFrozen);
        biomeListAll.addAll(biomeListLukeWarm);
        biomeListAll.addAll(biomeListWarm);
        biomeListAll.addAll(biomeListNormal);

    }
}
