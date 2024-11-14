package net.mtgf.economymod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.mtgf.economymod.block.ModBlocks;
import net.mtgf.economymod.item.ModCreativeModTabs;
import net.mtgf.economymod.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(net.mtgf.economymod.EconomyMod.MOD_ID)
public class EconomyMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "economymod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public EconomyMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // ItemStep C2. 바로 아래 문장 추가하기 --> main.java.net.mtgf.economymod.item.ModCreativeModTabs.java로 가기
        ModCreativeModTabs.register(modEventBus);

        // ItemStep2. 아래 문장 추가하기  --> 이후 main.java.net.mtgf.economymod.item.ModItems.java로 가기
        ModItems.register(modEventBus);
        // BlockStep2. 아래 문장 추가하기 --> main.java.net.mtgf.economymod.block.ModBlocks.java로 가기
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // ItemStep 4. ITEM_NAME 선언하기
        // resources.assets.economymod = A 로 축약함
        // resources.data.economymod = D 로 축약함
        // resources.data.minecraft = M 으로 축약함
    // ItemStep 5. A.lang.en_us.json과 A.lang.ko_kr.json에 이름 추가하기
    // ItemStep 6. A.models.item.item_name.json 추가하기 (3D인 경우 HKM4 리소스팩 모델 참고)
    // ItemStep 7. A.textures.item.item_name.png 추가하기 (위의 item_name과 동일할 필요는 없음)

    // 크리에이티브 탭 생성
    // Creative Tab이 따로 필요한 경우 : main.java.net.mtgf.economymod.item.ModCreativeModTabs.java 에 아이템 넣기 (밑의 CreativeModeTabs.INGREDIENTS 말고)
    // ItemStep C1. 위의 public EconomyMod()로 가기

    // BlockStep 6. A.lang.en_us.json과 R.lang.ko_kr.json에 이름 추가하기
    // BlockStep 7. A.blockstates.block_name.json 추가하기
    // BlockStep 8. A.models.block.block_name.json 추가하기
    // BlockStep 9. A.models.item.block_name.json 추가하기
    // BlockStep 10. A.textures.block.block_name.png 추가하기
    // BlockStep 11. A.textures.item.block_name.png 추가하기
    // BlockStep 12. D.loot_tables.blocks.block_name.json 추가하기
    // BlockStep 13. M.tags.blocks.mineable.tool_name.json에 이름 추가하기
    // BlockStep 14. M.tags.blocks.needs_ingridient_tool.json에 이름 추가하기
        // 네더라이트 도구는 resources.data.forge.tags.blocks.needs_netherite_tool.json 에 추가하기
        // 주의사항 : 해당 블록을 채굴할 도구의 가장 하위 등급의 도구 칸에만 쓰면 됨. 상위티어에도 쓰면 상위 티어 이상의 도구로만 채굴 가능
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            // 크리탭 - 재료 탭으로 (탭 변경 안함 --> ModCreativeModTabs.java에 추가 안함
            event.accept(ModItems.RUBY); // Ruby
            event.accept(ModBlocks.RUBY_BLOCK); // Ruby Block
            event.accept(ModBlocks.RUBY_ORE_BLOCK); // Ruby Ore Block

            event.accept(ModItems.SILVER_ORE); // Silver Ore
            event.accept(ModItems.SILVER_INGOT); // Silver Ingot
            event.accept(ModBlocks.SILVER_BLOCK); // Silver Block
            event.accept(ModBlocks.SILVER_ORE_BLOCK); // Silver Ore Block
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
