package net.java.main.handlers;

import net.java.main.constants.ExeptionMessagesConstants;
import net.java.main.enums.SpellType;
import net.java.main.exceptions.NotEnoughEnergyForSpellException;
import net.java.main.factories.SpellFactory;
import net.java.main.factories.UnitComparatorFactory;
import net.java.main.interfaces.Spell;
import net.java.main.interfaces.Unit;

import java.util.List;

public class CarrierCombatHandler extends BaseCombatHandler {
    private int spellCount;


    @Override
    public Spell generateAttack() throws NotEnoughEnergyForSpellException {
        Spell spell=SpellFactory.createSpell(SpellType.BULLET_RAIN,super.getUnit().getAttackPoints());
        Unit unit=super.getUnit();
        this.spellCount++;
        if(this.spellCount%3==0){
            return  spell;
        }else {
            if(unit.getEnergyPoints()<=spell.getEnergyCost()){
                throw new NotEnoughEnergyForSpellException(ExeptionMessagesConstants.NOT_ENOUGH_ENERGY_EXCEPTION_MESSAGE);
            }
        }


        unit.setEnergyPoints(unit.getEnergyPoints()-spell.getEnergyCost());
        return spell;
    }
}
