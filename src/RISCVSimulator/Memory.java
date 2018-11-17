/* File: Main.java
 * Authors: Marc Sun Bog & Simon Amtoft Pedersen
 *
 * The following file has a memory byte array and handles input and read from the array
 */
package RISCVSimulator;

public class Memory {
    private byte[] memory;

    /**
     * Constructor for Memory
     * Initializes as a byte array of size given by argument
     */
    Memory(int MEMORY_SIZE_IN_BYTES){
        memory = new byte[MEMORY_SIZE_IN_BYTES];
    }

    // Stores a single byte in the memory array
    void storeByte (int addr, int data) {
        memory[addr] = (byte) (data & 0xFF);
    }

    // Stores a half word in the memory array
    void storeHalfWord(int addr, short data) {
        memory[addr]    = (byte) (data & 0x00FF);
        memory[addr+1]  = (byte) (data &0xFF00);
    }

    // Stores a word in the memory array
    void storeWord(int addr, int data) {
        memory[addr]    = (byte) ((data & 0x000000FF));
        memory[addr+1]  = (byte) ((data & 0x0000FF00) >>> 8);
        memory[addr+2]  = (byte) ((data & 0x00FF0000) >>> 16);
        memory[addr+3]  = (byte) ((data & 0xFF000000) >>> 24);
    }

    // Returns the byte in the memory given by the address.
    byte getByte (int addr) {
        return memory[addr];
    }

    // Returns half word from memory array given by address
    int getHalfWord(int addr){
        return (getByte(addr+1) << 8) | (getByte(addr) & 0xFF);
    }

    // Returns word from memory array given by address
    int getWord(int addr){
        return (getHalfWord(addr+2) << 16) | (getHalfWord(addr) & 0xFFFF);
    }

    // Returns string starting at the address given and ends when next memory address is zero. UN-TESTED
    String getString(int addr){
        String returnValue = "";
        int i = 0;
        while(memory[addr+i] != 0){
            returnValue += (char) (memory[addr+i]);
        }
        return returnValue;
    }

    // Returns the memory array
    byte[] getMemory() {
        return memory;
    }
}
