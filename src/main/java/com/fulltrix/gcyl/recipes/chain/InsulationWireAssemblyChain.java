package com.fulltrix.gcyl.recipes.chain;

import static com.fulltrix.gcyl.materials.GCYLMaterials.*;
import static com.fulltrix.gcyl.item.GCYLCoreItems.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class InsulationWireAssemblyChain {
    public static void init() {

        // 4C2H4 + NH3 + HBr -> C8H20NBr
        CHEMICAL_RECIPES.recipeBuilder().duration(240).EUt(120)
                .fluidInputs(Ethylene.getFluid(4000))
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidInputs(HydrobromicAcid.getFluid(1000))
                .fluidOutputs(TetraethylammoniumBromide.getFluid(1000))
                .buildAndRegister();

        // H2O + C6H12O6 -> C6H14O2 + 5O
        CHEMICAL_RECIPES.recipeBuilder().duration(180).EUt(120)
                .notConsumable(dust, PdIrReOCeOS, 1)
                .fluidInputs(Water.getFluid(1000))
                .input(dust, Fructose, 24)
                .notConsumable(TetraethylammoniumBromide.getFluid(1))
                .fluidOutputs(Hexanediol.getFluid(1000))
                .fluidOutputs(Oxygen.getFluid(5000))
                .buildAndRegister();

        // 2NH3 + C6H14O2 -> 2H2O + C6H16N2
        CHEMICAL_RECIPES.recipeBuilder().duration(240).EUt(480)
                .fluidInputs(Hexanediol.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(2000))
                .fluidOutputs(Water.getFluid(2000))
                .fluidOutputs(Hexamethylenediamine.getFluid(1000))
                .notConsumable(dust, Ruthenium)
                .notConsumable(dust, Alumina, 1)
                .buildAndRegister();

        // C6H12O6 + 3 O -> C6H10O8 + H2O
        CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(480)
                .input(dust, Glucose, 24)
                .circuitMeta(0)
                .fluidInputs(Oxygen.getFluid(3000))
                .fluidOutputs(Water.getFluid(1000))
                .output(dust, SaccharicAcid, 24)
                .buildAndRegister();

        // C6H10O8 + 8H -> C6H10O4 + 4H2O
        LARGE_CHEMICAL_RECIPES.recipeBuilder().duration(160).EUt(480)
                .input(dust, SaccharicAcid, 24)
                .notConsumable(dust, AuPdCCatalyst, 1)
                .notConsumable(dust, ScandiumTriflate, 1)
                .fluidInputs(Hydrogen.getFluid(8000))
                .output(dust, AdipicAcid, 20)
                .fluidOutputs(Water.getFluid(4000))
                .buildAndRegister();

        // C3H6O + CH4 -> C4H10O
        CHEMICAL_RECIPES.recipeBuilder().duration(125).EUt(120)
                .notConsumable(dust, MagnesiumChloride)
                .input(dust, ZeoliteSievingPellets, 1)
                .fluidInputs(Acetone.getFluid(1000))
                .fluidInputs(Methane.getFluid(1000))
                .fluidOutputs(Tertbutanol.getFluid(1000))
                .output(dust, WetZeoliteSievingPellets, 1)
                .buildAndRegister();

        // 2C4H10O + 2CO2 -> H2O + C10H18O5
        CHEMICAL_RECIPES.recipeBuilder().duration(260).EUt(480)
                .fluidInputs(Tertbutanol.getFluid(2000))
                .fluidInputs(CarbonDioxide.getFluid(2000))
                .notConsumable(Toluenesulfonate.getFluid(1))
                .fluidOutputs(Water.getFluid(1000))
                .output(dust, DitertbutylDicarbonate, 33)
                .buildAndRegister();

        // C4H8 + C10H18O5 + 4NH3 + 3C -> 2 C4H10O + C6H18N4 + 3CO
        LARGE_CHEMICAL_RECIPES.recipeBuilder().duration(370).EUt(480)
                .input(dust, DitertbutylDicarbonate, 33)
                .input(dust, Carbon, 3)
                .fluidInputs(Butene.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(4000))
                .notConsumable(Trimethylchlorosilane.getFluid(1))
                .fluidOutputs(Tertbutanol.getFluid(2000))
                .fluidOutputs(CarbonMonoxide.getFluid(3000))
                .fluidOutputs(Triaminoethaneamine.getFluid(1000))
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder().duration(290).EUt(30720)
                .input(foil, Polyetheretherketone)
                .input(foil, SiliconeRubber)
                .input(dust, AdipicAcid, 20)
                .fluidInputs(Hexamethylenediamine.getFluid(1000))
                .fluidInputs(Triaminoethaneamine.getFluid(500))
                .outputs(PEEK_POLYAMIDE_FOIL.getStackForm(3))
                .buildAndRegister();

        // 2K + 2NaN3 + C10H18O5 -> 2Na + K2O + 2C5H9N3O2
        LARGE_CHEMICAL_RECIPES.recipeBuilder().duration(210).EUt(480)
                .input(dust, Potassium, 2)
                .input(dust, SodiumAzide, 8)
                .input(dust, DitertbutylDicarbonate, 33)
                .output(dust, Sodium, 2)
                .output(dust, Potash, 3)
                .fluidOutputs(TertButylAzidoformate.getFluid(2000))
                .buildAndRegister();

        // Aminated Fullerene is a Secondary Amine
        // C60 + 4C5H9N3O2 + 8H2O + 4CO -> C60N12H12 + 4C4H10O + 8CO2
        LARGE_CHEMICAL_RECIPES.recipeBuilder().duration(120).EUt(30720)
                .input(dust, Fullerene, 1)
                .fluidInputs(TertButylAzidoformate.getFluid(4000))
                .fluidInputs(Water.getFluid(8000))
                .fluidInputs(CarbonMonoxide.getFluid(4000))
                .fluidOutputs(AminatedFullerene.getFluid(1000))
                .fluidOutputs(CarbonDioxide.getFluid(8000))
                .fluidOutputs(Tertbutanol.getFluid(4000))
                .buildAndRegister();

        FLUID_HEATER_RECIPES.recipeBuilder().duration(120).EUt(480)
                .fluidInputs(AminatedFullerene.getFluid(1000))
                .fluidOutputs(Azafullerene.getFluid(1000))
                .notConsumable(wireFine, Rhenium)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder().duration(30).EUt(7680)
                .inputs(PEEK_POLYAMIDE_FOIL.getStackForm())
                .fluidInputs(Azafullerene.getFluid(10))
                .outputs(HIGHLY_INSULATING_FOIL.getStackForm())
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder().duration(100).EUt(120)
                .fluidInputs(Resorcinol.getFluid(500))
                .fluidInputs(Formaldehyde.getFluid(1000))
                .input(dust, GrapheneOxide, 3)
                .output(dust, GrapheneGelSuspension, 1)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder().duration(260).EUt(480)
                .input(dust, GrapheneGelSuspension, 1)
                .fluidInputs(Acetone.getFluid(100))
                .output(dust, DryGrapheneGel, 1)
                .buildAndRegister();

        FLUID_HEATER_RECIPES.recipeBuilder().duration(80).EUt(480)
                .fluidInputs(CarbonDioxide.getFluid(1000))
                .fluidOutputs(SupercriticalCO2.getFluid(1000))
                .circuitMeta(0)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder().duration(400).EUt(120).blastFurnaceTemp(5000)
                .input(dust, DryGrapheneGel, 1)
                .fluidInputs(SupercriticalCO2.getFluid(1000))
                .outputs(AEROGRAPHENE.getStackForm())
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder().duration(210).EUt(30720)
                .input(stick, Polyurethane)
                .input(stick, ReinforcedEpoxyResin)
                .inputs(MEMORY_FOAM_BLOCK.getStackForm())
                .inputs(HIGHLY_INSULATING_FOIL.getStackForm())
                .inputs(AEROGRAPHENE.getStackForm())
                .fluidInputs(Argon.getFluid(1000))
                .outputs(INSULATION_WIRE_ASSEMBLY.getStackForm(2))
                .buildAndRegister();
    }
}
