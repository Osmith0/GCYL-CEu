package com.fulltrix.gcyl.api.recipes.properties;

import gregtech.api.recipes.properties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import org.jetbrains.annotations.NotNull;

public class GCYLTemperatureProperty extends RecipeProperty<Integer> {
    public static final String KEY = "temperature";

    private static GCYLTemperatureProperty INSTANCE;

    private GCYLTemperatureProperty() {
        super("temperature", Integer.class);
    }

    public static GCYLTemperatureProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GCYLTemperatureProperty();
        }

        return INSTANCE;
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
        minecraft.fontRenderer.drawString(I18n.format("gcyl.recipe.temperature", value), x, y, color);
    }

}
