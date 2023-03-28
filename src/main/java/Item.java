public abstract class Item {
    private String itemName;
    private boolean hasItem = false;

    public Item(String itemName, boolean hasItem) {
        this.itemName = itemName;
        this.hasItem = hasItem;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;

    }

    public boolean hasItem() {
        return hasItem;
    }

    public void setHasItem(boolean hasItem) {
        this.hasItem = hasItem;
    }
}

