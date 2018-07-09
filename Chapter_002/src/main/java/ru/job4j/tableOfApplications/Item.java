package ru.job4j.tableOfApplications;

public class Item {
    public String name;
    public String id;
    public String description;
    public long created;
    public String[] comments;

    public Item (String id, String name, String description, long created) {
            // String[] comments
        this.name = name;
        this.id = id;
        this.description = description;
        this.created = created;
        this.comments = comments;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getDescription() {
        return this.description;
    }

    public long getCreated() {
        return this.created;
    }

    public String[] getComments() {
        return this.comments;
    }
}
