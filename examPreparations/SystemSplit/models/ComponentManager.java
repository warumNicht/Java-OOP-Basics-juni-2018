package SystemSplit.models;

import SystemSplit.models.hardware.BaseHardware;
import SystemSplit.models.hardware.HeavyHardware;
import SystemSplit.models.hardware.PowerHardware;
import SystemSplit.models.software.BaseSoftware;
import SystemSplit.models.software.ExpressSoftware;
import SystemSplit.models.software.LightSoftware;

import java.util.HashMap;
import java.util.Optional;

public class ComponentManager {

    private HashMap<String,BaseHardware> components;
    private int softwareCount;
    private long totalMemory;
    private long totalCapacity;
    private long usedTotalMemory;
    private long usedTotalCapacity;
    private HashMap<String,BaseHardware> errasedElements;

    public ComponentManager() {
        this.components=new HashMap<>();
        this.errasedElements=new HashMap<>();
    }

    public void registerPowerHardware(String name,int capacity, int memory){
        BaseHardware currPowHard=new PowerHardware(name,"Power",capacity,memory);
        components.put(name,currPowHard);
    }
    public void registerHeavyHardware(String name,int capacity, int memory){
        BaseHardware currHeavyHard=new HeavyHardware(name,"Heavy",capacity,memory);
        components.put(name,currHeavyHard);
    }
    public void registerExpressSoftware(String hardwareComponentName,String name,int capacity,int memory){
        if(components.containsKey(hardwareComponentName)){
            BaseHardware curHard=components.get(hardwareComponentName);
            BaseSoftware curSoft=new ExpressSoftware(name,capacity,memory);

            if(curHard.getUsedCapacity()+curSoft.getCapacityConsumption()<=curHard.getMaximumCapacity()
                    &&curHard.getUsedMemory()+curSoft.getMemoryConsumption()<=curHard.getMaximumMemory()){
                curHard.addUsedCapacity(curSoft.getCapacityConsumption());
                curHard.addUsedMemory(curSoft.getMemoryConsumption());
                curHard.getInstalled().add(curSoft);
            }
        }
    }
    public void registerLightSoftware(String hardwareComponentName,String name,int capacity,int memory){
        if(components.containsKey(hardwareComponentName)){
            BaseHardware curHard=components.get(hardwareComponentName);
            BaseSoftware curSoft=new LightSoftware(name,capacity,memory);

            if(curHard.getUsedCapacity()+curSoft.getCapacityConsumption()<=curHard.getMaximumCapacity()
                    &&curHard.getUsedMemory()+curSoft.getMemoryConsumption()<=curHard.getMaximumMemory()){
                curHard.addUsedCapacity(curSoft.getCapacityConsumption());
                curHard.addUsedMemory(curSoft.getMemoryConsumption());
                curHard.getInstalled().add(curSoft);
            }
        }
    }

    public void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName){
        if(components.containsKey(hardwareComponentName)){
            BaseHardware curHard=components.get(hardwareComponentName);
            Optional<BaseSoftware> softToRemove=curHard.getInstalled().stream()
                    .filter(x->x.getName().equals(softwareComponentName))
                    .findFirst();

            if(softToRemove.isPresent()){
                BaseSoftware removed=softToRemove.get();

                curHard.addUsedMemory(-removed.getMemoryConsumption());
                curHard.addUsedCapacity(-removed.getCapacityConsumption());

                curHard.getInstalled().remove(removed);
            }
        }
    }

    public void analyze(){
        countSoftwareElements();
        StringBuilder res=new StringBuilder();
        res.append("System Analysis").append(System.lineSeparator())
                .append(String.format("Hardware Components: %d%n",components.size()))
                .append(String.format("Software Components: %d%n",this.softwareCount))
                .append(String.format("Total Operational Memory: %d / %d%n",this.usedTotalMemory,this.totalMemory))
                .append(String.format("Total Capacity Taken: %s / %s",this.usedTotalCapacity,this.totalCapacity));

        System.out.println(res.toString());
    }

    protected void countSoftwareElements(){
        int softwareCount=0;
        long totalMemory=0;
        long totalCapacity=0;
        long usedTotalMemory=0;
        long usedTotalCapacity=0;

        for (BaseHardware baseHardware : components.values()) {
            softwareCount+=baseHardware.getInstalled().size();
            totalMemory+=baseHardware.getMaximumMemory();
            totalCapacity+=baseHardware.getMaximumCapacity();

            usedTotalCapacity+=baseHardware.getUsedCapacity();
            usedTotalMemory+=baseHardware.getUsedMemory();
        }
        this.softwareCount=softwareCount;
        this.totalCapacity=totalCapacity;
        this.totalMemory=totalMemory;
        this.usedTotalCapacity=usedTotalCapacity;
        this.usedTotalMemory=usedTotalMemory;
    }

    public  void systemSplit(){
        StringBuilder res=new StringBuilder();
        this.components.values().stream()
                .filter(x->x.getType().equals("Power"))
                .forEach(y->res.append(y.toString()).append(System.lineSeparator()));

        this.components.values().stream()
                .filter(x->x.getType().equals("Heavy"))
                .forEach(y->res.append(y.toString()).append(System.lineSeparator()));

        System.out.println(res);
    }

    public void dump(String hardwareComponentName){
        if(this.components.containsKey(hardwareComponentName)){
            this.errasedElements.put(hardwareComponentName,
                    this.components.get(hardwareComponentName));
            this.components.remove(hardwareComponentName);
        }
    }

    public void restore(String hardwareComponentName){
        if(this.errasedElements.containsKey(hardwareComponentName)){
            this.components.put(hardwareComponentName,
                    this.errasedElements.get(hardwareComponentName));
            this.errasedElements.remove(hardwareComponentName);
        }
    }

    public void destroy(String hardwareComponentName){
        if(this.errasedElements.containsKey(hardwareComponentName)){
            this.errasedElements.remove(hardwareComponentName);
        }
    }

    public void dumpAnalyze(){
        StringBuilder res=new StringBuilder();
        res.append("Dump Analysis\n");
        int powerHardware=0;
        int heavyHardware=0;
        int expressSoftware=0;
        int lightSoftware=0;
        long totalMemory=0;
        long totalCapacity=0;

        for (BaseHardware baseHardware : errasedElements.values()) {
            if(baseHardware.getType().equals("Power")){
                powerHardware++;
            }else {
                heavyHardware++;
            }
            for (BaseSoftware baseSoftware : baseHardware.getInstalled()) {
                if(baseSoftware.getClass().getSimpleName().equals("ExpressSoftware")){
                    expressSoftware++;
                }else {
                    lightSoftware++;
                }
                totalMemory+=baseSoftware.getMemoryConsumption();
                totalCapacity+=baseSoftware.getCapacityConsumption();
            }
        }
        res.append(String.format("Power Hardware Components: %d%n",powerHardware))
                .append(String.format("Heavy Hardware Components: %d%n", heavyHardware))
                .append(String.format("Express Software Components: %d%n",expressSoftware))
                .append(String.format("Light Software Components: %d%n",lightSoftware))
                .append(String.format("Total Dumped Memory: %d%n",totalMemory))
                .append(String.format("Total Dumped Capacity: %d%n",totalCapacity));

        System.out.println(res);
    }

}
