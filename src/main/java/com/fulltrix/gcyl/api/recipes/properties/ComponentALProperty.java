package com.fulltrix.gcyl.api.recipes.properties;

import gregtech.api.recipes.properties.RecipeProperty;
import gregtech.api.util.TextFormattingUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.TreeMap;

public class ComponentALProperty extends RecipeProperty<Integer> {
    public static final String KEY = "component_al_casing_tier";

    private static final TreeMap<Integer, String> registeredCasingTiers = new TreeMap<>();

    private static ComponentALProperty INSTANCE;

    protected ComponentALProperty() { super(KEY, Integer.class);}

    public static ComponentALProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ComponentALProperty();
        }

        return INSTANCE;
    }

    private static String getCasingTier(Integer tier) {
        Map.Entry<Integer, String> mapEntry = registeredCasingTiers.ceilingEntry(tier);

        if (mapEntry == null) {
            throw new IllegalArgumentException("oopz");
        }

        return String.format(" %s", mapEntry.getValue());
    }

    public static void registerCasingTier(int tier, String shortName) {
        Validate.notNull(shortName);
        registeredCasingTiers.put(tier, shortName);
    }

    @Override
    public @NotNull NBTBase serialize(@NotNull Object o) {
        return new NBTTagInt(castValue(o));
    }

    @Override
    public @NotNull Object deserialize(@NotNull NBTBase nbtBase) {
        return ((NBTTagInt) nbtBase).getInt();
    }

    @Override
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gregtech.recipe.component_al_casing_tier",
                        TextFormattingUtil.formatLongToCompactString(castValue(value))) + getCasingTier(castValue(value)), x, y,
                color);
    }
}
