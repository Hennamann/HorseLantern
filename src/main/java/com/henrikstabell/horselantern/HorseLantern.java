package com.henrikstabell.horselantern;

import com.henrikstabell.horselantern.api.ILanternArmor;
import com.henrikstabell.horselantern.block.HorseArmorLightBlock;
import com.henrikstabell.horselantern.block.entity.HorseArmorLightBlockEntity;
import com.henrikstabell.horselantern.item.DyeableHorseLanternArmorItem;
import com.henrikstabell.horselantern.item.HorseLanternArmorItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(HorseLantern.MODID)
@Mod.EventBusSubscriber(modid = HorseLantern.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HorseLantern {

    public static final String MODID = "horselantern";
    private static final Logger LOGGER = LogManager.getLogger();

    public static Item LEATHER_HORSE_LANTERN_ARMOR;
    public static Item IRON_HORSE_LANTERN_ARMOR;
    public static Item GOLDEN_HORSE_LANTERN_ARMOR;
    public static Item DIAMOND_HORSE_LANTERN_ARMOR;

    public static Block HORSE_ARMOR_LIGHT_BLOCK;
    public static BlockEntityType<HorseArmorLightBlockEntity> HORSE_ARMOR_LIGHT_BLOCK_ENTITYTYPE;

    public HorseLantern() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
        LEATHER_HORSE_LANTERN_ARMOR = new DyeableHorseLanternArmorItem(3, "leather", (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_MISC)).setRegistryName("leather_horse_lantern_armor");
        itemRegisterEvent.getRegistry().register(LEATHER_HORSE_LANTERN_ARMOR);
        IRON_HORSE_LANTERN_ARMOR = new HorseLanternArmorItem(5, "iron", (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_MISC)).setRegistryName("iron_horse_lantern_armor");
        itemRegisterEvent.getRegistry().register(IRON_HORSE_LANTERN_ARMOR);
        GOLDEN_HORSE_LANTERN_ARMOR = new HorseLanternArmorItem(7, "gold", (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_MISC)).setRegistryName("golden_horse_lantern_armor");
        itemRegisterEvent.getRegistry().register(GOLDEN_HORSE_LANTERN_ARMOR);
        DIAMOND_HORSE_LANTERN_ARMOR = new HorseLanternArmorItem(11, "diamond", (new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_MISC)).setRegistryName("diamond_horse_lantern_armor");
        itemRegisterEvent.getRegistry().register(DIAMOND_HORSE_LANTERN_ARMOR);
    }

    @SubscribeEvent
    public static void onBlocksRegistration(final RegistryEvent.Register<Block> blockRegisterEvent) {
        HORSE_ARMOR_LIGHT_BLOCK = new HorseArmorLightBlock(BlockBehaviour.Properties.of(Material.AIR).strength(-1.0F, 3600000.8F).noDrops().noOcclusion().lightLevel(HorseArmorLightBlock.LIGHT_EMISSION)).setRegistryName(MODID, "horse_armor_light");
        blockRegisterEvent.getRegistry().register(HORSE_ARMOR_LIGHT_BLOCK);
    }

    @SubscribeEvent
    public static void onBlockEntityRegistration(RegistryEvent.Register<BlockEntityType<?>> event) {
        HORSE_ARMOR_LIGHT_BLOCK_ENTITYTYPE = BlockEntityType.Builder.of(HorseArmorLightBlockEntity::new, HORSE_ARMOR_LIGHT_BLOCK).build(null);
        HORSE_ARMOR_LIGHT_BLOCK_ENTITYTYPE.setRegistryName(MODID, "horse_armor_light");
        event.getRegistry().register(HORSE_ARMOR_LIGHT_BLOCK_ENTITYTYPE);
    }

    @SubscribeEvent
    public void onHorseUpdate(LivingEvent.LivingUpdateEvent event) {
        BlockState blockState = HORSE_ARMOR_LIGHT_BLOCK.defaultBlockState();
        blockState.setValue(BlockStateProperties.LEVEL, 15);

        Level world = event.getEntityLiving().getCommandSenderWorld();
        BlockPos pos = event.getEntityLiving().eyeBlockPosition();

        if (event.getEntity() instanceof Horse) {
            if (((Horse) event.getEntityLiving()).isWearingArmor()) {
                if (((Horse) event.getEntityLiving()).getArmor().getItem() instanceof ILanternArmor) {
                    world.setBlockAndUpdate(pos, blockState);
                }
            }
        }
    }
}
