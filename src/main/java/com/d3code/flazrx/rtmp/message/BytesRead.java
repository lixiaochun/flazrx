package com.d3code.flazrx.rtmp.message;

import com.d3code.flazrx.rtmp.RTMPHeader;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * Created by Nottyjay on 2016/8/24.
 */
public class BytesRead extends AbstractMessage {

    private int value;

    public BytesRead(RTMPHeader header, ByteBuf in){
        super(header, in);
    }

    public BytesRead(long bytesRead){
        this.value = (int) bytesRead;
    }

    public int getValue(){
        return value;
    }

    @Override
    public ByteBuf encode() {
        ByteBuf out = Unpooled.buffer(4);
        out.writeInt(value);
        return out;
    }

    @Override
    public void decode(ByteBuf in) {
        value = in.readInt();
    }

    @Override
    MessageType getMessageType() {
        return MessageType.BYTES_READ;
    }

    @Override
    public String toString() {
        return super.toString() + value;
    }
}
