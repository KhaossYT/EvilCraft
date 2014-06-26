package evilcraft.items;

import evilcraft.api.config.ItemConfig;

/**
 * Config for the {@link LargeDoorItem}.
 * @author rubensworks
 *
 */
public class LargeDoorItemConfig extends ItemConfig {
    
    /**
     * The unique instance.
     */
    public static LargeDoorItemConfig _instance;

    /**
     * Make a new instance.
     */
    public LargeDoorItemConfig() {
        super(
        	true,
            "largeDoorItem",
            null,
            LargeDoorItem.class
        );
    }
    
    @Override
    public boolean isHardDisabled() {
    	return true;
    }
    
}
