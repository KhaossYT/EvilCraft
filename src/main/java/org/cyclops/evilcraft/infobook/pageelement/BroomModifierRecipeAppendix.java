package org.cyclops.evilcraft.infobook.pageelement;

import com.google.common.collect.Lists;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import org.apache.commons.lang3.tuple.Pair;
import org.cyclops.cyclopscore.helper.L10NHelpers;
import org.cyclops.cyclopscore.infobook.AdvancedButton;
import org.cyclops.cyclopscore.infobook.GuiInfoBook;
import org.cyclops.cyclopscore.infobook.IInfoBook;
import org.cyclops.cyclopscore.infobook.InfoSection;
import org.cyclops.cyclopscore.infobook.pageelement.RecipeAppendix;
import org.cyclops.cyclopscore.recipe.custom.api.IRecipe;
import org.cyclops.cyclopscore.recipe.custom.component.IngredientRecipeComponent;
import org.cyclops.evilcraft.api.broom.BroomModifier;
import org.cyclops.evilcraft.core.recipe.custom.DurationXpRecipeProperties;
import org.cyclops.evilcraft.core.recipe.custom.IngredientFluidStackAndTierRecipeComponent;

import java.util.List;
import java.util.Map;

/**
 * Broom modifier info.
 * @author rubensworks
 */
public class BroomModifierRecipeAppendix extends RecipeAppendix<IRecipe<IngredientFluidStackAndTierRecipeComponent, IngredientRecipeComponent, DurationXpRecipeProperties>> {

    private static final int START_X_RESULT = 68;

    private static final AdvancedButton.Enum INPUT = AdvancedButton.Enum.create();

    private final BroomModifier modifier;
    private final List<Pair<ItemStack, Float>> modifierValues;

    public BroomModifierRecipeAppendix(IInfoBook infoBook, BroomModifier modifier, Map<ItemStack, Float> modifierValues) {
        super(infoBook, null);
        this.modifier = modifier;
        this.modifierValues = Lists.newArrayList();
        for (Map.Entry<ItemStack, Float> entry : modifierValues.entrySet()) {
            this.modifierValues.add(Pair.of(entry.getKey(), entry.getValue()));
        }
    }

    @Override
    protected int getWidth() {
        return START_X_RESULT + 32;
    }

    @Override
    protected int getHeightInner() {
        return 15;
    }

    @Override
    protected String getUnlocalizedTitle() {
        return "broom.modifiers.evilcraft.type.name";
    }

    @Override
    public void bakeElement(InfoSection infoSection) {
        renderItemHolders.put(INPUT, new ItemButton(getInfoBook()));
        super.bakeElement(infoSection);
    }

    @Override
    public void drawElementInner(GuiInfoBook gui, int x, int y, int width, int height, int page, int mx, int my) {
        int tick = getTick(gui);
        Pair<ItemStack, Float> value = modifierValues.get(tick % modifierValues.size());

        ItemStack input = value.getKey();

        // Items
        renderItem(gui, x, y, input, mx, my, INPUT);

        // Effect
        String line = String.format("+ %s %s", value.getValue().toString(), L10NHelpers.localize(modifier.getUnlocalizedName()));
        drawString(gui, line, x + SLOT_SIZE + 4, y + 3);
    }

    protected void drawString(GuiInfoBook gui, String string, int x, int y) {
        FontRenderer fontRenderer = gui.getFontRenderer();
        boolean oldUnicode = fontRenderer.getUnicodeFlag();
        fontRenderer.setUnicodeFlag(true);
        fontRenderer.setBidiFlag(false);
        fontRenderer.drawSplitString(string, x, y, 200, 0);
        fontRenderer.setUnicodeFlag(oldUnicode);
    }
}
