package SystemSplit.models.hardware;

import SystemSplit.models.software.BaseSoftware;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseHardware {
    private String name;
    private String type;
    private int maximumCapacity;
    private int maximumMemory;
    private List<BaseSoftware> installed;
    private int usedCapacity;
    private int usedMemory;

    protected BaseHardware(String name, String type, int maximumCapacity, int maximumMemory) {
        this.name = name;
        this.type = type;
        this.maximumCapacity = maximumCapacity;
        this.maximumMemory = maximumMemory;
        this.installed=new ArrayList<>();
    }

    public void addUsedCapacity(int usedCapacity) {
        this.usedCapacity += usedCapacity;
    }

    public void addUsedMemory(int usedMemory) {
        this.usedMemory += usedMemory;
    }

    public String getType() {
        return type;
    }

    public int getUsedCapacity() {
        return usedCapacity;
    }

    public int getUsedMemory() {
        return usedMemory;
    }

    protected void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    protected void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public int getMaximumMemory() {
        return maximumMemory;
    }

    public List<BaseSoftware> getInstalled() {
        return installed;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();

        List<BaseSoftware> expressSoftwaresElem=this.installed.stream()
                .filter(x->x.getClass().getSimpleName().equals("ExpressSoftware"))
                .collect(Collectors.toList());
        int expressSoftCount=expressSoftwaresElem.size();
        int lightSoftCount=installed.size()-expressSoftCount;

        res.append(String.format("Hardware Component - %s%n",name))
                .append(String.format("Express Software Components - %d%n",expressSoftCount))
                .append(String.format("Light Software Components - %d%n",lightSoftCount))
                .append(String.format("Memory Usage: %d / %d%n",this.usedMemory,this.maximumMemory))
                .append(String.format("Capacity Usage: %d / %d%n",this.usedCapacity,this.maximumCapacity))
                .append(String.format("Type: %s%n",type));

        if(this.installed.isEmpty()){
            res.append("Software Components: None");
        }else {
            List<String> softNames=this.installed.stream()
                    .map(x->x.getName())
                    .collect(Collectors.toList());
            res.append(String.format("Software Components: %s",String.join(", ",softNames)));
        }
        return res.toString();
    }
}
