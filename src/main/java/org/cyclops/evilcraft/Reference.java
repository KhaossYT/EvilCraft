package org.cyclops.evilcraft;

/**
 * Class that can hold basic static things that are better not hard-coded
 * like mod details, texture paths, ID's...
 * @author rubensworks
 *
 */
@SuppressWarnings("javadoc")
public class Reference {
	
    // Mod info
    public static final String MOD_ID = "evilcraft";
    public static final String MOD_NAME = "EvilCraft";
    public static final String MOD_VERSION = "@VERSION@";
    public static final String MOD_BUILD_NUMBER = "@BUILD_NUMBER@";
    public static final String MOD_CHANNEL = MOD_ID;
    public static final String MOD_MC_VERSION = "@MC_VERSION@";
    public static final String MOD_FINGERPRINT = "@FINGERPRINT@";
    public static final String GA_TRACKING_ID = "UA-65307010-2";
    public static final String VERSION_URL = "https://raw.githubusercontent.com/CyclopsMC/Versions/master/1.12/EvilCraft.txt";

    // IMC keys
    public static final String IMC_BLACKLIST_VENGEANCESPIRIT = "blacklistVengeanceSpirit";
    public static final String IMC_OVERRIDE_SPIRITFURNACE_DROPS = "overrideSpiritFurnaceDrops";
    
    // Paths
    public static final String TEXTURE_PATH_GUI = "textures/gui/";
    public static final String TEXTURE_PATH_SKINS = "textures/skins/";
    public static final String TEXTURE_PATH_MODELS = "textures/models/";
    public static final String TEXTURE_PATH_ENTITIES = "textures/entities/";
    public static final String TEXTURE_PATH_GUIBACKGROUNDS = "textures/gui/title/background/";
    public static final String TEXTURE_PATH_ITEMS = "textures/items/";
    public static final String TEXTURE_PATH_PARTICLES = "textures/particles/";
    public static final String MODEL_PATH = "models/";
    
    // Enchantment ID's
    public static final int ENCHANTMENT_BREAKING = 101;
    public static final int ENCHANTMENT_LIFESTEALING = 102;
    public static final int ENCHANTMENT_UNUSING = 103;
    public static final int ENCHANTMENT_POISON_TIP = 104;
    public static final int ENCHANTMENT_VENGEANCE = 105;

    // Potion effect ID's
    public static final int POTION_PALING = 121;
    
    // Biome ID's
    public static final int BIOME_DEGRADED = 105;
    
    // Villager ID's
    public static final int VILLAGER_WEREWOLF = 66666;
    
    // OREDICT NAMES
    public static final String DICT_MATERIALPOISONOUS = "materialPoisonous";
    public static final String DICT_BLOCKGLASS = "blockGlass";
    public static final String DICT_MATERIALLEATHER = "materialLeather";
    public static final String DICT_MATERIALBONE = "materialBone";
    public static final String DICT_COBBLESTONE = "cobblestone";
    public static final String DICT_BLOCKSTONE = "blockStone";
    public static final String DICT_OREDARK = "oreDark";
    public static final String DICT_WOODPLANK = "plankWood";
    public static final String DICT_WOODLOG = "logWood";
    public static final String DICT_WOODSTICK = "stickWood";
    public static final String DICT_SAPLINGTREE = "treeSapling";
    public static final String DICT_GEMDARK = "gemDark";
    public static final String DICT_GEMDARKPOWER = "gemDarkPower";
    public static final String DICT_DYERED = "dyeRed";
    public static final String DICT_GEMDARKCRUSHED = "gemDarkCrushed";
    public static final String DICT_MATERIALSPIKE = "materialSpike";
    public static final String DICT_ITEMSKULL = "itemSkull";
    public static final String DICT_DUSTDULL = "dustDull";
    public static final String DICT_FLESH = "materialFlesh";
    public static final String DICT_STAIRWOOD = "stairWood";
    
    // MOD ID's
    public static final String MOD_FORGE = "forge";
    public static final String MOD_FORGE_VERSION = "@FORGE_VERSION@";
    public static final String MOD_FORGE_VERSION_MIN = "14.23.1.2555";
    public static final String MOD_CYCLOPSCORE = "cyclopscore";
    public static final String MOD_CYCLOPSCORE_VERSION = "@CYCLOPSCORE_VERSION@";
    public static final String MOD_CYCLOPSCORE_VERSION_MIN = "0.11.5";
    public static final String MOD_THERMALEXPANSION = "thermalexpansion";
    public static final String MOD_WAILA = "Waila";
    public static final String MOD_FORESTRY = "forestry";
    public static final String MOD_TCONSTRUCT = "tconstruct";
    public static final String MOD_BAUBLES = "baubles";
    public static final String MOD_BLOODMAGIC = "bloodmagic";
    public static final String MOD_THAUMCRAFT = "thaumcraft";
    public static final String MOD_EE3 = "ee3";
    public static final String MOD_IC2 = "ic2";
    public static final String MOD_JEI = "jei";
    public static final String MOD_IMMERSIVEENGINEERING = "immersiveengineering";
    public static final String MOD_ENDERIO = "enderio";
    public static final String MOD_MINETWEAKER = "minetweaker3";
    
    // Dependencies
    public static final String MOD_DEPENDENCIES =
            "required-after:" + MOD_FORGE       + "@[" + MOD_FORGE_VERSION_MIN       + ",);" +
            "required-after:" + MOD_CYCLOPSCORE + "@[" + MOD_CYCLOPSCORE_VERSION_MIN + ",);";
}