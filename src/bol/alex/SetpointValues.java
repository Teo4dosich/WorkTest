package bol.alex;

public class SetpointValues {
    private String group;
    private String name;
    private String value;
    private String description;

    public SetpointValues() {

    }

    public SetpointValues(String group, String name) {
        this.group = group;
        this.name = name;
    }

    public SetpointValues(String group, String name, String value, String description){
        this.group = group;
        this.name = name;
        this.value = value;
        this.description = description;
    }
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String name) {
        this.description = description;
    }
}
