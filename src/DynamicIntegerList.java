// Max size is currently Integer.MAX_VALUE - 1

class DynamicIntegerList {

    // Define max size of array
    private Integer maxArraySize = Integer.MAX_VALUE;

    // Define actual size of array
    private Integer size;

    // Define empty array
    Integer[] dynamicList;

    // Class constructor
    DynamicIntegerList() {
        super();
        this.size = 0;
        this.dynamicList = new Integer[0];
    }

    // Get amount of elements stored in this list
    Integer length() {
        return this.size;
    }

    // Return the number at given index position
    Integer getNumAtIndex(int index) {
        if (index < size)
            return this.dynamicList[index];

        return null;
    }

    // Modify the number at a given index position
    void setNumAtIndex(int index, int num) {
        if (index < size)
            this.dynamicList[index] = num;
    }

    // Add a value to the end of the list
    void add(int num) {
        if (this.size >= maxArraySize) return;
        if (this.size >= this.dynamicList.length)
            this.increaseListSize();

        this.dynamicList[this.size] = num;
        this.size += 1;

    }

    // Insert a value at a given index position
    void insert(int index, int num) {
        if(index > this.size) return;

        if(this.size >= maxArraySize) return;
        if(this.size >= this.dynamicList.length)
            this.increaseListSize();

        for (int i = index; i < this.size; i++)
            this.dynamicList[i + 1] = this.dynamicList[i];

        this.dynamicList[index] = num;
        this.size += 1;

    }

    // Delete a value at a given index position
    void delete(int index) {
        for (int i = index; i < this.size - 1; i++)
            this.dynamicList[i] = this.dynamicList[i + 1];

        this.dynamicList[this.size - 1] = null;
        this.size -= 1;
    }

    // Double space allocation as required
    private void increaseListSize() {
        if (this.dynamicList.length == 0) {
            this.dynamicList = new Integer[2];
            return;
        }

        Integer[] tempList;

        if (this.dynamicList.length * 2 <= maxArraySize)
            tempList = new Integer[this.dynamicList.length * 2];
        else
            tempList = new Integer[maxArraySize];

        for (int i = 0; i < this.dynamicList.length; i++)
            tempList[i] = this.dynamicList[i];

        this.dynamicList = tempList;

    }

    void printAll() {
        for (Integer num: this.dynamicList)
            System.out.println(num);
    }

}
