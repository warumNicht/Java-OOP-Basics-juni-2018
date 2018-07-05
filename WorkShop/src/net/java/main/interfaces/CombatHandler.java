package net.java.main.interfaces;

import net.java.main.exceptions.NotEnoughEnergyForSpellException;
import net.java.main.models.units.BaseUnit;

import java.util.List;

public interface CombatHandler {

    void setUnit(Unit unit);

    Unit pickNextTarget(List<Unit> targetCandidates);

    Spell generateAttack() throws NotEnoughEnergyForSpellException;
}
