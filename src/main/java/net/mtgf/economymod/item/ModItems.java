package net.mtgf.economymod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mtgf.economymod.EconomyMod;

public class ModItems {
    // ItemStep 1.아래 내용 쓰기 --> 이후 main.java.net.mtgf.economymod.EconomyMod.java로 가기
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EconomyMod.MOD_ID);

    // ITEM 추가하기 - 모드아이템
    // ItemStep 3. ITEM_NAME과 "item_name" 쓰기 --> 이후 main.java.net.mtgf.economymod.EconomyMod.java로 가기
    // 1,000,000 Won
    public static final RegistryObject<Item> WON_1M = ITEMS.register("won_1m",
            () -> new Item(new Item.Properties()));
    // 500,000 Won
    public static final RegistryObject<Item> WON_500K = ITEMS.register("won_500k",
            () -> new Item(new Item.Properties()));
    // 100,000 Won
    public static final RegistryObject<Item> WON_100K = ITEMS.register("won_100k",
            () -> new Item(new Item.Properties()));
    // 50,000 Won
    public static final RegistryObject<Item> WON_50K = ITEMS.register("won_50k",
            () -> new Item(new Item.Properties()));
    // 10,000 Won
    public static final RegistryObject<Item> WON_10K = ITEMS.register("won_10k",
            () -> new Item(new Item.Properties()));
    // 5,000 Won
    public static final RegistryObject<Item> WON_5K = ITEMS.register("won_5k",
            () -> new Item(new Item.Properties()));
    // 1,000 Won
    public static final RegistryObject<Item> WON_1K = ITEMS.register("won_1k",
            () -> new Item(new Item.Properties()));
    // 500 Won
    public static final RegistryObject<Item> WON_500 = ITEMS.register("won_500",
            () -> new Item(new Item.Properties()));
    // 100 Won
    public static final RegistryObject<Item> WON_100 = ITEMS.register("won_100",
            () -> new Item(new Item.Properties()));


    // ITEM 추가하기 - 바닐라아이템
    // ItemStep 3. ITEM_NAME과 "item_name" 쓰기 --> 이후 main.java.net.mtgf.economymod.EconomyMod.java로 가기
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
