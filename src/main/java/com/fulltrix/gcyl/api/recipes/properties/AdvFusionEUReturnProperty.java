package com.fulltrix.gcyl.api.recipes.properties;

import gregtech.api.recipes.properties.RecipeProperty;
import gregtech.api.util.TextFormattingUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AdvFusionEUReturnProperty extends RecipeProperty<Integer> {
    public static final String KEY = "adv_fusion_eu_return";

    private static final List<Integer> EUReturn = new ArrayList<>();
    private static AdvFusionEUReturnProperty INSTANCE;

    protected AdvFusionEUReturnProperty() {
        super(KEY, Integer.class);
    }

    public static AdvFusionEUReturnProperty getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AdvFusionEUReturnProperty();
        }

        return INSTANCE;
    }

    private static String getEUReturn(Integer percent) {

        return String.format(" %s", EUReturn.get(EUReturn.indexOf(percent)));
    }

    public static void setEUReturn(int percent) {
        EUReturn.add(percent);
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
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object percent) {
        minecraft.fontRenderer.drawString(I18n.format("gregtech.recipe.adv_fusion_eu_return",
                        TextFormattingUtil.formatLongToCompactString(castValue(percent))) + getEUReturn(castValue(percent)) + "%", x, y,
                color);
    }

}
