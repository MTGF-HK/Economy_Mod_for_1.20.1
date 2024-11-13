package net.mtgf.economymod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.mtgf.economymod.EconomyMod;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EconomyMod.MOD_ID);

    // ItemStep C3.탭 하나당 아래 내용 추가
    public static final RegistryObject<CreativeModeTab> MONEY_TAB = CREATIVE_MODE_TABS.register("money_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.WON_1M.get())) // 크리에이티브 앱 아이콘 = ITEM_NAME
                    .title(Component.translatable("creativetab.money_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        // 여기에 아이템 추가
                        output.accept(ModItems.WON_1M.get()); // 1,000,000원
                        output.accept(ModItems.WON_100K.get()); // 100,000원
                        output.accept(ModItems.WON_50K.get()); // 50,000원
                        output.accept(ModItems.WON_10K.get()); // 10,000원
                        output.accept(ModItems.WON_5K.get()); // 5,000원
                        output.accept(ModItems.WON_1K.get()); // 1,000원
                        output.accept(ModItems.WON_500.get()); // 500원
                        output.accept(ModItems.WON_100.get()); // 100원


                        output.accept(Items.DIAMOND); // 바닐라 아이템도 추가 가능
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
