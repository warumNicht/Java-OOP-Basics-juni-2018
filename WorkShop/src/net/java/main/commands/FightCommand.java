package net.java.main.commands;

import net.java.main.exceptions.GameException;
import net.java.main.interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FightCommand implements Command {
    private Battleground battleground;
    private Repository<Unit> unitRepository;

    public FightCommand(Battleground battleground, Repository<Unit> unitRepository) {
        this.battleground = battleground;
        this.unitRepository = unitRepository;
    }

    @Override
    public String execute(String[] args) throws GameException {
        List<Unit> killedUnits=new ArrayList<>();
        List<Unit> alliveUnits=this.unitRepository.findAll().stream()
                .filter(unit->unit.getHealthPoints()>0)
                .collect(Collectors.toList());

        if(alliveUnits.size()<2){
            return "- No enough spawns for fight!";
        }

        StringBuilder result=new StringBuilder();

        for (Unit unit : alliveUnits) {
            Position currUnitPosition=unit.getPosition();
            int range=unit.getRange();

            List<Unit> targets = this.battleground.getUnitsInRange(currUnitPosition.getX(),
                    currUnitPosition.getY(), range);
            if(targets.isEmpty()){
                continue;
            }
            Unit target=unit.getCombatHandler().pickNextTarget(targets);
            Spell spell=unit.getCombatHandler().generateAttack();

            if(spell.getDamage()>target.getDefensePoints()){
                target.setHealthPoints(target.getHealthPoints()-spell.getDamage());

                result.append(String.format("-  %s cast %s spell and did %d damage",
                        unit.getName(),spell.getClass().getSimpleName(),spell.getDamage()))
                .append(System.lineSeparator());


                if(target.getHealthPoints()<=0){
                    target.setHealthPoints(0);
                    result.append(String.format("-  %s killed %s",unit.getName(),target.getName()));
                    killedUnits.add(unit);
                }
            }

        }

        String resString=result.toString().trim();

        if(resString.isEmpty()){
            return "- Units are outside range of their enemies, move closer and try again!";
        }

        for (Unit killed : killedUnits) {
            this.battleground.remove(killed);
        }
        return resString;
    }
}
