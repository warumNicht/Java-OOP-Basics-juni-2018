package net.java.main.handlers;

import net.java.main.constants.ExeptionMessagesConstants;
import net.java.main.enums.SpellType;
import net.java.main.exceptions.NotEnoughEnergyForSpellException;
import net.java.main.factories.SpellFactory;
import net.java.main.interfaces.Spell;
import net.java.main.interfaces.Unit;

import java.util.List;

public class MarineCombatHandler extends BaseCombatHandler {
    private final int HALF_MARINE_HEALTH=25;
    private int getSpellEnergyCost(){
        Unit unit=super.getUnit();
        int energyCost=unit.getAttackPoints();

        if(unit.getHealthPoints()<HALF_MARINE_HEALTH){
            return energyCost*2;
        }
        return energyCost;
    }

    @Override
    public Spell generateAttack() throws NotEnoughEnergyForSpellException {
        Spell spell=SpellFactory.createSpell(SpellType.BULLET_RAIN,this.getSpellEnergyCost());
        Unit unit=super.getUnit();
        if(unit.getEnergyPoints()<=spell.getEnergyCost()){
            throw new NotEnoughEnergyForSpellException(ExeptionMessagesConstants.NOT_ENOUGH_ENERGY_EXCEPTION_MESSAGE);
        }
        unit.setEnergyPoints(unit.getEnergyPoints()-spell.getEnergyCost());


        return spell;
    }
}
