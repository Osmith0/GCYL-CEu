package com.fulltrix.gcyl.api.multi.abilities;

import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import net.minecraftforge.items.IItemHandlerModifiable;

import static gregtech.api.metatileentity.multiblock.MultiblockAbility.ability;

public class GCYLAbilities {
    public static final MultiblockAbility<IItemHandlerModifiable> DRILL_HOLDER = ability("drill_holder", IItemHandlerModifiable.class);
}
