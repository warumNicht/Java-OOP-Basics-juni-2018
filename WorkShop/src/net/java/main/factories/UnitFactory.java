package net.java.main.factories;

import net.java.main.constants.ExeptionMessagesConstants;
import net.java.main.enums.UnitType;
import net.java.main.exceptions.InvalidUnitTypeException;
import net.java.main.handlers.CarrierCombatHandler;
import net.java.main.handlers.MarineCombatHandler;
import net.java.main.interfaces.Position;
import net.java.main.interfaces.Unit;
import net.java.main.models.PositionImpl;
import net.java.main.models.units.Carrier;
import net.java.main.models.units.Marine;

public final class UnitFactory {
    private UnitFactory() {
    }

    public static Unit createUnit(UnitType unitType, String name, int xPosition, int yPosition)   {
        Position position=new PositionImpl(xPosition,yPosition);
        switch (unitType){
            case MARINE:{
                return new Marine(name,position,
                        CombatHandlerFactory.createMarineCombatHandler());
            }
            case CARRIER:{
                return new Carrier(name,position,
                        CombatHandlerFactory.createCarrierCombatHandler());
            }
            default: return null;
        }
    }
}
