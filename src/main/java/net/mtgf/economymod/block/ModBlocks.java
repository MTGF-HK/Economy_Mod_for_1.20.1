package net.mtgf.economymod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mtgf.economymod.EconomyMod;
import net.mtgf.economymod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    // BlockStep 1.Block_NAME과 "block_name" 쓰기 --> 이후 main.java.net.mtgf.economymod.EconomyMod.java로 가기
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EconomyMod.MOD_ID);

    // BlockStep 5. Block_NAME과 "block_name" 쓰기 --> 이후 main.java.net.mtgf.economymod.EconomyMod.java로 가기
        // .copy(Blocks.IRON_BLOCK) 뒤에 .sound(SoundType.COPPER) 붙이기 : 부서질 때 소리 설정
    // Ruby Block
    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    // Ruby Ore Block + Exp Drop
    public static final RegistryObject<Block> RUBY_ORE_BLOCK = registerBlock("ruby_ore_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .requiresCorrectToolForDrops(), UniformInt.of(3,6)));



    // Silver Block
    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    // Silver Ore Block
    public static final RegistryObject<Block> SILVER_ORE_BLOCK = registerBlock("silver_ore_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));


    // BlockStep4. 아래 내용 추가하기 -> 위로 이동
    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }



    // BLOCK 추가하기
    // BlockStep3. 아래 내용 추가하기 -> 위로 이동
    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
