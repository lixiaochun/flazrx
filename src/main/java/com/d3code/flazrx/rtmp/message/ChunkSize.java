package com.d3code.flazrx.rtmp.message;

import com.d3code.flazrx.rtmp.RTMPHeader;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * Created by Nottyjay on 2016/8/24.
 */
public class ChunkSize extends AbstractMessage {

    private int chunkSize;

    public ChunkSize(RTMPHeader header, ByteBuf in){
        super(header, in);
    }

    public ChunkSize(int chunkSize){
        this.chunkSize = chunkSize;
    }

    public int getChunkSize(){
        return chunkSize;
    }

    @Override
    public ByteBuf encode() {
        ByteBuf out = Unpooled.buffer(4);
        out.writeInt(chunkSize);
        return out;
    }

    @Override
    public void decode(ByteBuf in) {
        chunkSize = in.readInt();
    }

    @Override
    MessageType getMessageType() {
        return MessageType.CHUNK_SIZE;
    }

    @Override
    public String toString() {
        return super.toString() + chunkSize;
    }
}
