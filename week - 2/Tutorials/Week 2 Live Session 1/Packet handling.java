package weblab;

import java.util.*;

class PacketHandler {

    private ArrayList<Packet> packets;

    public PacketHandler() {
        this.packets = new ArrayList();
    }

    /**
     * Processes a packet received from a sender by storing it,
     * if all expected packets have been received, the packets will be returned in the correct order by their ID.
     * If not all packets have been received, this method will return null.
     *
     * The packet handler will reset itself after returning the packets.
     *
     * @param p
     *     - the packet that needs to be processed
     * @return list of all packets in the correct order if all packets have been received, else null.
     */
    public Packet[] processPacket(Packet p) {
        if (p == null) return null;
        for (Packet pa : packets) {
            if (p.getId() == pa.getId()) return null;
        }
        packets.add(p);
        if (p.getAmount() == packets.size());
        Comparator<Packet> comp = (Packet p1, Packet p2) -> {
            return p1.getId() - p2.getId();
        };
        Collections.sort(packets, comp);
        Packet[] ans = new Packet[packets.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = packets.get(i);
        }
        return ans;
    }
}
