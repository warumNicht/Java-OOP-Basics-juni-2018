package net.java.main.models.units;

import net.java.main.interfaces.CombatHandler;
import net.java.main.interfaces.Position;
import net.java.main.interfaces.Unit;


public abstract class BaseUnit implements Unit {
    private String name;
    private Integer range;
    private Position position;
    private int healthPoints;
    private int energyPoints;
    private int attackPoints;
    private int defencePoints;
    private CombatHandler combatHandler;

    protected BaseUnit(
            String name,
            int range,
            Position position,
            int healthPoints,
            int energyPoints,
            int attackPoints,
            int defencePoints,
            CombatHandler combatHandler) {
        this.name = name;
        this.range = range;
        this.healthPoints = healthPoints;
        this.energyPoints = energyPoints;
        this.attackPoints = attackPoints;
        this.defencePoints = defencePoints;
        this.combatHandler = combatHandler;
        this.combatHandler.setUnit(this);
        this.position=position;
    }

    
    public String getName() {
        return this.name;
    }

    public int getRange() {
        return this.range;
    }


    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getEnergyPoints() {
        return this.energyPoints;
    }

    public void setEnergyPoints(int energyPoints) {
        this.energyPoints = energyPoints;
    }

    public int getAttackPoints() {
        return this.attackPoints;
    }

    public int getDefencePoints() {
        return this.defencePoints;
    }

    public CombatHandler getCombatHandler() {
        return this.combatHandler;
    }

    @Override
    public String toString() {
        StringBuilder unit=new StringBuilder();
        unit.append(String.format("->%s",this.name)).append(System.lineSeparator());
        unit.append(String.format("-Type: %s",this.getClass().getSimpleName()))
        .append(System.lineSeparator())
                .append(String.format("-Position: %s",this.position.toString()))
                .append(System.lineSeparator())
                .append(String.format("- Attack points: %d",this.attackPoints))
                .append(System.lineSeparator())
                .append(String.format("- Defence points: %d",this.defencePoints))
                .append(System.lineSeparator())
                .append(String.format("- Energy points: %d",this.energyPoints))
                .append(System.lineSeparator())
                .append(String.format("- Health points: %d",this.healthPoints));

        return unit.toString();
    }
}
