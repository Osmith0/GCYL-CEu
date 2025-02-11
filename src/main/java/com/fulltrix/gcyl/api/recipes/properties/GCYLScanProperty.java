package com.fulltrix.gcyl.api.recipes.properties;

import gregtech.api.recipes.properties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import org.jetbrains.annotations.NotNull;

public class GCYLScanProperty extends RecipeProperty<Boolean> {
    public static final String KEY = "gcyl_scan";

    private static GCYLScanProperty INSTANCE;

    private GCYLScanProperty() {super(KEY, Boolean.class);}

    @NotNull
    public static GCYLScanProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GCYLScanProperty();
        }
        return INSTANCE;
    }

    @Override
    public @NotNull NBTBase serialize(@NotNull Object o) {
        int thing = 0;

        if((boolean) o)
            thing = 1;

        return new NBTTagInt(thing);
    }

    @Override
    public @NotNull Object deserialize(@NotNull NBTBase nbtBase) {
        int thing = ((NBTTagInt) nbtBase).getInt();

        if(thing == 0)
            return false;
        else
            return true;
    }

    @Override
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object value) {
        minecraft.fontRenderer.drawString(I18n.format("gcyl.recipe.scan_for_deep_miner"), x, y, color);
    }
}
