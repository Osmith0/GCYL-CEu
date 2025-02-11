package com.fulltrix.gcyl.api.recipes.properties;

import gregtech.api.recipes.properties.RecipeProperty;
import gregtech.api.util.TextFormattingUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagLong;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.TreeMap;

public class AdvFusionCoilProperty extends RecipeProperty<Integer> {
    public static final String KEY = "adv_fusion_coil_tier";

    private static final TreeMap<Integer, String> registeredAdvFusionTiers = new TreeMap<>();

    private static AdvFusionCoilProperty INSTANCE;

    protected AdvFusionCoilProperty() {
        super(KEY, Integer.class);
    }

    public static AdvFusionCoilProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AdvFusionCoilProperty();
        }

        return INSTANCE;
    }

    private static String getCoilTier(Integer tier) {
        Map.Entry<Integer, String> mapEntry = registeredAdvFusionTiers.ceilingEntry(tier);

        if (mapEntry == null) {
            throw new IllegalArgumentException("oopz");
        }

        return String.format(" %s", mapEntry.getValue());
    }

    public static void registerAdvFusionTier(int tier, String shortName) {
        Validate.notNull(shortName);
        registeredAdvFusionTiers.put(tier, shortName);
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
        minecraft.fontRenderer.drawString(I18n.format("gregtech.recipe.adv_fusion_coil_tier",
                        TextFormattingUtil.formatLongToCompactString(castValue(value))) + getCoilTier(castValue(value)), x, y,
                color);
    }
}
