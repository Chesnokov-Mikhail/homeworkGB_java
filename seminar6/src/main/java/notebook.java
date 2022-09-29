import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

public class notebook {
    protected static int number = 0;
    private int id =0;
    private String model;
    private String processor;
    private int memory;
    private int hardDisk;
    private String color;
    private String operationSystem;

    public notebook(String model, String processor, int memory, int hardDisk, String color, String operationSystem) {
        notebook.number++;
        this.id = notebook.number;
        this.model = model;
        this.processor = processor;
        this.memory = memory;
        this.hardDisk = hardDisk;
        this.color = color;
        this.operationSystem = operationSystem;
    }

    public notebook(String model, String processor, int memory, int hardDisk, String color) {
        this(model, processor, memory, hardDisk, color, null);
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "notebook{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", processor='" + processor + '\'' +
                ", memory=" + memory +
                ", hardDisk=" + hardDisk +
                ", color='" + color + '\'' +
                ", operationSystem='" + operationSystem + '\'' +
                '}';
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setHardDisk(int hardDisk) {
        this.hardDisk = hardDisk;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public int getId() {
        return id;
    }

    public String getProcessor() {
        return processor;
    }

    public int getMemory() {
        return memory;
    }

    public int getHardDisk() {
        return hardDisk;
    }

    public String getColor() {
        return color;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        notebook notebook = (notebook) o;
        return id == notebook.id && memory == notebook.memory && hardDisk == notebook.hardDisk && model.equals(notebook.model) && processor.equals(notebook.processor) && color.equals(notebook.color) && Objects.equals(operationSystem, notebook.operationSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, processor, memory, hardDisk, color, operationSystem);
    }

    public boolean like(Map<String,Object> filter) {
        return memory >= (int) filter.get("memory") &&
                hardDisk >= (int) filter.get("hardDisk") &&
                (color.equals((String) filter.get("color")) || (filter.get("color") == null) &&
                        (operationSystem.equals((String) filter.get("operationSystem")) || (filter.get("operationSystem") == null)));
    }
}
