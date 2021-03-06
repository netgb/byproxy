package net.dongliu.byproxy.store;

import java.nio.ByteBuffer;

/**
 * Store byte data, using ByteBuffer
 */
abstract class DataStore {

    private final ByteBuffer buffer;

    protected DataStore(ByteBuffer buffer) {
        this.buffer = buffer;
    }

    /**
     * Write data to store, return the start position at the store.
     * If store do not have enough space, return -1
     */
    public int write(ByteBuffer buffer) {
        if (buffer.remaining() > this.buffer.remaining()) {
            return -1;
        }
        int pos = this.buffer.position();
        this.buffer.put(buffer);
        return pos;
    }

    /**
     * Read data at specified position
     */
    public ByteBuffer read(int offset, int size) {
        ByteBuffer buffer = this.buffer.duplicate();
        buffer.position(offset).limit(offset + size);
        return buffer.slice();
    }
}
