class DynamicArray {

    private int[] arr;
    private int length;
    private int capacity;

    public DynamicArray(int capacity) {
        this.length = 0;
        this.capacity = capacity;
        this.arr = new int[this.capacity];

    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (length == capacity) {
            resize();
        }
        arr[length] = n;
        length++;
    }

    public int popback() {
        
        int result = arr[length - 1];
        length--;
        return result;
    }

    private void resize() {
        capacity *= 2;
        int[] newArr = new int[capacity];

        for (int i = 0; i < length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}
